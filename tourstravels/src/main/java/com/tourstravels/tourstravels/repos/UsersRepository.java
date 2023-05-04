package com.tourstravels.tourstravels.repos;

import com.tourstravels.tourstravels.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Long>{

    User findByEmailAndPassword(String  email,String password);



	
}
