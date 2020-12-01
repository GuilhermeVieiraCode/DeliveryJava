package modelo;

import java.util.ArrayList;

public class Produto {
	private static int counter = 0;
	private int id;
	private String nome;
	private double preco;
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	
	public Produto(String nome, double preco) {
		this.id = ++counter;
		this.nome = nome;
		this.preco = preco;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}
	
	@Override
	public String toString() {
		String texto = "id: " + id + ", nome:" + nome + ", preco: " + preco;
		return texto + "\n";
	}
	
}
