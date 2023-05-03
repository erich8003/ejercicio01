package cl.bci.ejercicio01.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@JsonTypeInfo(include= JsonTypeInfo.As.WRAPPER_OBJECT, use= JsonTypeInfo.Id.NAME)
public class Error {


    private Date timestamp;

    private HttpStatus codigo;
    private String detail;
    @JsonIgnore
    private List<String> errors;
    

    public Error(HttpStatus status, String message, List<String> errors, Date timestamp) {
        super();
        this.codigo = status;
        this.detail = message;
        this.errors = errors;
        this.timestamp = timestamp;
    }

    public Error(HttpStatus status, String message, String error, Date timestamp) {
        super();
        this.codigo = status;
        this.detail = message;
        errors = Arrays.asList(error);
        this.timestamp=timestamp;
    }

    public HttpStatus getCodigo() {
        return codigo;
    }

    public void setCodigo(HttpStatus codigo) {
        this.codigo = codigo;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

}
