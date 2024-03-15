package model;

import lombok.Data;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Data

@Entity
@Table(name = "cats")
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catid")
    private Integer id;

    @Column(name = "name")
    private  String name;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "breed")
    private String breed;

    @Column(name = "color")
    private String color;

   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(name = "Cats_Friend", joinColumns = @JoinColumn(name = "cat_friend_one"),
           inverseJoinColumns = @JoinColumn(name = "cat_friend_two"))
   private List<Cat> friendsCats;

    public Cat() {
    }

    public Cat(String name, Date birthday, String breed, String color, List<Cat> friendsCats) {
        this.name = name;
        this.breed = breed;
        this.birthday = birthday;
        this.color = color;
        this.friendsCats = friendsCats;
    }
}

