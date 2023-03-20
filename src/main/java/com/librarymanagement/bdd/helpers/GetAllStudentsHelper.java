package com.librarymanagement.bdd.helpers;

import com.google.common.collect.Lists;
import com.librarymanagement.bdd.config.Configuration;
import com.librarymanagement.bdd.modals.GetAllStudentsModal;
import com.librarymanagement.bdd.utils.DBUtils;
import java.util.List;
import java.util.Map;

public class GetAllStudentsHelper {

    private static DBUtils dbUtils = new DBUtils(Configuration.getJdbcUrl(), Configuration.getUserName(), Configuration.getPassword());

    public static List<GetAllStudentsModal> getAllStudentsModalList(){
        List<GetAllStudentsModal> getAllStudentsModalList = Lists.newArrayList();
        List<Map<String, Object>> results = dbUtils.selectQueryResult("select * from students");
        results.forEach(student->{
            GetAllStudentsModal getAllStudentsModal = GetAllStudentsModal.builder().id((Long)student.get("id"))
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
}
