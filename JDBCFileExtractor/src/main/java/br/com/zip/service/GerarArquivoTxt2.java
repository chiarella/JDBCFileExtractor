package br.com.zip.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import br.com.zip.DAO.ContatoDao;
import br.com.zip.bean.ContatoBean;

public class GerarArquivoTxt2 {
	
	public static void gerartxt() {

		try {
			String content = "c:/Arquivos/Arquivo gerado2.txt";

			File file = new File(content);

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			ContatoDao dao = new ContatoDao();
			List<ContatoBean> contatos = dao.getLista();
			StringBuilder texto = new StringBuilder();

			for (ContatoBean contato : contatos) {
				texto.append("Id: " + contato.getId());
				texto.append("Nome: " + contato.getNome());
				texto.append("Sobrenome: " + contato.getSobrenome());
				texto.append("Tel.: " + contato.getTel());
				texto.append("Cel.: " + contato.getCel());
				texto.append("email: " + contato.getEmail());
				texto.append("Observações: " + contato.getObservacoes());
				texto.append(System.getProperty("line.separator"));

			}

			texto.toString();
			// System.out.println(texto.toString());

			bw.write(texto.toString());
			bw.close();

			// Compactador.compactarParaZip(saida, content );

			System.out.println("Arquivo TXT gerado Verificar em  C:");

		} catch (IOException e) {
			System.out.println("Erro ao gerar o arquivo");
			e.printStackTrace();
		}

	}

}
