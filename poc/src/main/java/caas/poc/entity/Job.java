package caas.poc.entity;

import javax.persistence.*;

@Entity
public class Job {
    @Id
    @GeneratedValue
    public Integer id;

    public String config;

    public Byte[] datasetContent;

    @ManyToOne(cascade = CascadeType.ALL)
    public Workspace workspace;
}
