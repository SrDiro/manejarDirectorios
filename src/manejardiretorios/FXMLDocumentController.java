package manejardiretorios;

import Modelo.AccionesDirectorio;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField tfRuta;
    @FXML
    private Button botonAbrir;
    @FXML
    private RadioButton rbContenidoDirectorio;
    @FXML
    private ToggleGroup eleccion;
    @FXML
    private RadioButton rbContenidoFiltrado;
    @FXML
    private RadioButton rbSoloLectura;
    @FXML
    private RadioButton rbFiltradoTamano;
    @FXML
    private RadioButton rbArchivoNuevo;
    @FXML
    private TextField tfFiltradoTamano;
    @FXML
    private TextField tfNombreArchivo;
    @FXML
    private Button botonEjecutar;
    @FXML
    private TextArea taPantalla;

    AccionesDirectorio ad = new AccionesDirectorio();
    File ruta;
    @FXML
    private TextField tfContenidoFiltrado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tfRuta.setEditable(false);
        taPantalla.setEditable(false);
        
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Open Resource File");
        ruta = directoryChooser.showDialog(null);
        tfRuta.setText(ruta.getAbsolutePath());

    }

    @FXML
    private void abrirRuta(ActionEvent event) {

        if (botonAbrir.isFocused()) {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("Open Resource File");
            ruta = directoryChooser.showDialog(null);
            tfRuta.setText(ruta.getAbsolutePath());
        }

    }

    @FXML
    private void ejecutarOpcion(ActionEvent event) throws IOException {
        String archivos;
        String nombreArchivo;
        long tamanoArchivo;
        
        if (rbContenidoDirectorio.isSelected()) {
            
            archivos = ad.listar(ruta.getAbsolutePath());
            taPantalla.setText(archivos);
            
        } else if (rbContenidoFiltrado.isSelected()) {
            
            nombreArchivo = tfContenidoFiltrado.getText();
            archivos = ad.filtrarNombre(nombreArchivo, ruta.getAbsolutePath());
            taPantalla.setText(archivos);
            
        } else if (rbSoloLectura.isSelected()) {
            
            archivos = ad.filtrarLectura();
            taPantalla.setText(archivos);
        } else if (rbFiltradoTamano.isSelected()) {
            
            tamanoArchivo = Long.parseLong(tfFiltradoTamano.getText());
            archivos = ad.filtrarTamano(tamanoArchivo, ruta.getAbsolutePath());
            taPantalla.setText(archivos);
        }

    }

}
