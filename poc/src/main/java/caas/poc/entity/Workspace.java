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

    public Integer userId;
}
