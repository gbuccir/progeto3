package projetoBingo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
	public Cadastro() {
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("e-Mail:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 65, 60, 15);
		contentPane.add(lblNewLabel);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenha.setBounds(10, 125, 60, 15);
		contentPane.add(lblSenha);

		textField = new JTextField();
		textField.setBounds(80, 61, 317, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(80, 121, 100, 20);
		contentPane.add(passwordField);

		JLabel lblConfirmao = new JLabel("Confirma\u00E7\u00E3o:");
		lblConfirmao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConfirmao.setBounds(190, 124, 97, 14);
		contentPane.add(lblConfirmao);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastraJogador(textField.getText(), passwordField.getPassword(), passwordField_1.getPassword());
				View telaLogin = new View();
				telaLogin.setVisible(true);
				dispose();
			}
		});
		btnOk.setBounds(91, 187, 89, 23);
		contentPane.add(btnOk);

		JButton btnCancela = new JButton("Cancela");
		btnCancela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View telaLogin = new View();
				telaLogin.setVisible(true);
				dispose();
			}
		});
		btnCancela.setBounds(237, 187, 89, 23);
		contentPane.add(btnCancela);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(297, 124, 100, 20);
		contentPane.add(passwordField_1);
	}

	public void cadastraJogador(String mail, char[] senha, char[] confirma) {
		if(Arrays.equals(confirma, senha) && mail != "" && senha.length > 0 && confirma.length > 0 ){
			try {
				SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
				Date da = new Date();
				d.format(da);
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/baseBingo", "root", "root");
				PreparedStatement statement = conn.prepareStatement(""
						+ "INSERT INTO jogadoresCadastrados (eMail, Senha, PrimeiraDataMes, QtdVitoriasMes)"
						+ "VALUES ( '"+ mail +"', '"+ String.valueOf(senha) +"', '" + d.format(da) + "', '0')");
				statement.executeUpdate();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Problemas de conexão");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Senha invalida");
		}
	}

}
