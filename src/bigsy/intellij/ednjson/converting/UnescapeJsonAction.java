package bigsy.intellij.ednjson.converting;

import bigsy.intellij.ednjson.AbstractEdnJsonAction;

import java.util.Map;

public class UnescapeJsonAction extends AbstractEdnJsonAction<Object> {

	@Override
	public String transformByLine(Map<String, Object> actionContext, String s) {
		return org.apache.commons.text.StringEscapeUtils.unescapeJson(s);
	}
}