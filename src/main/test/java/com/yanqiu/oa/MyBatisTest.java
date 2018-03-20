package com.yanqiu.oa;

import com.yanqiu.oa.bean.OADepartment;
import com.yanqiu.oa.bean.OAUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {

    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init(){
        //加载mybatis核心配置文件
        InputStream inputStream = null;

        try {
            inputStream = Resources.getResourceAsStream("mybatis.cfg.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        解析mybatis.cfg.xml文档，并且初始化MyBatis（连接池、缓存）
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }


    @Test
    public void test1(){
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<OAUser> userList = sqlSession.selectList("com.yanqiu.oa.bean.userMapper.queryUser");
            for (OAUser user:userList){
                System.out.println(user.getUsername());
            }
    }


    @Test
    public void test3(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<OADepartment> departments = sqlSession.selectList("com.yanqiu.oa.bean.departmentMapper.selectDepartment");
        for (OADepartment oaDepartment:departments){
            System.out.println(oaDepartment.getDepartmentName());
        }
    }

    @Test
    public void test2(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OADepartment department = sqlSession.selectOne("com.yanqiu.oa.bean.departmentMapper.selectId", 1);
        List<OAUser> userList = department.getOaUserList();
        for (OAUser user:userList){
            System.out.println(user.getUsername());
        }
    }

    @Test
    public void test5(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //参数1：查询语句的id  参数2：入参
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("username","2 or 1=1");
        List<OAUser> userList = sqlSession.selectList("com.yanqiu.oa.bean.userMapper.queryUserById");
        for (OAUser user:userList){
            System.out.println(user.getUsername());
        }
        sqlSession.close();
    }
}
