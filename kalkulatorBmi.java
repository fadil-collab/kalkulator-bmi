import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BmiCalculator extends Application {
    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        stage.setTitle("Kalkulator BMI");
        stage.setScene(new Scene(root, 360, 320));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}