package com.ucar.training.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InitDataTest {
    public void initTest(String url){
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sampledb?useSSL=false&serverTimezone=UTC",
                    "root",
                    "password");
            ScriptRunner runner = new ScriptRunner(connection);
            Reader reader = Resources.getResourceAsReader(url);
            runner.runScript(reader);
            runner.closeConnection();
            System.out.println("初始化成功");
        }
        catch (ClassNotFoundException c){
            System.out.println("class not found!");
        }
        catch (SQLException s){
            System.out.println("get connection error!");
        }
        catch (IOException i){
            System.out.println("get resource error!");
        }
        finally {
            if(connection != null){
                try{
                    connection.close();
                }
                catch (SQLException s){
                    System.out.println("close connection error!");
                }
            }
        }
    }

    //初始化user表
    //@Test
    public void initUserTest(){
        initTest("data/init_user.sql");
    }

    //初始化message表
    //@Test
    public void initMessageTest(){
        initTest("data/init_message.sql");
    }

    //初始化role表
    //@Test
    public void initRoleTest(){
        initTest("data/init_role.sql");
    }

    //初始化permission表
    //@Test
    public void initPermissionTest(){
        initTest("data/init_permission.sql");
    }

    //初始化role_permission表
    //@Test
    public void initRolePermissionTest(){
        initTest("data/init_role_permission.sql");
    }

    //初始化user_role表
    //@Test
    public void initUserRoleTest(){
        initTest("data/init_user_role.sql");
    }
}
