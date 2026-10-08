package br.treino.entities;

public abstract class Veiculo {
	private Integer id;
	private String plate;
	private String model;
	private Double baseDailyFee;
	
	public Veiculo() {}

	public Veiculo(Integer id, String placa, String modelo, Double valorDiariaBase) {
		this.id = id;
		this.plate = placa;
		this.model = modelo;
		this.baseDailyFee = valorDiariaBase;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String placa) {
		this.plate = placa;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String modelo) {
		this.model = modelo;
	}

	public Double getBaseDailyFee() {
		return baseDailyFee;
	}

	public void setBaseDailyFee(Double valorDiariaBase) {
		this.baseDailyFee = valorDiariaBase;
	}
	
	public abstract Double calculateRentalFee(Integer dias);
}
