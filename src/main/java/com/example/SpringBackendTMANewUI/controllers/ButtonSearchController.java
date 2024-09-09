package com.example.SpringBackendTMANewUI.controllers;

import com.example.SpringBackendTMANewUI.models.ButtonSearch;

import com.example.SpringBackendTMANewUI.services.impl.ButtonSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ButtonSearchController {

    private final ButtonSearchService buttonSearchService;

    @Autowired
    public ButtonSearchController(ButtonSearchService buttonSearchService) {
        this.buttonSearchService = buttonSearchService;
    }

    @PostMapping("/button-searches")
    public ButtonSearch saveButtonSearch(@RequestBody ButtonSearch buttonSearch) throws JpaSystemException {
        return buttonSearchService.saveButtonSearch(buttonSearch);
    }

    @GetMapping("/button-searches")
    public List<ButtonSearch> getAllButtonSearches() throws JpaSystemException {
        return buttonSearchService.getAllButtonSearches();
    }

    @GetMapping("/count-button-search-today")
    public int countButtonSearchToday() {
        return buttonSearchService.countButtonSearchToday();
    }

    @GetMapping("/count-button-search-seven-day")
    public int countButtonSearch_SevenDay() {
        return buttonSearchService.countButtonSearch_SevenDay();
    }

    @GetMapping("/button-search-keyword-much-time-lasted")
    public List<ButtonSearch> getButtonSearch_KeyWordMuch_TimeLasted() throws JpaSystemException{
        return buttonSearchService.getButtonSearch_KeyWordMuch_TimeLasted();
    }

}
