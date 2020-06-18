package cn.tjd.product.listener;

import cn.tjd.product.zk.ServiceRegister;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.net.InetAddress;

/**
 * @Auther: TJD
 * @Date: 2020-06-18
 * @DESCRIPTION:
 **/
public class InitListener implements ServletContextListener {
    private String port;
    private String zkCluster;

    public InitListener(String port,String zkCluster) {
        this.port = port;
        this.zkCluster = zkCluster;
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            //获取当前节点的IP
            String hostAddress = InetAddress.getLocalHost().getHostAddress();
            //注册服务
            ServiceRegister.register(zkCluster,hostAddress, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
