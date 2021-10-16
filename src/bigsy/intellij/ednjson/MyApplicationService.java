package bigsy.intellij.ednjson;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.ex.ActionManagerEx;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.extensions.PluginId;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class MyApplicationService {
	private static final Logger LOG = Logger.getInstance(MyApplicationService.class);
	private static final String KEY = "bigsy.intellij.ednjson.MyApplicationService.lastAction";

	private Class lastAction;
	private Map<Class, AnAction> classToActionMap;

	public static MyApplicationService getInstance() {
		return ServiceManager.getService(MyApplicationService.class);
	}

	public AnAction getAnAction() {

		if (lastAction == null) {
			String value = PropertiesComponent.getInstance().getValue(KEY);
			if (value != null) {
				try {
					lastAction = Class.forName(value);
				} catch (Throwable e) {
					LOG.debug(e);
				}
			}
		}
		return getActionMap().get(lastAction);
	}

	public static void setAction(Class aClass) {
		if (aClass != null) {
			MyApplicationService instance = getInstance();
			instance.lastAction = aClass;
			PropertiesComponent.getInstance().setValue(KEY, aClass.getCanonicalName());
		}
	}



	@NotNull
	protected Map<Class, AnAction> getActionMap() {
		if (this.classToActionMap == null) {
			ActionManagerEx instanceEx = ActionManagerEx.getInstanceEx();
			PluginId pluginId = PluginId.getId("EdnJson Converter");

			HashMap<Class, AnAction> classToActionMap = new HashMap<Class, AnAction>();
			for (String string_manipulation : instanceEx.getPluginActions(pluginId)) {
				AnAction action = instanceEx.getAction(string_manipulation);
				classToActionMap.put(action.getClass(), action);
			}
			this.classToActionMap = classToActionMap;
		}
		return this.classToActionMap;
	}


}
