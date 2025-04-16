package com.eazybytes.eazyschool.service;

import com.eazybytes.eazyschool.constants.EazySchoolConstants;
import com.eazybytes.eazyschool.controller.ContactController;
import com.eazybytes.eazyschool.modal.Contact;
import com.eazybytes.eazyschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ContactService {


    @Autowired
    private ContactRepository contactRepository;
    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = false;
        contact.setStatus(EazySchoolConstants.OPEN);
        contact.setCreatedBy(EazySchoolConstants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());
        int result=contactRepository.saveContactMsg(contact);
        if(result>0)
        {
            isSaved=true;
        }
        return isSaved;
    }
    public List<Contact>findMsgsWithOpenStatus()
    {
        List<Contact>contactMessages=contactRepository.findMsgsWithStatus(EazySchoolConstants.OPEN);
        return contactMessages;
    }
    public boolean updateMsgStatus(int contactId, String updatedBy)
    {
        boolean isUpdated = false;
        int result=contactRepository.updateMsgStatus(contactId,EazySchoolConstants.CLOSE,updatedBy);
        if(result>0)
        {
            isUpdated=true;
        }
        return isUpdated;
    }
}
