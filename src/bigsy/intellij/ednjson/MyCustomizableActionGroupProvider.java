package bigsy.intellij.ednjson;

import com.intellij.ide.ui.customization.CustomizableActionGroupProvider;
import com.intellij.openapi.diagnostic.Logger;

public class MyCustomizableActionGroupProvider extends CustomizableActionGroupProvider {
	private static final Logger LOG = com.intellij.openapi.diagnostic.Logger.getInstance(MyCustomizableActionGroupProvider.class);

	@Override
	public void registerGroups(CustomizableActionGroupRegistrar registrar) {
		registrar.addCustomizableActionGroup("EdnJson.Group.Main", "JsonEdn Converter - Main popup");
	}
}
