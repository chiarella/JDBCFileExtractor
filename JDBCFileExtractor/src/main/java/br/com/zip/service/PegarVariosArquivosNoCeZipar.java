package br.com.zip.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import br.com.zip.DAO.ContatoDao;

public class PegarVariosArquivosNoCeZipar {

	// boolean arquivosParaCompactacao;

	static byte[] buffer = new byte[1024];
	// método para compactar arquivo

	public static ArrayList<String> irNoCListar() throws IOException {

		FileWriter arquivos = new FileWriter(new File("arquivosLista.csv"));

		File baseFolder = new File("C:/ARQUIVOS");

//		File[] files = baseFolder.listFiles();

		ArrayList<String> alfiles = new ArrayList<String>();
		File[] files1 = baseFolder.listFiles();
		for (int i = 0; i < files1.length; i++) {
			File file = files1[i];
			alfiles.add(file.getName());
			String name = file.getName();
			arquivos.write(name + "\n");
			arquivos.flush();
		}
		//String arquivoCompactado = "c:/Arquivos/Arquivo gerado.zip";
		compactarParaZipLista("c:/ARQUIVOS/Arquivo teste gerado.zip", alfiles);
		return alfiles;

	}


	String arquivoCompactado = "c:/Arquivos/Arquivo gerado.zip";

	public static void compactarParaZipLista(String arquivoCompactado, List<String> arquivosParaCompactacao)
			throws IOException {
		String  test2 = "c:/Arquivos/";
		try {
			// this.criarPasta(new File(arquivoCompactado).getParent());

			// cria o arquivo zip
			ZipOutputStream saidaDeStream = new ZipOutputStream(new FileOutputStream(arquivoCompactado));

			// marca o modo de compreensão do arquivo
			saidaDeStream.setLevel(Deflater.BEST_COMPRESSION);

			// laço para pegar todos os arquivos que serao zipados
			for (int i = 0; i < arquivosParaCompactacao.size(); i++) {
				// carrega o arquivo em um stream
						
				
				FileInputStream entradaDeStream = new FileInputStream(test2 + arquivosParaCompactacao.get(i));

				// cria uma entrada no zip para o arquivo
				saidaDeStream.putNextEntry(new ZipEntry(arquivosParaCompactacao.get(i)));

				// transfere os dados do arquivo para o zip
				int tamanhoArquivo;
				while ((tamanhoArquivo = entradaDeStream.read(buffer)) > 0) {
					saidaDeStream.write(buffer, 0, tamanhoArquivo);
				}

				// fecha a entrada do arquivo no zip
				saidaDeStream.closeEntry();

				// fecha o arquivo
				entradaDeStream.close();
			}

			// fecha o arquivo zip
			saidaDeStream.close();

		} catch (Exception e) {
			
			System.out.println("logger, ERRO AO ZIPAR TODOS ");

		}
	}

}
