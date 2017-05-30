package projetoBingo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridLayout;

public class Cartela extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cartela frame = new Cartela();
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
	public Cartela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 490, 48);
		contentPane.add(panel);
		
		JLabel lblNumeroSorteado = new JLabel("Numero sorteado:");
		panel.add(lblNumeroSorteado);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 47, 490, 373);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(6,5));
		
		JButton btnB = new JButton("B");
		panel_1.add(btnB);
		
		JButton btnI = new JButton("I");
		panel_1.add(btnI);
		
		JButton btnN = new JButton("N");
		panel_1.add(btnN);
		
		JButton btnG = new JButton("G");
		panel_1.add(btnG);
		
		JButton btnO = new JButton("O");
		panel_1.add(btnO);
		
		JButton button = new JButton("1");
		panel_1.add(button);
		
		JButton button_1 = new JButton("2");
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("3");
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("4");
		panel_1.add(button_3);
		
		JButton button_4 = new JButton("5");
		panel_1.add(button_4);
		
		JButton button_5 = new JButton("6");
		panel_1.add(button_5);
		
		JButton button_6 = new JButton("7");
		panel_1.add(button_6);
		
		JButton button_7 = new JButton("8");
		panel_1.add(button_7);
		
		JButton button_8 = new JButton("9");
		panel_1.add(button_8);
		
		JButton button_9 = new JButton("10");
		panel_1.add(button_9);
		
		JButton button_10 = new JButton("11");
		panel_1.add(button_10);
		
		JButton button_11 = new JButton("12");
		panel_1.add(button_11);
		
		JButton btnBingo = new JButton("BINGO");
		panel_1.add(btnBingo);
		
		JButton button_12 = new JButton("14");
		panel_1.add(button_12);
		
		JButton button_13 = new JButton("15");
		panel_1.add(button_13);
		
		JButton button_14 = new JButton("16");
		panel_1.add(button_14);
		
		JButton button_15 = new JButton("17");
		panel_1.add(button_15);
		
		JButton button_16 = new JButton("18");
		panel_1.add(button_16);
		
		JButton button_17 = new JButton("19");
		panel_1.add(button_17);
		
		JButton button_18 = new JButton("20");
		panel_1.add(button_18);
		
		JButton button_19 = new JButton("21");
		panel_1.add(button_19);
		
		JButton button_20 = new JButton("22");
		panel_1.add(button_20);
		
		JButton button_21 = new JButton("23");
		panel_1.add(button_21);
		
		JButton button_22 = new JButton("24");
		panel_1.add(button_22);
		
		JButton button_23 = new JButton("25");
		panel_1.add(button_23);
	}
}
