package projetoBingo;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Cartela extends JFrame {

	private JPanel contentPane;

	Boolean bingo = false;
	LayoutCartela cartela;
	Fila numSai;
	Thread tSorteio = null;
	Thread tSorteado = null;
	JLabel lblNumsorteado = new JLabel("numSorteado");

	Fila ns = new Fila();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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

		cartela = geraCartela();

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

		panel.add(lblNumsorteado);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 47, 490, 373);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(6, 5));

		JButton btnB = new JButton("B");
		panel_1.add(btnB);
		btnB.setEnabled(false);

		JButton btnI = new JButton("I");
		panel_1.add(btnI);
		btnI.setEnabled(false);

		JButton btnN = new JButton("N");
		panel_1.add(btnN);
		btnN.setEnabled(false);

		JButton btnG = new JButton("G");
		panel_1.add(btnG);
		btnG.setEnabled(false);

		JButton btnO = new JButton("O");
		panel_1.add(btnO);
		btnO.setEnabled(false);

		for (Integer i = 0; i <= 4; i++) {
			for (Integer j = 1; j <= 5; j++) {
				String letra = "";
				if (j == 1) {
					letra = "B";
				} else if (j == 2) {
					letra = "I";
				} else if (j == 3) {
					letra = "N";
				} else if (j == 4) {
					letra = "G";
				} else {
					letra = "O";
				}
				String nomeBotao = cartela.getLinhas().get(letra).get(i).toString();
				if ("-1".equals(nomeBotao)) {
					nomeBotao = "Bingo";
				}
				JButton button = new JButton(nomeBotao);
				panel_1.add(button);

				if ("Bingo".equals(nomeBotao)) {
					button.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							marcaBingo(button);
						}
					});

				} else {
					button.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							marcaBotao(button);
						}
					});

				}
			}
		}
		//
		// JButton button = new JButton("1");
		// panel_1.add(button);
		// button.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// marcaBotao(button);
		// }
		// });
		//
		// JButton button_1 = new JButton("2");
		// panel_1.add(button_1);
		// button_1.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// marcaBotao(button_1);
		// }
		// });
		//
		// JButton button_2 = new JButton("3");
		// panel_1.add(button_2);
		// button_2.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// marcaBotao(button_2);
		// }
		// });
		//
		// JButton button_3 = new JButton("4");
		// panel_1.add(button_3);
		// button_3.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// marcaBotao(button_3);
		// }
		// });
		//
		// JButton button_4 = new JButton("5");
		// panel_1.add(button_4);
		// button_4.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// marcaBotao(button_4);
		// }
		// });
		//
		// JButton button_5 = new JButton("6");
		// panel_1.add(button_5);
		// button_5.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// marcaBotao(button_5);
		// }
		// });
		//
		// JButton button_6 = new JButton("7");
		// panel_1.add(button_6);
		// button_6.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// marcaBotao(button_6);
		// }
		// });
		//
		// JButton button_7 = new JButton("8");
		// panel_1.add(button_7);
		// button_7.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// marcaBotao(button_7);
		// }
		// });
		//
		// JButton button_8 = new JButton("9");
		// panel_1.add(button_8);
		// button_8.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// marcaBotao(button_8);
		// }
		// });
		//
		// JButton button_9 = new JButton("10");
		// panel_1.add(button_9);
		// button_9.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// marcaBotao(button_9);
		// }
		// });
		//
		// JButton button_10 = new JButton("11");
		// panel_1.add(button_10);
		// button_10.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// marcaBotao(button_10);
		// }
		// });
		//
		// JButton button_11 = new JButton("12");
		// panel_1.add(button_11);
		// button_11.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// marcaBotao(button_11);
		// }
		// });
		//
		// JButton btnBingo = new JButton("BINGO");
		// panel_1.add(btnBingo);
		// btnBingo.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// marcaBotao(btnBingo);
		// }
		// });
		//
		// JButton button_12 = new JButton("14");
		// panel_1.add(button_12);
		// button_12.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// marcaBotao(button_12);
		// }
		// });
		//
		// JButton button_13 = new JButton("15");
		// panel_1.add(button_13);
		// button_13.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// marcaBotao(button_13);
		// }
		// });
		//
		// JButton button_14 = new JButton("16");
		// panel_1.add(button_14);
		// button_14.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// marcaBotao(button_14);
		// }
		// });
		//
		// JButton button_15 = new JButton("17");
		// panel_1.add(button_15);
		// button_15.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// marcaBotao(button_15);
		// }
		// });
		//
		// JButton button_16 = new JButton("18");
		// panel_1.add(button_16);
		// button_16.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// marcaBotao(button_16);
		// }
		// });
		//
		// JButton button_17 = new JButton("19");
		// panel_1.add(button_17);
		// button_17.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// marcaBotao(button_17);
		// }
		// });
		//
		// JButton button_18 = new JButton("20");
		// panel_1.add(button_18);
		// button_18.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// marcaBotao(button_18);
		// }
		// });
		//
		// JButton button_19 = new JButton("21");
		// panel_1.add(button_19);
		// button_19.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// marcaBotao(button_19);
		// }
		// });
		//
		// JButton button_20 = new JButton("22");
		// panel_1.add(button_20);
		// button_20.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// marcaBotao(button_20);
		// }
		// });
		//
		// JButton button_21 = new JButton("23");
		// panel_1.add(button_21);
		// button_21.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// marcaBotao(button_21);
		// }
		// });
		//
		// JButton button_22 = new JButton("24");
		// panel_1.add(button_22);
		// button_22.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// marcaBotao(button_22);
		// }
		// });
		//
		// JButton button_23 = new JButton("25");
		// panel_1.add(button_23);
		// button_23.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// marcaBotao(button_23);
		// }
		// });

		criaThread(lblNumsorteado, ns);
	}

	private void criaThread(JLabel lblNumsorteado, Fila ns) {
		sorteiaNumero(lblNumsorteado, ns, bingo);
		numerosSorteados(ns, bingo);
	}

	public boolean marcaBotao(JButton botao) {
		Color marcado = botao.getBackground();
		if (marcado != Color.GREEN) {
			botao.setBackground(Color.GREEN);
			return true;
		} else {
			botao.setBackground(null);
			return false;
		}

	}

	public void marcaBingo(JButton botao) {
		if (marcaBotao(botao)) {
			tSorteado.stop();
			tSorteio.stop();

			// valida cartao
			boolean venceu = true;
			for (ArrayList<Object> numeros : cartela.getLinhas().values()) {
				for (Object numero : numeros) {
					if (!ns.getNumeros().contains(numero) && (Integer) numero != -1) {
						System.out.println("Nao saiu o numero " + numero);
						venceu = false;
					}
				}
			}

			if (venceu == true) {
				JOptionPane.showMessageDialog(null, "Você venceu!!!");
				View telaLogin = new View();
				telaLogin.setVisible(true);
				dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Você perdeu :(");
				View telaLogin = new View();
				telaLogin.setVisible(true);
				dispose();
			}

		} else {
			// criaThread(lblNumsorteado, ns);
		}
	}

	public synchronized void sorteiaNumero(JLabel lbl, Fila numSaiu, Boolean bingo) {
		SorteioNum sort = new SorteioNum(lbl, numSaiu, bingo);
		tSorteio = new Thread(sort);
		tSorteio.start();

		// t1.stop();
		teste(numSaiu);

	}

	public synchronized void numerosSorteados(Fila numSaiu, Boolean bingo) {
		Sorteados sort = new Sorteados(numSaiu, bingo);
		tSorteado = new Thread(sort);
		tSorteado.start();
	}

	public void teste(Fila n) {
		synchronized (this) {
			while (n.semFila() == false) {
				System.out.println(n.remover() + "fora da thread");
			}
		}
	}

	public LayoutCartela geraCartela() {
		LayoutCartela nc = new LayoutCartela();

		for (int i = 0; i < 24; i++) {
			boolean inseriu = false;
			while (!inseriu) {
				Random geraCart = new Random();
				int cartNum = geraCart.nextInt(76);
				String letra = "";

				if (cartNum == 0) {
					continue;
				} else if (cartNum <= 15) {
					letra = "B";
				} else if (cartNum <= 30) {
					letra = "I";
				} else if (cartNum <= 45) {
					letra = "N";
				} else if (cartNum <= 60) {
					letra = "G";
				} else {
					letra = "O";
				}

				if (nc.semFila(letra)) {
					nc.insere(letra, cartNum);
					inseriu = true;
				} else {
					if (nc.getLinhas().get(letra).size() == 5) {
						continue;
					}

					if (nc.getLinhas().get(letra).size() == 4 && letra == "N") {
						continue;
					}

					if (!nc.getLinhas().get(letra).contains(cartNum)) {
						nc.insere(letra, cartNum);
						inseriu = true;
					}
				}
			}
		}

		nc.getLinhas().get("N").add(2, -1);
		return nc;
	}

	public static int intValue(Object object) {
		if (object == null) {
			return 0;
		}
		if (object == "") {
			return 0;
		}
		if (object instanceof Number) {
			return ((Number) object).intValue();
		}

		if (object instanceof Boolean) {
			return ((Boolean) object).booleanValue() ? 1 : 0;
		}
		return Integer.parseInt(object.toString());
	}

	/*
	 * public void confereCartela() {
	 * 
	 * }
	 */

}
