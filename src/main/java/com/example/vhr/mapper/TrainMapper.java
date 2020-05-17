package com.example.vhr.mapper;

import com.example.vhr.model.Train;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TrainMapper {
    int insert(Train record);

    int insertSelective(Train record);

    Train selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Train record);

    int updateByPrimaryKey(Train record);

    List<Train> getTrainByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("tr") Train train);

    Long getTotal(@Param("tr") Train train);

    List<Train> getAllTrain();

    Integer deleteTrainById(Integer id);

    Integer addTrain(@Param("list") List<Train> list);

//    Integer maxWorkId();
}