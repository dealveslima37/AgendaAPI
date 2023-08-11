package com.blackcode.agenda_api.controllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class StandardError {

    private int status;
    private Instant timestamp;
    private String message;
    private String error;
    private String path;

}
