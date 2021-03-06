package com.example.vhr.controller.system.basic;

import com.example.vhr.model.Menu;
import com.example.vhr.model.RespBean;
import com.example.vhr.model.Role;
import com.example.vhr.service.MenuService;
import com.example.vhr.service.system.basic.PemissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther:zhugq
 * @Date: 2020/04/27/14:11
 */
@RestController
@RequestMapping("/system/basic/pem")
public class PemissionController {
    @Autowired
    PemissionService roleService;
    @Autowired
    MenuService menuService;
    @GetMapping("/")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }
    @GetMapping("/menus")
    public List<Menu> getAllMenus(){
        return menuService.getAllMenus();
    }
    @GetMapping("/mids/{rid}")
    public List<Integer> getMidsByRid(@PathVariable Integer rid){
        return menuService.getMidsByRid(rid);
    }
    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid, Integer[] mids){
        if (menuService.updateMenuRole(rid,mids)){
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败！");
    }
    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role){
        if (roleService.addRole(role) ==1){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败!");
    }
    @PostMapping("/role/{rid}")
    public RespBean deleteRoleById(@PathVariable Integer rid){
        if (roleService.deleteRoleById(rid) ==1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败!");
    }

}
