package com.lordofthepushes.data;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserData implements Serializable {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    private String fullName;

    @Column(columnDefinition = "boolean default true")
    private Boolean active;

    @Column(unique = true)
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
    private Date createdAt;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, targetEntity= CountryData.class)
    @JoinColumn(name = "country_id", nullable = false)
    private CountryData country;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<CharacterData> characters;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_tables",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "adventure_table_id", referencedColumnName = "adventure_table_id", nullable = false, updatable = false)})
    private Set<AdventureTableData> tables;

    public void setUserId(Long user_id) {
        this.userId = user_id;
    }

    public Long getUserId() {
        return userId;
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

    private void setCreatedAt(Date created_at) {
        this.createdAt = created_at;
    }

    public Date getCreatedAt() {
        return createdAt;
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