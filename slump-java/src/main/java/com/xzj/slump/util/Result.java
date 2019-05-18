package com.xzj.slump.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result<T> {
    public enum Code {
        // 服务器成功返回数据
        OK(200),
        // 新建或修改成功
        CREATED(201),
        // 请求已经进入后台排队
        ACCEPTED(202),
        // 删除数据成功
        DELETE(204),
        // 用户没有权限
        ERROR(-1),
        OK_EMPTY(101),
        OK_EXIST(102),
        ILLEGAL_PARAMETER(100);
        private int code;

        Code(int code) {
            this.code = code;
        }

        public int getCode() {
            return this.code;
        }
    }

    private T data;
    private String message;
    private int code;

    public Result(T data, String message, Code code) {
        this.setData(data);
        this.setMessage(message);
        this.setCode(code.getCode());
    }

    public Result(String message,Code code){
        this.setMessage(message);
        this.setCode(code.getCode());
    }

    public static <T> Result<T> ok(T data) {
        return new Result(data, "ok", Code.OK);
    }

    public static <T> Result<T> okEmpty(T data) {
        return new Result(data, "ok", Code.OK_EMPTY);
    }

    public static <T> Result<T> error(T data, String errorMessage) {
        return new Result(data, errorMessage, Code.ERROR);
    }

    @Override
    public String toString() {
        return "Result{" +
                "data=" + data +
                ", message='" + message + '\'' +
                ", code=" + code +
                '}';
    }
}
