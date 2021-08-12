package com.matthew.seckillstage.common;

import lombok.Data;

@Data
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }

    public static <T> Result<T> error(CodeMessage codeMessage) {
        return new Result<T>(codeMessage);
    }

    private Result(T data) {
        this.data = data;
    }

    private Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Result(CodeMessage codeMessage) {
        if (codeMessage != null) {
            this.code = codeMessage.getCode();
            this.msg = codeMessage.getMsg();
        }
    }
}
