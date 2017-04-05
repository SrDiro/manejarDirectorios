package Modelo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.stream.Stream;

public class AccionesDirectorio {

    private Path directorio;

    public AccionesDirectorio() {
    }

    public String listar(String ruta) throws IOException {
        String respuesta = "1. Listado de la carpeta " + ruta + "\n";
        String fechaFormateada;
        Path archivos;
        long tamano;
        long fechaModificacion;

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy, HH:mm:ss");

        directorio = Paths.get(ruta);
        Stream<Path> datos = Files.list(directorio);

        Iterator<Path> it = datos.iterator();
        while (it.hasNext()) {

            archivos = it.next();
            tamano = Files.size(archivos);
            fechaModificacion = archivos.toFile().lastModified();

            LocalDateTime fecha = LocalDateTime.ofInstant(Instant.ofEpochMilli(fechaModificacion), ZoneId.systemDefault());
            fechaFormateada = fecha.format(formato);

            if (archivos.toFile().isFile()) {
                respuesta += "Archivo '" + archivos.getFileName() + "' --> Tamaño " + tamano + " kB modificado a: " + fechaFormateada + "\n";
            }
            if (archivos.toFile().isDirectory()) {
                respuesta += "Directorio '" + archivos.getFileName() + "' --> Tamaño " + tamano + " kB modificado a: " + fechaFormateada + "\n";
            }

        }

        return respuesta;
    }

    public String filtrarNombre(String nombreArchivo, String ruta) throws IOException {
        String respuesta = "2. Listado de la carpeta " + ruta + "\n";
        String fechaFormateada;
        Path archivos;
        long tamano;
        long fechaModificacion;

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy, HH:mm:ss");

        directorio = Paths.get(ruta);
        Stream<Path> datos = Files.list(directorio);

        Iterator<Path> it = datos.iterator();
        while (it.hasNext()) {

            archivos = it.next();
            tamano = Files.size(archivos);
            fechaModificacion = archivos.toFile().lastModified();

            LocalDateTime fecha = LocalDateTime.ofInstant(Instant.ofEpochMilli(fechaModificacion), ZoneId.systemDefault());
            fechaFormateada = fecha.format(formato);

            if (archivos.toFile().isFile() && archivos.getFileName().toString().equalsIgnoreCase(nombreArchivo)) {
                respuesta += "Archivo '" + archivos.getFileName() + "' --> Tamaño " + tamano + " kB modificado a: " + fechaFormateada + "\n";
            }
            if (archivos.toFile().isDirectory() && archivos.getFileName().toString().equalsIgnoreCase(nombreArchivo)) {
                respuesta += "Directorio '" + archivos.getFileName() + "' --> Tamaño " + tamano + " kB modificado a: " + fechaFormateada + "\n";
            }

        }

        return respuesta;
    }

    public String filtrarLectura() throws IOException {
        String respuesta = "";

        Stream<Path> datos = Files.list(directorio);

        Iterator<Path> it = datos.iterator();
        while (it.hasNext()) {
            Path nombreArchivo = it.next();
            if (Files.isReadable(nombreArchivo) && Files.isWritable(nombreArchivo)) {
                respuesta += nombreArchivo + "\n";
            }
        }

        return respuesta;
    }

    public String filtrarDirectorios() {
        String respuesta = "";

        return respuesta;
    }

    public String filtrarTamano(long tamano, String ruta) throws IOException {
        String respuesta = "";
        Path archivos;
        long tamanoArchivo;
        
        directorio = Paths.get(ruta);
        
        
        Stream<Path> datos = Files.list(directorio);

        Iterator<Path> it = datos.iterator();
        while (it.hasNext()) {

            archivos = it.next();
            tamanoArchivo = Files.size(archivos);

            if (tamanoArchivo >= tamano) {
                respuesta += "Archivo '" + archivos.getFileName() + "' --> Tamaño " + tamanoArchivo + " kB \n";
            }

        }
        return respuesta;
    }

    public String archivoNuevo() {
        String respuesta = "";
            
        return respuesta;
    }

}
