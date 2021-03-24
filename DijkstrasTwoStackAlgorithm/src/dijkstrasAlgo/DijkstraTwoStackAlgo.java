package dijkstrasAlgo;

import java.text.DecimalFormat;

public class DijkstraTwoStackAlgo {
	
	private Stack<String> operators;
	private Stack<Double> values;
	private String function;
	
	public DijkstraTwoStackAlgo(String function) {
		this.operators = new Stack<String>();
		this.values = new Stack<Double>();
		this.function = function + " ";
	}
	
	public String run() throws Exception {
		String toEvaluate = "";
		for(int i=0; i<this.function.length(); i++) {
			boolean done = false;
			if(this.function.charAt(i) != ' ') {
				toEvaluate += this.function.charAt(i);
			} else {
				done = true;
			}
			if(done) {
				if(check(toEvaluate).equals("double")) {
					this.values.push(Double.parseDouble(toEvaluate));
				} else if (check(toEvaluate).equals("operator")) {
					this.operators.push(toEvaluate);
				} else if(check(toEvaluate).equals("execute")) {
					double value1 = this.values.pop();
					double value2 = this.values.pop();
					double result = 0;
					String operator = this.operators.pop();
					switch(operator) {
					case "+":
						result = value2 + value1;
						break;
					case "-":
						result = value2 - value1;
						break;
					case "*":
						result = value2 * value1;
						break;
					case "/":
						result = value2 / value1;
						break;
					case "%":
						result = value2 % value1;
						break;
					default:
						break;
					}
					this.values.push(result);
				} else {
					toEvaluate = "";
					continue;
				}
				toEvaluate = "";
			}
		}
		DecimalFormat df = new DecimalFormat("###.##");
		return df.format(this.values.pop());
	}
	
	public String check(String character) throws Exception {
		if(character.matches("(([0-9]+)\\.([0-9]+))|([0-9]+)")) {
			return "double";
		} else if (character.matches("[%|*|+|[-]|/]")){
			return "operator";
		} else if (character.matches("[)]")){
			return "execute";
		} else if (character.matches("[(]")){
			return "";
		} else {
			throw new Exception("Function not entered correctly");
		}
	}
	
}
