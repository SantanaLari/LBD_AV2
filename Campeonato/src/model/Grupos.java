package model;

public class Grupos {
	
	private String Grupo;
	private Times CodigoTime;

	public String getGrupo() {
		return Grupo;
	}
	public void setGrupo(String grupo) {
		this.Grupo = grupo;
	}
	public Times getCodigoTime() {
		return CodigoTime;
	}
	public void setCodigoTime(Times codigoTime) {
		this.CodigoTime = codigoTime;
	}
	@Override
	public String toString() {
		return "Grupos [Grupo=" + Grupo + ", CodigoTime=" + CodigoTime + "]";
	}
	
	
	
}
