package projetoBingo;

public class Sorteados implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private Fila f;
	private Boolean bingo;

	public Sorteados( Fila f, Boolean bingo) {
		// super();		
		this.f = f;
		this.bingo = bingo;
	}


	@Override
	public void run() {
		int i = 0;
		while (true){

			
		while (i <= f.getNumeros().size()-1) {
			System.out.println(f.getNumeros().get(i).toString() + "fora da thread");
			i++;
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
