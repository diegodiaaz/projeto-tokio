package br.com.tokio.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class CriptografiaUtil {

	public static String criptografar(String senha) throws Exception {
		
		//Obtêm a instância de um algoritmo.
		MessageDigest md = MessageDigest.getInstance("MD5");
		
		//Passa os dados a serem criptografados e estipula enconding padrão.
		md.update(senha.getBytes("ISO-8859-1"));
		
		
		//Gera a chave criptografada em array de bytes para posterior hasing.
		BigInteger hash = new BigInteger(1, md.digest());
		
		//Retorna a senha criptografada, com o tamanho 16.
		return hash.toString(16);
		
	}
	
}
