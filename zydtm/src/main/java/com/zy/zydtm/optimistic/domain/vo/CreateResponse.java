package com.zy.zydtm.optimistic.domain.vo;

/**
 * 创建事务
 * @author wuhailong
 */
public class CreateResponse {
    
    /**
     * 创建用户Id
     */
    private String transactionToken;
    
    /**
     * 创建用户token，持有这个token提交或者回滚
     */
    private String createUserToken;

    public String getTransactionToken() {
        return transactionToken;
    }

    public void setTransactionToken(String transactionToken) {
        this.transactionToken = transactionToken;
    }
    
}
