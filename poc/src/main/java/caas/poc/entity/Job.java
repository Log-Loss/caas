package caas.poc.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Job {
    @Id
    @GeneratedValue
    public Integer id;

    public Integer modelId;

    public String datasetId;

    public String config;

    public Date createTime;

    public Date finishTime;

    public Integer workspaceId;
}
