package caas.poc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Dataset {
    @Id
    @GeneratedValue
    Integer id;

    public String name;

    @Column(length = 100000000)
    @JsonIgnore
    public byte[] content;

    public Boolean isPublic = false;

    public Integer workspaceId;
}
