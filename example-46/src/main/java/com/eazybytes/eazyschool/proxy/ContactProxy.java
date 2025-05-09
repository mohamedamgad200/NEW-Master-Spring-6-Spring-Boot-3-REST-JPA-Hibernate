package com.eazybytes.eazyschool.proxy;

import com.eazybytes.eazyschool.config.ProjectConfiguration;
import com.eazybytes.eazyschool.model.Contact;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="contact",
        url = "http://localhost:8080/api/contact",
        configuration = ProjectConfiguration.class)
public interface ContactProxy {
//    @GetMapping("/getAllMsgsByStatus")
    @RequestMapping(method = RequestMethod.GET,value = "/getMessagesByStatus")
    @Headers(value = "Content-Type:application/json")
    public List<Contact>getMessagesByStatus(@RequestParam(name="status") String status);
}
