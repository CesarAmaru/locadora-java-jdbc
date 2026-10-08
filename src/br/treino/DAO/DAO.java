package br.treino.DAO;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import br.treino.entities.Moto;
import br.treino.entities.Veiculo;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;

public class DAO {
	
	private static Properties carregarPropriedades() {
        Properties props = new Properties();
        try (FileInputStream fs = new FileInputStream("config.properties")) {
            props.load(fs);
        } catch (IOException e) {
            System.err.println("Erro ao carregar arquivo de configurações: " + e.getMessage());
        }
        return props;
    }

	public static Connection abrirBanco() throws SQLException {
		Properties props = carregarPropriedades();
        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String pw = props.getProperty("db.password");
        
		return DriverManager.getConnection(url, user, pw);
	}

}

