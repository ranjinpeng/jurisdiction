package com.fine.distribution.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yangrd on 2017/7/7.
 */
public class ResultGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResultGenerator.class);

    private static final String SUCCESS_MSG = "操作成功";

    private static final String ERROR_MSG = "操作失败";

    public static final Result<String> OK = new Result<>();

    public static final Result<String> ERROR = new Result<>();


    static {
        ERROR.setMsg(ERROR_MSG).setStatus(Result.Status.ERROR);
        OK.setMsg(SUCCESS_MSG);
    }

    public static <T> Result<T> genResult(Result.Status status, T content, String msg) {
        Result<T> result = Result.newInstance().setStatus(status).setContent(content).setMsg(msg);
        LOGGER.debug("generate rest result:{}", result);
        return result;
    }

    public static Result<String> ok() {
        return OK;
    }

    public static <T> Result<T> ok(T content) {
        return ok(SUCCESS_MSG, content);
    }

    public static <T> Result<T> ok(String msg, T content) {
        return genResult(Result.Status.SUCCESS, content, msg);
    }

    public static Result<String> error() {
        return ERROR;
    }

    public static <T> Result<T> error(String msg) {
        return genResult(Result.Status.ERROR, null, msg);
    }
}
