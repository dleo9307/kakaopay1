package com.kakao.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by dleo9 on 2020-03-26.
 */

@Data
@Entity(name="municipalityAgency")
public class MunicipalityAgency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    private String regionCode;
}