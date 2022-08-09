package com.xuyunfei;

import com.xuyunfei.entity.User;
import com.xuyunfei.mapper.UserMapper;
import org.apache.ibatis.io.ResolverUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //加载config.xml
        InputStream inputStream = ResolverUtil.Test.class.getClassLoader().getResourceAsStream("config.xml");
        //得到SqlSession,建造者模式
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession sqlSession = factory.openSession();

        User chenlei = new User();
        chenlei.setMobile("1234567891");
        chenlei.setPassword("987");

//        使用原生接口
////        增
//        String statement2 = "com.xuyunfei.mapper.UserMapper.save";
//        System.out.println(sqlSession.insert(statement2, chenlei));
////        删
//        String statement3 = "com.xuyunfei.mapper.UserMapper.deleteById";
//        System.out.println(sqlSession.delete(statement3, 11));
////        改
//        String statement = "com.xuyunfei.mapper.UserMapper.findById";
//        String statement4 = "com.xuyunfei.mapper.UserMapper.update";
//        User user = sqlSession.selectOne(statement,9);
//        user.setMobile("159236");
//        sqlSession.update(statement4,user);
        //查
        String statement1 = "com.xuyunfei.mapper.UserMapper.findAll";
        List<Object> users = sqlSession.selectList(statement1);
        for (Object O : users) {
            User temp = (User) O;
            System.out.println(temp);
        }

////        自定义接口
 //       UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        User xuyunfei = mapper.findById(9);
////        增
//        mapper.save(xuyunfei);
//        System.out.println(mapper.save(chenlei));
////        删除
//        System.out.println(mapper.deleteById(12));
////        改
//        xuyunfei.setPassword("147258");
//        System.out.println(mapper.update(xuyunfei));
        //查
//        List<User> users = mapper.findAll();
//        for (User user : users) {
//            System.out.println(user);
//        }
        sqlSession.commit();

    }

}
