package com.librarymanagement.bdd.modals;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenerateTokenModal {
    private String accessToken;
    private Long expiredIn;
    private Long refreshExpiresIn;
    private String tokenType;
}
