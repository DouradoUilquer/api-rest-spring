package com.connectsoftware.osworks.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.connectsoftware.osworks.domain.model.StatusOrdemService;

public class OrdemServiceModel {

	private Long id;
	private String nameClient;
	private ClientResumeModel client;
	private String description;
	private BigDecimal price;
	private StatusOrdemService status;
	private OffsetDateTime dateOpen;
	private OffsetDateTime dateFinished;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public StatusOrdemService getStatus() {
		return status;
	}

	public void setStatus(StatusOrdemService status) {
		this.status = status;
	}

	public OffsetDateTime getDateOpen() {
		return dateOpen;
	}

	public void setDateOpen(OffsetDateTime dateOpen) {
		this.dateOpen = dateOpen;
	}

	public OffsetDateTime getDateFinished() {
		return dateFinished;
	}

	public void setDateFinished(OffsetDateTime dateFinished) {
		this.dateFinished = dateFinished;
	}

	public ClientResumeModel getClient() {
		return client;
	}

	public void setClient(ClientResumeModel client) {
		this.client = client;
	}

	
	
}
