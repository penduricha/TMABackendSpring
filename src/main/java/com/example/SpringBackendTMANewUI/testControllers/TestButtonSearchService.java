package com.example.SpringBackendTMANewUI.testControllers;

import com.example.SpringBackendTMANewUI.models.ButtonSearch;
import com.example.SpringBackendTMANewUI.services.impl.ButtonSearchService;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class TestButtonSearchService {
    private final ButtonSearchService buttonSearchService;

    public TestButtonSearchService(ButtonSearchService buttonSearchService) {
        this.buttonSearchService = buttonSearchService;
    }
    @RequestMapping("/postbuttonsearch")
    public String postData()throws JpaSystemException {
        ButtonSearch buttonSearch1=new ButtonSearch("email1@gmail.com", LocalDateTime.now());
        ButtonSearch buttonSearch2=new ButtonSearch("email2@gmail.com", LocalDateTime.now());
        buttonSearchService.saveButtonSearch(buttonSearch1);
        buttonSearchService.saveButtonSearch(buttonSearch2);
        return "Success";
    }
}
