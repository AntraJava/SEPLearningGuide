package com.antra.sep.springiocdemo;

import com.antra.sep.springiocdemo.demo.AnnoTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AOPTest {
    @Autowired
    AnnoTest annoTest;

    @Test
    public void testTimer() {
        annoTest.doSomething();
        annoTest.doSomething2(400);
    }
}
