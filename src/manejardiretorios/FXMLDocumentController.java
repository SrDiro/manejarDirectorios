package manejardiretorios;

import Modelo.AccionesDirectorio;
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
    private TextField rfContenidoFiltrado;
    @FXML
    private TextField tfFiltradoTamano;
    @FXML
    private TextField tfNombreArchivo;
    @FXML
    private Button botonEjecutar;
    @FXML
    private TextArea taPantalla;

    AccionesDirectorio ad;
    String ruta;
    
    Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        ruta = fileChooser.showOpenDialog(stage) + "";
        tfRuta.setText(ruta);
        
        
    }

    @FXML
    private void abrirRuta(ActionEvent event) {

        if (botonAbrir.isFocused()) {

        }

    }

    @FXML
    private void ejecutarOpcion(ActionEvent event) throws IOException {

        if (rbContenidoDirectorio.isSelected()) {
            taPantalla.setText(ad.listar(ruta));
        }

    }

}
