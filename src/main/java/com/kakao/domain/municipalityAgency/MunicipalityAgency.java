package com.kakao.domain.municipalityAgency;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by dleo9 on 2020-03-26.
 */

@Data
@Entity
public class MunicipalityAgency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    private String regionCode;
}
