
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programa��o Orientada a Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/
package repositorio;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;

public class Repositorio {
	private ArrayList<Produto> produtos = new ArrayList<>();
	private ArrayList<Pedido> pedidos = new ArrayList<>();
	private HashMap<String,Cliente> clientes = new HashMap<>();	//a chave � o telefone
	
	public void adicionar(Produto p){
		produtos.add(p);
	}
	public void remover(Produto p){
		produtos.remove(p);
	}
	public Produto localizarProduto(int id){
		//associar id com a posi��o do objeto
		if(id>=1 && id <= produtos.size())
			return produtos.get(id-1); // posicao � id-1
		else
			return null;
	}
	
	public void adicionar(Pedido p){
		pedidos.add(p);
	}
	public void remover(Pedido p){
		pedidos.remove(p);
	}
	public Pedido localizarPedido(int id){
		for(Pedido p : pedidos){
			if(p.getId()==id)
				return p;
		}
		return null;
	}

	public void adicionar(Cliente c){
		clientes.put(c.getTelefone(),  c); //chave � o telefone
	}
	public void remover(Cliente c){
		clientes.remove(c.getTelefone());  //chave � o telefone
	}
	public Cliente localizarCliente(String telefone){
		return clientes.get(telefone);
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}
	public HashMap<String,Cliente> getClientes() {
		//return new ArrayList<>(clientes.values());
		return clientes;
	}
	
	public int getTotalProdutos(){
		return produtos.size();
	}
	public int getTotalPedidos(){
		return pedidos.size();
	}
	public int getTotalClientes(){
		return clientes.size();
	}



}

