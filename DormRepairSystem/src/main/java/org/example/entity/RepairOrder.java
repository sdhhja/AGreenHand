package org.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("repair_order")
public class RepairOrder {
    @TableId(type = IdType.AUTO) // 数据库设为自增 ID
    private Integer orderId;
    private String studentId;   // 谁报修的
    private String description; // 坏了什么
    private String status;      // 状态：待处理、已完成

    public RepairOrder() {}

    public Integer getOrderId() { return orderId; }
    public void setOrderId(Integer orderId) { this.orderId = orderId; }
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}