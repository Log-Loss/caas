package caas.poc.entity;

import javax.persistence.*;

@Entity
public class Code {
    @Id
    @GeneratedValue
    Integer id;

    public String name;

    public String type = "text";

    public String content;

    public Integer workspaceId;
}
