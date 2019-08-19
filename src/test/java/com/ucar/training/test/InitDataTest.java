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
    //@Test
    public void initUserTest(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sampledb?useSSL=false&serverTimezone=UTC",
                    "root",
                    "password");
            ScriptRunner runner = new ScriptRunner(connection);
            Reader reader = Resources.getResourceAsReader("data/init_user.sql");
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

    //初始化message表
    //@Test
    public void initMessageTest(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sampledb?useSSL=false&serverTimezone=UTC",
                    "root",
                    "password");
            ScriptRunner runner = new ScriptRunner(connection);
            Reader reader = Resources.getResourceAsReader("data/init_message.sql");
            runner.runScript(reader);
            runner.closeConnection();
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
}
