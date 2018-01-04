package caas.poc.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Workspace {
    @Id
    @GeneratedValue
    public Integer id;

    public String name;

    @ManyToOne(cascade = CascadeType.ALL)
    public User user;

    @OneToMany(mappedBy = "workspace", cascade = CascadeType.ALL)
    public Set<Dataset> datasets = new HashSet<Dataset>();

    @OneToMany(mappedBy = "workspace", cascade = CascadeType.ALL)
    public Set<Model> models = new HashSet<Model>();

    @OneToMany(mappedBy = "workspace", cascade = CascadeType.ALL)
    public Set<Job> jobs = new HashSet<Job>();

    @OneToMany(mappedBy = "workspace", cascade = CascadeType.ALL)
    public Set<Code> codes = new HashSet<Code>();
}
