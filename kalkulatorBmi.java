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

Label lblJudul = new Label("Kalkulator BMI");
lblJudul.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

TextField tfBerat = new TextField();
tfBerat.setPromptText("contoh: 65");
TextField tfTinggi = new TextField();
tfTinggi.setPromptText("contoh: 170");

GridPane form = new GridPane();
form.setHgap(10);
form.setVgap(10);
form.add(new Label("Berat badan (kg):"), 0, 0);
form.add(tfBerat, 1, 0);
form.add(new Label("Tinggi badan (cm):"), 0, 1);
form.add(tfTinggi, 1, 1);

Button btnHitung = new Button("Hitung");
Button btnReset = new Button("Reset");
HBox boxTombol = new HBox(10, btnHitung, btnReset);
boxTombol.setAlignment(Pos.CENTER);

Label lblHasil = new Label();
Label lblKategori = new Label();

VBox root = new VBox(15, lblJudul, form, boxTombol, lblHasil, lblKategori);
root.setPadding(new Insets(20));
root.setAlignment(Pos.CENTER);

btnHitung.setOnAction(e -> {
    double berat = Double.parseDouble(tfBerat.getText());
    double tinggiM = Double.parseDouble(tfTinggi.getText()) / 100.0;
    double bmi = berat / (tinggiM * tinggiM);

    String kategori;
    if (bmi < 18.5) kategori = "Kurus";
    else if (bmi < 25) kategori = "Normal";
    else if (bmi < 30) kategori = "Kelebihan berat badan";
    else kategori = "Obesitas";

    lblHasil.setText(String.format("BMI Anda: %.1f", bmi));
    lblKategori.setText("Kategori: " + kategori);
});