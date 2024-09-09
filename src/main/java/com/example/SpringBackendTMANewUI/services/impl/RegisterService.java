package com.example.SpringBackendTMANewUI.services.impl;

import com.example.SpringBackendTMANewUI.dtos.RegisterDTO;
import com.example.SpringBackendTMANewUI.models.Register;
//import com.example.SpringBackendTMANewUI.models.dto.SignupStats;
import com.example.SpringBackendTMANewUI.projections.RegisterProjection;
import com.example.SpringBackendTMANewUI.repositories.RegisterRepository;
import com.example.SpringBackendTMANewUI.services.I_RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class RegisterService implements I_RegisterService {
    private final RegisterRepository registerRepository;
    @Autowired
    public RegisterService(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    @Override
    public Register saveRegister(Register register) throws JpaSystemException {
        return registerRepository.save(register);
    }

    @Override
    public int getNumberOfRegistersInSevenDays() {
        LocalDateTime endDate = LocalDateTime.now().plusDays(1).toLocalDate().atStartOfDay();
        //toLocalDate(): Chuyển về chuỗi DateTime
        LocalDateTime startDate = LocalDateTime.now().minusDays(7).toLocalDate().atStartOfDay();
        return registerRepository.countByDateSignupBetween(startDate, endDate);
    }

    @Override
    public List<Register> getAllRegister() throws JpaSystemException {
        return registerRepository.getAllRegisterSortByDate_signup();
    }

    @Override
    public List<Register> getAllRegisterFromSevenDayToNow() {
        LocalDateTime endDate = LocalDateTime.now().plusDays(1).toLocalDate().atStartOfDay();
        //toLocalDate(): Chuyển về chuỗi DateTime
        LocalDateTime startDate = LocalDateTime.now().minusDays(7).toLocalDate().atStartOfDay();
        return registerRepository.getAllRegisterFromSevenDayToNow(startDate, endDate);
    }

    @Override
    public List<RegisterDTO> getAllSignupGroup_fromSevenDayToNow()throws JpaSystemException {
        LocalDateTime endDate = LocalDateTime.now().plusDays(1).toLocalDate().atStartOfDay();
        //toLocalDate(): Chuyển về chuỗi DateTime
        LocalDateTime startDate = LocalDateTime.now().minusDays(7).toLocalDate().atStartOfDay();
        return registerRepository.getAllSignupGroupFromSevenDaysToNow(startDate,endDate);
    }

    @Override
    public int countSignupToday() {
        LocalDateTime endDate = LocalDateTime.now().plusDays(1).toLocalDate().atStartOfDay();
        LocalDateTime startDate = LocalDateTime.now().toLocalDate().atStartOfDay();
        return registerRepository.countSignupToday(startDate,endDate);
    }

    @Override
    public int countSignup_3_Days_Lasted() {
        LocalDateTime endDate = LocalDateTime.now().toLocalDate().atStartOfDay();
        //toLocalDate(): Chuyển về chuỗi DateTime
        LocalDateTime startDate = LocalDateTime.now().minusDays(3).toLocalDate().atStartOfDay();
        return registerRepository.countSignup_3_Days_Lasted(startDate,endDate);
    }

    public List<Object[]> getAllSignupGroup_fromSevenDayToNow_2()throws JpaSystemException{
        LocalDateTime endDate = LocalDateTime.now().plusDays(1).toLocalDate().atStartOfDay();
        //toLocalDate(): Chuyển về chuỗi DateTime
        LocalDateTime startDate = LocalDateTime.now().minusDays(7).toLocalDate().atStartOfDay();
        return registerRepository.getAllSignupGroupFromSevenDaysToNow_2(startDate,endDate);
    }

    public List<RegisterProjection> getAllSignupGroup_fromSevenDayToNow_3()throws JpaSystemException{
        LocalDateTime endDate = LocalDateTime.now().plusDays(1).toLocalDate().atStartOfDay();
        //toLocalDate(): Chuyển về chuỗi DateTime
        LocalDateTime startDate = LocalDateTime.now().minusDays(7).toLocalDate().atStartOfDay();
        return registerRepository.getAllSignupGroupFromSevenDaysToNow_3(startDate,endDate);
    }

//    @Override
//    public List<RegisterDto> getAllSignupGroup_fromSevenDayToNow(LocalDateTime startDate,LocalDateTime endDate) {
//        return registerRepository.getAllSignupGroupFromSevenDaysToNow(startDate,endDate);
//    }
//    @Override
//    public List<SignupStats> getAllSignupGroup_fromSevenDayToNow(LocalDateTime startDate, LocalDateTime endDate) throws JpaSystemException{
//        return registerRepository.getAllSignupGroupFromSevenDaysToNow(startDate, endDate);
//        //return null;
//    }
//    public Map<LocalDateTime, Long> groupByDateSignupAndCountEmails() {
//        return getAllRegisterFromSevenDayToNow().stream()
//                .collect(Collectors.groupingBy(
//                        register -> register.getDate_signup().toLocalDate().atStartOfDay(), // Nhóm theo ngày
//                        Collectors.counting() // Đếm số lượng email
//                ));
//    }

}
