package com.librarymanagement.bdd.context;

public final class TokenContext {
    private static String tokenGlobal;

    public static String getToken() {
        return tokenGlobal;
    }

    public static void setToken(String token) {
        tokenGlobal = token;
    }
}
