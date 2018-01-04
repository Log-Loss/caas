package caas.poc.util;

import java.util.List;

public class Response {
    public Response(int code) {
        this.code = code;
        if (code == 501) {
            message = "Missing Param in Body";
        }

        if (code == 404) {
            message = "Resource Not Found";
        }
    }

    public Response(int code, String message, Object result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public int code;
    public String message;
    public Object result;
}
