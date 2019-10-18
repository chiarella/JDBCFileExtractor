package br.com.zip.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LocalizarArquivos {
	
	

	public static File[] main1(String[] args) throws IOException{
		
	  //  FileInputStream file = new FileInputStream("c:/Users/Chiarella/Desktop/teste/");
	FileWriter arquivos = new FileWriter(new File("arquivosLista.txt"));

	File baseFolder = new File("C:/ARQUIVOS");
	File[] files = baseFolder.listFiles();

	for (int i = 0; i < files.length; i++) {
	    File file = files[i];
	    if (file.getPath().endsWith(".txt")) {
		String name = file.getName();
		arquivos.write(name + "\n");
		arquivos.flush();
	    }
	//    compactarParaZip("c:/ARQUIVOS/Arquivo teste gerado.zip", baseFolder.listFiles());
	
	}
	return baseFolder.listFiles();

    }
}