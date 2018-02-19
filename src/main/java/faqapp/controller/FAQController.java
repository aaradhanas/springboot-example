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
        //this.faqs = buildFAQs();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<FAQ> getFaqs(){
        return this.faqs;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public FAQ getFAQ(@PathVariable("id") String id){
        //return this.faqs.stream().filter(faq -> id == faq.getId()).findFirst().orElse(null);
        return this.faqService.getFAQ(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public FAQ saveFAQ(@RequestBody FAQ faq){
        long nextId = 1L;
        if(this.faqs.size() > 0){
            FAQ lastFaq = this.faqs.stream().skip(this.faqs.size() - 1).findFirst().orElse(null);
            //nextId = lastFaq.getId()+1L;
        }

        //faq.setId(nextId);
        this.faqs.add(faq);
        return faq;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public boolean deleteFAQ(@PathVariable("id") int id){
        /*FAQ deleteFAQ = this.faqs.stream().filter(faq -> id == faq.getId()).findFirst().orElse(null);

        if(deleteFAQ != null){
            this.faqs.remove(deleteFAQ);
            return true;
        }
        else{
            return false;
        }*/
        return false;
    }

    private List<FAQ> buildFAQs(){
        List<FAQ> faqs = new ArrayList<>();

        /*faqs.add(new FAQ(1,"What is your name?","Aara"));
        faqs.add(new FAQ(2,"What is your hobby?","Reading"));
        faqs.add(new FAQ(3,"What is your birth place?","Hosur"));*/

        return faqs;
    }
}