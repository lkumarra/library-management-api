package com.librarymanagement.bdd.helpers;

import com.google.common.collect.Lists;

import static com.librarymanagement.bdd.config.Configuration.*;

import com.librarymanagement.bdd.constants.Constants;
import com.librarymanagement.bdd.modals.GetAllStudentsModal;
import com.librarymanagement.bdd.utils.DBUtils;
import com.librarymanagement.bdd.utils.StringReader;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public final class GetAllStudentsHelper {

    private static final DBUtils dbUtils = new DBUtils(getJdbcUrl(), getUserName(), getPassword());

    public static List<GetAllStudentsModal> getAllStudentsModalList() {
        StringReader stringReader = new StringReader();
        List<GetAllStudentsModal> getAllStudentsModalList = Lists.newArrayList();
        List<Map<String, Object>> results = dbUtils.selectQueryResult(stringReader.getFileData(Constants.scriptDirectory.concat("GetAllStudents.sql")));
        results.forEach(student -> {
            GetAllStudentsModal getAllStudentsModal = GetAllStudentsModal.builder().id((Long) student.get("id"))
                    .studentName((String) student.get("student_name"))
                    .createdAt((Long) student.get("created_at"))
                    .updatedAt((Long) student.get("updated_at"))
                    .department((String) student.get("department"))
                    .status((Boolean) student.get("status"))
                    .rollNo((Long) student.get("roll_no")).build();
            getAllStudentsModalList.add(getAllStudentsModal);
        });
        return getAllStudentsModalList;
    }

    public static void insertStudentData() {
        StringReader stringReader = new StringReader(Constants.scriptDirectory.concat("AddStudents.sql"));
        String script = stringReader.getFileData();
        int rowsImpacted = dbUtils.insertQuery(script);
        log.info("Rows impacted with insert query : {} are : {}", script, rowsImpacted);
    }

    public static void deleteStudent() {
        StringReader stringReader = new StringReader(Constants.scriptDirectory.concat("DeleteStudents.sql"));
        String script = stringReader.getFileData();
        int rowsImpacted = dbUtils.deleteQuery(script);
        log.info("Rows impacted with delete query : {} are : {}", script, rowsImpacted);
    }

}
