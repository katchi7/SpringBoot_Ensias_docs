package com.ensias.Ensias_docs.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="element")
public class Element {

    @Id
    @GeneratedValue
    private int elm_id;

    @Column(name = "elm_name")
    private String elmName;

    @Column(name = "elm_module")
    private String elmModule;
    @Column(name = "elm_description")
    private String elmDesc;
    @Column(name = "elm_annee")
    private String elmAnnee;
    @Column(name = "elm_semester")
    private String elmSem;
    @Column(name = "date_exam")
    private Date dateExam;





}
