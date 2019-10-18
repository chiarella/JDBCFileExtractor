package br.com.zip.teste;

import java.sql.SQLException;
import java.util.List;

import br.com.zip.DAO.ContatoDao;
import br.com.zip.bean.ContatoBean;

public class TestaListaSelect {

	public static void main(String[] args) throws SQLException {

		// Criando um contato DAO
		ContatoDao dao = new ContatoDao();

		// Lista os contatos com o DAO
		List<ContatoBean> contatos = dao.getLista();

		for (ContatoBean contato : contatos) {
			System.out.println("Id: " + contato.getId());
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Sobrenome: " + contato.getSobrenome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Telefone: " + contato.getTel());
			System.out.println("Celular: " + contato.getCel());
			System.out.println("Obsercações: " + contato.getObservacoes());
			System.out.println("---");
		}
	}
}
