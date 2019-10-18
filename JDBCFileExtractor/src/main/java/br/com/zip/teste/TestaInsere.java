package br.com.zip.teste;

import java.sql.SQLException;

import br.com.zip.DAO.ContatoDao;
import br.com.zip.bean.ContatoBean;

public class TestaInsere {
	
	
	public static void main(String[] args) throws SQLException {

	ContatoBean contato  = new ContatoBean();
	contato.setId(6);
	contato.setNome("Angelo");
	contato.setSobrenome("Chiarella");
	contato.setEmail("Aline@gmail.com.com.br");
	contato.setTel(0);
	contato.setCel(0);
	contato.setObservacoes(null);
		
	ContatoDao.adiciona(contato);
		
	}

}
