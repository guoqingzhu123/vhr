package com.example.vhr.service;

import com.example.vhr.mapper.MenuMapper;
import com.example.vhr.mapper.MenuRoleMapper;
import com.example.vhr.model.Hr;
import com.example.vhr.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther:zhugq
 * @Date: 2020/04/25/22:20
 */
@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    MenuRoleMapper menuRoleMapper;
    public List<Menu> getMenusByHrId() {
        return menuMapper.getMenusByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());

    }

    @Cacheable
    public List<Menu> getAllMenusWithRole(){
        return menuMapper.getAllMenusWithRole();
    }

    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }

    public List<Integer> getMidsByRid(Integer rid) {
        return menuMapper.getMidsByRid(rid);
    }

    @Transactional
    public boolean updateMenuRole(Integer rid, Integer[] mids) {
        menuRoleMapper.deleteByPrimaryKey(rid);
        if (mids == null || mids.length == 0) {
            return true;
        }

        Integer result = menuRoleMapper.insertRecord(rid, mids);
            return result == mids.length;

    }
}
