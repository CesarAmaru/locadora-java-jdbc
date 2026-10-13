package br.treino.DAO.interfaces;

import java.util.List;


public interface InterfaceDAO<T> {
	public void salvar(T v);
	public T buscarPorID(Integer id);
	public List<T> listarTodos();
	public void deletar(T v);
	public void update(T v);
}
