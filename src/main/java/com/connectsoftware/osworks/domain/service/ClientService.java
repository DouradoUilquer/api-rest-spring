package com.connectsoftware.osworks.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connectsoftware.osworks.domain.exception.BusinessException;
import com.connectsoftware.osworks.domain.model.Client;
import com.connectsoftware.osworks.domain.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	public Client insert (Client client) {
		Client clientExistente = clientRepository.findByEmail(client.getEmail());
		
		
		if(clientExistente != null && !clientExistente.equals(client)) {
			throw new BusinessException("CLIENTE JA CADASTRADO COM ESSE EMAIL");
		}
		
		
		
		
		return clientRepository.save(client);
	}
	
	public void delete(Long id) {
		clientRepository.deleteById(id);
	}
	
}
