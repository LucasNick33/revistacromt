package com.lucasnick33.revistacromt.repository.util;

import java.util.ArrayList;
import java.util.List;

public class Where {

	private Integer index;
	private List parametros;
	
	public Where() {
		this.parametros = new ArrayList();
		this.index = 0;
	}
	
	public String add(String str, Object o) {
		return add(str, o, "");
	}
	
	public String add(String str, Object parametro, String strSubstituta) {
		if (parametro == null || parametro.toString().isEmpty()) {
			return strSubstituta;
		}
		str = str.replace("?", "?" + index);
		parametros.add(parametro);
		index++;
		return str;
	}
	
	public String add(String str, List parametros, String strSeparador) {
		return add(str, parametros, strSeparador, "");
	}
	
	public String add(String str, List parametros, String strSeparador, String strSubstituta) {
		StringBuilder builder = new StringBuilder();
		boolean temParametro = false;
		for (Object parametro : parametros) {
			if (parametro != null && !parametro.toString().isEmpty()) {
				temParametro = true;
				String strParametro = str.replace("?", "?" + index);
				builder.append(strSeparador);
				builder.append(strParametro);
				this.parametros.add(parametro);
				index++;
			}
		}
		if (temParametro) {
			builder.delete(0, strSeparador.length());
			return builder.toString();
		}
		return strSubstituta;
	}
	
	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public List getParametros() {
		return this.parametros;
	}
	
}
