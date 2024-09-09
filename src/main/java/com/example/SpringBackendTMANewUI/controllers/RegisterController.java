package com.example.SpringBackendTMANewUI.controllers;

import com.example.SpringBackendTMANewUI.dtos.RegisterDTO;
import com.example.SpringBackendTMANewUI.models.Register;
//import com.example.SpringBackendTMANewUI.models.dto.SignupStats;
import com.example.SpringBackendTMANewUI.projections.RegisterProjection;
import com.example.SpringBackendTMANewUI.services.impl.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
@RequestMapping("/api")
public class RegisterController {

    private final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/registers")
    public Register saveRegister(@RequestBody Register register) throws JpaSystemException {
        return registerService.saveRegister(register);
    }

    @GetMapping("/registers/get-number-of-registers-last-7-days")
    public int countRegistersInLast7Days() {
        return registerService.getNumberOfRegistersInSevenDays();
    }

    @GetMapping("/registers/get-number-of-registers-last-3-days")
    public int countRegistersInLast3Days() {
        return registerService.countSignup_3_Days_Lasted();
    }

    @GetMapping("/registers/get-number-of-registers-today")
    public int countRegistersToday() {
        return registerService.countSignupToday();
    }

    @GetMapping("/registers")
    public List<Register> getAllRegisters() throws JpaSystemException {
        return registerService.getAllRegister();
    }

    @GetMapping("/registers/registers-seven-day-last")
    public List<Register> getAllRegisterFromSevenDayToNow()  throws JpaSystemException {
        return registerService.getAllRegisterFromSevenDayToNow();
    }

    @GetMapping("/registers-statistic-by-day")
    public List<RegisterDTO> getAllSignupGroup_fromSevenDayToNow()throws JpaSystemException{
        return registerService.getAllSignupGroup_fromSevenDayToNow();
    }

    @GetMapping("/registers-statistic-by-day-2")
    public List<Map<String, Object>> getAllSignupGroup_fromSevenDayToNow_2() {
        List<Object[]> results = registerService.getAllSignupGroup_fromSevenDayToNow_2();
        List<Map<String, Object>> statsList = new ArrayList<>();
        for (Object[] result : results) {
            Map<String, Object> stat = new HashMap<>();
            stat.put("date_signup", result[0]);
            stat.put("email_count", result[1]);
            statsList.add(stat);
        }
        // Jackson tự động chuyển đổi thành JSON
        return statsList;
    }

    @GetMapping("/registers-statistic-by-day-3")
    public List<RegisterProjection> getAllSignupGroup_fromSevenDayToNow_3() {
        return registerService.getAllSignupGroup_fromSevenDayToNow_3();
    }

}
