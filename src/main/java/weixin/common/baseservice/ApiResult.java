package weixin.common.baseservice;

import java.io.Serializable;
import java.util.Optional;

/**
 * @author chenx 2018-10-12 15:24
 */
public class ApiResult<T> implements Serializable {
    private String code = "0000";
    private String message;
    private String description;
    private T data;
    public ApiResult(T t) {
        this.data = t;
    }

    public ApiResult() {

    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
