package com.nttdata.bootcamp.web.common.app.util;

import com.nttdata.bootcamp.web.common.app.dto.UserDemo;
import com.nttdata.bootcamp.web.common.app.exception.TechnicalException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class JsonMapperTest {

    @Test
    @DisplayName("Returns java value to json string")
    void convert_java_value_to_json_string() {
        // Expected
        String expected = "{\"id\":1,\"email\":\"lliragar@nttdata.com\"}";

        // Execution
        UserDemo userDemo = new UserDemo();
        userDemo.setId(1L);
        userDemo.setEmail("lliragar@nttdata.com");
        String actual = JsonMapper.convertValueToJson(userDemo);

        // Result
        assertAll(() -> assertNotNull(actual, "Value must not be null"),
            () -> assertEquals(expected, actual));
    }

    @Test
    @DisplayName("Throw exception when try convert java value to json string")
    void throw_exception_convert_java_value_to_json_string() {
        // Expected
        String expected = "No serializer found for class java.lang.Object and no properties discovered to create " +
            "BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)";

        // Execution
        Object value = new Object();
        TechnicalException exception = assertThrows(TechnicalException.class, () -> JsonMapper.convertValueToJson(value));
        String actual = exception.getMessage();

        // Result
        assertAll(() -> assertNotNull(exception, "Exception must not be null"),
            () -> assertEquals(expected, actual));
    }

    @Test
    @DisplayName("Throw exception when try print java value to json string")
    void throw_exception_print_java_value_to_json_string() {
        // Expected
        String expectedType = "Technical";
        Integer expectedCode = 1004;
        String expectedMessage = "No serializer found for class java.lang.Object and no properties discovered to create " +
            "BeanSerializer";

        // Execution
        Object value = new Object();
        TechnicalException exception = assertThrows(TechnicalException.class, () -> JsonMapper.printValueToJson(value));
        String actualMessage = exception.getMessage();
        String actualType = exception.getType();
        Integer actualCode = exception.getCode();

        // Result
        assertAll(
            () -> assertNotNull(exception, "Exception must not be null"),
            () -> assertTrue(actualMessage.contains(expectedMessage)),
            () -> assertFalse(expectedMessage.contains(actualMessage)),
            () -> assertEquals(expectedType, actualType),
            () -> assertEquals(expectedCode, actualCode)
        );
    }

    @Test
    @DisplayName("Throw exception if java value is null")
    void throw_exception_java_value_is_null() {
        // Expected
        String expected = "Java value object must not be null";

        // Execution
        Exception exception = assertThrows(IllegalArgumentException.class, () -> JsonMapper.printValueToJson(null));
        String actual = exception.getMessage();

        // Result
        assertAll(() -> assertNotNull(exception, "Exception must not be null"),
            () -> assertEquals(expected, actual, "The message error is not expected"));
    }
}
