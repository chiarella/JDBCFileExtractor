package br.com.zip.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.zip.bean.ContatoBean;

public class ContatoDao  {
	
	
//	private static  Connection connection;
//	private List<ContatoBean> contatos;
//	
//	public ContatoDao() {
//		this.connection = new ConnectURL().getConnection();
//	}
//
	
	public static  void adiciona(ContatoBean contato) throws SQLException {
		 
		Connection  connection = new ConnectURL().getConnection();
		String sql = "insert into dbo.ContatoDois (Id, nome, sobrenome, email,tel, cel, observacoes) values(?,?,?,?,?,?,?)";
		 try {
			
             PreparedStatement stmt = connection.prepareStatement(sql);
	         stmt.setInt(1,contato.getId());
             stmt.setString(2,contato.getNome());
             stmt.setString(3,contato.getSobrenome());
             stmt.setString(4,contato.getEmail());
             stmt.setInt(5,contato.getTel());
             stmt.setInt(6,contato.getCel());
             stmt.setString(7,contato.getObservacoes());
             
             stmt.execute();
             stmt.close();
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
     }
	
	public List<ContatoBean> getLista() {
		
		try {
			Connection connection = new ConnectURL().getConnection();
			
			List<ContatoBean> contato = new ArrayList<ContatoBean>();
			PreparedStatement stmt = connection.prepareStatement("select * from ContatoDois");
			ResultSet rs = stmt.executeQuery();
			
		//	contatos = null;
			while (rs.next()) {
				ContatoBean contato1  =  new ContatoBean();
				contato1.setId(rs.getInt("id"));
				contato1.setNome(rs.getString("nome"));
				contato1.setSobrenome(rs.getString("sobrenome"));
				contato1.setTel(rs.getInt("tel"));
				contato1.setCel(rs.getInt("cel"));
				contato1.setEmail(rs.getString("email"));
				contato1.setObservacoes(rs.getString("observacoes"));
				contato.add(contato1);
			}
            rs.close();
            stmt.close();
            connection.close();
            return contato;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}