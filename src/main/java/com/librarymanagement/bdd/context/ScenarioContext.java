package com.librarymanagement.bdd.context;

import com.google.common.collect.Maps;

import java.util.HashMap;

public final class ScenarioContext<T> {

    private static final HashMap<Class<?>, Object> hashMap = Maps.newHashMap();

    public void setContext(Class<T> clazz, Object object){
        hashMap.put(clazz,object);
    }

    @SuppressWarnings("unchecked")
    public <T> T getContext(Class<T> clazz){
        return (T) hashMap.get(clazz);
    }

}
