package com.ensias.Ensias_docs.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="filiere")
public class Filiere {
    @Id
    @Column(name = "filiere_name")
    private String filiere_name;
    @Column(name = "filiere_name")
    private String filiere_abs;



}
