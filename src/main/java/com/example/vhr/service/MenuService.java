package com.example.vhr.service;

import com.example.vhr.mapper.MenuMapper;
import com.example.vhr.model.Hr;
import com.example.vhr.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther:zhugq
 * @Date: 2020/04/25/22:20
 */
@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    public List<Menu> getMenusByHrId() {
        return menuMapper.getMenusByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());

    }

    public List<Menu> getAllMenusWithRole(){
        return menuMapper.getAllMenusWithRole();
    }
}
