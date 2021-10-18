package bigsy.intellij.ednjson.converting;

import bigsy.intellij.ednjson.AbstractEdnJsonAction;


import java.util.Map;

import clojure.java.api.Clojure;
import clojure.lang.IFn;


public class EdnToJson extends AbstractEdnJsonAction<Object> {

	static {
		Thread.currentThread().setContextClassLoader(EdnToJson.class.getClassLoader());
		IFn require = Clojure.var("clojure.core", "require");
		require.invoke(Clojure.read("com.bigsy.convert"));
	}


	private static final  IFn ednjson_impl= Clojure.var("com.bigsy.convert", "edn->json");


	public String ednjson(String string){
		return ednjson_impl.invoke(string).toString();
	}

	@Override
	public String transformByLine(Map<String, Object> actionContext, String s) {
		//return org.apache.commons.text.StringEscapeUtils.escapeJava(service("wibble"));
		return ednjson(s);
    }
}
