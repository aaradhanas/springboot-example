package faqapp.repository;

import faqapp.bean.FAQ;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by AAS on 2/19/2018.
 */
@Repository
public interface FaqRepository extends MongoRepository<FAQ, String> {

    List<FAQ> findAll();

    FAQ findOneById(String id);

    FAQ insert(FAQ faq);

    void delete(String id);
}
