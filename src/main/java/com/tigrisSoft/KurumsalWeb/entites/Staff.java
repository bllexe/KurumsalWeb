package com.tigrisSoft.KurumsalWeb.entites;


import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "username")
    @NotNull
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "profile_image")
    private String profileImage;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "job")
    private String job;

    @Column(name = "age")
    private int age;

    @Column(name = "workStatus")
    private boolean workStatus;

    @OneToMany(mappedBy = "staff",cascade = CascadeType.REMOVE)
    private List<Project> project;

    @OneToOne(cascade = CascadeType.REMOVE)
    private AboutUs aboutUs;

}
