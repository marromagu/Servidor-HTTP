/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ServerHTTP;

/**
 *
 * @author DAM_M
 */
import java.io.BufferedReader;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * *****************************************************************************
 * Servidor HTTP que atiende peticiones de tipo 'GET' recibidas por el puerto
 * 8066
 *
 * NOTA: para probar este código, comprueba primero de que no tienes ningún otro
 * servicio por el puerto 8066 (por ejemplo, con el comando 'netstat' si estás
 * utilizando Windows)
 *
 * @author IMCG
 */
class ServidorHTTP {

    /**
     * **************************************************************************
     * procedimiento principal que asigna a cada petición entrante un socket
     * cliente, por donde se enviará la respuesta una vez procesada
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            //Asociamos al servidor el puerto 8066
            ServerSocket socServidor = new ServerSocket(8066);
            imprimeDisponible();
            Socket socCliente;

            //ante una petición entrante, procesa la petición por el socket cliente
            //por donde la recibe
            while (true) {
                //a la espera de peticiones
                socCliente = socServidor.accept();
                //atiendo un cliente
                System.out.println("--> Atendiendo al cliente ");
                procesaPeticion(socCliente);
                //cierra la conexión entrante
                socCliente.close();
                System.out.println("--> Cliente atendido");
            }
        } catch (IOException ex) {
            Logger.getLogger(ServidorHTTP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *****************************************************************************
     * procesa la petición recibida
     *
     * @throws IOException
     */
    private static void procesaPeticion(Socket socketCliente) {
        InputStreamReader inSR = null;
        try {
            //Variables locales
            String peticion;
            String html;
            
            //Flujo de entrada
            inSR = new InputStreamReader(socketCliente.getInputStream());
            
            //Espacio en memoria para la entrada de peticiones
            BufferedReader bufLeer = new BufferedReader(inSR);
            
            //Objeto de java.io que entre otras características, permite escribir 'línea a línea' en un flujo de salida
            PrintWriter printWriter = new PrintWriter(socketCliente.getOutputStream(), true);
            
            //Mensaje petición cliente
            peticion = bufLeer.readLine();
            
            //Para compactar la petición y facilitar así su análisis, suprimimos todos los espacios en blanco que contenga
            peticion = peticion.replaceAll(" ", "");
            System.out.println(peticion);
            
            //Si realmente se trata de una petición 'GET'
            if (peticion.startsWith("GET")) {
                //extrae la subcadena entre 'GET' y 'HTTP/1.1'
                peticion = peticion.substring(3, peticion.lastIndexOf("HTTP"));

                //si corresponde a la página de inicio
                if (peticion.length() == 0 || peticion.equals("/")) {
                    //sirve la página
                    html = Paginas.html_index;
                    printWriter.println(Mensajes.lineaInicial_OK);
                    printWriter.println(Paginas.primeraCabecera);
                    printWriter.println("Content-Length: " + html.length() + 1);
                    printWriter.println("\n");
                    printWriter.println(html);
                } //si corresponde a la página del Quijote
                else if (peticion.equals("/quijote")) {
                    //sirve la página
                    html = Paginas.html_quijote;
                    printWriter.println(Mensajes.lineaInicial_OK);
                    printWriter.println(Paginas.primeraCabecera);
                    printWriter.println("Content-Length: " + html.length() + 1);
                    printWriter.println("\n");
                    printWriter.println(html);
                } //en cualquier otro caso
                else if (peticion.equals("/formularioGet")) {
                    //sirve la página
                    html = Paginas.html_GET;
                    printWriter.println(Mensajes.lineaInicial_OK);
                    printWriter.println(Paginas.primeraCabecera);
                    printWriter.println("Content-Length: " + html.length() + 1);
                    printWriter.println("\n");
                    printWriter.println(html);
                } //en cualquier otro caso
                else if (peticion.equals("/formularioPost")) {
                    //sirve la página
                    html = Paginas.html_POST;
                    printWriter.println(Mensajes.lineaInicial_OK);
                    printWriter.println(Paginas.primeraCabecera);
                    printWriter.println("Content-Length: " + html.length() + 1);
                    printWriter.println("\n");
                    printWriter.println(html);
                } //en cualquier otro caso
                else if (peticion.equals("/formularioRespuesta")) {
                    //sirve la página
                    html = Paginas.html_Respuesta;
                    printWriter.println(Mensajes.lineaInicial_OK);
                    printWriter.println(Paginas.primeraCabecera);
                    printWriter.println("Content-Length: " + html.length() + 1);
                    printWriter.println("\n");
                    printWriter.println(html);
                } //en cualquier otro caso
                else {
                    //sirve la página
                    html = Paginas.html_noEncontrado;
                    printWriter.println(Mensajes.lineaInicial_NotFound);
                    printWriter.println(Paginas.primeraCabecera);
                    printWriter.println("Content-Length: " + html.length() + 1);
                    printWriter.println("\n");
                    printWriter.println(html);
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(ServidorHTTP.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                inSR.close();
            } catch (IOException ex) {
                Logger.getLogger(ServidorHTTP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * **************************************************************************
     * muestra un mensaje en la Salida que confirma el arranque, y da algunas
     * indicaciones posteriores
     */
    private static void imprimeDisponible() {

        System.out.println(
                  "El Servidor WEB se está ejecutando y permanece a la "
                + "escucha por el puerto 8066.\nEscribe en la barra de direcciones "
                + "de tu explorador preferido:\n\nhttp://localhost:8066\npara "
                + "solicitar la página de bienvenida\n\nhttp://localhost:8066/"
                + "quijote\n para solicitar una página del Quijote,\n\nhttp://"
                + "localhost:8066/q\n para simular un error");
    }
}
