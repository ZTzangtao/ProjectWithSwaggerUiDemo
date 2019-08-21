package com.bbd.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * JSON工具类，默认是用Jackson
 * <p>
 *
 * @author 臧涛
 */
@Slf4j
public class JsonTools {
    /**
     * 同名(属性名)序列化
     */
    private static final ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = SpringUtils.getBean(ObjectMapper.class);
    }

    /**
     * 序列化
     *
     * @param data
     * @return
     */
    public static String serialize(Object data) {
        try {
            return OBJECT_MAPPER.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            log.error("serialize failure", e.getMessage());
        }

        return null;
    }

    /**
     * 序列化
     *
     * @param data
     * @return
     */
    public static byte[] writeValueAsBytes(Object data) {
        try {
            return OBJECT_MAPPER.writeValueAsBytes(data);
        } catch (JsonProcessingException e) {
            log.error("serialize failure", e.getMessage());
        }

        return null;
    }

    /**
     * 反序列化
     *
     * @param dataString
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T deserialize(String dataString, TypeReference type) {
        try {
            return OBJECT_MAPPER.readValue(dataString, type);
        } catch (IOException e) {
            log.error("deserialize failure", e.getMessage());
        }

        return null;
    }

    /**
     * 反序列化
     *
     * @param dataString
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T deserialize(String dataString, Class<T> type) {
        try {
            return OBJECT_MAPPER.readValue(dataString, type);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("deserialize failure", e.getMessage());
        }

        return null;
    }

    /**
     * 反序列化
     *
     * @param dataByte
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T deserialize(byte[] dataByte, Class<T> type) {
        try {
            return OBJECT_MAPPER.readValue(dataByte, type);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("deserialize failure", e.getMessage());
        }

        return null;
    }

    /**
     * 转换数据类型
     *
     * @param data
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T convert(Object data, Class<T> type) {
        return JsonTools.deserialize(JsonTools.serialize(data), type);
    }

    /**
     * 转换数据类型
     *
     * @param data
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T convert(Object data, TypeReference type) {
        return JsonTools.deserialize(JsonTools.serialize(data), type);
    }

    /**
     * 转换数据类型，针对多层嵌套
     *
     * @param ob
     * @param cla
     * @param <T>
     * @return
     */
    public static <T> T convertValue(Object ob, Class<T> cla) {
        return OBJECT_MAPPER.convertValue(ob, cla);
    }

    /**
     * 转json 字符串
     *
     * @param object
     * @return
     */
    public static String objectToJsonStr(Object object) {
        if (null == object) {
            return null;
        }
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
