package com.example.vhr.service.system.basic;

import com.example.vhr.mapper.RoleMapper;
import com.example.vhr.model.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther:zhugq
 * @Date: 2020/04/27/14:12
 */
@Service
public class PemissionService {
    @Resource
    RoleMapper roleMapper;

    public List<Role> getAllRoles(){
        return roleMapper.getAllRoles();
    }
    public Integer addRole(Role role){
        if(!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_"+role.getName());
        }
        return roleMapper.insert(role);
    }
    public Integer deleteRoleById(Integer rid){
        return roleMapper.deleteByPrimaryKey(rid);
    }

}
