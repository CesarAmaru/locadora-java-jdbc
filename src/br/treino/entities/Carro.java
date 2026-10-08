package br.treino.entities;

public class Carro extends Veiculo{
	private Integer doorQuantity;
	private Boolean airConditioning;
	
	public Carro() {}
	public Carro(Integer id, String placa, String modelo, Double valorDiariaBase, Integer quantidadePortas,
			Boolean arCondicionado) {
		super(id, placa, modelo, valorDiariaBase);
		this.doorQuantity = quantidadePortas;
		this.airConditioning = arCondicionado;
	}

	

	public Integer getDoorQuantity() {
		return doorQuantity;
	}

	public void setDoorQuantity(Integer quantidadePortas) {
		this.doorQuantity = quantidadePortas;
	}

	public Boolean getAirConditioning() {
		return airConditioning;
	}

	public void setAirConditioning(Boolean arCondicionado) {
		this.airConditioning = arCondicionado;
	}

	@Override
	public Double calculateRentalFee(Integer dias) {
		return getBaseDailyFee() * dias;
	}
	
	@Override
	public String toString() {
		return String.format("id %d | placa: %s | modelo: %s | diária: %.2f | portas: %d | ar-condicionado: %b", getId(), getPlate(), getModel(), getBaseDailyFee(), getDoorQuantity(), getAirConditioning());
	}
}
