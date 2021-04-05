package com.lordofthepushes.data;

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
    private Integer character_id;

    @NotBlank(message = "First name is mandatory")
    private String first_name;

    @NotBlank(message = "Last name is mandatory")
    private String last_name;

    private String full_name;

    @Column(columnDefinition = "boolean default true")
    private Boolean enabled;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date created_at;

    @ManyToOne(targetEntity = UserData.class)
    @JoinColumn(name = "user_id", nullable = false)
    private UserData user;

    public void setCharacter_id(Integer character_id) {
        this.character_id = character_id;
    }

    public Integer getCharacter_id() {
        return character_id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getFull_name() {
        return full_name;
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