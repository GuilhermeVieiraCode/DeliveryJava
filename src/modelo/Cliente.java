package modelo;

import java.util.ArrayList;

public class Cliente {
	private String telefone;
	private String nome;
	private String endereco;
	private ArrayList<Pedido> pedidos;
	
	public Cliente(String telefone, String nome, String endereco, ArrayList<Pedido> pedidos) {
		this.telefone = telefone;
		this.nome = nome;
		this.endereco = endereco;
		this.pedidos = pedidos;
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
	
	public ArrayList<Pedido> getPedidos(){
		return this.pedidos;
	}
	
	@Override
	public String toString() {
		String texto = " telefone: " + telefone + ", nome:" + nome + ", endereco: " + endereco;
		return texto + "\n";
	}
}
