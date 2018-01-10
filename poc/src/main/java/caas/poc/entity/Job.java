package caas.poc.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Job {
    @Id
    @GeneratedValue
    public Integer id;

    public Integer modelId;

    public Integer datasetId;

    public String datasetName;

    public Integer epochs;

    public Integer batchSize;

    @Column(length = 10000)
    public String config;

    public Date createTime;

    public Date startTime;

    public Date finishTime;
}
