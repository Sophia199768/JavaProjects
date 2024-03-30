package com.example.core.model;

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

    @Column(name = "name")
    private String name;

    @Column(name = "birthday")
    private Date birthday;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "masters_cats", joinColumns = @JoinColumn(name = "master_id"),  inverseJoinColumns = @JoinColumn(name = "cat_id"))
    @Fetch(FetchMode.SUBSELECT)
    private List<Cat> cats = new ArrayList<>();

    public Master() {
    }

    public Master(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }
}
