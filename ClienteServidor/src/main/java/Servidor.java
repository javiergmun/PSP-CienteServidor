import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {
    int numClientes=0;
        ServerSocket servidor;
        Socket cliente;
        int puerto = 6666;
        boolean salir = false;

        try{
            System.out.println("¡Servidor montado! Estamos esperando a que vengan paquetes.");
            servidor= new ServerSocket(puerto);
            while(!salir) {
                cliente = servidor.accept();//se acepta
                numClientes++;
                System.out.println("El cliente ha sido aceptado, ahora tenemos: " + numClientes + " paquetes");
                System.out.println("El paquete llega desde: " + cliente.getInetAddress());
                System.out.println("Estás siendo redirigido a la gestion de paquetes...");
                //MANDAR A CLIENTE GESTION
                GestionCliente gestion = new GestionCliente(numClientes, cliente);
                gestion.start();
            }
            System.out.println("===");
            System.out.println("FIN");
            System.out.println("===");
            servidor.close();
            } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

