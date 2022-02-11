package com.dampcave.websiteitransitiontask3.models;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "peoples")
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "registration")
    private Date registration;

    @Column(name = "lastlogin")
    private Date lastLogin;

    @Column(name = "status")
    private String status;



    public People() {

    }


    public People(String name, String email) {
        this.name = name;
        this.email = email;
        this.registration = new Date();
        this.status = "Unblocked";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegistration() {
        return registration;
    }

    public void setRegistration(Date registration) {
        this.registration = registration;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", registration=" + registration +
                ", lastLogin=" + lastLogin +
                ", status='" + status + '\'' +
                '}';
    }
}
