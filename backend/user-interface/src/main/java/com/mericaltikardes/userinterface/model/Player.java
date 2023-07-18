package com.mericaltikardes.userinterface.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mericaltikardes.userinterface.util.Gender;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private Gender gender;
    @Column(nullable = false)
    private Date birthDate;
    @Column(nullable = false)
    private String birthCity;
    @Column(nullable = false)
    private boolean isActive;
    @ManyToOne
    @JoinColumn(name = "game_id")
    @JsonIgnoreProperties("players")
    private Game game;

    public Player(String name, String surname, Gender gender, Date birthDate, String birthCity, boolean isActive) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.birthCity = birthCity;
        this.isActive = isActive;
    }

    public Player() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
