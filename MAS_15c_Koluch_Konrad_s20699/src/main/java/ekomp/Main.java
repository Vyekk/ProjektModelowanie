package ekomp;

import ekomp.Helpers.ObjectPlus;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Controllers/main.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws ClassNotFoundException {
        String extentfile = "ekstensja.txt";
        try {
            ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(extentfile)));
            ObjectPlus.readExtents(in);
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku z danymi");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        launch();


        try {
            ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(extentfile)));
            ObjectPlus.writeExtents(out);
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku z danymi");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}