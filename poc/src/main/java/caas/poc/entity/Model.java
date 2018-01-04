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

    public Integer workspaceId;

    public Integer datasetId;

}
