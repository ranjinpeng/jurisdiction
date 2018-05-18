package com.fine.distribution.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class JsonBackEntityT<T> {

	@ApiModelProperty(value = "请求是否成功:0成功,1其他为失败")
	private Integer code;
	@ApiModelProperty(value = "返回参数")
	private T result;





	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
}
