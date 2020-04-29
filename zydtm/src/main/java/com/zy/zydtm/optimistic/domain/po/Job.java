package com.zy.zydtm.optimistic.domain.po;

import java.util.Map;

/**
 * 任务，子事务
 * @author wuhailong
 */
public class Job {
    
    /**
     * 事务token
     */
    private String transactionToken;
    
    /**
     * 请求地址，含主机IP和端口，如http://localhost:8080/test。get请求包含参数
     */
    private String url;
    
    /**
     * 请求方法
     */
    private String requestMethod;
    
    /**
     * 请求参数
     */
    private Map<String, String> requestParameters;
    
    /**
     * 执行状态
     * @return 
     */
    private boolean success;

    public String getTransactionToken() {
        return transactionToken;
    }

    public void setTransactionToken(String transactionToken) {
        this.transactionToken = transactionToken;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public Map<String, String> getRequestParameters() {
        return requestParameters;
    }

    public void setRequestParameters(Map<String, String> requestParameters) {
        this.requestParameters = requestParameters;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    
    
    
}
