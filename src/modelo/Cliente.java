package modelo;

import java.util.ArrayList;

public class Cliente {
	private String telefone;
	private String nome;
	private String endereco;
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	
	public Cliente(String telefone, String nome, String endereco) {
		this.telefone = telefone;
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getEndereco() {
		return this.endereco;
	}
	
	@Override
	public String toString() {
		String texto = " telefone: " + telefone + ", nome:" + nome + ", endereco: " + endereco;
		return texto + "\n";
	}
}
