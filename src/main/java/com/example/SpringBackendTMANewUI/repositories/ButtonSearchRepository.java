package com.example.SpringBackendTMANewUI.repositories;

import com.example.SpringBackendTMANewUI.models.ButtonSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ButtonSearchRepository extends JpaRepository<ButtonSearch,Long> {

    @Query("select count(b) from ButtonSearch b where b.date_click >=:startDate and b.date_click < :endDate")
    int countButtonSearchToday(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    @Query("select count(b) from ButtonSearch b where b.date_click >=:startDate and b.date_click < :endDate")
    int countButtonSearch_SevenDay(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    @Query("select b from ButtonSearch b where b.key_word is not null and trim(b.key_word) <> '' order by (select count(*) from ButtonSearch b1 where b1.key_word=b.key_word) desc, b.date_click desc limit 10")
    List<ButtonSearch> getButtonSearch_KeyWordMuch_TimeLasted();
}
