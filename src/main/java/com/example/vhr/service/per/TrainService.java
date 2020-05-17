package com.example.vhr.service.per;

import com.example.vhr.mapper.TrainMapper;
import com.example.vhr.model.RespPageBean;
import com.example.vhr.model.Train;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {
    @Autowired
    TrainMapper trainMapper;
    @Autowired
    TrainService trainService;
    @Autowired
    RabbitTemplate rabbitTemplate;

//    public RespPageBean getEmployeeByPage(Integer page, Integer size, Employee employee, Date[] beginDateScope) {
//        if (page != null && size != null) {
//            page = (page - 1) * size;
//        }
//        List<Employee> data = employeeMapper.getEmployeeByPage(page, size, employee, beginDateScope);
//        Long total = employeeMapper.getTotal(employee, beginDateScope);
//        RespPageBean bean = new RespPageBean();
//        bean.setData(data);
//        bean.setTotal(total);
//        return bean;
//    }

//    public Integer maxWorkId() {
//        return ecMapper.maxWorkId();
//    }

    public Integer deleteTrainById(Integer id) {
        return trainMapper.deleteTrainById(id);
    }

    public Integer updateTrain(Train train) {
        return trainMapper.updateByPrimaryKeySelective(train);
    }

    public Integer addTrain(Train train) {

        int result = trainMapper.insertSelective(train);
        if (result == 1) {
            //生成消息的唯一id

            Train train1 = new Train();
            train1.setId(train1.getId());
            train1.setName(train1.getName());
            train1.setSectorId(train1.getSectorId());
            train1.setSectorName(train1.getSectorName());
            train1.setTrainName(train1.getTrainName());
            train1.setTrainPrize(train1.getTrainPrize());
            train1.setTrainResult(train1.getTrainResult());
            train1.setTrainTime(train1.getTrainTime());
            train1.setRemark(train1.getRemark());
            trainService.insert(train);
        }
        return result;
    }
    public Integer insert(Train train) {
        return trainMapper.insert(train);
    }

    public RespPageBean getTrainByPage(Integer page, Integer size, Train train) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Train> data = trainMapper.getTrainByPage(page, size, train);
        Long total = trainMapper.getTotal(train);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public List<Train> getAllTrain() {
        return trainMapper.getAllTrain();
    }


}
