package com.tigrisSoft.KurumsalWeb.entites;


import com.tigrisSoft.KurumsalWeb.util.UniqueUsername;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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


    private String surname;

    @NotNull(message = "{tigris.constraint.username.NotNull.message}")
    @Size(min = 4,max = 32)
    //@UniqueUsername
    private String username;

    @NotNull
    @Size(min = 8, max=255)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message="{tigris.constraint.password.Pattern.message}")
    private String password;

    private String profileImage;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "job")
    private String job;

    @Column(name = "age")
    private int age;

    @Column(name = "workStatus")
    private boolean workStatus;

/*    @OneToMany(mappedBy = "staff",cascade = CascadeType.REMOVE)
    private List<Project> project;*/


}
