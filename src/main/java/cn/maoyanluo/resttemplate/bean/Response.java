package cn.maoyanluo.resttemplate.bean;

public class Response<T> {

    private Integer code;
    private String message;
    private T data;

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

    public static <T> Response<T> success(T data) {
        Response<T> resp = new Response<>();
        resp.setCode(200);
        resp.setMessage("success");
        resp.setData(data);
        return resp;
    }

    public static <T> Response<T> failed(String message) {
        Response<T> resp = new Response<>();
        resp.setCode(-1);
        resp.setMessage(message);
        return resp;
    }

}
