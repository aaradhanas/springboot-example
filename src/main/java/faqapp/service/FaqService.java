package faqapp.service;

import faqapp.bean.FAQ;
import faqapp.repository.FaqRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public FAQ getFAQ(String id){
        return faqRepository.findOneById(id);
    }
}
