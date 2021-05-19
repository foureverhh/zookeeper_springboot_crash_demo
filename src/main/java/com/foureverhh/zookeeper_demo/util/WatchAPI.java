package com.foureverhh.zookeeper_demo.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WatchAPI implements Watcher {
    @Autowired
    private ZooKeeper zkClient;

    @Override
    public void process(WatchedEvent event) {
        try {
        for(String node : zkClient.getChildren("/",true)){
                log.info(node);
            }
        }catch(Exception e){
            log.error("error",e.getMessage());
        }

        log.info("【Watcher监听事件】={}", event.getState());
        log.info("【监听路径为】={}", event.getPath());
        log.info("【监听的类型为】={}", event.getType()); //  三种监听类型： 创建，删除，更新
    }
}
