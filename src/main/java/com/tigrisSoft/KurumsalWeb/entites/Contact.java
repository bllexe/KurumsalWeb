package com.tigrisSoft.KurumsalWeb.entites;


import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

}
