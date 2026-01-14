package com.example.taskmaster.common;

import lombok.Data;

/**
 * Standard API Response Wrapper.
 * @param <T> The type of the actual data.
 */
@Data
public class Result<T> {
    private Integer code;    // 200 for success, others for error
    private String message;
    private T data;

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("success");
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error(String message) {
        Result<T> result = new Result<>();
        result.setCode(500); // General error code
        result.setMessage(message);
        result.setData(null);
        return result;
    }
}
