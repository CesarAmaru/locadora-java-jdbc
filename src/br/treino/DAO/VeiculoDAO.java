package br.treino.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.InvalidAttributesException;

import br.treino.DAO.entities.InterfaceDAO;
import br.treino.entities.Veiculo;
import br.treino.entities.Carro;
import br.treino.entities.Cliente;
import br.treino.entities.Moto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VeiculoDAO extends DAO implements InterfaceDAO<Veiculo> {

	@Override
	public void salvar(Veiculo v) {
		try (Connection con = abrirBanco();) {
			if (v instanceof Carro carroTemp) {
				String sql = "INSERT INTO veiculos (id, tipo_veiculo, placa, modelo, valor_diaria_base, quantidade_portas, ar_condicionado) VALUES (null, ?, ?, ?, ?, ?, ?)";
				try (PreparedStatement prs = con.prepareStatement(sql);) {
					prs.setString(1, "CARRO");
					prs.setString(2, carroTemp.getPlate());
					;
					prs.setString(3, carroTemp.getModel());
					prs.setDouble(4, carroTemp.getBaseDailyFee());
					prs.setInt(5, carroTemp.getDoorQuantity());
					prs.setBoolean(6, carroTemp.getAirConditioning());

					prs.executeUpdate();
				}
			} else if (v instanceof Moto motoTemp) {
				String sql = "INSERT INTO veiculos (id, tipo_veiculo, placa, modelo, valor_diaria_base, cilindradas) VALUES (null, ?, ?, ?, ?, ?)";
				try (PreparedStatement prs = con.prepareStatement(sql);) {
					prs.setString(1, "MOTO");
					prs.setString(2, motoTemp.getPlate());
					;
					prs.setString(3, motoTemp.getModel());
					prs.setDouble(4, motoTemp.getBaseDailyFee());
					prs.setInt(5, motoTemp.getCilindradas());

					prs.executeUpdate();
				}
			} else {
				System.err.println("ERRO: Classe invalida.");
			}
			System.out.println("Veiculo salvo!");
		} catch (SQLException e) {
			System.err.printf("ERRO: Não foi possivel inserir o veiculo na tabela. %n%s%n", e.getMessage());
		}

	}

	@Override
	public Veiculo buscarPorID(Integer id) {
		String sql = "SELECT id, tipo_veiculo, placa, modelo, valor_diaria_base, quantidade_portas, ar_condicionado, cilindradas FROM veiculos WHERE id = ?";
		Veiculo veic = null;
		try (Connection con = abrirBanco(); PreparedStatement prs = con.prepareStatement(sql);) {
			prs.setInt(1, id);
			try (ResultSet rs = prs.executeQuery();) {
				if (rs.next()) {
					if (rs.getString("tipo_veiculo").equalsIgnoreCase("MOTO")) {
						Moto tempMoto = new Moto();
						tempMoto.setId(rs.getInt("id"));
						tempMoto.setPlate(rs.getString("placa"));
						tempMoto.setModel(rs.getString("modelo"));
						tempMoto.setBaseDailyFee(rs.getDouble("valor_diaria_base"));
						tempMoto.setCilindradas(rs.getInt("cilindradas"));
						veic = tempMoto;
					} else if (rs.getString("tipo_veiculo").equalsIgnoreCase("CARRO")) {
						Carro tempCarro = new Carro();
						tempCarro.setId(rs.getInt("id"));
						tempCarro.setPlate(rs.getString("placa"));
						tempCarro.setModel(rs.getString("modelo"));
						tempCarro.setBaseDailyFee(rs.getDouble("valor_diaria_base"));
						tempCarro.setDoorQuantity(rs.getInt("quantidade_portas"));
						tempCarro.setAirConditioning(rs.getBoolean("ar_condicionado"));
						veic = tempCarro;

					} else {
						System.err.println("ERRO: classe invalida.");
					}
				}
			}
			System.out.println("Veículo encontrado!");
		} catch (SQLException e) {
			System.err.printf("ERRO: Não foi possivel encontrar veiculo na tabela. %n%s%n", e.getMessage());
		}

		return veic;
	}

	@Override
	public List<Veiculo> listarTodos() {
		String sql = "SELECT id, tipo_veiculo, placa, modelo, valor_diaria_base, quantidade_portas, ar_condicionado, cilindradas FROM veiculos";
		List<Veiculo> listaAux = new ArrayList<>();
		try (Connection con = abrirBanco();
				PreparedStatement prs = con.prepareStatement(sql);
				ResultSet rs = prs.executeQuery();) {
			while (rs.next()) {
				if (rs.getString("tipo_veiculo").equalsIgnoreCase("MOTO")) {
					Moto tempMoto = new Moto();
					tempMoto.setId(rs.getInt("id"));
					tempMoto.setPlate(rs.getString("placa"));
					tempMoto.setModel(rs.getString("modelo"));
					tempMoto.setBaseDailyFee(rs.getDouble("valor_diaria_base"));
					tempMoto.setCilindradas(rs.getInt("cilindradas"));
					listaAux.add(tempMoto);
				} else if (rs.getString("tipo_veiculo").equalsIgnoreCase("CARRO")) {
					Carro tempCarro = new Carro();
					tempCarro.setId(rs.getInt("id"));
					tempCarro.setPlate(rs.getString("placa"));
					tempCarro.setModel(rs.getString("modelo"));
					tempCarro.setBaseDailyFee(rs.getDouble("valor_diaria_base"));
					tempCarro.setDoorQuantity(rs.getInt("quantidade_portas"));
					tempCarro.setAirConditioning(rs.getBoolean("ar_condicionado"));
					listaAux.add(tempCarro);
				}
			}
			System.out.println("Lista feita!");
		} catch (SQLException e) {
			System.err.printf("ERRO: Não foi possivel listar veiculos da tabela. %n%s%n", e.getMessage());
		}

		return listaAux;
	}

	@Override
	public void Deletar(Veiculo v) {
		String sql = "DELETE FROM veiculos where id = ?";
		try (Connection con = abrirBanco(); PreparedStatement prs = con.prepareStatement(sql)) {
			prs.setInt(1, v.getId());
			prs.executeUpdate();
			System.out.println("Veiculo excluido!");
		} catch (SQLException e) {
			System.err.printf("ERRO: Não foi possivel excluir veiculo da tabela. %n%s%n", e.getMessage());
		}

	}

	@Override
	public void update(Veiculo v) {
		
		try (Connection con = abrirBanco();) {
			if (v instanceof Carro carroTemp) {
				String sql = "UPDATE veiculos SET valor_diaria_base = ?, quantidade_portas = ?, ar_condicionado = ? WHERE id = ?";
				try (PreparedStatement prs = con.prepareStatement(sql);) {
					prs.setDouble(1, carroTemp.getBaseDailyFee());
					prs.setInt(2, carroTemp.getDoorQuantity());
					prs.setBoolean(3, carroTemp.getAirConditioning());
					prs.setInt(4, carroTemp.getId());
					prs.executeUpdate();
				}

			} else if (v instanceof Moto motoTemp) {
				String sql = "UPDATE veiculos SET valor_diaria_base = ?, cilindradas = ? WHERE id = ?";
				try (PreparedStatement prs = con.prepareStatement(sql);) {
					prs.setDouble(1, motoTemp.getBaseDailyFee());
					prs.setInt(2, motoTemp.getCilindradas());
					prs.setInt(3, motoTemp.getId());
					prs.executeUpdate();
				}
			}else {
				System.err.println("ERRO: classe invalida.");
			}
			System.out.println("Veículo atualizado com sucesso!");
		} catch (SQLException e) {
			System.err.printf("ERRO: Não foi possivel atualizar veiculo da tabela. %n%s%n", e.getMessage());
		}
	}

}
