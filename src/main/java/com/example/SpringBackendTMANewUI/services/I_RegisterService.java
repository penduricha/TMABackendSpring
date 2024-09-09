package com.example.SpringBackendTMANewUI.services;

import com.example.SpringBackendTMANewUI.dtos.RegisterDTO;
import com.example.SpringBackendTMANewUI.models.*;
//import com.example.SpringBackendTMANewUI.models.dto.SignupStats;
//import org.springframework.data.repository.query.Param;

import java.util.*;

public interface I_RegisterService {
    public Register saveRegister(Register register);
    public int getNumberOfRegistersInSevenDays();
    public List<Register> getAllRegister();
    public List<Register>  getAllRegisterFromSevenDayToNow();
    public List<RegisterDTO> getAllSignupGroup_fromSevenDayToNow();
    public int countSignupToday();
    public int countSignup_3_Days_Lasted();
}
