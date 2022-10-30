package model;

public class Times {

	private int CodigoTime;
	private String NomeTime;
	private String Cidade;
	private String Estadio;
	
	public int getCodigoTime() {
		return CodigoTime;
	}
	public void setCodigoTime(int codigoTime) {
		CodigoTime = codigoTime;
	}
	public String getNomeTime() {
		return NomeTime;
	}
	public void setNomeTime(String nomeTime) {
		NomeTime = nomeTime;
	}
	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		Cidade = cidade;
	}
	public String getEstadio() {
		return Estadio;
	}
	public void setEstadio(String estadio) {
		Estadio = estadio;
	}
	@Override
	public String toString() {
		return "Times [CodigoTime=" + CodigoTime + ", NomeTime=" + NomeTime + ", Cidade=" + Cidade + ", Estadio="
				+ Estadio + "]";
	}
	
	
}
