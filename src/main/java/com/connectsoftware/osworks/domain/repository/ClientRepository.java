package com.connectsoftware.osworks.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.connectsoftware.osworks.domain.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	//List<Client> findByName(String name);
	
	Client findByEmail(String email);

}
