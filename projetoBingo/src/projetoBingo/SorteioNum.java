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

	public SorteioNum(JLabel x, Fila f) {
		// super();
		this.x = x;
		this.f = f;
	}


	@Override
	public void run() {
		int i = 1;
		while (i <= 3) {
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
