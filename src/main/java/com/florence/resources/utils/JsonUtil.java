package com.florence.resources.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Florence
 */
public class JsonUtil {

    private static final String JSON = "json";
    private static final String TEXT = "text";

    /**
     * json转换成对象
     *
     * @param jsonStr json字符串
     * @return Object 封装城的对象
     */
    public static <T> T jsonToObj(Class<T> clazz, String jsonStr) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonStr, clazz);
    }

    /**
     * 对象转换成json
     *
     * @param obj 转换的对象
     * @return json字符串
     */
    public static String objToJson(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
    }


    public static <T> T mapToObj(Map<String, Object> map, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(mapToJson(map), clazz);
    }

    /**
     * map转json
     *
     * @param map 要转换的map
     * @return 得到的jsonString
     * @throws JsonProcessingException json转化异常
     */
    public static String mapToJson(Map<String, Object> map) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
    }

    /**
     * json转Map
     *
     * @param json jsonString
     * @return 得到的Map
     * @throws IOException 转化异常
     */
    public static HashMap jsonToMap(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(json);
        return mapper.readValue(json, HashMap.class);
    }
}
