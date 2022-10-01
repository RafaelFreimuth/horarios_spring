package com.sorteador.horarios.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sorteador.horarios.beans.DadosSorteadorHorarios;
import com.sorteador.horarios.util.FileUtil;

@Service
public class SorteadorService {
	
	public List<String> sortearByPath(DadosSorteadorHorarios dados) throws IOException {
		byte[] arquivo = FileUtil.lerArquivoByNomeArquivo("horarios.txt");
		
		List<String> listaHoraios = converterArrayBytesEmListaString(arquivo);
		
		return realizarSorteio(dados, listaHoraios);
	} 
	
	private List<String> converterArrayBytesEmListaString(byte[] bytes) {
		return Arrays.asList(new String(bytes, StandardCharsets.UTF_8).split(";"));
	}
	
	private List<String> realizarSorteio(DadosSorteadorHorarios dados, List<String> listaHoraios) {
		int qtdDeRepeticoes = dados.getQtdSorteios();
		int controle = 1;
		
		List<String> resultados = new ArrayList<>();
		
		while (controle <= qtdDeRepeticoes) {			
			resultados.add(sortearHorariosRamdom(listaHoraios, dados));
			
			controle++;
		}
		
		return resultados;
	}
	
	private String sortearHorariosRamdom(List<String> listaHoraios, DadosSorteadorHorarios dados) {
		
		int qtdDeHorarios = dados.getQtdDeHorarios();
		int controleQtdHorarios = 1;
		
		List<String> listaHorariosSorteados = new ArrayList<String>();
		
		while (controleQtdHorarios <= qtdDeHorarios) {
			String elemento = getRamdomElement(listaHoraios);
			
			if (listaHorariosSorteados.contains(elemento) || isJahPossuiMesmaHoraJaEscolhida(listaHorariosSorteados, elemento)) {
				continue;
			}
			
			listaHorariosSorteados.add(elemento.concat("  "));
			
			controleQtdHorarios++;
		}
		
		return listaHorariosSorteados.stream().reduce("", String::concat);
	}
	
	private String getRamdomElement(List<String> listaHoraios) {
		Random rand = new Random();
		
		return listaHoraios.get(rand.nextInt(listaHoraios.size()));
	}
	
	private boolean isJahPossuiMesmaHoraJaEscolhida(List<String> listaHorariosSorteados, String elementoAtual) {
		if (listaHorariosSorteados.size() <= 0) {
			return false;
		}
		
		List<String> listaSomenteHoras = listaHorariosSorteados.stream()
															   .map(horario -> horario.substring(0, 2))
															   .collect(Collectors.toList());
		
		return listaSomenteHoras.contains(elementoAtual.substring(0, 2));
	}
}
