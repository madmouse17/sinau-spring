package com.sinau.spring.models;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "todo")
public class TodoModels implements Serializable {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@DateTimeFormat(fallbackPatterns = "YYYY-MM-dd")
	@NotNull(message = "Tanggal Harus diisi")
	@Column(name = "date")
	private LocalDate date;
	
	 
	@NotEmpty(message = "Aktivitas Harus diisi") 
	@Column(name = "aktivitas")
	private String aktivitas;
	

	@NotNull(message = "Selesai Harus diisi")
	@Enumerated(EnumType.STRING )
	private SelesaiEnum selesai;
	
	@Column(name="created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Instant created_at;
	@Column(name="updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Instant updated_at;

	public Instant getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Instant created_at) {
		this.created_at = created_at;
	}

	public Instant getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Instant updated_at) {
		this.updated_at = updated_at;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getAktivitas() {
		return aktivitas;
	}

	public void setAktivitas(String aktivitas) {
		this.aktivitas = aktivitas;
	}

	public SelesaiEnum getSelesai() {
		return selesai;
	}

	public void setSelesai(SelesaiEnum selesai) {
		this.selesai = selesai;
	}
	
	
}

