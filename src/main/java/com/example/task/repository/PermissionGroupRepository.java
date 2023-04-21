package com.example.task.repository;


import com.example.task.entity.Files;
import com.example.task.entity.PermissionGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PermissionGroupRepository extends JpaRepository<PermissionGroup,Integer> {

    @Query(value = "select pg from PermissionGroup pg where pg.group_name =:group_name ")
    PermissionGroup findByGroup_name(@Param("group_name") String group_name);

}
