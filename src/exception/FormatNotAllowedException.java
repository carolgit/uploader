package exception;

public class FormatNotAllowedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String getMessage() {
		return "Tipo de Arquivo Inválido, somente xlsx e xls suportados";
	}
}
