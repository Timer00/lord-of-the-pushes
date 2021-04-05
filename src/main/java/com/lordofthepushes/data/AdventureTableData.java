package com.lordofthepushes.data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "adventure_table")
public class AdventureTableData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adventure_table_id;

    @NotBlank(message = "Table name must not be empty")
    private String table_name;

    private Date created_at;

    @ManyToMany(mappedBy = "tables")
    private Set<UserData> users;

    public void setAdventure_table_id(Integer adventure_table_id) {
        this.adventure_table_id = adventure_table_id;
    }

    public Integer getAdventure_table_id() {
        return adventure_table_id;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setUsers(Set<UserData> users) {
        this.users = users;
    }

    public Set<UserData> getUsers() {
        return users;
    }
}
