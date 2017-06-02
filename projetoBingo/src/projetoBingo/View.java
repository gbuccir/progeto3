package projetoBingo;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class View extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 * 
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws Exception {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/baseBingo", "root", "root");
			PreparedStatement statement = conn.prepareStatement("select * from jogadoresCadastrados");
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				System.out.println(result.getString(1));
			}
		} catch (Exception e) {
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public View() {
		setTitle("Login");
		getContentPane().setLayout(null);
		setBounds(100, 100, 350, 450);
		JLabel lblEmail = new JLabel("e-Mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(24, 46, 55, 25);
		getContentPane().add(lblEmail);

		JLabel lblNewLabel = new JLabel("Senha:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(24, 91, 55, 14);
		getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(79, 50, 178, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(79, 90, 178, 20);
		getContentPane().add(passwordField);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cartela cartela = new Cartela();
				cartela.setVisible(true);
				dispose();
			}
		});
		btnEntrar.setBounds(10, 136, 63, 23);
		getContentPane().add(btnEntrar);

		JButton btnCancela = new JButton("Cancela");
		btnCancela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancela.setBounds(79, 136, 98, 23);
		getContentPane().add(btnCancela);

		JButton btnCadastrarse = new JButton("Cadastrar-se");
		btnCadastrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cadastro telaCadastro = new Cadastro();
				telaCadastro.setVisible(true);
				dispose();
			}
		});
		btnCadastrarse.setBounds(187, 136, 119, 23);
		getContentPane().add(btnCadastrarse);

		JLabel lblNewLabel_1 = new JLabel("Records do M\u00EAs");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(70, 170, 158, 25);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setBounds(80, 206, 46, 14);
		getContentPane().add(lblNome);

		JLabel lblNewLabel_2 = new JLabel("Vit\u00F3rias");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(165, 206, 46, 14);
		getContentPane().add(lblNewLabel_2);

		JLabel lblFulanoDeTal = new JLabel("Fulano de tal");
		lblFulanoDeTal.setBounds(24, 248, 102, 14);
		getContentPane().add(lblFulanoDeTal);

		JLabel label = new JLabel("50");
		label.setBounds(165, 248, 46, 14);
		getContentPane().add(label);

		JLabel lblNewLabel_3 = new JLabel("Fulano de tal 2");
		lblNewLabel_3.setBounds(24, 284, 86, 14);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Fulano de tal 3");
		lblNewLabel_4.setBounds(24, 330, 76, 14);
		getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(165, 284, 46, 14);
		getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(165, 330, 46, 14);
		getContentPane().add(lblNewLabel_6);
	}
}
