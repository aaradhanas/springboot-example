package faqapp.repository;

import faqapp.bean.FAQ;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by AAS on 2/19/2018.
 */
@Repository
public interface FaqRepository extends MongoRepository<FAQ, ObjectId> {

    FAQ findOneById(String id);
}
