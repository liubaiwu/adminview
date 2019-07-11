package me.look.controller.admin;

/**统一返回结果*/
public class Result<T> {
    /**
     * 错误码，对应{@link ErrorCode}，表示一种错误类型
     * 如果是成功，则code为200
     */
    private String code;
    /**
     * 对错误的具体解释
     */
    private String message;
    /**
     * 返回的结果包装在data中，data可以是单个对象
     */
    private T data;


    public Result(String code,String message,T data)
    {
        this.code=code;
        this.message=message;
        this.data=data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
}
