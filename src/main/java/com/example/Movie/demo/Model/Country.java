package com.example.Movie.demo.Model;
import jakarta.persistence.*;

@Entity
@Table(name="Country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int countryId;
    private String name;
    private String language;

    public Country() {
    }

    public Country(int countryId, String name, String language) {
        this.countryId = countryId;
        this.name = name;
        this.language = language;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    // Getters, setters, constructors, and other methods
}