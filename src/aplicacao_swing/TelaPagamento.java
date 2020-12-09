package aplicacao_swing;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Pedido;
import fachada.Fachada;


public class TelaPagamento extends JFrame {
	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel idPedido;
	private JLabel nomeEntregador;
	private JButton btnCriar;
	private JButton btnCriarExpress;
	
	private JLabel lblmsg;
	
	public TelaPagamento() {
		setTitle("Criar Pedido");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 311, 217);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		idPedido = new JLabel("IdPedido");
		idPedido.setBounds(10, 52, 64, 15);
		contentPane.add(idPedido);
		
		textField_2 = new JTextField();
		textField_2.setBounds(90, 49, 150, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		nomeEntregador = new JLabel("Entregador");
		nomeEntregador.setBounds(10, 77, 80, 25);
		contentPane.add(nomeEntregador);
		
		textField_3 = new JTextField();
		textField_3.setBounds(90, 80, 80, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

				
		btnCriar = new JButton("Pagar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(textField_2.getText().isEmpty() )
						lblmsg.setText("campo vazio");
					else {
						int idpedido = Integer.parseInt(textField_2.getText());
						String entregador = textField_3.getText();
						Fachada.pagarPedido(idpedido,entregador);

						lblmsg.setText("Pedido pago com sucesso");
						textField_2.setText("");
						textField_3.setText("");
					}
				}
				catch(Exception erro){
					lblmsg.setText(erro.getMessage());
				}
			}
		});
		btnCriar.setBounds(168, 140, 110, 23);
		contentPane.add(btnCriar);

		
		lblmsg = new JLabel("");
		lblmsg.setBounds(10, 170, 268, 14);
		contentPane.add(lblmsg);

	}
}


