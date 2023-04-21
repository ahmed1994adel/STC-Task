package com.example.task.repository;


import com.example.task.entity.Files;
import com.example.task.entity.PermissionGroup;
import com.example.task.entity.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PermissionsRepository extends JpaRepository<Permissions,Integer> {

    @Query(value = "select p from Permissions p" +
            " inner join PermissionGroup pg on p.permissionGroup.id = pg.id" +
            " where p.permission_level =:permission_level and pg.group_name =:group_name ")
    Permissions findByPermission_level(@Param("permission_level") String permission_level,@Param("group_name") String group_name);
}
