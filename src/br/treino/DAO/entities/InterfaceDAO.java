package br.treino.DAO.entities;

import java.util.List;

import br.treino.entities.Cliente;

public interface InterfaceDAO<T> {
	public void salvar(T v);
	public T buscarPorID(Integer id);
	public List<T> listarTodos();
	public void Deletar(T v);
	public void update(T v);
}
