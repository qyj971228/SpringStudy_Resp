import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataSourceTest {

    /**
     * 测试手动创建c3p0
     */
    @Test
    public void test1() throws PropertyVetoException, SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/world?serverTimezone=UTC");
        dataSource.setUser("root");
        dataSource.setPassword("DBJdedi2gehao");
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        conn.close();
    }

    /**
     * 测试手动创建Druid
     */
    @Test
    public void test2() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/world?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("DBJdedi2gehao");
        DruidPooledConnection conn = dataSource.getConnection();
        System.out.println(conn);
        conn.close();
    }
    /**
     * 测试手动创建c3p0 -> 配置文件形式
     */
    @Test
    public void test3() throws PropertyVetoException, SQLException {

        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("jdbc.driver");
        String url = bundle.getString("jdbc.url");
        String user = bundle.getString("jdbc.username");
        String password = bundle.getString("jdbc.password");

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        Connection conn = dataSource.getConnection();

        System.out.println(conn);
        conn.close();
    }

    /**
     * 测试手动创建Druid -> 配置文件形式
     */
    @Test
    public void test4() throws SQLException {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("jdbc.driver");
        String url = bundle.getString("jdbc.url");
        String user = bundle.getString("jdbc.username");
        String password = bundle.getString("jdbc.password");

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);

        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        conn.close();
    }
}
