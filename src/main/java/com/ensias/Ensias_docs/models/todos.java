package com.ensias.Ensias_docs.models;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="todos")
public class todos {
    @Id
    @GeneratedValue
    private int todo_id;

    @JoinColumn(name = "todo_title")
    @Column(name = "todo_title")
    private String title;

    @JoinColumn(name = "todo_description")
    @Column(name = "todo_description")
    private String description;

    @JoinColumn(name = "todo_is_done")
    @Column(name = "todo_is_done")
    private int done;

    @JoinColumn(name = "todo_delai")
    @Column(name = "todo_delai")
    private Date delai;




}
