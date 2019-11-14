package calculator;

public class BeforeAfterOperating {
	private String firstOperand="";
	private String secondOperand="";
	private String operator="";
	private String result="";
	
	void setFirstOP(String op) {
		this.firstOperand=op;
	}
	void setSecondOP(String op) {
		this.secondOperand=op;
	}
	void setOperator(String op) {
		this.operator=op;
	}
	void operate() {
		if(this.operator=="+") {
			//Add.add(this.firstOperand,this.secondOperand);
			//this.result=getResult();
		}
		else {
			//Subtract.subtract(this.firstOperand,this.secondOperand);
			//this.result=getResult();
		}
	}
	String getResult() {
		return this.result;
	}
	
}
