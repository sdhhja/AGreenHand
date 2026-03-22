package org.example.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("user")
public class User {
    @TableId
    private String id;
    private String password;
    private String role;
    private String building;
    private String room;

    public User() {}
    public User(String id, String password, String role) {
        this.id = id;
        this.password = password;
        this.role = role;
    }

    // 这些方法必须有，否则 UserService 里的 u.getPassword() 会报错
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getBuilding() { return building; }
    public void setBuilding(String building) { this.building = building; }
    public String getRoom() { return room; }
    public void setRoom(String room) { this.room = room; }
}