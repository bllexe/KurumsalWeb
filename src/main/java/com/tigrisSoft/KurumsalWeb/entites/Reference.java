package com.tigrisSoft.KurumsalWeb.entites;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Reference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String referenceName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @OneToOne(cascade = CascadeType.REMOVE)
    private FileAttachment fileAttachment;

}
