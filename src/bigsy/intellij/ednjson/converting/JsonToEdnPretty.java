package bigsy.intellij.ednjson.converting;

import bigsy.intellij.ednjson.AbstractEdnJsonAction;
import clojure.java.api.Clojure;
import clojure.lang.IFn;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.editor.Editor;

import java.util.Map;

public class JsonToEdnPretty extends AbstractEdnJsonAction<Object> {

	static {
		Thread.currentThread().setContextClassLoader(JsonToEdnPretty.class.getClassLoader());
		IFn require = Clojure.var("clojure.core", "require");
		require.invoke(Clojure.read("com.bigsy.convert"));
	}

	private static final  IFn jsonedn_impl= Clojure.var("com.bigsy.convert", "json->edn-pretty");

	public String jsonedn(String string){
		return jsonedn_impl.invoke(string).toString();
	}


	@Override
	public String transformSelection(Editor editor, Map<String, Object> actionContext, DataContext dataContext, String selectedText, Object additionalParam) {
		return jsonedn(selectedText);
	}


	@Override
	public String transformByLine(Map<String, Object> actionContext, String s) {
		throw new RuntimeException();
	}
}