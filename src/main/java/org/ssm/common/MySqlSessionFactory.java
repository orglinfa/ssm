package org.ssm.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 获取sqlfactory
 * mybatis 可以通过
 */
public class MySqlSessionFactory {
    /**
     * ignore new
     */
    private MySqlSessionFactory(){}
    public  volatile static SqlSessionFactory instance;
    private static final String resource="mybatis_config.xml";

    /**
     * 通过单例模式获取SessionFactory
     * @return
     * @throws IOException
     */
    public static SqlSessionFactory getInstance() throws IOException {
        if (instance==null){
            synchronized (MySqlSessionFactory.class){
                //当第一次调用getInstance方法时，即instance为空时，同步操作，保证多线程实例唯一
                //当以后调用getInstance方法时，即instance不为空时，不进入同步代码块，减少了不必要的同步开销
                if(instance==null){
                    InputStream inputStream= Resources.getResourceAsStream(resource);
                    instance=new SqlSessionFactoryBuilder().build(inputStream);
                }
            }
        }
            return instance;

    }



    /**
     * test get sessionFactory
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        SqlSessionFactory instance = MySqlSessionFactory.getInstance();
        System.out.println(instance.getConfiguration().getDatabaseId());
    }
}
