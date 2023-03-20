package com.librarymanagement.bdd.utils;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import java.io.FileReader;


@Slf4j
public class JsonUtils {

    private String filePath;

    public JsonUtils(String jsonFilePath) {
        this.filePath = jsonFilePath;
    }

    public JsonUtils(){}

    private JSONObject getJsonObject(){
        try {
            FileReader fileReader = new FileReader(filePath);
            JSONTokener token = new JSONTokener(fileReader);
            JSONObject jsonObject = new JSONObject(token);
            return jsonObject;
        }catch (Exception e){
            log.error("Error occurred with error message : {}", e.getMessage());
        }
        return null;
    }

    private JSONObject getJsonObject(String json){
        try {
            JSONTokener token = new JSONTokener(json);
            JSONObject jsonObject = new JSONObject(token);
            return jsonObject;
        }catch (Exception e){
            log.error("Error occurred with error message : {}", e.getMessage());
        }
        return null;
    }

    private void logError(String key, String message){
        log.error("Error occurred while getting the value of key : {} with error message : {}", key, message);
    }
    public String getStringValue(String key) {
        try {
            Assert.assertNotNull(key, "Key can not be null");
            return getJsonObject().getString(key);
        } catch (Exception e) {
           logError(key, e.getMessage());
        }
        return "";
    }

    public String getStringValue(String json, String key){
        try {
            Assert.assertNotNull(json, "JSON can not be null or empty");
            Assert.assertNotNull(key, "Key can not be null or empty");
            return getJsonObject(json).getString(key);
        }catch (Exception e){
            logError(key, e.getMessage());
        }
        return null;
    }

    public int getIntegerValue(String key) {
        try {
            Assert.assertNotNull(key, "Key can not be null or empty");
            return getJsonObject().getInt(key);
        } catch (Exception e) {
            logError(key, e.getMessage());
        }
        return 0;
    }

    public int getIntegerValue(String json, String key) {
        try {
            Assert.assertNotNull(json, "JSON can not be null or empty");
            Assert.assertNotNull(key, "Key can not be null or empty");
            return getJsonObject(json).getInt(key);
        } catch (Exception e) {
            logError(key, e.getMessage());
        }
        return 0;
    }

    public boolean getBooleanValue(String key) {
        try {
            Assert.assertNotNull(key, "Key can not be null or empty");
            return getJsonObject().getBoolean(key);
        } catch (Exception e) {
            logError(key, e.getMessage());
        }
        return false;
    }
    public boolean getBooleanValue(String json, String key) {
        try {
            Assert.assertNotNull(json, "JSON can not be null or empty");
            Assert.assertNotNull(key, "Key can not be null or empty");
            return getJsonObject(json).getBoolean(key);
        } catch (Exception e) {
            logError(key, e.getMessage());
        }
        return false;
    }
    public double getDoubleValue(String key) {
        try {
            Assert.assertNotNull(key, "Key can not be null or empty");
            return getJsonObject().getDouble(key);
        } catch (Exception e) {
            logError(key, e.getMessage());
        }
        return 0.0;
    }

    public double getDoubleValue(String json, String key) {
        try {
            Assert.assertNotNull(key, "Key can not be null or empty");
            return getJsonObject(json).getDouble(key);
        } catch (Exception e) {
            logError(key, e.getMessage());
        }
        return 0.0;
    }
    public float getFloatValue(String key) {
        try {
            Assert.assertNotNull(key, "Key can not be null or empty");
            return getJsonObject().getFloat(key);
        } catch (Exception e) {
            logError(key, e.getMessage());
        }
        return 0.0f;
    }
    public float getFloatValue(String json, String key) {
        try {
            Assert.assertNotNull(json, "JSON can not be null or empty");
            Assert.assertNotNull(key, "Key can not be null or empty");
            return getJsonObject(json).getFloat(key);
        } catch (Exception e) {
            logError(key, e.getMessage());
        }
        return 0.0f;
    }
    public long getLongValue(String key) {
        try {
            Assert.assertNotNull(key, "Key can not be null or empty");
            return getJsonObject().getLong(key);
        } catch (Exception e) {
            logError(key, e.getMessage());
        }
        return 0l;
    }

    public long getLongValue(String json,String key) {
        try {
            Assert.assertNotNull(json, "JSON can not be null or empty");
            Assert.assertNotNull(key, "Key can not be null or empty");
            return getJsonObject(json).getLong(key);
        } catch (Exception e) {
            logError(key, e.getMessage());
        }
        return 0l;
    }

    public JSONObject getJSONObject(String key) {
        try {
            Assert.assertNotNull(key, "Key can not be null or empty");
            return getJsonObject();
        } catch (Exception e) {
            logError(key, e.getMessage());
        }
        return new JSONObject();
    }

    public JSONObject getJSONObject(String json,String key) {
        try {
            Assert.assertNotNull(json, "JSON can not be null or empty");
            Assert.assertNotNull(key, "Key can not be null or empty");
            return getJsonObject(json).getJSONObject(key);
        } catch (Exception e) {
            logError(key, e.getMessage());
        }
        return new JSONObject();
    }

    public JSONArray getJSONArray(String key) {
        try {
            Assert.assertNotNull(key, "Key can not be null or empty");
            return getJsonObject().getJSONArray(key);
        } catch (Exception e) {
            logError(key, e.getMessage());
        }
        return new JSONArray();
    }

    public JSONArray getJSONArray(String json, String key) {
        try {
            Assert.assertNotNull(json, "JSON can not be null or empty");
            Assert.assertNotNull(key, "Key can not be null or empty");
            return getJsonObject(json).getJSONArray(key);
        } catch (Exception e) {
            logError(key, e.getMessage());
        }
        return new JSONArray();
    }
}
