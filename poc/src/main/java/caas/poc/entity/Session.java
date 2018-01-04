package caas.poc.entity;

import javax.persistence.*;

@Entity
public class Session {
    @Id
    @GeneratedValue
    public Integer id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    public User user;
}
