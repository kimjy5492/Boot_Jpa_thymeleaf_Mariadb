package com.example.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Study_record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int key_id;

    private String study_day;

    private String contents;

    @org.hibernate.annotations.Generated(GenerationTime.ALWAYS)
    @Column(name="reg_day", updatable = false)
    private LocalDateTime reg_day;

    @org.hibernate.annotations.Generated(GenerationTime.ALWAYS)
    @Column(name="mod_day")
    private LocalDateTime mod_day;
}
