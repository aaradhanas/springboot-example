package faqapp.controller;

import faqapp.bean.FAQ;
import faqapp.service.FaqService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/faq")
public class FAQController {

    private FaqService faqService;

    public FAQController(FaqService faqService){
        this.faqService = faqService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<FAQ> getFaqs(){
        return this.faqService.getFAQs();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<FAQ> getFAQ(@PathVariable("id") String id){
        Optional<FAQ> optionalFaq = this.faqService.getFAQ(id);
        FAQ faq = optionalFaq.isPresent() ? optionalFaq.get() : null;

        if(faq != null){
            return ResponseEntity.ok(faq);
        }
        else{
            return new ResponseEntity<FAQ>(HttpStatus.NOT_FOUND);
        }
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