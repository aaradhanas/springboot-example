package faqapp.controller;

import faqapp.bean.FAQ;
import faqapp.service.FaqService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/faq")
public class FAQController {

    private List<FAQ> faqs = new ArrayList<>();
    private FaqService faqService;

    public FAQController(FaqService faqService){
        this.faqService = faqService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<FAQ> getFaqs(){
        return this.faqService.getFAQs();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public FAQ getFAQ(@PathVariable("id") String id){
        //return this.faqs.stream().filter(faq -> id == faq.getId()).findFirst().orElse(null);
        return this.faqService.getFAQ(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public FAQ saveFAQ(@RequestBody FAQ faq){
        return this.faqService.saveFAQ(faq);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteFAQ(@PathVariable("id") String id){
        this.faqService.deleteFAQ(id);
    }
}