package com.users.api.util;

import com.fasterxml.jackson.annotation.JsonRawValue;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
    private boolean status;
    private String message;
    @JsonRawValue
    private String data;
}
