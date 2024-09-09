package com.example.SpringBackendTMANewUI.services;

import com.example.SpringBackendTMANewUI.models.*;

import java.util.List;

public interface I_ButtonSearchService {
    public ButtonSearch saveButtonSearch(ButtonSearch buttonSearch);
    public List<ButtonSearch> getAllButtonSearches();
    public int countButtonSearchToday();
    public int countButtonSearch_SevenDay();
    public List<ButtonSearch> getButtonSearch_KeyWordMuch_TimeLasted();
}
