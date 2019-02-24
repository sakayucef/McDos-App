package com.example.demo.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.McDo;

public interface McDoDao extends JpaRepository<McDo, Long> {
	@Query("select c from McDo c where c.name like :x")
public Page<McDo> search(@Param("x")String mc,Pageable pageable);

}
