package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Pedido {
	private int id;
	private LocalDateTime dataHora;
	private double valorTotal;
	private String entregador;
	private boolean pago;
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	private Cliente cliente;
	
	public Pedido(int id, LocalDateTime datahora, double valorTotal, String entregador, boolean pago, ArrayList<Produto> produtos, Cliente cliente) {
		this.id = id;
		this.dataHora = datahora;
		this.valorTotal = valorTotal;
		this.entregador = entregador;
		this.pago = pago;
		this.produtos = produtos;
		this.cliente = cliente;
	}
	
	public int getId() {
		return id;
	}
	
	public double getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public ArrayList<Produto> getProdutos(){
		return produtos;
	}
	
	@Override
	public String toString() {
		return "Pedido: id=" + id + ", datahora=" + dataHora + ", valortotal=" + valorTotal + ", entregador="
				+ entregador + ", pago=" + pago + ", produtos=" + produtos + "\ncliente=" + cliente + "\n";
	}
	
}
