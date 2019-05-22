package application;

import java.io.IOException;
import java.net.URL;
import java.util.Hashtable;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController extends Application implements Initializable {


    @FXML
    private Button login;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private RadioButton reader;
    @FXML
    private RadioButton author;
    @FXML
    private RadioButton admin;
    @FXML
    private Label message;
    @FXML
    private ComboBox<String> cb_roles;
    private TextField first;
    
    private TextField rollnumber;
    
    private TextField Decimalvalue;
    
    private TextField Add;
    
    private TextField Addthis;
    
    private TextField Result;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        cb_roles.setPromptText("Select User");
        cb_roles.getItems().addAll("Reader", "Author", "Admin");
    }

    /***
     * @author Jaskirat Singh Grewal, Prince Parihar, Harshit
     */
    public void launchRelevantWindow() {
        message.setText("");
        String checkuser = username.getText().toString();
        String checkpass = password.getText().toString();
        String checkUserType = cb_roles.getSelectionModel().getSelectedItem();
        Hashtable<Integer,String> titleTable = new Hashtable<Integer, String>();
        titleTable.put(1,"Reader's Hub");
        titleTable.put(2,"Author's Hub");
        titleTable.put(3,"Admin's Hub");
        String currentStageTitle = "";

        if (checkuser.equals("team9") && checkpass.equals("123")) {
            try {
                // Read file fxml and draw interface.
                FXMLLoader fxmlLoader;
                if (checkUserType.equals("Reader")) {
                    fxmlLoader = new FXMLLoader(getClass()
                            .getResource("/application/HomeWindow.fxml"));
                    currentStageTitle = titleTable.get(1);
                }
                else if (checkUserType.equals("Author")) {
                    fxmlLoader = new FXMLLoader(getClass()
                            .getResource("/application/AuthorHub.fxml"));
                    currentStageTitle = titleTable.get(2);
                }
                else
                {
                    fxmlLoader = new FXMLLoader(getClass()
                            .getResource("/application/AdminHub.fxml"));
                    currentStageTitle = titleTable.get(3);
                }
                Parent root1 = (Parent) fxmlLoader.load();
                Stage mainStage = new Stage();
                mainStage.setTitle(currentStageTitle);
                mainStage.setScene(new Scene(root1));
                mainStage.show();

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Can't Load the window");
            }
        } else
            message.setText("Please Enter Correct Credentials");
    }

    public void result() throws IOException {
        int a;
        a=170008 ; // roll number
        int b;
        b=48 ;   // decimal value multiplied
        int c;
        c= a+b;
        Result.setText(String.valueOf(c)); 
    }
    
    public void SignUp() throws IOException {



        FXMLLoader fxmlLoader = new FXMLLoader(getClass()
                .getResource("/application/SignUp.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage mainStage = new Stage();
        mainStage.setTitle("Reader's Hub");
        mainStage.setScene(new Scene(root1));
        mainStage.show();
    }
    @Override
    public void start(Stage arg0) throws Exception {
        Parent root = FXMLLoader.load(getClass()
                .getResource("/application/LoginPage.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("eBook Software");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


    }
}
		
