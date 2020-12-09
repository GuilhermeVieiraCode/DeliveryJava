package fachada;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import modelo.Cliente;
import modelo.Pedido;
import modelo.PedidoExpress;
import modelo.Produto;
import repositorio.Repositorio;

public class Fachada {
	static Repositorio repositorio = new Repositorio();
	private static int idpedido=0;
	//...

	public static ArrayList<Produto> listarProdutos() {
		// retorna todos os produtos do repositorio cujo nome cont�m o texto fornecido (ou retorna todos os produtos caso o texto esteja vazio)
		return repositorio.getProdutos();
	}
	
	public static ArrayList<Produto> listarProdutos(String texto) {
		// retorna todos os produtos do repositorio cujo nome cont�m o texto fornecido (ou retorna todos os produtos caso o texto esteja vazio)
		ArrayList<Produto> produtos = new ArrayList<>(); 
		ArrayList<Produto> listaProdutos = repositorio.getProdutos();
		if(texto == "") {
			return listaProdutos;
		}
		for(Produto p : listaProdutos) {
			if(p.getNome().contains(texto)) {
				produtos.add(p);
			}
		}
		return produtos;
	}
	
	public static HashMap<String,Cliente> listarClientes() {
		// retorna todos os clientes do repositorio
		//return new ArrayList<Cliente>();
		return repositorio.getClientes();
	}
	
	public static ArrayList<Pedido>	listarPedidos() {
		// retorna todos pedidos do repositorio
		return repositorio.getPedidos();
	}
	
	public static ArrayList<Pedido>	listarPedidos(String telefone, int tipo) {
		// retorna os pedidos pagos (tipo=1) ou pedidos n�o pagos (tipo=2) ou pedidos pagos e n�o pagos (tipo=3) de um cliente
		Cliente cliente = repositorio.localizarCliente(telefone);
		System.out.println(cliente.getNome() + " - " + telefone);
		ArrayList<Pedido> pedidoCliente = cliente.getPedidos();
		ArrayList<Pedido> pedidoTipo = new ArrayList<Pedido>();
		if(tipo==1) {	
			for(Pedido p : pedidoCliente) {
				if(p.getPago()==true) {
					pedidoTipo.add(p);
					}
			}
			return pedidoTipo;
		}
		else if(tipo==2){
			for(Pedido p : pedidoCliente) {
				if(p.getPago()==false) {
					pedidoTipo.add(p);
				}
			}
			return pedidoTipo;
		}
		else {
			return pedidoTipo;	
		}
	}
	
	
	public static Produto cadastrarProduto(String nome, double preco) throws Exception {
		//cria e retorna um novo produto
		Produto novoProduto = new Produto(nome, preco);
		if(repositorio.localizarProduto(nome) != null) {
			throw new Exception("Produto já cadastrado.");
		}else {
			repositorio.adicionar(novoProduto);
			return novoProduto;
		}
	}
	
	public static Cliente cadastrarCliente(String telefone, String nome, String endereco) {
		// cria e retorna um novo cliente
		Cliente novoCliente = new Cliente(telefone, nome, endereco);
		repositorio.adicionar(novoCliente);
		return novoCliente;
	}
	
	public static Pedido criarPedido(String telefone)throws Exception {
		// cria e retorna um novo pedido relacionado ao Cliente
		idpedido++;
		LocalDateTime data = LocalDateTime.now();  
		String entregador = "";
		boolean pago = false;
		ArrayList<Produto> produtos = new ArrayList<>();
		Cliente cliente = repositorio.localizarCliente(telefone);
		if(cliente==null) 
			throw new Exception("Telefone de cliente não encontrado.");
		double valorTotal = 0;
		Pedido novoPedido = new Pedido(idpedido, data, valorTotal, entregador, pago, produtos, cliente);
		repositorio.adicionar(novoPedido);
		return novoPedido;
	}
	
	public static Pedido criarPedidoExpress(String telefone, double taxa)throws Exception {
		// cria e retorna um novo pedido relacionado ao Cliente
		idpedido++;
		LocalDateTime data = LocalDateTime.now();  
		String entregador = "";
		boolean pago = false;
		ArrayList<Produto> produtos = new ArrayList<>();
		Cliente cliente = repositorio.localizarCliente(telefone);
		if(cliente==null) 
			throw new Exception("Telefone de cliente não encontrado.");
		double valorTotal = 0;
		PedidoExpress novoPedido = new PedidoExpress(idpedido, data, valorTotal, entregador, pago, produtos, cliente, taxa);
		repositorio.adicionar(novoPedido);
		return novoPedido;
	}
	
	public static void 	adicionarProdutoPedido(int idpedido, int idproduto) throws Exception {
		// adiciona uma ocorr�ncia do produto no pedido
		Pedido pedido = repositorio.localizarPedido(idpedido);
		Produto produto = repositorio.localizarProduto(idproduto);
		if(pedido==null)
			throw new Exception("Pedido de id "+idpedido+" não encontrado!");
		if(produto==null)
			throw new Exception("Produto de id "+idproduto+" não encontrado!");
		pedido.setValorTotal(produto.getPreco()+pedido.getValorTotal());
		pedido.getProdutos().add(produto);
	}
	
	public static void 	removerProdutoPedido(int idpedido, int idproduto) throws Exception {
		// remove uma ocorr�ncia do produto no pedido
		Pedido pedido = repositorio.localizarPedido(idpedido);
		Produto produto = repositorio.localizarProduto(idproduto);
		if(pedido==null)
			throw new Exception("Pedido de id "+idpedido+" não encontrado!");
		if(produto==null)
			throw new Exception("Produto de id "+idproduto+" não encontrado!");
		pedido.setValorTotal(pedido.getValorTotal()-produto.getPreco());
		pedido.getProdutos().remove(produto);
	}
	
	public static Pedido consultarPedido(int idpedido) throws Exception {
		//retorna o pedido
		Pedido pedido = repositorio.localizarPedido(idpedido);
		if(pedido == null) {
			throw new Exception("Pedido inexistente");
		}
		return pedido;
		
	}
	
	public static void 	pagarPedido(int idpedido, String nomeentregador) throws Exception {
		// atualiza dados de pagamento do pedido (entregador e pago) 
		Pedido pedido = repositorio.localizarPedido(idpedido);
		if(pedido.getPago())
			throw new Exception("O pedido já foi pago.");
		pedido.setEntregador(nomeentregador);
		pedido.setPago(true);
	}
	
	public static void 	cancelarPedido(int idpedido) throws Exception {
		// apaga o pedido
		Pedido pedido = repositorio.localizarPedido(idpedido);
		if(pedido.getPago() == false) {
			repositorio.remover(pedido);
		}
		else {
			throw new Exception("Pedidos pagos não podem ser cancelados.");
		}
	}
	
	public static double consultarArrecadacao(int dia) {
		// retorna a soma do valortotal dos pedidos pagos do dia 
		ArrayList<Pedido> pedidos = repositorio.getPedidos();
		double arrec = 0;
		for(Pedido p : pedidos) 
			if(p.getDataHora().getDayOfMonth() == dia)
				arrec = arrec + p.getValorTotal();
		
		return arrec;
	}
	
	public static ArrayList<Produto> consultarProdutoTop() {
		// retorna os produtos que tiveram o maior quantidade de pedidos (n�o deve incluir os pedidos cancelados)
		ArrayList<Produto> produtos = repositorio.getProdutos();
		ArrayList<Produto> bigger = new ArrayList<>();
		int counter = 0;
		for(Produto p : produtos) {
			if(p.getPedidos().size() > counter) 
				counter = p.getPedidos().size();	
		}
		for(Produto p : produtos) {
			if(p.getPedidos().size() == counter)
				bigger.add(p);
		}
		return bigger;
	}

}
