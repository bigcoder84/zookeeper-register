package cn.tjd.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Auther: TJD
 * @Date: 2020-06-18
 * @DESCRIPTION:
 **/
@RestController
public class ProductController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/product")
    public String product() {
        try {
            String hostAddress = InetAddress.getLocalHost().getHostAddress();
            return "此次任务调用了" + hostAddress + ":" + port + "上的product服务";
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "product服务调用失败";
    }
}
