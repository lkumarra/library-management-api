package com.librarymanagement.bdd.utils;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Objects;

@Slf4j
public final class StringReader {

    private String filePath;

    public StringReader(String filePath) {
        this.filePath = filePath;
    }

    public StringReader(){

    }

    @NotNull
    public String getFileData(){
        StringBuilder stringBuffer = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(this.filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while (Objects.nonNull(line = bufferedReader.readLine())){
                stringBuffer.append(line);
                stringBuffer.append("\n");
            }
        }catch (Exception e){
            log.error("Error occurred while reading the data from file located at : {} with error message : {}", filePath, e.getMessage());
        }
        return stringBuffer.toString();
    }

    @NotNull
    public String getFileData(String filePath){
        StringBuilder stringBuffer = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while (Objects.nonNull(line = bufferedReader.readLine())){
                stringBuffer.append(line);
                stringBuffer.append("\n");
            }
        }catch (Exception e){
            log.error("Error occurred while reading the data from file located at : {} with error message : {}", filePath, e.getMessage());
        }
        return stringBuffer.toString();
    }

}
