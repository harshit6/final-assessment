package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class DC implements Initializable {
	
	@FXML
	WebView webView;
	
    @FXML 
   private WebEngine webengine;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		 this.webengine = this.webView.getEngine();
		    this.webengine.load("http://google.com");
		
		
	}
	
}
