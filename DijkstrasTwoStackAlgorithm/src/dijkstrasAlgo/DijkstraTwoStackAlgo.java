package dijkstrasAlgo;

public class DijkstraTwoStackAlgo {
	
	private Stack<String> operators;
	private Stack<Integer> values;
	private String function;
	
	public DijkstraTwoStackAlgo(String function) {
		this.operators = new Stack<String>();
		this.values = new Stack<Integer>();
		this.function = function + " ";
	}
	
	public int run() throws Exception {
		String toEvaluate = "";
		for(int i=0; i<this.function.length(); i++) {
			boolean done = false;
			if(this.function.charAt(i) != ' ') {
				toEvaluate += this.function.charAt(i);
			} else {
				done = true;
			}
			if(done) {
				if(check(toEvaluate).equals("int")) {
					this.values.push(Integer.parseInt(toEvaluate));
				} else if (check(toEvaluate).equals("operator")) {
					this.operators.push(toEvaluate);
				} else if(check(toEvaluate).equals("execute")) {
					int value1 = this.values.pop();
					int value2 = this.values.pop();
					int result = 0;
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
		return this.values.pop();
	}
	
	public String check(String character) throws Exception {
		if(character.matches("[0-9]+")) {
			return "int";
		} else if (character.matches("[%|*|+|/]")){
			return "operator";
		} else if (character.matches("[)]")){
			return "execute";
		} else if (character.equals("-")){
			return "operator";
		} else if (character.matches("[(]")){
			return "";
		} else {
			throw new Exception("Function not entered correctly");
		}
	}
	
}
