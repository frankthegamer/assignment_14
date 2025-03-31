import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.scene.layout.HBox;


public class MetricConvertUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(20); 
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        // main title
        Label label = new Label("Metric Converter");
        label.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        label.setTextFill(Color.BLUE);
        label.setTextAlignment(TextAlignment.CENTER);
        label.setStyle("-fx-background-color: lightgray; -fx-padding: 10; -fx-border-color: black; -fx-border-width: 2;");
        
        // input number
        TextField inputField = new TextField("Enter Number");
        inputField.setPromptText("Enter Number");

        // select conversion type
        ComboBox<String> unitComboBox = new ComboBox<>();
        unitComboBox.setPromptText("Select Conversion");
        unitComboBox.getItems().addAll("Millimeters to Inches", "Meters to Kilometers", "Feet to Miles", "Inches to Centimeters", "Fahrenheit to Celsius");

        // convert button
        Button button = new Button("Convert");

        //result label
        Label resultLabel = new Label("Result: ");

        // hbox for input number and dropdown
        HBox inputBox = new HBox(10, inputField, unitComboBox);
        inputBox.setAlignment(Pos.CENTER);

        root.getChildren().addAll(label, inputBox, button,resultLabel);

        // scene setup
        Scene scene = new Scene(root, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Metric Converter");
        primaryStage.show();

        // events handler 
        button.setOnAction(e -> {
            String inputText = inputField.getText();
            try{
                int inputValue = Integer.parseInt(inputText);

                String conversionType = unitComboBox.getValue();
                double answer = MetricConverter.MetricConvert(inputValue, conversionType);

                if(answer != -1){
                    resultLabel.setTextFill(Color.GREEN);
                    resultLabel.setText("result: " + answer);
                }
            } catch (NumberFormatException ex){
                resultLabel.setTextFill(Color.RED);
                resultLabel.setText("Invalid input");
            } catch (NullPointerException ex) {
                resultLabel.setTextFill(Color.RED);
                resultLabel.setText("Please select a conversion type");
            } catch (Exception ex) {
                resultLabel.setTextFill(Color.RED);
                resultLabel.setText("An error occurred: " + ex.getMessage());
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
