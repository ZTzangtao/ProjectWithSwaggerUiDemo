package com.bbd.common.base;


/**
 * @author zangtao
 */

public enum ErrorCode {
    /**
     * 错误码
     */
    AUTH_ERROR("鉴权失败", 1001),
    APP_NOT_FOUND("应用不存在", 1006),
    REQUEST_PARAM_MISSING("请求参数缺失", 1008),
    REQUEST_TIME_LIMIT("请求时间超时", 1009),
    RANDOM_PARAM_ERROR("random参数异常", 1012),
    REQUEST_ERROR("请求异常，请稍后再试", 1002),
    NO_TYPE_INFO("资讯类型id错误",1014),
    NO_INFO("id错误，查询不到信息",1015);


    /**1008
     * 错误码
     */
    private int code;
    /**
     * 错误
     */
    private String errorName;

    ErrorCode(String errorName, int code) {
        this.code = code;
        this.errorName = errorName;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }
}
