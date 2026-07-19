package exception;

/**
 * Excepción personalizada utilizada cuando un RUT
 * no cumple con el formato o dígito verificador.
 */
public class RutInvalidoException extends Exception {

    public RutInvalidoException(String mensaje) {
        super(mensaje);
    }
}
