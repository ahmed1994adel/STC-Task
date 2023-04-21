package com.example.task.repository;


import com.example.task.entity.Files;
import com.example.task.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface FilesRepository extends JpaRepository<Files,Integer> {



}
