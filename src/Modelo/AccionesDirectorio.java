package Modelo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

public class AccionesDirectorio {

    private Path directorio;

    public AccionesDirectorio() {
    }
    
    public String listar(String ruta) throws IOException {
        String respuesta = "";

        directorio = Paths.get(ruta);
        Stream<Path> datos = Files.list(directorio);

        Iterator<Path> it = datos.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().getFileName());
        }

        return respuesta;
    }

    public String filtrarNombre() {
        String respuesta = "";

        return respuesta;
    }

    public String filtrarDirectorios() {
        String respuesta = "";

        return respuesta;
    }

    public String filtrarTamano() {
        String respuesta = "";

        return respuesta;
    }

    public String archivoNuevo() {
        String respuesta = "";

        return respuesta;
    }

}
