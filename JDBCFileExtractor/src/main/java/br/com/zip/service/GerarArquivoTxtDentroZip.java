package br.com.zip.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import br.com.zip.DAO.ContatoDao;
import br.com.zip.bean.ContatoBean;

public class GerarArquivoTxtDentroZip {

	public static void gerarTxtZip() throws Exception {

		try {
			ContatoDao dao = new ContatoDao();
			List<ContatoBean> contatos = dao.getLista();
			StringBuilder texto = new StringBuilder();

			for (ContatoBean contato : contatos) {
				texto.append(contato.getId());
				texto.append(contato.getNome());
				texto.append(contato.getSobrenome());
				texto.append(contato.getTel());
				texto.append(contato.getCel());
				texto.append(contato.getEmail());
				texto.append(contato.getObservacoes());
				texto.append(System.getProperty("line.separator"));
			}

			File f = new File("C:/Arquivos/ArquivoTXTZipado.zip");
			
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f));
			ZipEntry e = new ZipEntry("Arquivo Gerado.txt");
			
			out.putNextEntry(e);

			byte[] data = texto.toString().getBytes();
			out.write(data, 0, data.length);
			out.closeEntry();

			out.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}