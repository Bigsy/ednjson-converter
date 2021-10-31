package bigsy.intellij.ednjson.converting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import bigsy.intellij.ednjson.AbstractEdnJsonAction;
import org.junit.Test;

public class ConversionsTest {


	private boolean fail;

	@Test
	public void ednToJson() throws Exception {
		EdnToJson action = new EdnToJson();
		assertEquals("{\"foo\":\"bar\",\"baz\":5}",
				action.transformSelection(null,null,null,"{:foo \"bar\" :baz 5}",null));

	}



	@Test
	public void jsonToEdn() throws Exception {

		JsonToEdn action = new JsonToEdn();
		assertEquals("{:foo \"bar\", :baz {:eggplant [1 2 3]}}",
				action.transformSelection(null,null,null,"{\"foo\":\"bar\",\"baz\":{\"eggplant\":[1,2,3]}}",null));

	}


	@Test
	public void jsonToEdnPretty() throws Exception {

		JsonToEdnPretty action = new JsonToEdnPretty();
		assertEquals("{:a {:a 0, :b 1, :c 2, :d 3, :e 4},\n" +
						" :b {:a 0, :b 1, :c 2, :d 3, :e 4},\n" +
						" :c {:a 0, :b 1, :c 2, :d 3, :e 4},\n" +
						" :d {:a 0, :b 1, :c 2, :d 3, :e 4},\n" +
						" :e {:a 0, :b 1, :c 2, :d 3, :e 4}}\n",
				action.transformSelection(null,null,null,"{\"a\":{\"a\":0,\"b\":1,\"c\":2,\"d\":3,\"e\":4},\"b\":{\"a\":0,\"b\":1,\"c\":2,\"d\":3,\"e\":4},\"c\":{\"a\":0,\"b\":1,\"c\":2,\"d\":3,\"e\":4},\"d\":{\"a\":0,\"b\":1,\"c\":2,\"d\":3,\"e\":4},\"e\":{\"a\":0,\"b\":1,\"c\":2,\"d\":3,\"e\":4}}",null));

	}

	@Test
	public void ednToJsonPretty() throws Exception {
		EdnToJsonPretty action = new EdnToJsonPretty();
		assertEquals("{\n" +
						"  \"foo\" : \"bar\",\n" +
						"  \"baz\" : 5\n" +
						"}",
				action.transformSelection(null,null,null,"{:foo \"bar\" :baz 5}",null));

	}


}
