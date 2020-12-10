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


public class TelaPedidosPagos extends JFrame {
	private JPanel contentPane;
	private JTextField textField_3;
	private JLabel telefone;
	private JButton btnCriar;
	
	private JLabel lblmsg;
	
	public TelaPedidosPagos() {
		setTitle("Pedidos do cliente");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 311, 170);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		telefone = new JLabel("telefone");
		telefone.setBounds(10, 40, 64, 25);
		contentPane.add(telefone);
		
		textField_3 = new JTextField();
		textField_3.setBounds(80, 45, 80, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

				
		btnCriar = new JButton("Listar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String telefone = textField_3.getText();	
					ArrayList<Pedido> lista = Fachada.listarPedidos(telefone, 1);
					String texto = "Listagem de pedidos: \n";
					if (lista.isEmpty())
						texto += "n�o tem pedido cadastrado\n";
					else 
						for(Pedido p: lista) 
							texto +=  p + "\n"; 
					
					TelaListagem j = new TelaListagem(texto);
					j.setVisible(true);
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


