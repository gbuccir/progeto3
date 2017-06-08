package projetoBingo;

import java.util.Random;
import java.util.concurrent.Callable;
import javax.swing.JLabel;

public class SorteioNum implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel x;
	private Fila f;
	private Boolean bingo;

	public SorteioNum(JLabel x, Fila f, Boolean bingo) {
		// super();
		this.x = x;
		this.f = f;
		this.bingo = bingo;
	}


	@Override
	public void run() {
		int i = 1;
		while (true) {
			try {
				Thread.sleep(3000);
				Random gerador = new Random();
				int sorteado = gerador.nextInt(76);
				x.setText(String.valueOf(sorteado));
				f.insere(sorteado);
			} catch (Exception t) {
			}
			i++;
		}
	}
}
