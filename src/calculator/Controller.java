package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    public TextField textField;
    private int temp1, temp2;
    private String event = "";
    private boolean isOperatorClicked = false;
    private int sum = 0;

    private void calculate () {
        switch(event) {
            case "+":
                sum = temp1+temp2;
                break;
            case "-":
                sum = temp1-temp2;
                break;
            case "*":
                sum = temp1*temp2;
                break;
            case "/":
                sum = temp1/temp2;
                break;
            default:
                temp1 = 0;
                temp2 = 0;
        }
        temp1 = 0;
        temp2 = 0;
    }

    public void onClick(ActionEvent actionEvent) {
        textField.appendText(((Button)actionEvent.getSource()).getText());
    }

    public void reset(ActionEvent actionEvent) {
        isOperatorClicked = false;
        temp1 = 0;
        temp2 = 0;
        sum = 0;
        event = "";
        textField.clear();
    }

    public void result(ActionEvent actionEvent) {
        temp2 = Integer.parseInt(textField.getText());
        textField.clear();
        calculate();
        textField.appendText(sum + "");
        isOperatorClicked = false;
        temp1 = 0;
        temp2 = 0;
        sum = 0;
        event = "";
    }

    public void action(ActionEvent actionEvent) {
        if (isOperatorClicked) {
            temp2 = Integer.parseInt(textField.getText());
            textField.clear();
            calculate();
            temp1 = sum;
        } else {
            temp1 = Integer.parseInt(textField.getText());
            textField.clear();
        }
        event = ((Button)actionEvent.getSource()).getText();
        isOperatorClicked = true;
    }
}
