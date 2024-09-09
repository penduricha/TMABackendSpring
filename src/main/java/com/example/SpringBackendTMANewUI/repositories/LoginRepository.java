package com.example.SpringBackendTMANewUI.repositories;

import com.example.SpringBackendTMANewUI.dtos.LoginDTO;
import com.example.SpringBackendTMANewUI.models.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface LoginRepository extends JpaRepository<Login,Long> {
    @Query("select new com.example.SpringBackendTMANewUI.dtos.LoginDTO(l.date_login, count(*))" +
            "from Login l " +
            "where l.date_login >= :startDate and l.date_login <  :endDate " +
            "group by date(l.date_login) " +
            "order by date(l.date_login)")
    List<LoginDTO> getAllLoginGroupFromSevenDaysToNow(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    @Query("select count(l) from Login l where l.date_login >=:startDate and l.date_login < :endDate")
    int countLoginToday(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    @Query("select count(l) from Login l where l.date_login >=:startDate and l.date_login < :endDate")
    int countLoginYesterday(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
