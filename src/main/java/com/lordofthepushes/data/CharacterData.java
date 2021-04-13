package com.lordofthepushes.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "characters")
public class CharacterData implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long characterId;

    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    private String fullName;

    @Column(columnDefinition = "boolean default true")
    private Boolean enabled;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserData user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "adventure_table_id", nullable = false)
    private AdventureTableData table;

    public void setCharacterId(Long character_id) {
        this.characterId = character_id;
    }

    public Long getCharacterId() {
        return characterId;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFullName(String full_name) {
        this.fullName = full_name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setCreatedAt(Date created_at) {
        this.createdAt = created_at;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setUser(UserData user) {
        this.user = user;
    }

    public UserData getUser() {
        return user;
    }

    public void setTable(AdventureTableData table) {
        this.table = table;
    }

    public AdventureTableData getTable() {
        return table;
    }
}