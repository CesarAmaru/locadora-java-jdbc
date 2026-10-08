package br.treino.DAO.entities;

import java.util.List;

import br.treino.entities.Cliente;

public interface IClienteDAO {
	public void salvar(Cliente v);
	public Cliente buscarPorID(Integer id);
	public List<Cliente> listarTodos();
	public void Deletar(Cliente v);
}
