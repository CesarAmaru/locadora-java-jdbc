package br.treino.view;

import java.util.List;

import br.treino.DAO.ClienteDAO;
import br.treino.DAO.VeiculoDAO;
import br.treino.entities.Carro;
import br.treino.entities.Cliente;
import br.treino.entities.Moto;
import br.treino.entities.Veiculo;

public class Tela {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		ClienteDAO clienteDAO = new ClienteDAO();

		System.out.println("--- INSERINDO CLIENTES ---");
		clienteDAO.salvar(new Cliente(null, "Ana Costa", "11122233344"));
		clienteDAO.salvar(new Cliente(null, "Roberto Almeida", "55566677788"));
		clienteDAO.salvar(new Cliente(null, "Fernanda Lima", "99988877766"));
		clienteDAO.salvar(new Cliente(null, "João Silva", "10101010101"));
		clienteDAO.salvar(new Cliente(null, "Maria Oliveira", "20202020202"));
		clienteDAO.salvar(new Cliente(null, "Carlos Souza", "30303030303"));
		clienteDAO.salvar(new Cliente(null, "Beatriz Santos", "40404040404"));
		clienteDAO.salvar(new Cliente(null, "Lucas Pereira", "50505050505"));
		clienteDAO.salvar(new Cliente(null, "Juliana Costa", "60606060606"));
		clienteDAO.salvar(new Cliente(null, "Marcos Rodrigues", "70707070707"));
		System.out.println("10 Clientes inseridos com sucesso!\n");

		System.out.println("--- INSERINDO VEÍCULOS ---");
		
		veiculoDAO.salvar(new Carro(null, "ABC-1001", "Toyota Corolla", 200.0, 4, true));
		veiculoDAO.salvar(new Carro(null, "XYZ-2002", "Fiat Mobi", 90.0, 4, false));
		veiculoDAO.salvar(new Carro(null, "DEF-3003", "Jeep Renegade", 250.0, 4, true));
		veiculoDAO.salvar(new Carro(null, "GHI-4004", "Chevrolet Onix", 110.0, 4, true));
		veiculoDAO.salvar(new Carro(null, "JKL-5005", "Volkswagen Polo", 130.0, 4, true));
		veiculoDAO.salvar(new Carro(null, "MNO-6006", "Renault Kwid", 85.0, 4, false));
		veiculoDAO.salvar(new Carro(null, "PQR-7007", "Hyundai HB20", 115.0, 4, true));
		veiculoDAO.salvar(new Carro(null, "STU-8008", "Nissan Kicks", 200.0, 4, true));
		veiculoDAO.salvar(new Carro(null, "VWX-9009", "Honda HR-V", 220.0, 4, true));
		veiculoDAO.salvar(new Carro(null, "YZA-1010", "Ford Ka", 95.0, 2, false));

	
		veiculoDAO.salvar(new Moto(null, "MOT-1001", "Honda CB 500", 130.0, 500));
		veiculoDAO.salvar(new Moto(null, "YAM-2002", "Yamaha Fazer 250", 85.0, 250));
		veiculoDAO.salvar(new Moto(null, "BCD-2022", "Honda CG 160", 60.0, 160));
		veiculoDAO.salvar(new Moto(null, "EFG-3033", "Yamaha NMAX 160", 75.0, 160));
		veiculoDAO.salvar(new Moto(null, "HIJ-4044", "Honda PCX", 80.0, 150));
		veiculoDAO.salvar(new Moto(null, "KLM-5055", "BMW G 310 R", 150.0, 313));
		veiculoDAO.salvar(new Moto(null, "NOP-6066", "Kawasaki Ninja 400", 180.0, 399));
		veiculoDAO.salvar(new Moto(null, "QRS-7077", "Suzuki V-Strom 650", 250.0, 645));
		veiculoDAO.salvar(new Moto(null, "TUV-8088", "Triumph Tiger 900", 350.0, 888));
		veiculoDAO.salvar(new Moto(null, "WXY-9099", "Royal Enfield Classic", 140.0, 350));
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
			clienteDAO.Deletar(clienteParaDeletar);
			System.out.println("Cliente " + clienteParaDeletar.getName() + " deletado com sucesso!");
		}

	}

}
