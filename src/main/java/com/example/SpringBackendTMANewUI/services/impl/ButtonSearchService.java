package com.example.SpringBackendTMANewUI.services.impl;

import com.example.SpringBackendTMANewUI.models.ButtonSearch;
import com.example.SpringBackendTMANewUI.repositories.ButtonSearchRepository;
import com.example.SpringBackendTMANewUI.services.I_ButtonSearchService;
import org.springframework.data.domain.Sort;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class ButtonSearchService implements I_ButtonSearchService {
    private final ButtonSearchRepository buttonSearchRepository;

    public ButtonSearchService(ButtonSearchRepository buttonSearchRepository) {
        this.buttonSearchRepository = buttonSearchRepository;
    }

    @Override
    public ButtonSearch saveButtonSearch(ButtonSearch buttonSearch) throws JpaSystemException {
        return buttonSearchRepository.save(buttonSearch);
    }

    @Override
    public List<ButtonSearch> getAllButtonSearches() {
        return buttonSearchRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public int countButtonSearchToday() {
        LocalDateTime endDate = LocalDateTime.now().plusDays(1).toLocalDate().atStartOfDay();
        //toLocalDate(): Chuyển về chuỗi DateTime
        LocalDateTime startDate = LocalDateTime.now().toLocalDate().atStartOfDay();
        return buttonSearchRepository.countButtonSearchToday(startDate,endDate);
    }

    @Override
    public int countButtonSearch_SevenDay() {
        LocalDateTime endDate = LocalDateTime.now().toLocalDate().atStartOfDay();
        //toLocalDate(): Chuyển về chuỗi DateTime
        LocalDateTime startDate = LocalDateTime.now().minusDays(7).toLocalDate().atStartOfDay();
        return buttonSearchRepository.countButtonSearch_SevenDay(startDate,endDate);
    }

    @Override
    public List<ButtonSearch> getButtonSearch_KeyWordMuch_TimeLasted() throws JpaSystemException{
        return buttonSearchRepository.getButtonSearch_KeyWordMuch_TimeLasted();
    }
}
