package com.lordofthepushes.data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "country")
public class CountryData implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer country_id;

    @NotBlank
    private String country_name;

    @NotBlank
    private String continent_name;

    @OneToMany(mappedBy = "country", targetEntity= UserData.class)
    private List<UserData> users;

    public void setCountry_id(Integer country_id) {
        this.country_id = country_id;
    }

    public Integer getCountry_id() {
        return country_id;
    }

    public void setUsers(List<UserData> users) {
        this.users = users;
    }

    public List<UserData> getUsers() {
        return users;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setContinent_name(String continent_name) {
        this.continent_name = continent_name;
    }

    public String getContinent_name() {
        return continent_name;
    }
}
