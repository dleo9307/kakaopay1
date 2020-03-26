package com.kakao.model.entity;

import lombok.Data;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

import java.time.LocalDateTime;

/**
 * Created by dleo9 on 2020-03-26.
 */

@Data
@Entity
public class MunicipalityInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String regionCode;

    @Column(nullable = false)
    private String target;

    @Column(nullable = false)
    private String usage;

    @Column(nullable = false)
    private String limit;

    @Column(nullable = false)
    private double rate;

    @Column(nullable = false)
    private String institute;

    @Column(nullable = false)
    private String mgmt;

    @Column(nullable = false)
    private String reception;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime createdTimeAt;

    @UpdateTimestamp
    private LocalDateTime updateTimeAt;

}
