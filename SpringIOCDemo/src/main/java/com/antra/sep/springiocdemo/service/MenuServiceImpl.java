package com.antra.sep.springiocdemo.service;

import com.antra.sep.springiocdemo.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuRepository menuRepository;

    @Override
    public String getMenuName(int id) {
        return menuRepository.findById(id).get().getName();
    }
}
