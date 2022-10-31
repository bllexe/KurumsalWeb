package com.tigrisSoft.KurumsalWeb.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Reference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    private String imageUrl;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;


}
