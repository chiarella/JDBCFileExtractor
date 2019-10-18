package br.com.zip.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public enum ConfiguracaoService {
	NOME_COMPONENTE, DIRETORIO_PROCESSAMENTO, DIRETORIO_PROCESSADO, DIRETORIO_GERADO, DIRETORIO_ERRO, ARQUIVO_ENTRADA,
	ARQUIVO_ENTRADA_EXTENSAO, ARQUIVO_SAIDA,

	ARQUIVO_SAIDA_TXT, ARQUIVO_SAIDA_CSV;

	private static Properties properties;

	public static Properties getPropertiesInstance() throws Exception {
		FileInputStream FileInputStream = null;
		try {
			synchronized (Properties.class) {
				if (properties == null) {
					properties = new Properties();
					FileInputStream = new FileInputStream("conf/configuracao.properties");
					properties.load(FileInputStream);
				}
				return properties;
			}
		} catch (FileNotFoundException excecao) {
			throw excecao;
		} catch (IOException excecao) {
			throw excecao;
		} catch (Exception excecao) {
			throw excecao;
		} finally {
			if (FileInputStream != null)
				try {
					FileInputStream.close();
				} catch (IOException excecao) {
					throw excecao;
				}
		}
	}

	public String getValor() throws Exception {
		try {
			getPropertiesInstance();
		} catch (Exception excecao) {
			throw excecao;
		}

		return properties.getProperty(this.name());
	}

	public String getValor(Object... parametros) throws Exception {
		return formatarParametros(this.getValor(), parametros);
	}

	public Integer getValorInteiro() throws NumberFormatException, Exception {
		return Integer.parseInt(this.getValor());
	}

	public Boolean getValorBooleano() throws Exception {
		return Boolean.parseBoolean(this.getValor());
	}

	private static String formatarParametros(String valor, Object... parametros) {

		for (int cont = 0; cont < parametros.length; cont++) {
			valor = valor.replaceFirst("\\{" + cont + "\\}", parametros[cont].toString());
		}
		return valor;
	}
}