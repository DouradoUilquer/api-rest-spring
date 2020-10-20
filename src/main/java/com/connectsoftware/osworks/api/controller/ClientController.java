package com.connectsoftware.osworks.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.connectsoftware.osworks.domain.model.Client;

@RestController
public class ClientController {

	@GetMapping("/client")
	public List<Client> list() {
		var client1 = new Client();
		client1.setId(1L);
		client1.setName("Jose Silva");
		client1.setEmail("email@email.com");
		client1.setTelephone("3333-3333");

		var client2 = new Client();
		client2.setId(2L);
		client2.setName("Maria");
		client2.setEmail("email@email.com");
		client2.setTelephone("3333-3333");

		return Arrays.asList(client1, client2);
	}

}
