package com.example.myblog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Result<T> {
    private Integer code;    // 业务状态码 0-成功 1-失败
    private String message;  // 提示信息
    private T data;          // 响应数据

    // 默认构造函数
    public Result() {}

    // 全参构造函数
    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // Getter 和 Setter 方法
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    // 快速返回操作成功响应结果（带响应数据）
    public static <E> Result<E> success(E data) {
        return new Result<>(0, "操作成功", data);
    }

    // 快速返回操作成功响应结果（没有数据）
    public static Result success() {
        return new Result(0, "操作成功", null);
    }

    // 返回失败响应结果
    public static Result error(String message) {
        return new Result(1, message, null);
    }

    // toString 方法，用于调试时打印对象的字符串表示
    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    // equals 方法，用于比较两个 Result 对象是否相等
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Result<?> result = (Result<?>) obj;
        return code.equals(result.code) && message.equals(result.message) && data.equals(result.data);
    }

    // hashCode 方法，用于生成对象的哈希值
    @Override
    public int hashCode() {
        int result = code.hashCode();
        result = 31 * result + message.hashCode();
        result = 31 * result + data.hashCode();
        return result;
    }
}
