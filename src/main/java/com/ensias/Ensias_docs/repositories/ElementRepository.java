package com.ensias.Ensias_docs.repositories;

import com.ensias.Ensias_docs.models.Element;
import com.ensias.Ensias_docs.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ElementRepository extends JpaRepository<Element,Long> {



    //void inscrireUsers(List<User> users,Element element);

}
