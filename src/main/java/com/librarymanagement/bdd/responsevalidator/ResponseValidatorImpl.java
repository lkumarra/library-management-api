package com.librarymanagement.bdd.responsevalidator;

import com.librarymanagement.bdd.context.ResponseModalContext;
import com.librarymanagement.bdd.modals.ErrorResponseModal;
import com.librarymanagement.bdd.modals.ResponseModal;
import com.librarymanagement.bdd.utils.RestAssuredUtils;
import org.jetbrains.annotations.NotNull;
import org.testng.Assert;

import java.util.Objects;

public final class ResponseValidatorImpl implements ResponseValidator{

    @Override
    public void verifyResponse(@NotNull ErrorResponseModal errorResponseModal) {
        ResponseModal responseModalActual = ResponseModalContext.getResponseModalGlobal();
        Assert.assertEquals(errorResponseModal.getStatus(), responseModalActual.getStatusCode());
        if(Objects.nonNull(errorResponseModal.getError()) && Objects.nonNull(errorResponseModal.getMessage())){
            ErrorResponseModal errorResponseModalActual = new RestAssuredUtils().mapResponseToClass(responseModalActual.getResponse(), ErrorResponseModal.class);
            Assert.assertEquals(errorResponseModalActual.getMessage(), errorResponseModal.getMessage());
            Assert.assertEquals(errorResponseModalActual.getError(), errorResponseModal.getError());
        }
    }
}
