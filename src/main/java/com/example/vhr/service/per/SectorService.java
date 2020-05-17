package com.example.vhr.service.per;

import com.example.vhr.mapper.SectorMapper;
import com.example.vhr.model.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectorService {
    @Autowired
    SectorMapper sectorMapper;
    public List<Sector> getAllSector() {
        return sectorMapper.getAllSector();
    }
}
