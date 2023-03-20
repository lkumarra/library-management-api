package com.librarymanagement.bdd.context;

import com.librarymanagement.bdd.modals.ResponseModal;

public class ResponseModalContext {

    private static ResponseModal responseModalGlobal;

    public static void setResponseModal(ResponseModal responseModal) {
        responseModalGlobal = responseModal;
    }

    public static ResponseModal getResponseModal() {
        return responseModalGlobal;
    }
}
