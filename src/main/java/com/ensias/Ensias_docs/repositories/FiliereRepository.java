package com.ensias.Ensias_docs.repositories;

import com.ensias.Ensias_docs.models.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FiliereRepository extends JpaRepository<Filiere,Integer> {

    @Override
    List<Filiere> findAll();

}
