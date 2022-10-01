package com.sorteador.horarios.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sorteador.horarios.beans.DadosSorteadorHorarios;
import com.sorteador.horarios.service.SorteadorService;
import com.sorteador.horarios.util.response.PayloadResponse;

@RestController 
@RequestMapping(path = "/sorteador", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
@CrossOrigin
public class SorteadorController {

	@Autowired
	private SorteadorService service;
	
	@PostMapping(path = "/sortear")
	public PayloadResponse<List<String>> sortear(@RequestBody DadosSorteadorHorarios dados) throws IOException {
		return PayloadResponse.of(service.sortearByPath(dados));
	}
}
