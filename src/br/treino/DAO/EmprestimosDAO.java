package br.treino.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.treino.DAO.interfaces.InterfaceDAO;
import br.treino.entities.Emprestimos;

public class EmprestimosDAO extends DAO implements InterfaceDAO<Emprestimos>{

	@Override
	public void salvar(Emprestimos v) {
		String sql = "INSERT INTO emprestimos(id, cliente_id, veiculo_id, data_inicio, data_fim, valor_total, status) VALUES (null, ?, ?, ?, ?, ?, ?)";
		try(Connection con = abrirBanco();
			PreparedStatement prs = con.prepareStatement(sql);){
			prs.setInt(1, v.getCliente().getId());
			prs.setInt(2, v.getVeiculo().getId());
			prs.setObject(3, v.getDataInicio()); // setObject aceita java.time, assim não preciso converter a data usando java.sql.Date.valueOf
			prs.setObject(4, v.getDataFim());
			v.setValorTotal();
			prs.setDouble(5, v.getValorTotal());
			prs.setString(6, v.getStatus());
		
			prs.executeUpdate();
			System.out.println("Empréstimo inserido com sucesso!");
			
		}catch(SQLException e) {
			System.err.printf("ERRO: Não foi possivel inserir Emprestimo na tabela. %n%s%n", e.getMessage());
		}
		
	}

	@Override
	public Emprestimos buscarPorID(Integer id) {
		String sql = "SELECT id, cliente_id, veiculo_id, data_inicio, data_fim, valor_total, status FROM emprestimos WHERE id = ?";
		Emprestimos emprestimo = null;
		try(Connection con = abrirBanco();
			PreparedStatement prs = con.prepareStatement(sql);){
			prs.setInt(1, id);
			try(ResultSet rs = prs.executeQuery()){
				if(rs.next()) {
					emprestimo = new Emprestimos();
					emprestimo.setId(rs.getInt("id"));
					emprestimo.setCliente(new ClienteDAO().buscarPorID(rs.getInt("cliente_id")));
					emprestimo.setVeiculo(new VeiculoDAO().buscarPorID(rs.getInt("veiculo_id")));
					emprestimo.setDataInicio(rs.getObject("data_inicio", LocalDate.class));
					emprestimo.setDataFim(rs.getObject("data_fim", LocalDate.class));
					emprestimo.setValorTotal();
					emprestimo.setStatus(rs.getString("status"));
				}
			}
			System.out.println("Emprestimo encontrado!");
			
		}catch (SQLException e) {
			System.err.printf("ERRO: Não foi possivel encontrar emprestimo na tabela. %n%s%n", e.getMessage());
		}
		return emprestimo;
	}

	@Override
	public List<Emprestimos> listarTodos() {
		String sql = "SELECT id, cliente_id, veiculo_id, data_inicio, data_fim, valor_total, status FROM emprestimos";
		List<Emprestimos> listaTemp = new ArrayList<>();
		VeiculoDAO veicAux = new VeiculoDAO();
		ClienteDAO clienteAux = new ClienteDAO();
		
		try(Connection con = abrirBanco();
			PreparedStatement prs = con.prepareStatement(sql);
			ResultSet rs = prs.executeQuery();){
			while(rs.next()) {
				Emprestimos emprestimo = new Emprestimos();
				emprestimo.setId(rs.getInt("id"));
				emprestimo.setCliente(clienteAux.buscarPorID(rs.getInt("cliente_id")));
				emprestimo.setVeiculo(veicAux.buscarPorID(rs.getInt("veiculo_id")));
				emprestimo.setDataInicio(rs.getObject("data_inicio", LocalDate.class));
				emprestimo.setDataFim(rs.getObject("data_fim", LocalDate.class));
				emprestimo.setValorTotal();
				emprestimo.setStatus(rs.getString("status"));
				
				listaTemp.add(emprestimo);
			}
			System.out.println("Lista Gerada!");
			
		}catch (SQLException e) {
			System.err.printf("ERRO: Não foi possivel encontrar emprestimos na tabela. %n%s%n", e.getMessage());
		}
		return listaTemp;
	}

	@Override
	public void deletar(Emprestimos v) {
		String sql = "DELETE FROM emprestimos WHERE id = ?";
		try(Connection con = abrirBanco();
			PreparedStatement prs = con.prepareStatement(sql);){
			prs.setInt(1, v.getId());
			prs.executeUpdate();
			
		}catch (SQLException e) {
			System.err.printf("ERRO: Não foi possivel excluir emprestimo na tabela. %n%s%n", e.getMessage());
		}
		
	}

	@Override
	public void update(Emprestimos v) {
		String sql = "UPDATE emprestimos SET data_fim = ?, valor_total = ?, status = ? ";
		try(Connection con = abrirBanco();
			PreparedStatement prs = con.prepareStatement(sql);){
			prs.setObject(1, v.getDataFim());
			prs.setDouble(2, v.getValorTotal());
			prs.setString(3, v.getStatus());
			
			
		}catch (SQLException e) {
			System.err.printf("ERRO: Não foi possivel atualizar emprestimo na tabela. %n%s%n", e.getMessage());
		}
	}

}
