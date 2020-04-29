package com.zy.zydtm.optimistic.domain.vo;

/**
 * 回滚
 * @author wuhailong
 */
public class RollbackRequest {
    
    /**
     * 事务token
     */
    private String transactionToken;
    
    /*
    * 创建用户Id
    */
    private String createUserId;
    
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

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserToken() {
        return createUserToken;
    }

    public void setCreateUserToken(String createUserToken) {
        this.createUserToken = createUserToken;
    }
    
}
