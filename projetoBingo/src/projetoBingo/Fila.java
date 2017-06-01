package projetoBingo;

import java.util.ArrayList;

public class Fila {

	ArrayList<Object> numeros = new ArrayList<Object>();

	public void insere(Object numeros) {
		this.numeros.add(numeros);
	}

	public Object remover() {
		if (semFila() == false) {
			return this.numeros.remove(0);
		} else {
			return "";
		}
	}

	public Object proximo() {
		if (semFila() == false) {
			return this.numeros;
		} else {
			return "";
		}
	}

	public boolean semFila() {
		if (this.numeros.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int tamanho() {
		if (this.numeros.size() == 0) {
			return 0;
		} else {
			return this.numeros.size();
		}
	}

}
