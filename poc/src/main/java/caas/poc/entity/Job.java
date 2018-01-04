package caas.poc.entity;

import javax.persistence.*;

@Entity
public class Job {
    @Id
    @GeneratedValue
    public Integer id;

    public String config;

    @Column(length = 100000000)
    public byte[] datasetContent;

    public Integer workspaceId;
}
