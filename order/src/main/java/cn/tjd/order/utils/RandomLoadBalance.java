package cn.tjd.order.utils;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

/**
 * @Auther: TJD
 * @Date: 2020-06-18
 * @DESCRIPTION:
 **/
@Component
public class RandomLoadBalance extends LoadBalance {
    @Override
    public String getService() {
        List<String> serviceList = LoadBalance.SERVICE_LIST;
        if (serviceList.size()>0) {
            int index = new Random().nextInt(serviceList.size());
            return serviceList.get(index);
        }
        return null;
    }
}
