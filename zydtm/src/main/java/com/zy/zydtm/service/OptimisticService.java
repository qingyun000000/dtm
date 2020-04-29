package com.zy.zydtm.service;

import com.zy.zydtm.optimistic.domain.vo.CreateRequest;
import com.zy.zydtm.optimistic.domain.vo.CreateResponse;
import com.zy.zydtm.optimistic.domain.vo.JobSubmitRequest;
import com.zy.zydtm.optimistic.domain.vo.JoinRequest;
import com.zy.zydtm.optimistic.domain.vo.JoinResponse;
import com.zy.zydtm.optimistic.domain.vo.RollbackRequest;
import com.zy.zydtm.optimistic.domain.vo.RollbackResponse;
import com.zy.zydtm.optimistic.domain.vo.SubmitRequest;
import com.zy.zydtm.optimistic.domain.vo.SubmitResponse;

/**
 * 乐观机制业务层接口
 * @author wuhailong
 */
public interface OptimisticService {

    /**
     * 创建事务
     * @param createTransactionRequest
     * @return 
     * @throws java.lang.Exception 
     */
    public CreateResponse create(CreateRequest createTransactionRequest) throws Exception;

    /**
     * 增加任务
     * @param joinRequest
     * @return 
     * @throws java.lang.Exception 
     */
    public JoinResponse join(JoinRequest joinRequest) throws Exception;
    
    /**
     * 任务确认
     * @param jobSubmitRequest
     * @throws java.lang.Exception 
     */
    public void jobSubmit(JobSubmitRequest jobSubmitRequest) throws Exception;

    /**
     * 回滚
     * @param rollbackRequest
     * @return 
     * @throws java.lang.Exception 
     */
    public RollbackResponse rollback(RollbackRequest rollbackRequest) throws Exception;

    /**
     * 提交
     * @param submitRequest
     * @return
     * @throws Exception 
     */
    public SubmitResponse submit(SubmitRequest submitRequest) throws Exception;
    
}
