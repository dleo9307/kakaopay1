package com.kakao.domain.information;

import com.kakao.domain.agency.SupportAgency;
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
public class SupportInform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String target;

    @Column(nullable = false)
    private String usage;

    @Column(nullable = false)
    private String limitValue;

    @Column(nullable = false)
    private String rate;

    @Column(nullable = false)
    private String institute;

    @Column(nullable = false)
    private String mgmt;

    @Column(nullable = false)
    private String reception;

    @CreationTimestamp
    private LocalDateTime createdTimeAt;

    @UpdateTimestamp
    private LocalDateTime updateTimeAt;

    @ManyToOne
    @JoinColumn(name = "supportAgency_regionCode", nullable = false)
    SupportAgency supportAgency;

    @Transient
    private String region;

    public String getRegion(){
        return this.supportAgency.getRegion();
    }
}
