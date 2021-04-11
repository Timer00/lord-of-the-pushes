package com.lordofthepushes.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "countries")
public class CountryData implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long countryId;

    @NotBlank
    private String countryName;

    @NotBlank
    @Column(unique = true)
    private String countryIsoCode;

    @JsonIgnore
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY,
            targetEntity= UserData.class,
            cascade = CascadeType.ALL)
    private Set<UserData> users;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "continent_id", nullable = false)
    private ContinentData continent;

    public void setCountryId(Long country_id) {
        this.countryId = country_id;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryName(String country_name) {
        this.countryName = country_name;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setUsers(Set<UserData> users) {
        this.users = users;
    }

    public Set<UserData> getUsers() {
        return users;
    }

    public void setCountryIsoCode(String country_iso_code) {
        this.countryIsoCode = country_iso_code;
    }

    public String getCountryIsoCode() {
        return countryIsoCode;
    }

    public void setContinent(ContinentData continent) {
        this.continent = continent;
    }

    public ContinentData getContinent() {
        return continent;
    }
}
