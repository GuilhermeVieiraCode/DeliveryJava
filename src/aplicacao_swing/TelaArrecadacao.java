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


public class TelaArrecadacao extends JFrame {
	private JPanel contentPane;
	private JTextField textField_3;
	private JLabel dia;
	private JButton btnCriar;
	private JButton btnCriarExpress;
	
	private JLabel lblmsg;
	
	public TelaArrecadacao() {
		setTitle("Arrecadação");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 311, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		dia = new JLabel("Dia");
		dia.setBounds(10, 40, 64, 25);
		contentPane.add(dia);
		
		textField_3 = new JTextField();
		textField_3.setBounds(55, 45, 80, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

				
		btnCriar = new JButton("Total");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(textField_3.getText().isEmpty() )
						lblmsg.setText("campo vazio");
					else {
						String telefone = textField_3.getText();
						int dia = Integer.parseInt(textField_3.getText());
						Double p = Fachada.consultarArrecadacao(dia);
						String texto = "Listagem de Arrecadação: \n";
						
						texto +=  p;
						TelaListagem j = new TelaListagem(texto);
						j.setVisible(true);
						textField_3.setText("");
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
		lblmsg.setBounds(10, 170, 268, 14);
		contentPane.add(lblmsg);

	}
}


