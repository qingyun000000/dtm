package com.zy.zydtmc.initiate;

import com.alibaba.fastjson.JSON;
import com.zy.zydtmc.client.ClientStatus;
import com.zy.zydtmc.enums.RpcType;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 客户端初始化服务
 *
 * @author wuhailong
 * @createTime 2020-03-27
 * @updateTime 2020-03-27
 */
@Component
public class InitialService implements ApplicationListener<ContextRefreshedEvent> {
    
    @Value("${server.port:8080}")
    private int port;

    @Value("${zydtm.rpc.type:ZyRas}")
    private String rpcType;

    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        if("ZyRas".equals(rpcType)){
            ClientStatus.setRpcType(RpcType.ZYRAS);
        }else if("SpringCloud_Eureka".equals(rpcType)){
            System.out.println("暂不支持的分布式服务类型");
            //ClientStatus.setRpcType(RpcType.SPRINGCLOUD_EUREKA);
            
        }else{
            System.out.println("暂不支持的分布式服务类型");
        }

    }

    

}
