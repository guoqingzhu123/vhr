package com.example.vhr.mapper;

import com.example.vhr.model.Hr;
import com.example.vhr.model.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Lenovo
 */
public interface HrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    @Select("select * from hr where username=#{username}")
    Hr loadUserByUsername(String username);

    @Select("select r.* from role r, hr_role hrr where hrr.rid=r.id and hrr.hrid=#{id}")
    List<Role> getHrRolesById(Integer id);
}
