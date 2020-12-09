package aplicacao_swing;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Pedido;
import modelo.Produto;
import fachada.Fachada;


public class TelaProdutos extends JFrame {
	private JPanel contentPane;
	private JTextField textField_3;
	private JLabel nomeProduto;
	private JButton btnCriar;
	
	private JLabel lblmsg;
	
	public TelaProdutos() {
		setTitle("Produtos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 311, 170);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nomeProduto = new JLabel("Texto");
		nomeProduto.setBounds(10, 40, 64, 25);
		contentPane.add(nomeProduto);
		
		textField_3 = new JTextField();
		textField_3.setBounds(55, 45, 80, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

				
		btnCriar = new JButton("Listar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(textField_3.getText().isEmpty()) {
					ArrayList<Produto> lista = Fachada.listarProdutos();
					String texto = "Listagem de produtos: \n";
					if (lista.isEmpty())
						texto += "n�o tem produto cadastrado\n";
					else 
						for(Produto p: lista) 
							texto +=  p + "\n"; 
					
					TelaListagem j = new TelaListagem(texto);
					j.setVisible(true);
					}
					else {
						String nomeProduto = textField_3.getText();
						ArrayList<Produto> lista = Fachada.listarProdutos(nomeProduto);
						String texto = "Listagem de produtos: \n";
						if (lista.isEmpty())
							texto += "n�o tem produto cadastrado\n";
						else 
							for(Produto p: lista) 
								texto +=  p + "\n"; 
						
						TelaListagem j = new TelaListagem(texto);
						j.setVisible(true);
						textField_3.setText("");
					}
				}
				catch(Exception erro){
					lblmsg.setText(erro.getMessage());
				}
			}
		});
		btnCriar.setBounds(168, 90, 110, 23);
		contentPane.add(btnCriar);

		lblmsg = new JLabel("");
		lblmsg.setBounds(10, 112, 268, 14);
		contentPane.add(lblmsg);

	}
}


