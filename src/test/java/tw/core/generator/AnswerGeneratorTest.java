package tw.core.generator;

import org.junit.jupiter.api.Test;
import tw.core.Answer;
import tw.core.exception.OutOfRangeAnswerException;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {

    @Test
    void generate() throws OutOfRangeAnswerException {
        AnswerGenerator ansg = new AnswerGenerator(new RandomIntGenerator());
        for (int i = 0; i < 10; i++) {
            Answer ans = ansg.generate();
            assertTrue(ans.toString().matches("[0-9] [0-9] [0-9] [0-9]"));
        }
    }
}

