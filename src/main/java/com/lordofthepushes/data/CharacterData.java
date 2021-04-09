package com.lordofthepushes.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "characters")
public class CharacterData implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer characterId;

    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    private String fullName;

    @Column(columnDefinition = "boolean default true")
    private Boolean enabled;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date created_at;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private UserData user;

    public void setCharacterId(Integer character_id) {
        this.characterId = character_id;
    }

    public Integer getCharacterId() {
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

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setUser(UserData user) {
        this.user = user;
    }

    public UserData getUser() {
        return user;
    }
}