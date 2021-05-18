package com.foureverhh.zookeeper_demo.controller;

import com.foureverhh.zookeeper_demo.util.ZkAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;

@Controller
@Slf4j
public class ZookeeperController {
    @Autowired
    private ZkAPI zkAPI;

    @GetMapping("/createNode")
    @ResponseBody
    public Boolean createNode(@RequestParam(value = "path") String path, @RequestParam("data") String data){
        log.debug("ZookeeperController create node {},{}", path, data);
        return zkAPI.createNode(path,data);
    }
}
