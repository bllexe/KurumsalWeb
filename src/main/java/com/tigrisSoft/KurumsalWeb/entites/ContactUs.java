package com.tigrisSoft.KurumsalWeb.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class ContactUs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phoneNumber;

    private String firtname;

    private String surname;

    private String email;

    private String messageContent;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

}
