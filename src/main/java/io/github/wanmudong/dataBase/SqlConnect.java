package io.github.wanmudong.dataBase;

import java.sql.*;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/5/17 20:26
 * @description：
 */
public class SqlConnect {
    //声明Connection对象
    private static Connection con;
    //驱动程序名
    private static String driver = "com.mysql.jdbc.Driver";
    //URL指向要访问的数据库名mydata
    private static String url = "jdbc:mysql://localhost:3306/spider-sina";
    //MySQL配置时的用户名
    private static String user = "root";
    //MySQL配置时的密码
    private static String password = "123456";
    public static Connection getConnect() throws ClassNotFoundException, SQLException {
        if (con !=null){
            return con;
        }else {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url,user,password);
        }
        return con;
    }
    public void setCookie() throws SQLException {
        //2.创建statement类对象，用来执行SQL语句！！
        Statement statement = con.createStatement();
        //要执行的SQL语句
        String sql = "select * from cookies";
        //3.ResultSet类，用来存放获取的结果集！！
        ResultSet rs = statement.executeQuery(sql);
        System.out.println("-----------------");
        System.out.println("执行结果如下所示:");
        System.out.println("-----------------");
        System.out.println("姓名" + "\t" + "职称");
        System.out.println("-----------------");

        String job = null;
        String id = null;
        while(rs.next()){
            //获取stuname这列数据
            job = rs.getString("job");
            //获取stuid这列数据
            id = rs.getString("ename");

            //输出结果
            System.out.println(id + "\t" + job);
        }
        rs.close();
    }
}
