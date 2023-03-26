package com.librarymanagement.bdd.context;

import com.librarymanagement.bdd.modals.ResponseModal;
import lombok.Getter;
import lombok.Setter;

public final class ResponseModalContext {

    private static ResponseModal responseModalGlobal;

    public static ResponseModal getResponseModalGlobal() {
        return responseModalGlobal;
    }

    public static void setResponseModalGlobal(ResponseModal responseModalGlobal) {
        ResponseModalContext.responseModalGlobal = responseModalGlobal;
    }
}
