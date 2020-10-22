package com.connectsoftware.osworks.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	private OrdemServiceRepository ordemServiceRepository;

	@Autowired
	private OrdemServiceService ordemServiceService;

	// @GetMapping
	// public List<Client> list() {
	// return clientRepository.findAll();

	// }

	/**
	 * @GetMapping("/{id}") public ResponseEntity<Client> buscar(@PathVariable Long
	 * id) { Optional<Client> client = clientRepository.findById(id);
	 * 
	 * if (client.isPresent()) { return ResponseEntity.ok(client.get()); } return
	 * ResponseEntity.notFound().build(); }
	 * 
	 **/
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemService insert(@Valid @RequestBody OrdemService ordemService) {
		return ordemServiceService.insert(ordemService);
	}

	/**
	 * 
	 * 
	 * @PutMapping("/{id}") public ResponseEntity<Client>
	 * update(@Valid @PathVariable Long id , @RequestBody Client client) {
	 * if(!clientRepository.existsById(id)) { return
	 * ResponseEntity.notFound().build(); } client.setId(id); client =
	 * clientService.insert(client);
	 * 
	 * return ResponseEntity.ok(client); }
	 * 
	 * @DeleteMapping("/{id}") public ResponseEntity<Void> delete (@PathVariable
	 * Long id){ if(!clientRepository.existsById(id)) { return
	 * ResponseEntity.notFound().build(); }
	 * 
	 * clientService.delete(id);
	 * 
	 * return ResponseEntity.noContent().build(); }
	 * 
	 **/
}
