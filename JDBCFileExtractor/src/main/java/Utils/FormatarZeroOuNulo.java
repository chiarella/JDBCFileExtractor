package Utils;

public class FormatarZeroOuNulo {

	public static String zeroOuNull(Object formatar) {
		String formatado = "";

		if (formatar == null) {
			return formatado;
		} else if (formatar.getClass().equals(Integer.class)) {
			return ((Integer.parseInt(formatar.toString()) == 0) ? formatado : String.valueOf(formatar));
		} else if (formatar.getClass().equals(String.class)) {
			return (formatar == "0" ? formatado : String.valueOf(formatar));
		}
		return String.valueOf(formatar);
	}
}

//	public static Object zeroOuNull(Object formatar) {
//
//		Object formatado = "Verificar dados";
//		
//		int teste = 0;
//		Integer.toString((int) formatar);
//		
//		if ((formatar == null) || (formatar == "0")) {
//			return formatado;
//		}
//		return formatar;
//	}
