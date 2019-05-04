package Assignment8;

import java.util.Stack;

/**
 *
 * @author Jeremy Santorelli
 */
public class Calculator {

    static String getAnswer(String expression) {
        String[] expressionParts = expression.split(" ");
        Stack<String> operators = new Stack<>();
        Stack<Double> terms = new Stack<>();

        Double total = 0.0;

        for (int i = 0; i < expressionParts.length; i++) {

            try {
                switch (expressionParts[i]) {
                    case "*":
                        terms.push(terms.pop() * Double.parseDouble(expressionParts[++i]));
                        break;
                    case "/":
                        terms.push(terms.pop() / Double.parseDouble(expressionParts[++i]));
                        break;
                    default:
                        try {
                            terms.push(Double.parseDouble(expressionParts[i]));
                        } catch (NumberFormatException e) {
                            operators.push(expressionParts[i]);
                        }
                        break;
                }
            } catch (NumberFormatException e) {
                return expression + " is not formatted properly";
            }
        }

        total += terms.pop();

        while (!operators.isEmpty()) {
            switch (operators.pop()) {
                case "+":
                    total += terms.pop();
                    break;
                case "-":
                    total -= terms.pop();
                    break;
                case "*":
                    total *= terms.pop();
                    break;
                case "/":
                    total /= terms.pop();
            }
        }

        return total.toString();

    }

}
