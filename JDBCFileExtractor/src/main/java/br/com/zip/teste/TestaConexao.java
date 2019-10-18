package br.com.zip.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.zip.DAO.ConnectURL;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

		try {

			Connection connection = new ConnectURL().getConnection();
			System.out.println("Conexao Aberta");
			connection.close();
			System.out.println("Conexao Fechada");

		} catch (Exception e) {

		}

	}
}
