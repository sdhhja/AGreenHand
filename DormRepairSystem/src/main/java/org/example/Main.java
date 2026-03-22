package org.example;

import org.example.controller.RepairController;

public class Main {
    public static void main(String[] args) {
        // 调用 Controller 开启菜单
        new RepairController().showMenu();
    }
}