package ekomp;

import ekomp.Helpers.ObjectPlus;
import ekomp.Models.Computer;
import ekomp.Models.Order;
import ekomp.Models.Part;
import ekomp.Models.PartComputer;
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
        // Przykładowe dane z komputerami
        Part p1 = new Part("nvidia gtx 1080",1999.99f,"Karta graficzna");
        Part p2 = new Part("Gigabyte Z23",449.99f,"Płyta główna");
        Computer c1 = new Computer(340);
        PartComputer pc1 = new PartComputer(2,p1,c1);
        PartComputer pc2 = new PartComputer(1,p2,c1);
//        Order o = (Order) ObjectPlus.allExtents.get(Order.class).get(0);
//        System.out.println(o.getNumber() + " " + o.getClient());
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