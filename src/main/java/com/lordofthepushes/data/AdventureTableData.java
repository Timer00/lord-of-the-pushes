package com.lordofthepushes.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "adventure_table")
public class AdventureTableData implements Serializable {

    @Id
    @Column(name = "adventure_table_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adventureTableId;

    @NotBlank(message = "Table name must not be empty")
    private String tableName;

    private Date createdAt;

    @JsonIgnore
    @ManyToMany(mappedBy = "tables", fetch = FetchType.LAZY)
    private Set<UserData> users;

    @OneToMany(mappedBy = "table", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CharacterData> characters;

    public void setAdventureTableId(Long adventure_table_id) {
        this.adventureTableId = adventure_table_id;
    }

    public Long getAdventureTableId() {
        return adventureTableId;
    }

    public void setTableName(String table_name) {
        this.tableName = table_name;
    }

    public String getTableName() {
        return tableName;
    }

    public void setCreatedAt(Date created_at) {
        this.createdAt = created_at;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setUsers(Set<UserData> users) {
        this.users = users;
    }

    public Set<UserData> getUsers() {
        return users;
    }
}
