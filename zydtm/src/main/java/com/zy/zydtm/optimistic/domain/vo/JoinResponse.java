package com.zy.zydtm.optimistic.domain.vo;

/**
 * 增加任务
 * @author wuhailong
 */
public class JoinResponse {
    
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
