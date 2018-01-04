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
    public String email;

    public String password;
}
