package br.treino.view;

import java.util.List;
import br.treino.DAO.ClienteDAO;
import br.treino.DAO.VeiculoDAO;
import br.treino.entities.Cliente;
import br.treino.entities.Veiculo;

public class Tela {

	public static void main(String[] args) {
		
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		ClienteDAO clienteDAO = new ClienteDAO();

		System.out.println("20 Veículos inseridos com sucesso!\n");

		System.out.println("--- LISTA DE CLIENTES CADASTRADOS ---");
		List<Cliente> clientes = clienteDAO.listarTodos();
		clientes.stream().forEach(System.out::println);

		System.out.println("\n--- LISTA DE VEÍCULOS (POLIMORFISMO) ---");
		List<Veiculo> veiculos = veiculoDAO.listarTodos();
		veiculos.stream().forEach(System.out::println);

		System.out.println("\n--- TESTANDO EXCLUSÃO E BUSCA POR ID ---");
		Cliente clienteParaDeletar = clienteDAO.buscarPorID(1);
		if (clienteParaDeletar != null) {
			clienteDAO.deletar(clienteParaDeletar);
			System.out.println("Cliente " + clienteParaDeletar.getName() + " deletado com sucesso!");
		}

	}

}
