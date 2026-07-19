package model;

/**
 * Representa la dirección asociada a una persona.
 * Esta clase permite aplicar composición dentro del sistema.
 */
public class Direccion {

    private String calle;
    private String numero;
    private String comuna;

    public Direccion(String calle, String numero, String comuna) {
        setCalle(calle);
        setNumero(numero);
        setComuna(comuna);
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        if (calle == null || calle.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La calle no puede estar vacía."
            );
        }

        this.calle = calle.trim();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        if (numero == null || numero.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El número no puede estar vacío."
            );
        }

        this.numero = numero.trim();
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        if (comuna == null || comuna.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La comuna no puede estar vacía."
            );
        }

        this.comuna = comuna.trim();
    }

    @Override
    public String toString() {
        return calle + " " + numero + ", " + comuna;
    }
}
