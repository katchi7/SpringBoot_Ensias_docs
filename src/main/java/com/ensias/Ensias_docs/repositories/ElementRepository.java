package com.ensias.Ensias_docs.repositories;

import com.ensias.Ensias_docs.models.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ElementRepository extends JpaRepository<Element,Long> {

}
