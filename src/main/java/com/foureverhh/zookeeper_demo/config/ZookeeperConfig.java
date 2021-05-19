package com.foureverhh.zookeeper_demo.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Configuration
@Slf4j
public class ZookeeperConfig {
    @Value("${zookeeper.address}")
    private String connectAddress;

    @Value("${zookeeper.timeout}")
    private int timeout;

    @Bean("zkClient")
    public ZooKeeper zkClient(){
        ZooKeeper zooKeeper = null;
        try{
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            zooKeeper = new ZooKeeper(connectAddress, timeout, watchedEvent -> {
                if(watchedEvent.getState() == Watcher.Event.KeeperState.SyncConnected)
                    countDownLatch.countDown();
            });
            countDownLatch.await();
            log.info("【初始化ZooKeeper连接状态....】={}", zooKeeper.getState());
        }catch (Exception e){
            log.error("初始化ZooKeeper连接异常....】={}", e);
        }
        return zooKeeper;
    }

}
