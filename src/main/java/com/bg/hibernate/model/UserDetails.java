package com.bg.hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "personne")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_personne")
    private int id;
    @Column(name = "prenom")
    private String firstName;
    @Column(name = "nom")
    private String lastName;
    @Column(name = "login")
    private String email;

    public UserDetails() {
    }

    public UserDetails(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
