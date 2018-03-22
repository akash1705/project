package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Lab;


@Repository
public interface LabRepository extends JpaRepository<Lab, Integer> {
	
	public Lab findByEmail(String email);

}
