package com.lordofthepushes.data;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class UserData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    @NotBlank(message = "First name is mandatory")
    private String first_name;

    @NotBlank(message = "Last name is mandatory")
    private String last_name;

    private String full_name;

    @Column(columnDefinition = "boolean default true")
    private Boolean active;

    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Password is mandatory")
    private String password;

    @Temporal(TemporalType.DATE)
    @NotBlank(message = "Birthday is mandatory")
    private Date birthday;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "timestamp default current_timestamp")
    private Date created_at;

    @ManyToOne(targetEntity= CountryData.class)
    @JoinColumn(name = "country_id", nullable = false)
    private CountryData country;

    @OneToMany(mappedBy = "character_id", targetEntity = CharacterData.class)
    private List<CharacterData> characters;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_table",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "adventure_table_id", referencedColumnName = "adventure_table_id"))
    private Set<AdventureTableData> tables;

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getUser_id() {
        return user_id;
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

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getActive() {
        return active;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return birthday;
    }

    private void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCountry(CountryData country) {
        this.country = country;
    }

    public CountryData getCountry() {
        return country;
    }

    public void setCharacters(List<CharacterData> characters) {
        this.characters = characters;
    }

    public List<CharacterData> getCharacters() {
        return characters;
    }

    public void setTables(Set<AdventureTableData> tables) {
        this.tables = tables;
    }

    public Set<AdventureTableData> getTables() {
        return tables;
    }
}