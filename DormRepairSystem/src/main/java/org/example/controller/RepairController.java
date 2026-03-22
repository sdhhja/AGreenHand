package org.example.controller;

import org.example.entity.User;
import org.example.service.UserService;
import java.util.Scanner;

public class RepairController {
    private UserService userService = new UserService();
    private Scanner sc = new Scanner(System.in);

    public void showMenu() {
        while (true) {
            System.out.println("\n===== 宿舍报修系统 =====");
            System.out.println("1. 登录  2. 注册  0. 退出");
            String choice = sc.nextLine();
            if ("1".equals(choice)) doLogin();
            else if ("2".equals(choice)) doRegister();
            else if ("0".equals(choice)) break;
        }
    }

    private void doRegister() {
        System.out.print("账号: "); String id = sc.nextLine();
        System.out.print("密码: "); String pwd = sc.nextLine();
        System.out.print("角色(1-学生): "); String role = sc.nextLine();
        userService.register(id, pwd, role);
        System.out.println("注册成功！");
    }

    private void doLogin() {
        System.out.print("账号: "); String id = sc.nextLine();
        System.out.print("密码: "); String pwd = sc.nextLine();
        User user = userService.login(id, pwd);
        if (user != null) {
            System.out.println("登录成功！");
            showStudentMenu(user);
        } else {
            System.out.println("登录失败！");
        }
    }

    private void showStudentMenu(User u) {
        while (true) {
            System.out.println("\n1. 申请报修  2. 查看记录  0. 返回");
            String c = sc.nextLine();
            if ("1".equals(c)) {
                System.out.print("内容: ");
                userService.submitRepair(u.getId(), sc.nextLine());
            } else if ("2".equals(c)) {
                userService.myRepairOrders(u.getId());
            } else if ("0".equals(c)) break;
        }
    }
}