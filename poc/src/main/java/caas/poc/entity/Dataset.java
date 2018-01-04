package caas.poc.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Dataset {
    @Id
    @GeneratedValue
    Integer id;

    public String name;

    public Byte[] content;

    public Boolean isPublic = false;

    @ManyToOne(cascade = CascadeType.ALL)
    public Workspace workspace;

    @OneToMany(mappedBy = "dataset", cascade = CascadeType.ALL)
    public Set<Model> models = new HashSet<Model>();
}
