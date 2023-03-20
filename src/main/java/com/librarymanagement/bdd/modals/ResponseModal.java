package com.librarymanagement.bdd.modals;

import io.restassured.http.Headers;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseModal implements Serializable {
    private static final long serialVersionUID = 1L;

    private String response;

    private Integer statusCode;

    private Headers headers;

    private long responseTime;

}
