package com.example.task.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "permissions")
public class Permissions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_email")
    private String user_email;

    @Column(name = "permission_level")
    private String permission_level;

    @ManyToOne
    @JoinColumn(name="group_id", nullable=true)
    @JsonIgnore
    private PermissionGroup permissionGroup;


}
