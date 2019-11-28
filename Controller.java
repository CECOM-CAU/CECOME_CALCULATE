package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {
	
	private String operator = ""; 
//	private String x = "";
	private String temp="";
	private Operand op1=new Operand();
	//private Operand op2=new Operand();
	private Model model = new Model();
	@FXML
	private Text result;
	
	@FXML
	private void operand(ActionEvent event) {
		result.setText(result.getText() + ((Button)event.getSource()).getText());
	}
	
	@FXML
	private void operator(ActionEvent event) {
		if(((Button) event.getSource()).getText().equals("=")) {
		//	op2.reverse(result.getText());
			temp=(String)(result.getText());
			String reversed="";
			for(int i=temp.length()-1;i>=0;i--){
	               reversed+=String.valueOf(temp.charAt(i));
	           }
			result.setText(model.calculate(operator,  op1, reversed));
		} else {
			operator = ((Button)event.getSource()).getText();
			temp = result.getText();
			op1.reverse(temp);
			result.setText("");
	
	}
}
}