package tw.core;


import org.junit.jupiter.api.Test;
import tw.core.generator.RandomIntGenerator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {
    @Test
    void generateNums(){
        RandomIntGenerator randomint = new RandomIntGenerator();
        assertTrue(randomint.generateNums(9,4).matches("[0-9] [0-9] [0-9] [0-9]"));
        assertTrue(randomint.generateNums(5,4).matches("[0-5] [0-5] [0-5] [0-5]"));
        assertTrue(randomint.generateNums(6,3).matches("[0-6] [0-6] [0-6]"));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> randomint.generateNums(3,4));
        assertEquals("Can't ask for more numbers than are available", exception.getMessage());
    }
}