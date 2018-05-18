package com.fine.distribution.common;

/**
 * Created by yangrd on 2017/7/7.
 */

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by sunxyz on 2017/3/14.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> {

    @Enumerated(EnumType.STRING)
    private Status status;//状态：=> SUCCESS or ERROR

    private String msg;//提示信息

    private T content;//SUCCESS状态返回内容部分

    {
        status = Status.SUCCESS;
    }

    public static <T> Result<T> newInstance() {
        return new Result<>();
    }

    public Result<T> orGetErrorMsg(String message) {
        return this.status.equals(Status.ERROR) ? ResultGenerator.error(message) : this;
    }

    public Result<T> orGetSuccessMsg(String message) {
        return this.status.equals(Status.SUCCESS) ? ResultGenerator.ok(message, this.getContent()) : this;
    }

    public Status getStatus() {
        return status;
    }

    public Result setStatus(Status status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Result setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getContent() {
        return content;
    }

    public Result setContent(T content) {
        this.content = content;
        return this;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", content=" + content +
                '}';
    }

    enum Status {
        SUCCESS, ERROR
    }


}
