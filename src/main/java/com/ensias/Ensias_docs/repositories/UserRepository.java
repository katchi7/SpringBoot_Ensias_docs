package com.ensias.Ensias_docs.repositories;

import com.ensias.Ensias_docs.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {

    Optional<User> findByEmail(String email);
}


