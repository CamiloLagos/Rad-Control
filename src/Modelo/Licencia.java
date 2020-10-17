package Modelo;

import com.google.gson.annotations.SerializedName;

public class Licencia {

	@SerializedName("valor")
	private String valor;
	@SerializedName("usada")
	private String usada;
	@SerializedName("usuario")
	private String usuario;

	public Licencia() {
		super();
	}

	public Licencia(String valor, String usada, String usuario) {
		super();
		this.valor = valor;
		this.usada = usada;
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String toJson() {

		String json = "{" + "\"usada\": \"" + usada + "\"," + "\"usuario\": \"" + usuario + "\"," + "\"valor\": \""
				+ valor + "\"" + "}";

		return json;

	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getUsada() {
		return usada;
	}

	public void setUsada(String usada) {
		this.usada = usada;
	}

}
