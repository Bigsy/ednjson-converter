package bigsy.intellij.ednjson.converting;

import bigsy.intellij.ednjson.AbstractEdnJsonAction;

import java.util.Map;
import clojure.java.api.Clojure;
import clojure.lang.IFn;

public class JsonToEdn extends AbstractEdnJsonAction<Object> {

	static {
		Thread.currentThread().setContextClassLoader(EdnToJson.class.getClassLoader());
		IFn require = Clojure.var("clojure.core", "require");
		require.invoke(Clojure.read("com.bigsy.convert"));
	}

	private static final  IFn jsonedn_impl= Clojure.var("com.bigsy.convert", "json->edn");

	public String jsonedn(String string){
		return jsonedn_impl.invoke(string).toString();
	}

	@Override
	public String transformByLine(Map<String, Object> actionContext, String s) {

		return jsonedn(s);
    }
}