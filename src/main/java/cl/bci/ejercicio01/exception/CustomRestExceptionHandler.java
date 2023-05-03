package cl.bci.ejercicio01.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        List<String> errors = new ArrayList<String>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }

        Error apiError =
                new Error(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors, new Date());
        return handleExceptionInternal(
                ex, apiError, headers, apiError.getCodigo(), request);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        String error = ex.getParameterName() + " parameter is missing";

        Error apiError =
                new Error(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error, new Date());
        return new ResponseEntity<Object>(
                apiError, new HttpHeaders(), apiError.getCodigo());
    }

    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<Object> handleConstraintViolation(
            ConstraintViolationException ex, WebRequest request) {
        List<String> errors = new ArrayList<String>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.add(violation.getRootBeanClass().getName() + " " +
                    violation.getPropertyPath() + ": " + violation.getMessage());
        }

        Error apiError =
                new Error(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors, new Date());
        return new ResponseEntity<Object>(
                apiError, new HttpHeaders(), apiError.getCodigo());
    }

    @ExceptionHandler({ DuplicatedUserException.class })
    public ResponseEntity<Object> handleDuplicatedUser(
            DuplicatedUserException ex, WebRequest request) {
        List<String> errors = new ArrayList<String>();

        Error apiError =
                new Error(HttpStatus.CONFLICT, ex.getLocalizedMessage(), errors, new Date());
        return new ResponseEntity<Object>(
                apiError, new HttpHeaders(), apiError.getCodigo());
    }

    @ExceptionHandler({ MethodArgumentTypeMismatchException.class })
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
            MethodArgumentTypeMismatchException ex, WebRequest request) {
        String error =
                ex.getName() + " should be of type " + ex.getRequiredType().getName();

        Error apiError =
                new Error(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error, new Date());
        return new ResponseEntity<Object>(
                apiError, new HttpHeaders(), apiError.getCodigo());
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        StringBuilder builder = new StringBuilder();
        builder.append(ex.getMethod());
        builder.append(
                " method is not supported for this request. Supported methods are ");
        ex.getSupportedHttpMethods().forEach(t -> builder.append(t + " "));

        Error apiError = new Error(HttpStatus.METHOD_NOT_ALLOWED,
                ex.getLocalizedMessage(), builder.toString(), new Date());
        return new ResponseEntity<Object>(
                apiError, new HttpHeaders(), apiError.getCodigo());
    }


    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
        Error apiError = new Error(
                HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), "error occurred", new Date());
        return new ResponseEntity<Object>(
                apiError, new HttpHeaders(), apiError.getCodigo());
    }
}
