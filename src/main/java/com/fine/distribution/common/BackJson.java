package com.fine.distribution.common;


import com.fine.distribution.utlis.JsonUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


public class BackJson {

	/**
	 * 请求成功
	 * 
	 * @param body
	 * @return
	 */
	public static ResponseEntity<Object> handleSuccess(Object body) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType(Constants.JSON_UTF_8));
		headers.add("Accept-Charset", "UTF-8");
		return new ResponseEntity<Object>(success(body), headers, HttpStatus.OK);
	}

	/**
	 * 请求成功
	 * 
	 * @param body
	 * @return
	 */
	public static ResponseEntity<Object> handleSuccess() {
		return handleSuccess(null);
	}

	/**
	 * 请求失败
	 * 
	 * @param body
	 * @return
	 */
	public static ResponseEntity<Object> handleError(int errorCode) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType(Constants.JSON_UTF_8));
		headers.add("Accept-Charset", "UTF-8");
		return new ResponseEntity<Object>(error(errorCode), headers, HttpStatus.OK);
	}

	/**
	 * 请求成功json处理
	 * 
	 * @param body
	 * @return
	 */
	public static String success(Object body) {
		JsonBackEntity backEntity = new JsonBackEntity();
		backEntity.setCode(Constants.REQUEST_SUCCESS);
		backEntity.setResult(body);
		return JsonUtil.ObjectToJsonStr(backEntity);
	}

	/**
	 * 请求成功json处理
	 * 
	 * @param body
	 * @return
	 */
	public static <T> JsonBackEntityT<T> successObj(T body) {
		JsonBackEntityT<T> backEntity = new JsonBackEntityT<T>();
		backEntity.setCode(Constants.REQUEST_SUCCESS);
		backEntity.setResult(body);
		return backEntity;
	}
	
	/*
	 * 自定义请求失败
	 */
	public static <T> JsonBackEntityT<T> terrorobj() {
		JsonBackEntityT<T> backEntity = new JsonBackEntityT<T>();
		backEntity.setCode(1);
		backEntity.setResult(null);
		return backEntity;
	}

	/*
	 * 自定义泛型请求失败
	 */
	public static JsonBackEntityT terrorobjT() {
		JsonBackEntityT backEntity = new JsonBackEntityT();
		backEntity.setCode(1);
		backEntity.setResult("");
		return backEntity;
	}

	/**
	 * 请求成功json处理
	 * 
	 * @param body
	 * @return
	 */
	public static JsonBackEntity successObj() {
		JsonBackEntity backEntity = new JsonBackEntity();
		backEntity.setCode(Constants.REQUEST_SUCCESS);
		return backEntity;
	}

	/**
	 * 请求失败json处理
	 * 
	 * @param body
	 * @return
	 */
	public static JsonBackEntity errorObj(int errorId, Object result) {
		JsonBackEntity backEntity = new JsonBackEntity();
		backEntity.setCode(errorId);
		backEntity.setResult(result);
		return backEntity;
	}
	/**
	 * 请求失败jsonT处理
	 *
	 * @param body
	 * @return
	 */
	public static JsonBackEntityT errorObjT(int errorId, Object result) {
		JsonBackEntityT backEntity = new JsonBackEntityT();
		backEntity.setCode(errorId);
		backEntity.setResult(result);
		return backEntity;
	}

	/**
	 * 请求失败json处理
	 * 
	 * @param body
	 * @return
	 */
	public static String error(int errorCode) {
		JsonBackEntity backEntity = new JsonBackEntity();
		backEntity.setCode(errorCode);
		return JsonUtil.ObjectToJsonStr(backEntity);
	}
	
	
	
}
