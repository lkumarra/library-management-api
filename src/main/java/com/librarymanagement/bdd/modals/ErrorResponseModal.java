package com.librarymanagement.bdd.modals;

import lombok.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseModal implements Serializable {
    private static final long serialVersionUID = 1L;
    private String timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

}
