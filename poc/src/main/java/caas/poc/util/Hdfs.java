package caas.poc.util;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Hdfs {

    private static Configuration conf = new Configuration(true);

    static {
        conf.set("fs.default.name", "hdfs://localhost:9000");
        Path srcPath = new Path("/caas");
        FileSystem fs;
        try {
            fs = srcPath.getFileSystem(conf);
            fs.mkdirs(srcPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void put(String filePath, String dst) throws Exception {
        FileSystem fs = FileSystem.get(conf);
        Path srcPath = new Path(filePath);
        Path dstPath = new Path(dst);
        fs.copyFromLocalFile(false, srcPath, dstPath);
        fs.close();
    }

    public static void putBytes(String name, byte[] content) throws Exception {
        FileSystem fs = FileSystem.get(conf);
        Path path = new Path("/caas/" + name);
        FSDataOutputStream out = fs.create(path);
        out.write(content);
        out.close();
        fs.close();
    }

    public static byte[] getBytes(String name) throws Exception {
        FileSystem fs = FileSystem.get(conf);
        Path path = new Path("/caas/" + name);
        InputStream inputStream = fs.open(path);
        return IOUtils.toByteArray(inputStream);
    }

    public static byte[] get(String name) throws Exception {
        FileSystem fs = FileSystem.get(conf);
        Path path = new Path("/caas/" + name);
        InputStream inputStream = fs.open(path);
        return IOUtils.toByteArray(inputStream);
    }

    public static void main(String[] args){

    }
}