package com.ensias.Ensias_docs.beans;


import javax.persistence.*;

@Entity
@Table(name = "filiere")
public class Filiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String filiere_name;
    private String filiere_abs;

    public String getFiliere_abs() {
        return filiere_abs;
    }

    public void setFiliere_abs(String filiere_abs) {
        this.filiere_abs = filiere_abs;
    }

    public String getFiliere_name() {
        return filiere_name;
    }

    public void setFiliere_name(String filiere_name) {
        this.filiere_name = filiere_name;
    }
}
