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


public class TelaCriacaoPedido extends JFrame {
	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel valor;
	private JLabel taxa;
	private JButton btnCriar;
	private JButton btnCriarExpress;
	
	private JLabel lblmsg;
	
	public TelaCriacaoPedido() {
		setTitle("Criar Pedido");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 311, 217);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		valor = new JLabel("Telefone");
		valor.setBounds(10, 52, 64, 15);
		contentPane.add(valor);
		
		textField_2 = new JTextField();
		textField_2.setBounds(90, 49, 150, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		taxa = new JLabel("Taxa");
		taxa.setBounds(10, 77, 64, 25);
		contentPane.add(taxa);
		
		textField_3 = new JTextField();
		textField_3.setBounds(60, 80, 80, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

				
		btnCriar = new JButton("Normal");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(textField_2.getText().isEmpty() )
						lblmsg.setText("campo vazio");
					else {
						String telefone = textField_2.getText();
						Pedido p = Fachada.criarPedido(telefone);

						lblmsg.setText("cadastrado pedido="+p.getId());
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

		
		
		btnCriarExpress = new JButton("Express");
		btnCriarExpress.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try{
					if(textField_2.getText().isEmpty() || textField_3.getText().isEmpty() )
						lblmsg.setText("campo vazio");
					else {
						String telefone = textField_2.getText();
						Double taxa = Double.parseDouble(textField_3.getText()); 
						Pedido p = Fachada.criarPedidoExpress(telefone,taxa);

						lblmsg.setText("cadastrado pedido="+p.getId());
						textField_2.setText("");
						textField_3.setText("");
					}
				}
				catch(Exception erro){
					lblmsg.setText(erro.getMessage());
				}
			}
		});
		btnCriarExpress.setBounds(25, 140, 110, 23);
		contentPane.add(btnCriarExpress);
		
		lblmsg = new JLabel("");
		lblmsg.setBounds(10, 170, 268, 14);
		contentPane.add(lblmsg);

	}
}


