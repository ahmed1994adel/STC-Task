package com.example.task.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "items")
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name="permission_group_id", nullable=true)
    @JsonIgnore
    private PermissionGroup itemPermissionGroup;

    @OneToMany(mappedBy="item")
    @JsonIgnore
    private List<Files> files;

}
