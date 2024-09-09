package com.example.SpringBackendTMANewUI.services.impl;

import com.example.SpringBackendTMANewUI.dtos.LoginDTO;
import com.example.SpringBackendTMANewUI.models.Login;
import com.example.SpringBackendTMANewUI.repositories.LoginRepository;
import com.example.SpringBackendTMANewUI.services.I_LoginService;
import org.springframework.data.domain.Sort;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LoginService implements I_LoginService {
    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public Login saveLogin(Login login) throws JpaSystemException {
        return loginRepository.save(login);
    }

    @Override
    public List<Login> getAllLogins() {
        return loginRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public List<LoginDTO> getAllLoginGroup_fromSevenDayToNow() {
        LocalDateTime endDate = LocalDateTime.now().plusDays(1).toLocalDate().atStartOfDay();
        //toLocalDate(): Chuyển về chuỗi DateTime
        LocalDateTime startDate = LocalDateTime.now().minusDays(7).toLocalDate().atStartOfDay();
        return loginRepository.getAllLoginGroupFromSevenDaysToNow(startDate,endDate);
    }

    @Override
    public int countLoginToday() {
        LocalDateTime endDate = LocalDateTime.now().plusDays(1).toLocalDate().atStartOfDay();
        //toLocalDate(): Chuyển về chuỗi DateTime
        LocalDateTime startDate = LocalDateTime.now().toLocalDate().atStartOfDay();
        return loginRepository.countLoginToday(startDate,endDate);
    }

    @Override
    public int countLoginYesterday() {
        LocalDateTime endDate = LocalDateTime.now().toLocalDate().atStartOfDay();
        //toLocalDate(): Chuyển về chuỗi DateTime
        LocalDateTime startDate = LocalDateTime.now().minusDays(1).toLocalDate().atStartOfDay();
        return loginRepository.countLoginYesterday(startDate,endDate);
    }
}
