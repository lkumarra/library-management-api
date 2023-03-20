package com.librarymanagement.bdd;

public class HttpStatusCodes {
    public static Integer getHttpStatusCodeValue(StatusCodesEnum statusCodes){
        switch (statusCodes){
            case OK:
                return 200;
            case UNAUTHORIZED:
                return 401;
            case FORBIDDEN:
                return 403;
            case CREATED:
                return 201;
            case NOT_FOUND:
                return 404;
            case BAD_REQUEST:
                return 400;
            case ACCEPTED:
                return 202;
            case GATEWAY_TIME_OUT:
                return 502;
            case CONFLICT:
                return 409;
            case INTERNAL_SERVER_ERROR:
                return 500;
            default:
                return 0;
        }
    }
    public enum StatusCodesEnum {
        OK,
        UNAUTHORIZED,
        FORBIDDEN,
        INTERNAL_SERVER_ERROR,
        CONFLICT,
        ACCEPTED,
        CREATED,
        BAD_REQUEST,
        NOT_FOUND,
        GATEWAY_TIME_OUT;
    }
}

