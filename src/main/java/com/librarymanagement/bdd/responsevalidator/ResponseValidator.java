package com.librarymanagement.bdd.responsevalidator;

import com.librarymanagement.bdd.modals.ErrorResponseModal;
import com.librarymanagement.bdd.modals.ResponseModal;

public interface ResponseValidator {

    public void verifyResponse(ErrorResponseModal responseModalExpected);
}
