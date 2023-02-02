package com.example.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Study_member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MEMBER_ID;

    @Column(name = "LOGIN_ID")
    private String loginId;

    private String PASSWORD;

    private String NAME;

    private String ROLE;

    @org.hibernate.annotations.Generated(GenerationTime.ALWAYS)
    @Column(name = "reg_day", updatable = false)
    private LocalDateTime reg_day;

    private String EMAIL;

}
