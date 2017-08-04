package com.example.demo.repository;

import org.springframework.data.jpa.repository.*;

import com.example.demo.domain.ServerFile;



public interface MyFileRepository extends  JpaRepository<ServerFile,Long>{

	ServerFile findByFileUniqueId(String fileuniqueid);
}
