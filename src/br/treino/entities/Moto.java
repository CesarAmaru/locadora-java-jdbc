package br.treino.entities;

public class Moto extends Veiculo{
	private Integer cilindradas;
	
	public Moto() {}
	public Moto(Integer id, String placa, String modelo, Double valorDiariaBase, Integer cilindradas) {
		super(id, placa, modelo, valorDiariaBase);
		this.cilindradas = cilindradas;
	}

	public Integer getCilindradas() {
		return cilindradas;
	}

	public void setCilindradas(Integer cilindradas) {
		this.cilindradas = cilindradas;
	}

	@Override
	public Double calculateRentalFee(Integer dias) {
		return getBaseDailyFee() * dias;
	}
	 
	@Override
	public String toString() {
		return String.format("id %d | placa: %s | modelo: %s | diária: %.2f | cilindradas: %d", getId(), getPlate(), getModel(), getBaseDailyFee(), getCilindradas());
	}
	
}
