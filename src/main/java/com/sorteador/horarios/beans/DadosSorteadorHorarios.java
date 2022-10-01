package com.sorteador.horarios.beans;

import java.io.Serializable;

public class DadosSorteadorHorarios implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer qtdSorteios;
	
	private Integer qtdDeHorarios;

	public Integer getQtdSorteios() {
		return qtdSorteios;
	}

	public void setQtdSorteios(Integer qtdSorteios) {
		this.qtdSorteios = qtdSorteios;
	}

	public Integer getQtdDeHorarios() {
		return qtdDeHorarios;
	}

	public void setQtdDeHorarios(Integer qtdDeHorarios) {
		this.qtdDeHorarios = qtdDeHorarios;
	}
}
