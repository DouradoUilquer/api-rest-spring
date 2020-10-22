package com.connectsoftware.osworks.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.connectsoftware.osworks.domain.model.OrdemService;

@Repository
public interface OrdemServiceRepository extends JpaRepository<OrdemService, Long> {

	

}
