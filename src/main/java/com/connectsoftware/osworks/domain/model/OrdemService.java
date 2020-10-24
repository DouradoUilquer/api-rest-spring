package com.connectsoftware.osworks.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.connectsoftware.osworks.domain.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.sun.istack.NotNull;

@Entity
public class OrdemService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Valid
	@ConvertGroup(from = Default.class  , to = ValidationGroups.ClientId.class)
	@NotNull
	@ManyToOne
	private Client client;

	@NotBlank
	private String description;

	@NotNull
	private BigDecimal price;

	@Enumerated(EnumType.STRING)
	private StatusOrdemService status;

	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dateOpen;

	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dateFinished;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemService other = (OrdemService) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
