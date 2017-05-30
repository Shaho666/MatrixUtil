package com.example.matrixui.uiframe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class HashMapItem {

	private static Map<String, String> items = null;

	public static Map<String, String> getItems() throws Exception {

		items = new HashMap<String, String>();
		Properties properties = PropertiesInterface.getAllItems();

		Iterator<Entry<Object, Object>> iterator = properties.entrySet().iterator();

		while (iterator.hasNext()) {

			Entry<Object, Object> entry = iterator.next();
			items.put((String) entry.getKey(), (String) entry.getValue());

		}

		return items;
	}
	
}
