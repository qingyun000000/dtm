package com.zy.zydtm.optimistic.domain.vo;

/**
 * 创建事务
 * @author wuhailong
 */
public class CreateRequest {
    
    /*
    * 创建用户Id
    */
    private String createUserId;

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }
    
}
