package br.com.zip.teste;

import br.com.zip.service.GerarArquivoTxt;
import br.com.zip.service.PegarVariosArquivosNoCeZipar;

public class Main {

	public static void main(String[] args) {

		try {
			
		//	PegarVariosArquivosNoCeZipar.irNoCListar();
		
			
			// Gerar arquivo Txt
			 GerarArquivoTxt.gerartxt();
			// GerarArquivoTxt2.gerartxt();

			// Gerar arquivo TXT dentro do ZIP
			// GerarArquivoTxtDentroZip.gerarTxtZip();
			// Pegar no C Arquivo gerado.txt e Zipa no mesmo local
			// PegarArquivoNoCeZipar.compactarParaZip("c:/Arquivos/Arquivo gerado.zip",
			// "c:/Arquivos/Arquivo gerado.txt");
		
			
		} catch (Exception e) {
			System.out.println("ARQUIVO NAO GERADO");
			e.printStackTrace();
		}
	}
}
