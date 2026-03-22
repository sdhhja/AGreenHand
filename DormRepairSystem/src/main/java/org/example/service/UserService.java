package org.example.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.entity.RepairOrder;
import org.example.entity.User;
import org.example.mapper.RepairOrderMapper;
import org.example.mapper.UserMapper;
import org.example.utils.MyBatisUtils;
import java.util.List;

public class UserService {
    private UserMapper userMapper = MyBatisUtils.getMapper(UserMapper.class);
    private RepairOrderMapper repairOrderMapper = MyBatisUtils.getMapper(RepairOrderMapper.class);

    public void register(String id, String password, String role) {
        userMapper.insert(new User(id, password, role));
    }

    public User login(String id, String password) {
        User user = userMapper.selectById(id);
        if (user != null && user.getPassword().equals(password)) return user;
        return null;
    }

    public void submitRepair(String userId, String content) {
        RepairOrder order = new RepairOrder();
        order.setStudentId(userId);
        order.setDescription(content);
        order.setStatus("待处理");
        repairOrderMapper.insert(order);
    }

    public void myRepairOrders(String userId) {
        QueryWrapper<RepairOrder> qw = new QueryWrapper<>();
        qw.eq("student_id", userId);
        List<RepairOrder> list = repairOrderMapper.selectList(qw);
        for (RepairOrder o : list) {
            // 这里用 getOrderId 和 getDescription
            System.out.println("单号:" + o.getOrderId() + " | 内容:" + o.getDescription() + " | 状态:" + o.getStatus());
        }
    }
}