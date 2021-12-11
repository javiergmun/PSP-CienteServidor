import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

public class Paquete implements Serializable {
    private String tipo;
    private String envio;
    private UUID idDron;
    private UUID idPaquete;
    private Instant instante;
    private int dosYemas;

    public Paquete(String tipo, String envio, UUID idDron, UUID idPaquete, Instant instante, int dosYemas) {
        this.tipo = tipo;
        this.envio = envio;
        this.idDron = idDron;
        this.idPaquete = idPaquete;
        this.instante = instante;
        this.dosYemas = dosYemas;
    }

    public Paquete() {
        tipo = "Huevos";
        envio = "Paquete";
        idDron = UUID.randomUUID();
        idPaquete = UUID.randomUUID();
        instante = Instant.now();
        dosYemas= 0;
    }

    /*public Paquete(){
        envio = "paquete";
        numero = 1;

    }
     */

    @Override
    public String toString() {
        return "Paquete{" +
                "tipo=" + tipo +
                ", envio='" + envio + '\'' +
                ", idDron=" + idDron +
                ", idPaquete=" + idPaquete +
                ", instante='" + instante + '\'' +
                ", dosYemas=" + dosYemas +
                '}';
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEnvio() {
        return envio;
    }

    public void setEnvio(String envio) {
        this.envio = envio;
    }

    public UUID getIdDron() {
        return idDron;
    }

    public void setIdDron(UUID idDron) {
        this.idDron = idDron;
    }

    public UUID getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(UUID idPaquete) {
        this.idPaquete = idPaquete;
    }

    public Instant getInstante() {
        return instante;
    }

    public void setInstante(Instant instante) {
        this.instante = instante;
    }

    public int getDosYemas() {
        return dosYemas;
    }

    public void setDosYemas(int dosYemas) {
        this.dosYemas = dosYemas;
    }



}
