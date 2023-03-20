package com.librarymanagement.bdd.modals;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenerateTokenModal {
    private String accessToken;
    private long expiredIn;
    private long refreshExpiresIn;
    private String tokenType;
}
