package com.spoc.common;

import lombok.Data;

/**
 * 统一返回结果类
 * @param <T> 数据内容的类型
 */
@Data
public class Result<T> {

    private Integer code; // 状态码：1-成功，0-失败
    private String msg;   // 提示信息
    private T data;       // 返回的数据

    // 私有构造方法，禁止外部直接 new
    private Result() {}

    // 1. 成功的方法 - 没有数据
    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.code = 1;
        result.msg = "操作成功";
        return result;
    }

    // 2. 成功的方法 - 带数据
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.code = 1;
        result.msg = "操作成功";
        result.data = data;
        return result;
    }

    // 3. 失败的方法 - 带错误信息
    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>();
        result.code = 0;
        result.msg = msg;
        return result;
    }
}