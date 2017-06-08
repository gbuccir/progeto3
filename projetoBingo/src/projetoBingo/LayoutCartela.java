package projetoBingo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LayoutCartela {

	private Map<String, ArrayList<Object>> linhas = new HashMap<String, ArrayList<Object>>(0);

	private ArrayList<Object> numeros = new ArrayList<Object>();

	public Map<String, ArrayList<Object>> getLinhas() {
		return linhas;
	}

	public void setLinhas(Map<String, ArrayList<Object>> linhas) {
		this.linhas = linhas;
	}

	public ArrayList<Object> getNumeros() {
		return numeros;
	}

	public void setNumeros(ArrayList<Object> numeros) {
		this.numeros = numeros;
	}

	public void insere(String letra, Object numeros) {
		ArrayList<Object> colunas = linhas.get(letra);

		if (colunas == null) {
			colunas = new ArrayList<Object>(0);
		}
		colunas.add(numeros);
		linhas.put(letra, colunas);
	}

	public Object remover(String letra) {
		if (semFila(letra) == false) {
			return this.linhas.get(letra).remove(0);
		} else {
			return "";
		}
	}

	public Object proximo(String letra) {
		if (semFila(letra) == false) {
			return this.linhas.get(letra);
		} else {
			return "";
		}
	}

	public boolean semFila(String letra) {
		if (this.linhas.get(letra) == null || this.linhas.get(letra).size() == 0) {
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
