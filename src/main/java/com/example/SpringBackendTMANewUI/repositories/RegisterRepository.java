package com.example.SpringBackendTMANewUI.repositories;

import com.example.SpringBackendTMANewUI.dtos.RegisterDTO;
import com.example.SpringBackendTMANewUI.models.Register;
//import com.example.SpringBackendTMANewUI.models.dto.SignupStats;

import com.example.SpringBackendTMANewUI.projections.RegisterProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface RegisterRepository extends JpaRepository<Register,String> {

    @Query("select count(r) from Register r where r.date_signup >= :startDate and r.date_signup < :endDate")
    int countByDateSignupBetween(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    @Query("select count(r) from Register r where r.date_signup >=:startDate and r.date_signup < :endDate")
    int countSignupToday(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    @Query("select count(r) from Register r where r.date_signup >=:startDate and r.date_signup < :endDate")
    int countSignup_3_Days_Lasted(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    @Query("select r from Register r order by r.date_signup")
    List<Register> getAllRegisterSortByDate_signup();

    @Query("select r from Register r where r.date_signup >= :startDate and r.date_signup < :endDate order by r.date_signup")
    List<Register> getAllRegisterFromSevenDayToNow(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

//    @Query("select date(r.date_signup), count(r.email) " +
//            "from Register r " +
//            "where r.date_signup >= :startDate and r.date_signup < :endDate " +
//            "group by date(r.date_signup) " +
//            "order by date(r.date_signup)")
    @Query("select new com.example.SpringBackendTMANewUI.dtos.RegisterDTO(r.date_signup, count(*))" +
            "from Register r " +
            "where r.date_signup >= :startDate and r.date_signup <  :endDate " +
            "group by date(r.date_signup) " +
            "order by date(r.date_signup)")
    List<RegisterDTO> getAllSignupGroupFromSevenDaysToNow(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    /*
    SELECT DATE(r.date_signup) as date_signup, COUNT(r.email) as email_count
    FROM register r
    WHERE r.date_signup >= '2024-08-26T00:00:00' AND r.date_signup < '2024-09-05T00:00:00'
    GROUP BY DATE(r.date_signup)
    ORDER BY DATE(r.date_signup);
     */
    @Query("select date(r.date_signup) as date_signup, count(*) as email_count " +
            "from Register r where r.date_signup >=:startDate and r.date_signup < :endDate " +
            "group by date(r.date_signup) order by r.date_signup")
    List<Object[]> getAllSignupGroupFromSevenDaysToNow_2(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    @Query("select date(r.date_signup) as date_signup, count(*) as email_count " +
            "from Register r where r.date_signup >=:startDate and r.date_signup < :endDate " +
            "group by date(r.date_signup) order by r.date_signup")
    List<RegisterProjection> getAllSignupGroupFromSevenDaysToNow_3(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);


}
