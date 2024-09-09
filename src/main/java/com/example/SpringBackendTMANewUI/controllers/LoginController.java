package com.example.SpringBackendTMANewUI.controllers;

import com.example.SpringBackendTMANewUI.dtos.LoginDTO;
import com.example.SpringBackendTMANewUI.models.Login;
import com.example.SpringBackendTMANewUI.services.impl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/logins")
    public Login saveLogin(@RequestBody Login login) throws JpaSystemException {
        return loginService.saveLogin(login);
    }

    @GetMapping("/logins")
    public List<Login> getAllLogins() throws JpaSystemException {
        return loginService.getAllLogins();
    }

    @GetMapping("/logins-statistic-by-day")
    public List<LoginDTO> getAllLoginGroup_fromSevenDayToNow()throws JpaSystemException{
        return loginService.getAllLoginGroup_fromSevenDayToNow();
    }

    @GetMapping("/count-login-today")
    public int countLoginToday() throws JpaSystemException {
        return loginService.countLoginToday();
    }

    @GetMapping("/count-login-yesterday")
    public int countLoginYesterday() throws JpaSystemException {
        return loginService.countLoginYesterday();
    }
}
