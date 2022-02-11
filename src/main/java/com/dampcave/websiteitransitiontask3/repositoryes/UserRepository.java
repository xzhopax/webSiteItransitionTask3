package com.dampcave.websiteitransitiontask3.repositoryes;



import com.dampcave.websiteitransitiontask3.models.People;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<People, Integer> {


}
