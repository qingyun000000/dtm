package com.zy.zydtmc.client;

import com.zy.zydtmc.enums.RpcType;

/**
 * 客户端状态
 * @author wuhailong
 */
public class ClientStatus {
    
    /**
     * 配套分布式服务类型
     */
    private static RpcType rpcType;

    public static RpcType getRpcType() {
        return rpcType;
    }

    public static void setRpcType(RpcType rpcType) {
        ClientStatus.rpcType = rpcType;
    }
    
    
}
