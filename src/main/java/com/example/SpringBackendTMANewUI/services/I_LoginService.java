package com.example.SpringBackendTMANewUI.services;

import com.example.SpringBackendTMANewUI.dtos.LoginDTO;
import com.example.SpringBackendTMANewUI.models.Login;
import java.util.*;
public interface I_LoginService {
    public Login saveLogin(Login login);
    public List<Login> getAllLogins();
    public List<LoginDTO> getAllLoginGroup_fromSevenDayToNow();
    public int countLoginToday();
    public int countLoginYesterday();
}
