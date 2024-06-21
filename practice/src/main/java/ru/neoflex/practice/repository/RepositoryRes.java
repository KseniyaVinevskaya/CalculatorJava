package ru.neoflex.practice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.neoflex.practice.database.DatabaseRes;

import java.util.List;

@Repository
public interface RepositoryRes extends JpaRepository<DatabaseRes, Integer> {
    @Query("Select db from DatabaseRes db")
    List<DatabaseRes> findAllRes();
}