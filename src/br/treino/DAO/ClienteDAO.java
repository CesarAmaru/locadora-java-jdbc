package br.treino.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.treino.DAO.entities.IClienteDAO;
import br.treino.entities.Cliente;

public class ClienteDAO extends DAO implements IClienteDAO {

	@Override
	public void salvar(Cliente v) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO clientes (id, nome, cnh) VALUES (null, ?, ?)";
		try (Connection con = abrirBanco(); PreparedStatement prs = con.prepareStatement(sql);) {
			prs.setString(1, v.getName());
			prs.setString(2, v.getCnh());
			prs.executeUpdate();
			System.out.println("Cliente salvo!");
		} catch (SQLException e) {
			System.err.printf("ERRO: Não foi possivel inserir cliente na tabela. %n%s%n", e.getMessage());
		}
	}

	@Override
	public Cliente buscarPorID(Integer id) {
		String sql = "SELECT id, nome, cnh FROM clientes WHERE id = ?";
		Cliente cliente = null;
		try (Connection con = abrirBanco(); PreparedStatement prs = con.prepareStatement(sql);) {
			prs.setInt(1, id);
			try (ResultSet rs = prs.executeQuery()) {
				if (rs.next()) {
					cliente = new Cliente();
					cliente.setId(rs.getInt("id"));
					cliente.setName(rs.getString("nome"));
					cliente.setCnh(rs.getString("cnh"));
				}
			}
			System.out.println("Cliente encontrado!");
		} catch (SQLException e) {
			System.err.printf("ERRO: Não foi possivel encontrar cliente na tabela. %n%s%n", e.getMessage());
		}

		return cliente;
	}

	@Override
	public List<Cliente> listarTodos() {
		String sql = "SELECT id, nome, cnh FROM clientes";
		List<Cliente> listaTemp = new ArrayList<>();
		try (Connection con = abrirBanco();
				PreparedStatement prs = con.prepareStatement(sql);
				ResultSet rs = prs.executeQuery();) {
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setName(rs.getString("nome"));
				cliente.setCnh(rs.getString("cnh"));
				listaTemp.add(cliente);
			}
			System.out.println("Lista feita!");
		} catch (SQLException e) {
			System.err.printf("ERRO: Não foi possivel listar clientes da tabela. %n%s%n", e.getMessage());
		}

		return listaTemp;
	}

	@Override
	public void Deletar(Cliente v) {
		String sql = "DELETE FROM clientes where id = ? ";
		try (Connection con = abrirBanco(); PreparedStatement prs = con.prepareStatement(sql);) {
			prs.setInt(1, v.getId());
			prs.executeUpdate();
			System.out.println("Cliente excluído!");
		} catch (SQLException e) {
			System.err.printf("ERRO: Não foi possivel excluir cliente da tabela. %n%s%n", e.getMessage());
		}

	}

}
