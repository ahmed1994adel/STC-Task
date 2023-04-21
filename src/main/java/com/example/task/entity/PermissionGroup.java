package com.example.task.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "permission_group")
public class PermissionGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "group_name")
    private String group_name;

    @OneToMany(mappedBy="permissionGroup")
    @JsonIgnore
    private List<Permissions> Permissions;

    @OneToMany(mappedBy="itemPermissionGroup")
    @JsonIgnore
    private List<Items> items;


}
