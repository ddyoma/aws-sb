package com.spboot.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spboot.test.entity.FileInfo;

public interface FileInfoReposytory extends JpaRepository<FileInfo, Integer> {

}
