package com.librarymanagement.bdd.constants;

import com.librarymanagement.bdd.utils.JsonUtils;

public class EndPoints {
    private static JsonUtils jsonUtils = new JsonUtils(Constants.endPointDirectory.concat("EndPoints.json"));
    public static final String loginBasePath = jsonUtils.getStringValue("loginPath");
    public static final String loginEndPoint = jsonUtils.getStringValue("token");
    public static final String studentBasePath = jsonUtils.getStringValue("studentPath");
    public static final String getAllStudents = jsonUtils.getStringValue("getAllStudents");
}
