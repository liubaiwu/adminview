package me.look.controller.admin;

public class ResultTable<T> {
    /**
     * 错误码，对应{@link ErrorCode}，表示一种错误类型
     * 如果是成功，则code为200
     */
    private String code;
    /**
     * 对错误的具体解释
     */
    private String msg;
    /**
     * 总数量
     */
    private int count;
    /**
     * 返回的结果包装在data中，data可以是单个对象
     */
    private T data;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
