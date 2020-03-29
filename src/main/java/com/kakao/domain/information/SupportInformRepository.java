package com.kakao.domain.information;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by dleo9 on 2020-03-27.
 */
public interface SupportInformRepository extends JpaRepository<SupportInform, Long>{
    List<SupportInformMapping> findAllBy();
}
