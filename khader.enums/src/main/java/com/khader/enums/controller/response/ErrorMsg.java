package com.khader.enums.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMsg {
    private Integer index;
    private String key;
    private String field;
    private String msg;

    public ErrorMsg(String key, String msg) {
        this.key = key;
        this.msg = msg;
    }

    public ErrorMsg(String key, String field, String msg) {
        this.key = key;
        this.field = field;
        this.msg = msg;
    }
}
