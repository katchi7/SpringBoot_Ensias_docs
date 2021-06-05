package com.ensias.Ensias_docs.services;


import com.ensias.Ensias_docs.models.Element;
import com.ensias.Ensias_docs.models.User;
import com.ensias.Ensias_docs.repositories.ElementRepository;
import com.ensias.Ensias_docs.repositories.InscriptionRepository;
import com.ensias.Ensias_docs.repositories.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class ElementService {
    @Autowired
    ElementRepository ep;

    @Autowired
    InscriptionRepository ir;

    @Autowired
    UserRepository ur ;

    public List<Element> getElementsByUser(int user_id){
        return ur.getById(user_id).getElements();
    }

    public List<Element> getAllElements(){
        return ep.findAll();
    }

    public void createElement( Element element ){
        ep.save(element);
        List<User> users = ur.findUserByFiliereAndNiv(element.getFilieres(),element.getElmAnnee());
        System.out.println(users.size());
        ir.InscrirUsers(users,element);

    }


}
