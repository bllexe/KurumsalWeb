package com.tigrisSoft.KurumsalWeb.entites;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    /*@ManyToOne()
    private Staff staff;*/

    @OneToOne(cascade = CascadeType.REMOVE)
    private FileAttachment fileAttachment;
}
