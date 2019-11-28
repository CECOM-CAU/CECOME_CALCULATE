package application;

public class Model {
	public String calculate(String operator, Operand op1, String op2) {
	if(operator.equals("+")) {
		op1.add(op2);
	
	}
	else if(operator.equals("-")) {
		op1.subtract(op2);
		
	}
	//else if(operator.equals("*")) {
		//return x * y;
	//}
	//else {
	//return x / y;
	//	}
	return op1.getResult();
	}
	
}
