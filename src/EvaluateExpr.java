import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class EvaluateExpr {
	
	private static String expr = "(1+4)*6/(3-1)";
  
	public static void main(String[] args) {
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
		try {
			System.out.println("Expr (" + expr + ") = " + engine.eval(expr));
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
