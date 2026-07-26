package com.alfajorxd.web.common.exeptions;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ErrorMessage {

    private String name;
    private String exception;
    private String path;
    private Map<String, String> errors;

    public ErrorMessage(String name, String exception, String path) {
        this.name = name;
        this.exception = exception;
        this.path = path;
        this.errors = new HashMap<>();
    }

    public ErrorMessage(String name, String exception, String path, Map<String, String> errors) {
        this.name = name;
        this.exception = exception;
        this.path = path;
        this.errors = errors;
    }
}
