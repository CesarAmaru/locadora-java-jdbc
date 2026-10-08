package br.treino.DAO.entities;

import java.util.List;

import br.treino.entities.Veiculo;

public interface IVeiculoDAO {
	public void salvar(Veiculo v);
	public Veiculo buscarPorID(Integer id);
	public List<Veiculo> listarTodos();
	public void Deletar(Veiculo v);
}
