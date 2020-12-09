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


public class TelaAlteracaoPedido extends JFrame {
	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel Id_Pedido;
	private JLabel Id_produto;
	private JButton btnCriar;
	private JButton btnCriarExpress;
	
	private JLabel lblmsg;
	
	public TelaAlteracaoPedido() {
		setTitle("Criar Pedido");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 311, 217);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		Id_Pedido = new JLabel("ID Pedido");
		Id_Pedido.setBounds(10, 52, 70, 15);
		contentPane.add(Id_Pedido);
		
		textField_2 = new JTextField();
		textField_2.setBounds(100, 49, 150, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		Id_produto = new JLabel("ID Produto");
		Id_produto.setBounds(10, 77, 70, 25);
		contentPane.add(Id_produto);
		
		textField_3 = new JTextField();
		textField_3.setBounds(100, 80, 80, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

				
		btnCriar = new JButton("Inserir");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(textField_2.getText().isEmpty() || textField_3.getText().isEmpty() )
						lblmsg.setText("campo vazio");
					else {
						int id_pedido = Integer.parseInt(textField_2.getText());
						int id_produto = Integer.parseInt(textField_3.getText());
						Fachada.adicionarProdutoPedido(id_pedido,id_produto);
						lblmsg.setText("");
						lblmsg.setText("Alteração realizada");
//						textField_2.setText("");
					}
				}
				catch(Exception erro){
					lblmsg.setText(erro.getMessage());
				}
			}
		});
		btnCriar.setBounds(168, 140, 110, 23);
		contentPane.add(btnCriar);

		
		
		btnCriarExpress = new JButton("Remover");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(textField_2.getText().isEmpty() || textField_2.getText().isEmpty())
						lblmsg.setText("campo vazio");
					else {
						int id_pedido = Integer.parseInt(textField_2.getText());
						int id_produto = Integer.parseInt(textField_3.getText());
						Fachada.removerProdutoPedido(id_pedido,id_produto);
						lblmsg.setText("");
						lblmsg.setText("Alteração realizada");
//						
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


