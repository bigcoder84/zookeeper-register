package cn.tjd.order.controller;

import cn.tjd.order.utils.LoadBalance;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @Auther: TJD
 * @Date: 2020-06-18
 * @DESCRIPTION:
 **/
@RestController
public class OrderController {
    @Autowired
    private LoadBalance loadBalance;

    @GetMapping("/order")
    public String order(){
        String service = loadBalance.getService();
        System.out.println(service);
        if (service != null) {
            OkHttpClient okHttpClient = new OkHttpClient();
            Request request = new Request.Builder().url("http://"+service+"/product").build();
            try (Response response = okHttpClient.newCall(request).execute()) {
                ResponseBody body = response.body();
                return body.string();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "没有找到可用的product服务";
    }
}
