package com.example.task.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "files")
public class Files {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "binary")
    private String binary;

    @ManyToOne
    @JoinColumn(name="item_id", nullable=true)
    @JsonIgnore
    private Items item;


}
