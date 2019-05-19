package io.github.wanmudong.dataBase;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/5/17 20:51
 * @description：
 */
public class MybatisSession {
    private static SqlSession session;
    //mybatis的配置文件
    private static String resource = "conf.xml";
    //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
    private static InputStream is = MybatisSession.class.getClassLoader().getResourceAsStream(resource);
    //构建sqlSession的工厂
    private static SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
    public static SqlSession getSession(){
        if (session == null){
             session = sessionFactory.openSession();
        }
        return session;
    }
}
