package com.khader.enums.controller.response;

public enum ResponseStatus {
    SUCCESS("success"), ERROR("error"), IMPORT_ERROR("import_error");

    private final String value;
    ResponseStatus(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
