package utils;

import exception.RutInvalidoException;

/**
 * Clase utilitaria encargada de limpiar y validar RUT chilenos.
 */
public final class ValidadorRut {

    private ValidadorRut() {
        // Evita que la clase sea instanciada.
    }

    public static String limpiarRut(String rut) {
        if (rut == null) {
            return "";
        }

        return rut.replace(".", "")
                .replace("-", "")
                .trim()
                .toUpperCase();
    }

    public static void validar(String rut) throws RutInvalidoException {

        String rutLimpio = limpiarRut(rut);

        if (rutLimpio.length() < 8 || rutLimpio.length() > 9) {
            throw new RutInvalidoException(
                    "El RUT debe contener entre 8 y 9 caracteres."
            );
        }

        String cuerpo = rutLimpio.substring(0, rutLimpio.length() - 1);
        char digitoIngresado = rutLimpio.charAt(rutLimpio.length() - 1);

        if (!cuerpo.matches("\\d+")) {
            throw new RutInvalidoException(
                    "El cuerpo del RUT solo debe contener números."
            );
        }

        int suma = 0;
        int multiplicador = 2;

        for (int i = cuerpo.length() - 1; i >= 0; i--) {
            suma += Character.getNumericValue(cuerpo.charAt(i))
                    * multiplicador;

            multiplicador++;

            if (multiplicador == 8) {
                multiplicador = 2;
            }
        }

        int resultado = 11 - (suma % 11);
        char digitoCalculado;

        if (resultado == 11) {
            digitoCalculado = '0';
        } else if (resultado == 10) {
            digitoCalculado = 'K';
        } else {
            digitoCalculado = Character.forDigit(resultado, 10);
        }

        if (digitoIngresado != digitoCalculado) {
            throw new RutInvalidoException(
                    "El dígito verificador del RUT no es válido."
            );
        }
    }

    public static String formatear(String rut) {

        String rutLimpio = limpiarRut(rut);

        if (rutLimpio.length() < 2) {
            return rutLimpio;
        }

        String cuerpo = rutLimpio.substring(0, rutLimpio.length() - 1);
        char digitoVerificador = rutLimpio.charAt(rutLimpio.length() - 1);

        return cuerpo + "-" + digitoVerificador;
    }
}
