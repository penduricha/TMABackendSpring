package com.example.SpringBackendTMANewUI.testControllers;

import com.example.SpringBackendTMANewUI.models.Register;
import com.example.SpringBackendTMANewUI.services.impl.RegisterService;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class TestRegisterController {
    private final RegisterService registerService;

    public TestRegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }
    @RequestMapping("/postRegister")
    public String postData() throws JpaSystemException{
        Register register1=new Register("email1@edu.vn", LocalDateTime.now());
        Register register2=new Register("email2@edu.vn", LocalDateTime.now());
        registerService.saveRegister(register1);
        registerService.saveRegister(register2);

        return "Success";
    }

}
