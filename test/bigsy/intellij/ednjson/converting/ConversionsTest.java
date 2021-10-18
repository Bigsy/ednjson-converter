package bigsy.intellij.ednjson.converting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class ConversionsTest {


	private boolean fail;

	@Test
	public void ednToJson() throws Exception {
		EdnToJson action = new EdnToJson();
		assertEquals("{\"foo\":\"bar\",\"baz\":5}", action.transformByLine("{:foo \"bar\" :baz 5}"));

	}



	@Test
	public void jsonToEdn() throws Exception {

		JsonToEdn action = new JsonToEdn();
		assertEquals("{:foo \"bar\", :baz {:eggplant [1 2 3]}}", action.transformByLine("{\"foo\":\"bar\",\"baz\":{\"eggplant\":[1,2,3]}}"));

	}
}
