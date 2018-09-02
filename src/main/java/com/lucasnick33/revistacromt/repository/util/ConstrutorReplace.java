package com.lucasnick33.revistacromt.repository.util;

import java.util.HashMap;
import java.util.Map;

public class ConstrutorReplace {

	private Map<String, String> listaReplace;
	private Map<Class, String> listaAlias;
	
	public ConstrutorReplace() {
		this.listaReplace = new HashMap<String, String>();
		listaAlias = new HashMap<Class, String>();
	}
	
	public void add(String str, String strReplace) {
		listaReplace.put("[".concat(str).concat("]"), strReplace);
	}
	
	public void addClasse(Class classe, String nomeClasse, String alias) {
		listaAlias.put(classe, alias);
		add(nomeClasse, classe.getSimpleName());
	}
	
	public void addPropriedade(Class classe, String strReplace, String nomePropriedade) {
		String str = listaAlias.get(classe).concat(".").concat(nomePropriedade);
		strReplace = listaAlias.get(classe).concat(".").concat(strReplace);
		add(str, strReplace);
	}
	
	public String replace(String str) {
		for (String chave : listaReplace.keySet()) {
			String valor = listaReplace.get(chave);
			str = str.replace(chave, valor);
		}
		return str;
	}
	
}
