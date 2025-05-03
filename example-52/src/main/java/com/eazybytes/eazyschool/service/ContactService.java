package com.eazybytes.eazyschool.service;

import com.eazybytes.eazyschool.config.EazySchoolProp;
import com.eazybytes.eazyschool.constants.EazySchoolConstants;
import com.eazybytes.eazyschool.model.Contact;
import com.eazybytes.eazyschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ContactService {


    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private EazySchoolProp eazySchoolProp;

    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = false;
        contact.setStatus(EazySchoolConstants.OPEN);
        Contact savedContact = contactRepository.save(contact);
        if (null != savedContact && savedContact.getContactId() > 0) {
            isSaved = true;
        }
        return isSaved;
    }

    public Page<Contact> findMsgsWithOpenStatus(int pageNum,String sortField,String sortDir) {
        int pageSize=eazySchoolProp.getPageSize();
        if(null!=eazySchoolProp.getContact()&&null!=eazySchoolProp.getContact().get("pageSize"))
        {
            pageSize=Integer.parseInt(eazySchoolProp.getContact().get("pageSize").trim());
        }
        Pageable pageable= PageRequest.of(pageNum-1,pageSize,sortDir.equals("asc")
                ? Sort.by(sortField).ascending():
                Sort.by(sortField).descending());
        Page<Contact> contactMessages = contactRepository.findByStatusWithQuery(EazySchoolConstants.OPEN,pageable);
        return contactMessages;
    }

    public boolean updateMsgStatus(int contactId) {
        boolean isUpdated = false;
        int updatedRecords = contactRepository.updateStatusById(EazySchoolConstants.CLOSE,contactId);
        if (updatedRecords>0) {
            isUpdated = true;
        }
        return isUpdated;
    }
}
