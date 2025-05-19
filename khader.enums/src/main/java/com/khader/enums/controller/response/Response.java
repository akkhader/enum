package com.khader.enums.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Response<T> {

    /**
     * Error code, picked from docs
     */
    public String errorCode;
    /**
     * The business status
     */
    public ResponseStatus status;
    /**
     * The actual returned data
     */
    public T data;

    /**
     * Optional returned message
     */
    public String msg;
    /**
     * Optional returned list of errors (specially used for multiple errors in submitted records)
     */
    public List<ErrorMsg> errors;

    private String transactionId;


    public static class ResponseBuilder<T>{
        public ResponseBuilder<T> success(T data){
            this.status = ResponseStatus.SUCCESS;
            this.data = data;
            return this;
        }

        public ResponseBuilder<T> success(){
            this.status = ResponseStatus.SUCCESS;
            return this;
        }

        public ResponseBuilder<T> error(T data){
            this.status = ResponseStatus.ERROR;
            this.data = data;
            return this;
        }

        public ResponseBuilder<T> errorMsg(HttpStatus status){
            this.status = ResponseStatus.ERROR;
            this.errorCode = String.valueOf(status.value());
            this.msg = status.getReasonPhrase();
            return this;
        }
    }

}
