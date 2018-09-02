package com.lucasnick33.revistacromt.repository.util;

public class RepositoryUtils {
	
	public static String concat(Object... args) {
		if (args == null) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		for (Object arg : args) {
			if (arg != null) {
				builder.append(arg);
			}
		}
		return builder.toString();
	}
	
	public static String join(String str, Object... parametros) {
		if (parametros == null) {
			return "";
		}
		for (Object parametro : parametros) {
			if (parametro != null && !parametro.toString().isEmpty()) {
				return str;
			}
		}
		return "";
	}
	
}
