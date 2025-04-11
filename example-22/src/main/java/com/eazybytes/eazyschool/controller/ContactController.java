package com.eazybytes.eazyschool.controller;

import com.eazybytes.eazyschool.modal.Contact;
import com.eazybytes.eazyschool.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class ContactController {
//    private static Logger log= LoggerFactory.getLogger(ContactController.class);
    private final ContactService contactService;
    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }
    @RequestMapping("/contact")
    public String displayContactPage()
    {
        return "contact.html";
    }
    /*
    @RequestMapping(value = "/saveMsg",method = POST)
    public ModelAndView saveMessage(@RequestParam String name,@RequestParam String mobileNum
    ,@RequestParam String email,@RequestParam String subject,@RequestParam String message)
    {
        log.info("Name : "+name);
        log.info("MobileNum : "+mobileNum);
        log.info("Email : "+email);
        log.info("Subject : "+subject);
        log.info("Message : "+message);
        return new ModelAndView("redirect:/contact");
    }
     */
    @RequestMapping(value = "/saveMsg",method = POST)
    public ModelAndView saveMessage(Contact contact)
    {
        contactService.saveMessageDetails(contact);
        return new ModelAndView("redirect:/contact");
    }
}
