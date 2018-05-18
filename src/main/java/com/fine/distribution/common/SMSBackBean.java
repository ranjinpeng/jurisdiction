package com.fine.distribution.common;

import java.io.Serializable;

public class SMSBackBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer code;
	private String msg;
	private String detail;
	private SMSResult result;

	public Integer getCode() {
		return code;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public SMSResult getResult() {
		return result;
	}

	public void setResult(SMSResult result) {
		this.result = result;
	}

	public class SMSResult {
		private Integer count;
		private Integer fee;
		private Double sid;

		public Integer getCount() {
			return count;
		}

		public void setCount(Integer count) {
			this.count = count;
		}

		public Integer getFee() {
			return fee;
		}

		public void setFee(Integer fee) {
			this.fee = fee;
		}

		public Double getSid() {
			return sid;
		}

		public void setSid(Double sid) {
			this.sid = sid;
		}
	}
}
