package com.zy.zydtm.optimistic.domain.po;

import java.util.List;

/**
 * 事务
 * @author wuhailong
 */
public class Transaction {
    
    /*
    * 创建用户Id
    */
    private String createUserId;
    
    /**
     * 创建用户token，持有这个token提交或者回滚
     */
    private String createUserToken;
    
    /*
    * job列表
    */
    private List<Job> jobs;

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

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
    
}
