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


public class TelaCancelamento extends JFrame {
	private JPanel contentPane;
	private JTextField textField_3;
	private JLabel id_pedido;
	private JButton btnCriar;
	
	private JLabel lblmsg;
	
	public TelaCancelamento() {
		setTitle("Cancelar pedido");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 311, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		id_pedido = new JLabel("ID Pedido");
		id_pedido.setBounds(10, 40, 80, 25);
		contentPane.add(id_pedido);
		
		textField_3 = new JTextField();
		textField_3.setBounds(90, 45, 80, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

				
		btnCriar = new JButton("Cancelar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(textField_3.getText().isEmpty() )
						lblmsg.setText("campo vazio");
					else {
						int id_pedido = Integer.parseInt(textField_3.getText());
						Fachada.cancelarPedido(id_pedido);
						lblmsg.setText("Cancelamento feito com sucesso");
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


