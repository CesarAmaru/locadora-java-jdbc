package br.treino.entities;

public class Cliente {
	private Integer id;
	private String name;
	private String cnh;
	
	public Cliente() {}
	public Cliente(Integer id, String nome, String cnh) {
		this.id = id;
		this.name = nome;
		this.cnh = cnh;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String nome) {
		this.name = nome;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	
	@Override
	public String toString() {
		return String.format("id: %d | nome: %s | cnh: %s", id, name, cnh);
	}
	
}
