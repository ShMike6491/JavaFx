package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    public TextField textField;
    private int num1, num2;
    private String event = "";

    public void onClick(ActionEvent actionEvent) {
        textField.appendText(((Button)actionEvent.getSource()).getText());
    }

    public void reset(ActionEvent actionEvent) {
        num1 = 0;
        num2 = 0;
        event = "";
        textField.clear();
    }

    public void result(ActionEvent actionEvent) {
        num2 = Integer.parseInt(textField.getText());
        textField.clear();
        switch(event) {
            case "+":
                num1+=num2;
                break;
            case "-":
                num1-=num2;
                break;
            case "*":
                num1*=num2;
                break;
            case "/":
                num1/=num2;
                break;
            default:
                num1 = 0;
        }
        textField.appendText(num1 + "");
    }

    public void action(ActionEvent actionEvent) {
        event = ((Button)actionEvent.getSource()).getText();
        num1 = Integer.parseInt(textField.getText());
        textField.clear();
    }
}
