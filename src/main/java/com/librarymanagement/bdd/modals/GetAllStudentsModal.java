package com.librarymanagement.bdd.modals;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class GetAllStudentsModal  implements Serializable {

	private static final long serialVersionUID = 1L;

	public Long id;

    private String studentName;

    private Long rollNo;

    private String department;

    private Boolean status;

    private Long createdAt;

    private Long updatedAt;
}
