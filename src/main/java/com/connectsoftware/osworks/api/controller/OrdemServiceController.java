package com.connectsoftware.osworks.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
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

import com.connectsoftware.osworks.api.model.OrdemServiceInput;
import com.connectsoftware.osworks.api.model.OrdemServiceModel;
import com.connectsoftware.osworks.domain.model.OrdemService;
import com.connectsoftware.osworks.domain.repository.OrdemServiceRepository;
import com.connectsoftware.osworks.domain.service.OrdemServiceService;

@RestController
@RequestMapping("/ordem")
public class OrdemServiceController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private OrdemServiceService ordemServiceService;

	@Autowired
	private OrdemServiceRepository ordemServiceRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemServiceModel insert(@Valid @RequestBody OrdemServiceInput ordemServiceInput) {

		OrdemService ordem = toEntity(ordemServiceInput);

		return toModel(ordemServiceService.insert(ordem));
	}

	@GetMapping
	public List<OrdemServiceModel> list() {
		return toCollectionModel(ordemServiceRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrdemServiceModel> buscar(@PathVariable Long id) {
		Optional<OrdemService> ordem = ordemServiceRepository.findById(id);

		if (ordem.isPresent()) {
			OrdemServiceModel model = toModel(ordem.get());
			return ResponseEntity.ok(model);
		}
		return ResponseEntity.notFound().build();

	}

	private OrdemServiceModel toModel(OrdemService ordem) {
		return modelMapper.map(ordem, OrdemServiceModel.class);
	}

	private List<OrdemServiceModel> toCollectionModel(List<OrdemService> ordem) {
		return ordem.stream().map(ordemService -> toModel(ordemService)).collect(Collectors.toList());
	}

	private OrdemService toEntity(OrdemServiceInput ordem) {
		return modelMapper.map(ordem, OrdemService.class);

	}

}
