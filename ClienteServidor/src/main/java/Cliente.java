import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.UUID;

public class Cliente {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ArrayDeque<String> almacen = new ArrayDeque<>();
        almacen.add("PILA DE PAQUETES ENVIADOS = ");

        for (int i = 0; i <10;i++) {
        Socket servidor = new Socket("localhost",6666 );
        Paquete paqueteSalida = new Paquete("","paquete",UUID.randomUUID(),UUID.randomUUID(),Instant.now(),2);
            //ALMACEN PARA METER TODOS LOS PAQUETES QUE LLEGAN
        //ArrayDeque<String> almacen = new ArrayDeque<>();
            //enviar un paquete de huevos
            ObjectOutputStream bufferSalida = new ObjectOutputStream(servidor.getOutputStream());
            bufferSalida.writeObject(paqueteSalida);

            System.out.println("Se ha enviado un paquete: " + paqueteSalida.toString()); // creado en paquete

            //recibir
            ObjectInputStream bufferEntrada = new ObjectInputStream(servidor.getInputStream());
            Paquete paqueteEntrada = (Paquete) bufferEntrada.readObject();
            System.out.println("El señor Spock nos da las gracias por enviarle: " + paqueteEntrada.toString());
            bufferEntrada.read();
            System.out.println("---");

            //almacen.add("PILA DE PAQUETES ENVIADOS = ");
            System.out.println("Añadiendo a pila...");
            almacen.add(paqueteEntrada.toString());
            System.out.println(almacen);
        }
        System.out.println("===");
        System.out.println("FIN");
        System.out.println("===");
    }
}
