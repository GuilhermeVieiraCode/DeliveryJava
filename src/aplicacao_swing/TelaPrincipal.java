package aplicacao_swing;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import aplicacao.AplicacaoConsole1;
import fachada.Fachada;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;

public class TelaPrincipal {
	private JFrame frame;
	private JLabel label;
	private JMenu mnPedido;
	private JMenuItem Criar;
	private JMenuItem Alterar;
	private JMenuItem Pagar;
	private JMenuItem Cancelar;
	private JMenu mnListar;
	private JMenuItem Produtos;
	private JMenuItem Clientes;
	private JMenuItem Pedidos;
	private JMenuItem PedidosDoCliente;
	private JMenuItem PedidosPagosClientes;
	private JMenuItem PedidosNaoPagos;
	private JMenuItem ProdutosTops;
	private JMenuItem Arrecadacao;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public TelaPrincipal() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Delivery");

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				try{
					//  pre-cadastro
					new AplicacaoConsole1().AplicacaoConsole1();
					
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			@Override
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(frame, "Agradecemos sua prefer�ncia!");
			}
		});
		
		frame.setBounds(100, 100, 384, 271);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//imagem de fundo
				label = new JLabel("");
				label.setBounds(0, 0, frame.getWidth(), frame.getHeight()); //fundo da janela

				ImageIcon imagem = new ImageIcon(getClass().getResource("/imagem/rock-burger2.jpg"));
				imagem = new ImageIcon(imagem.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT));
				label.setIcon(imagem);
				frame.getContentPane().add(label);
				frame.setResizable(false);
				
				//-------------BARRA DE MENU-----------------------------------
				JMenuBar menuBar = new JMenuBar();
				frame.setJMenuBar(menuBar);
				
				//-------------MENU-----------------------------------
				mnPedido = new JMenu("Pedido");
				menuBar.add(mnPedido);

				Criar = new JMenuItem("Criar");
				Criar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						TelaCriacaoPedido j = new TelaCriacaoPedido();
						j.setVisible(true);
					}
				});
				
				mnPedido.add(Criar);
				
				Alterar = new JMenuItem("Alterar");
				Alterar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						TelaAlteracaoPedido j = new TelaAlteracaoPedido();
						j.setVisible(true);
					}
				});
				
				mnPedido.add(Alterar);

				Pagar = new JMenuItem("Pagar");
				Pagar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						TelaPagamento j = new TelaPagamento();
						j.setVisible(true);
					}
				});
				mnPedido.add(Pagar);

				Cancelar = new JMenuItem("Cancelar");
				Cancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						TelaCancelamento j = new TelaCancelamento();
						j.setVisible(true);
					}
				});
				mnPedido.add(Cancelar);
				
				//-------------MENU LISTAR-----------------------------------
				
				mnListar = new JMenu("Listar");
				menuBar.add(mnListar);
				
				
				Produtos = new JMenuItem("Produtos");
				Produtos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TelaProdutos j = new TelaProdutos();
						j.setVisible(true);
					}
				});
				mnListar.add(Produtos);
				
				Clientes = new JMenuItem("Clientes");
				Clientes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						HashMap<String, Cliente> lista = Fachada.listarClientes();
						String texto = "Listagem de Clientes: \n";
						if (lista.isEmpty())
							texto += "n�o tem Clientes cadastrado\n";
						else 
							for(Cliente p: lista.values()) 
								texto +=  p + "\n"; 
						
						TelaListagem j = new TelaListagem(texto);
						j.setVisible(true);
					}
				});
				mnListar.add(Clientes);
				
				Pedidos = new JMenuItem("Pedidos");
				Pedidos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ArrayList<Pedido> lista = Fachada.listarPedidos();
						String texto = "Listagem de Pedidos: \n";
						if (lista.isEmpty())
							texto += "n�o tem Pedidos cadastrado\n";
						else 
							for(Pedido p: lista) 
								texto +=  p + "\n"; 
						
						TelaListagem j = new TelaListagem(texto);
						j.setVisible(true);
					}
				});
				mnListar.add(Pedidos);
								
				ProdutosTops = new JMenuItem("Produtos Top");
				ProdutosTops.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ArrayList<Produto> lista = Fachada.consultarProdutoTop();
						String texto = "Listagem de Produtos Top: \n";
						if (lista.isEmpty())
							texto += "n�o tem Pedidos Top cadastrado\n";
						else 
							for(Produto p: lista) 
								texto +=  p + "\n"; 
						
						TelaListagem j = new TelaListagem(texto);
						j.setVisible(true);
					}
				});
				mnListar.add(ProdutosTops);
				
				Arrecadacao = new JMenuItem("Arrecadaçẫo");
				Arrecadacao.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {					
						TelaArrecadacao j = new TelaArrecadacao();
						j.setVisible(true);
					}
				});
				mnListar.add(Arrecadacao);
				



				//-------------MENU-----------------------------------
		/*		mnPrateleira = new JMenu("Prateleira");
				menuBar.add(mnPrateleira);

				mntmCriar = new JMenuItem("Criar");
				mntmCriar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						TelaCadastroPrateleira j = new TelaCadastroPrateleira();
						j.setVisible(true);
					}
				});
				mnPrateleira.add(mntmCriar);

				mntmListar_1 = new JMenuItem("Listar");
				mntmListar_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ArrayList<Prateleira> lista = Fachada.listarPrateleiras();
						String texto = "Listagem de prateleiras: \n";
						if (lista.isEmpty())
							texto += "n�o tem prateleira cadastrada\n";
						else 
							for(Prateleira p: lista) 
								texto +=  p + "\n"; 
						
						TelaListagem j = new TelaListagem(texto);
						j.setVisible(true);
					}
				});
				mnPrateleira.add(mntmListar_1);

				mntmInserirProduto = new JMenuItem("Inserir produto");
				mntmInserirProduto.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						TelaProdutoPrateleira j = new TelaProdutoPrateleira();
						j.setVisible(true);
					}
				});
				mnPrateleira.add(mntmInserirProduto);

				mntmRemoverProduto = new JMenuItem("Remover produto");
				mntmRemoverProduto.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						TelaProdutoPrateleira j = new TelaProdutoPrateleira();
						j.setVisible(true);
					}
				});
				mnPrateleira.add(mntmRemoverProduto);

				//-------------MENU-----------------------------------
				JMenu mnConsulta = new JMenu("Consulta");
				menuBar.add(mnConsulta);
				mnConsulta.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						TelaConsulta j = new TelaConsulta();
						j.setVisible(true);
					}
				});*/


			}
		}


