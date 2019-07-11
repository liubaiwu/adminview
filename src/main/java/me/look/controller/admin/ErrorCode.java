package me.look.controller.admin;

/**
 * 错误码
 */
public enum ErrorCode {
    SUCCESS("success","成功"),
    FAIL("fail","失败"),
    ERROR("error","服务器异常"),
    UNKNOW_ERROR("unknow_error","未知错误");

    private String code;
    private String msg;

    ErrorCode(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
