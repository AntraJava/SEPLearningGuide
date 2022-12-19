package com.antra.sep.springiocdemo.controller;

import com.antra.sep.springiocdemo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    @Autowired
    MenuService menuService;

    @GetMapping("/menu/{id}")
    public String getMenuNameById(@PathVariable int id) {
        String menuName = menuService.getMenuName(id);
        return menuName;
    }
}
