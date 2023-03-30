package com.librarymanagement.bdd.modals;

import lombok.Data;

@Data
public class GenerateTokenModal {
    private String accessToken;
    private Long expiredIn;
    private Long refreshExpiresIn;
    private String tokenType;
}
