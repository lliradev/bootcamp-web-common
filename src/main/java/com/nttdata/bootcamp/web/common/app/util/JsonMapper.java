package com.nttdata.bootcamp.web.common.app.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.bootcamp.web.common.app.exception.TechnicalException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

@UtilityClass
@Slf4j
public class JsonMapper {

    /**
     * Method that can be used to serialize and print any Java value as a Json string
     *
     * @param value Java object
     */
    public void printValueToJson(Object value) {
        Assert.notNull(value, "Java value object must not be null");

        ObjectMapper mapper = new ObjectMapper();
        try {
            log.info("Value object to string: {}", mapper.writeValueAsString(value));
        } catch (JsonProcessingException e) {
            throw new TechnicalException(e.getMessage());
        }
    }

    /**
     * Method that can be used to serialize any Java value as a Json string
     *
     * @param value Java object
     * @return value to json
     */
    public String convertValueToJson(Object value) {
        Assert.notNull(value, "Java value object must not be null");

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new TechnicalException(e.getMessage());
        }
    }
}
