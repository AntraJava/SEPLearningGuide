package com.antra.sep.springiocdemo;

import com.antra.sep.springiocdemo.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringIocDemoApplicationTests {

    @Autowired
    MenuService menuService1;
    @Autowired
    MenuService menuService2;

    @Test
    void contextLoads() {
        System.out.println(menuService1 == menuService2);
    }

}
