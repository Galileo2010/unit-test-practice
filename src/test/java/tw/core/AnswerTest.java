package tw.core;

import org.junit.jupiter.api.Test;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.model.Record;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    @Test
    void validate() {
        Answer ans = Answer.createAnswer("1 2 34");
        Exception exception = assertThrows(OutOfRangeAnswerException.class, () -> ans.validate());
        assertEquals("Answer format is incorrect", exception.getMessage());
    }

    @Test
    void check() {
        Answer ans = Answer.createAnswer("1 2 3 4");
        Record rc =  ans.check(Answer.createAnswer("1 2 5 6"));
        assertEquals("2A0B",rc.getValue());
        rc =  ans.check(Answer.createAnswer("9 2 5 6"));
        assertEquals("1A0B",rc.getValue());
        rc =  ans.check(Answer.createAnswer("3 4 5 6"));
        assertEquals("0A2B",rc.getValue());
    }

    @Test
    void getIndexOfNum() {
        Answer ans = Answer.createAnswer("1 2 3 4");
        assertEquals(1, ans.getIndexOfNum("2"));
        assertEquals(0, ans.getIndexOfNum("1"));
        assertEquals(3, ans.getIndexOfNum("4"));
    }

    @Test
    void test_toString() {

        Answer ans = Answer.createAnswer("1 2 3 4");
        assertEquals("1 2 3 4",ans.toString());
        ans = Answer.createAnswer("2 1 3 4");
        assertEquals("2 1 3 4",ans.toString());
        ans = Answer.createAnswer("4 7 2 1");
        assertEquals("4 7 2 1",ans.toString());
    }
}