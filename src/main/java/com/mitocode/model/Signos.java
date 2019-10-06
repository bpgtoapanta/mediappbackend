package com.mitocode.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "signos")
public class Signos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSigno;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fecha;
	
	@Column(name = "temperatura", nullable = false, length = 10)
	private int temperatura;

	@Column(name = "pulso", nullable = false, length = 50)
	private String pulso;
	
	@Column(name = "ritmo", nullable = false, length = 50)
	private String ritmoRespiratorio;
	
	@ManyToOne
	@JoinColumn(name = "id_paciente", nullable = false, foreignKey = @ForeignKey(name = "fk_signos_paciente"))
	private Paciente paciente;
	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Integer getIdSigno() {
		return idSigno;
	}

	public void setIdSigno(Integer idSigno) {
		this.idSigno = idSigno;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

	public String getPulso() {
		return pulso;
	}

	public void setPulso(String pulso) {
		this.pulso = pulso;
	}

	public String getRitmoRespiratorio() {
		return ritmoRespiratorio;
	}

	public void setRitmoRespiratorio(String ritmoRespiratorio) {
		this.ritmoRespiratorio = ritmoRespiratorio;
	}
	
	
	

}
