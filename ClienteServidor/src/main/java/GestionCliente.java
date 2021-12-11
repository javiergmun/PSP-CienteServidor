import jdk.net.Sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class GestionCliente extends Thread {
    private int numClientes;
    private Socket cliente;


    public GestionCliente(int numClientes, Socket cliente) {
        this.numClientes = numClientes;
        this.cliente = cliente;
    }

    //public GestionCliente() {
    //}

    @Override
    public void run() {
        ObjectInputStream bufferEntradas = null;
        try{
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("----------------------BIENVENIDO A GESTION DE PAQUETES----------------------");
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("!UN NUEVO PAQUETE HA LLEGADO DESDE CLIENTE¡");
            System.out.println("Se está tratando el paquete: " + numClientes +". Proveniente de la lejana direccion: " + cliente.getInetAddress());

            //lo que recibimos del cliente es
            bufferEntradas = new ObjectInputStream(cliente.getInputStream());
            Paquete paqueteEntrante = (Paquete) bufferEntradas.readObject();
            //paqueteEntrante.enseñar();
            System.out.println("Se ha hecho mostrar el siguiente paquete a nuestro poderoso Spock: " +
                    ""+ paqueteEntrante.toString());
            System.out.println("Mandando mensaje de agradecimiento al cliente por enviarle estos huevos...");
            //lo que mandamos al cliente si se llega a los 100 huevos
            Paquete infoSaliente = new Paquete();
            ObjectOutputStream bufferSalidas= new ObjectOutputStream(cliente.getOutputStream());
            bufferSalidas.writeObject(infoSaliente);
            System.out.println("----------------------------------------");
            System.out.println("FINAL !Mensaje informativo a cliente ENVIADO¡ Esperando mas llegadas. ");
            try {
                Thread.sleep(2000); // se duerme 2 segundos para volver a tratar un cliente
            } finally {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                bufferEntradas.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
