package org.example.utils;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.io.InputStream;

public class MyBatisUtils {
    private static SqlSessionFactory factory;

    static {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            factory = new MybatisSqlSessionFactoryBuilder().build(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> T getMapper(Class<T> clazz) {
        // 设置为 true 开启自动提交
        SqlSession session = factory.openSession(true);
        return session.getMapper(clazz);
    }
}