package com.spboot.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spboot.test.entity.ExhibitonInfo;

public interface ExhibitonInfoRepository extends JpaRepository<ExhibitonInfo, Integer> {

}
