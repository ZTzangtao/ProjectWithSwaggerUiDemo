package com.bbd.common.base;

/**
 * @author zangtao
 */
public class Response {
    private int resultCode;
    String message;
    Object details;

    public Response() {}

    public Response(int resultCode, String message, Object details) {
        this.resultCode = resultCode;
        this.message = message;
        this.details = details;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getDetails() {
        return details;
    }

    public void setDetails(Object details) {
        this.details = details;
    }

    public static Response success(Object details) {
        return new Response(200, "", details);
    }

    public static Response successMessage(String message) {
        return new Response(200, message, "");
    }

    public static Response success() {
        return new Response(200, "", "");
    }

    public static Response error( String message) {
        return new Response(0, message, "");
    }

    public static Response error(Integer resultCode, String message) {
        return new Response(resultCode, message, "");
    }
}
