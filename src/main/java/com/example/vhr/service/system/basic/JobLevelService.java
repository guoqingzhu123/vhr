package com.example.vhr.service.system.basic;

import com.example.vhr.mapper.JObLevelMapper;
import com.example.vhr.model.JObLevel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Auther:zhugq
 * @Date: 2020/04/26/16:02
 */
@Service
public class JobLevelService {
    @Resource
    JObLevelMapper jObLevelMapper;

    public List<JObLevel> getAllJObLevel() {
        return jObLevelMapper.selectAllJobLevel();
    }

    public Integer addJObLevel(JObLevel jObLevel) {
        jObLevel.setEnabled(true);
        jObLevel.setCreateDate(new Date());
        return jObLevelMapper.insertSelective(jObLevel);
    }

    public Integer updateJObLevel(JObLevel jObLevel) {
        return jObLevelMapper.updateByPrimaryKeySelective(jObLevel);
    }

    public Integer deleteJObLevel(Integer id) {
        return jObLevelMapper.deleteByPrimaryKey(id);
    }
    public Integer deleteJObLevel(Integer[] ids) {
        return jObLevelMapper.deleteByIds(ids);
    }
}
