package com.fine.distribution.utlis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {
	/**
	 * 对象转换为json字符串
	 */
	public static String ObjectToJsonStr(Object obj) {
		if (obj == null)
			return null;
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return gson.toJson(obj).toString();
	}

	/**
	 * 集合转换为json字符串
	 */
	public static <T> String ListToJsonStr(List<T> c) {
		if (c == null)
			return null;
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		Type type = new TypeToken<List<T>>() {
		}.getType();
		return gson.toJson(c, type).toString();
	}

	/**
	 * json字符串转换为对象
	 */
	public static <T> T JsonToObject(Object object, Class<T> clazz) {
		if (object == null)
			return null;
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return gson.fromJson(object.toString(), clazz);
	}

	/**
	 * json字符串转换为对象
	 */
	public static <T> T JsonToObject(String object, Class<T> clazz) {
		if (object == null || object.length() < 1)
			return null;
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return gson.fromJson(object.toString(), clazz);
	}

	/**
	 * json字符串转换为对象集合
	 */
	public static <T> List<T> JsonToObjectList(String jsonStr, Class<T> clazz) {
		if (jsonStr == null || jsonStr.length() < 1)
			return null;
		List<T> list = new ArrayList<T>();

		JsonArray jsonArray = new JsonParser().parse(jsonStr).getAsJsonArray();

		for (int i = 0; i < jsonArray.size(); i++) {
			list.add(JsonToObject(jsonArray.get(i), clazz));
		}
		return list;
	}

	/**
	 * json字符串转换为对象集合
	 */
	public static List<String> JsonToStringList(String jsonStr) {
		if (jsonStr == null || jsonStr.length() < 1)
			return null;
		List<String> list = new ArrayList<String>();

		JsonArray jsonArray = new JsonParser().parse(jsonStr).getAsJsonArray();
		for (int i = 0; i < jsonArray.size(); i++) {
			list.add(jsonArray.get(i).toString());
		}
		return list;
	}
}