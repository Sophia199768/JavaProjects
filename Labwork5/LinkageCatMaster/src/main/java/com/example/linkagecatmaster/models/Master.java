package com.example.linkagecatmaster.models;


import lombok.Data;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data

@Entity
@Table(name = "masters")
public class Master {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "master_id")
    private Integer id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "role")
    private Role role;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "masters_cats", joinColumns = @JoinColumn(name = "master_id"),  inverseJoinColumns = @JoinColumn(name = "cat_id"))
    @Fetch(FetchMode.SUBSELECT)
    private List<Cat> cats = new ArrayList<>();

    public Master() {
    }

    public Master(String login, String password, Date birthday, Role role) {
        this.login = login;
        this.password = password;
        this.birthday = birthday;
        this.role = role;
    }
}
