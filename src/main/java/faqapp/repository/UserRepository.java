package faqapp.repository;

import faqapp.bean.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by AAS on 3/4/2018.
 */

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findOneByUserName(String username);
}
