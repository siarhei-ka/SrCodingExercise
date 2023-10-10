package org.sk.scoreboard;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentMap;

import static org.junit.jupiter.api.Assertions.assertSame;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ScoreBoardTest {

    @BeforeAll
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        Field instance = ScoreBoard.class.getDeclaredField("cache");
        instance.setAccessible(true);
        ConcurrentMap<String, ScoreBoard> map = (ConcurrentMap<String, ScoreBoard>) instance.get(null);
        map.clear();
    }

    @Test
    public void testGetInstanceWhenCalledTwiceThenReturnSameInstance() {
        ScoreBoard instance1 = ScoreBoard.getInstance();
        ScoreBoard instance2 = ScoreBoard.getInstance();

        assertSame(instance1, instance2, "Instances are not the same");
    }
}