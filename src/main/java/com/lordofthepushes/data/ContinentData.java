package com.lordofthepushes.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "continents")
public class ContinentData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long continentId;

    @NotBlank
    private String continentName;

    @NotBlank
    private String continentIsoCode;

    @JsonIgnore
    @OneToMany(mappedBy = "continent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CountryData> countries;

    public void setContinentId(Long continent_id) {
        this.continentId = continent_id;
    }

    public Long getContinentId() {
        return continentId;
    }

    public void setContinentName(String continent_name) {
        this.continentName = continent_name;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentIsoCode(String continent_iso_code) {
        this.continentIsoCode = continent_iso_code;
    }

    public String getContinentIsoCode() {
        return continentIsoCode;
    }

    public void setCountries(Set<CountryData> countries) {
        this.countries = countries;
    }

    public Set<CountryData> getCountries() {
        return countries;
    }
}
