package com.example.task.repository;

import com.example.task.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ItemsRepository extends JpaRepository<Items,Integer> {


    Items findByName(@Param("name")String name);

}
