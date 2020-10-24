package com.connectsoftware.osworks.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.connectsoftware.osworks.domain.model.OrdemService;
import com.connectsoftware.osworks.domain.repository.OrdemServiceRepository;
import com.connectsoftware.osworks.domain.service.OrdemServiceService;

@RestController
@RequestMapping("/ordem")
public class OrdemServiceController {

	@Autowired
	private OrdemServiceService ordemServiceService;

	@Autowired
	private OrdemServiceRepository ordemServiceRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemService insert(@Valid @RequestBody OrdemService ordemService) {
		return ordemServiceService.insert(ordemService);
	}

	@GetMapping
	public List<OrdemService> list() {
		return ordemServiceRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrdemService> buscar (@PathVariable Long id){
		Optional<OrdemService> ordem = ordemServiceRepository.findById(id);

		if (ordem.isPresent()) {
			return ResponseEntity.ok(ordem.get());
		}
		return ResponseEntity.notFound().build();
		
	}
	
	
	
}
