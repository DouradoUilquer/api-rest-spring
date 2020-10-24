package com.connectsoftware.osworks.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connectsoftware.osworks.domain.exception.BusinessException;
import com.connectsoftware.osworks.domain.model.Client;
import com.connectsoftware.osworks.domain.model.OrdemService;
import com.connectsoftware.osworks.domain.model.StatusOrdemService;
import com.connectsoftware.osworks.domain.repository.ClientRepository;
import com.connectsoftware.osworks.domain.repository.OrdemServiceRepository;

@Service
public class OrdemServiceService {

	@Autowired
	private OrdemServiceRepository ordemServiceRepository;

	@Autowired
	private ClientRepository clientRepository;

	public OrdemService insert(OrdemService ordem) {

		Client client = clientRepository.findById(ordem.getClient().getId())
				.orElseThrow(() -> new BusinessException("CLIENTE NÃO ENCONTRADO"));

		ordem.setClient(client);
		ordem.setStatus(StatusOrdemService.OPEN);
		ordem.setDateOpen(OffsetDateTime.now());
		return ordemServiceRepository.save(ordem);
	}

	public void delete(Long id) {
		ordemServiceRepository.deleteById(id);
	}

}
