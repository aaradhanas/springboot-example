package faqapp.service;

import faqapp.bean.FAQ;
import faqapp.repository.FaqRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by AAS on 2/19/2018.
 */
@Service
@Transactional
public class FaqService {

    private FaqRepository faqRepository;

    public FaqService(FaqRepository faqRepository){
        this.faqRepository = faqRepository;
    }

    public List<FAQ> getFAQs(){
        return faqRepository.findAll();
    }
    public Optional<FAQ> getFAQ(String id){
        return faqRepository.findOneById(id);
    }

    public FAQ saveFAQ(FAQ newFAQ){
        return faqRepository.insert(newFAQ);
    }

    public void deleteFAQ(String id){
        faqRepository.delete(id);
    }
}
