package tw.core;

import org.junit.jupiter.api.Test;
import tw.validator.InputValidator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {
    @Test
    void validate(){
        InputValidator input = new InputValidator();
        assertTrue(input.validate("1 2 3 4"));
        assertFalse(input.validate("12 3 4"));
        assertFalse(input.validate("1 23 4"));
        assertFalse(input.validate("1 2"));
        assertFalse(input.validate("1 2 3 40"));
    }
}
