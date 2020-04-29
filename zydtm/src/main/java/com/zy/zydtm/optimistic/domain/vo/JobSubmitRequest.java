package com.zy.zydtm.optimistic.domain.vo;

/**
 * 任务完成
 * @author wuhailong
 */
public class JobSubmitRequest {
    
    /**
     * 事务token
     */
    private String transactionToken;
    
    /**
     * job排序
     */
    private int jobIndex;

    public String getTransactionToken() {
        return transactionToken;
    }

    public void setTransactionToken(String transactionToken) {
        this.transactionToken = transactionToken;
    }    

    public int getJobIndex() {
        return jobIndex;
    }

    public void setJobIndex(int jobIndex) {
        this.jobIndex = jobIndex;
    }
    
}
