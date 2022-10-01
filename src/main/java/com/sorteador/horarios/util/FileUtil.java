package com.sorteador.horarios.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

import org.springframework.util.ResourceUtils;

public class FileUtil {

	public static byte[] lerArquivoByNomeArquivo(String nomeArquivo) {
		
		try {
			
			URL url = ResourceUtils.getURL("classpath:" + nomeArquivo);
			
			BufferedReader buffer = new BufferedReader(new InputStreamReader(url.openStream()));
			
			String linha = buffer.lines().collect(Collectors.joining(System.lineSeparator()));
			
			buffer.close();
			
			return linha.getBytes();
			
		} catch (IOException e) {
			throw new RuntimeException("Erro ao ler arquivo. motivo: " + e);
		}
		
		
	}
}
