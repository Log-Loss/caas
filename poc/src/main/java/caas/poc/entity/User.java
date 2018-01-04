package caas.poc.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue
    public Integer id;

    @Column(unique = true)
    public String name;

    public String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public Set<Workspace> workspaces = new HashSet<Workspace>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public Set<Session> sessions = new HashSet<Session>();
}
