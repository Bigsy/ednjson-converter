package bigsy.intellij.ednjson.converting;

import bigsy.intellij.ednjson.AbstractEdnJsonAction;

import java.util.Map;

public class NonAsciiToUnicodeEscapedAction extends AbstractEdnJsonAction<Object> {

	@Override
	public String transformByLine(Map<String, Object> actionContext, String s) {
        return s;
    }
}