package caas.poc.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Model {
    @Id
    @GeneratedValue
    public Integer id;

    public String name;

    public String config;

    @ManyToOne(cascade = CascadeType.ALL)
    public Workspace workspace;

    @ManyToOne(cascade = CascadeType.ALL)
    public Dataset dataset;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL)
    public Set<Job> jobs = new HashSet<Job>();
}
