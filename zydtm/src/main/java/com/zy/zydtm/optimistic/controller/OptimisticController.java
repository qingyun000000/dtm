package com.zy.zydtm.optimistic.controller;

import cn.whl.commonutils.service.result.ResultParam;
import cn.whl.commonutils.service.result.ServiceResult;
import cn.whl.commonutils.service.result.ServiceResultUtils;
import com.zy.zydtm.optimistic.domain.vo.CreateRequest;
import com.zy.zydtm.optimistic.domain.vo.JobSubmitRequest;
import com.zy.zydtm.optimistic.domain.vo.JoinRequest;
import com.zy.zydtm.optimistic.domain.vo.RollbackRequest;
import com.zy.zydtm.optimistic.domain.vo.SubmitRequest;
import com.zy.zydtm.service.OptimisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 乐观机制服务接口
 * @author wuhailong
 */
@RestController
@RequestMapping("/optimistic")
public class OptimisticController {
    
    @Autowired
    private OptimisticService service;
    
    /**
     * 创建事务
     * @param createTransactionRequest
     * @return 
     */
    @PostMapping("/create")
    public ServiceResult create(CreateRequest createTransactionRequest){
        ServiceResult result = ServiceResultUtils.action(ResultParam.Data, ()->service.create(createTransactionRequest));
        return result;
    }
    
    /**
     * 加入任务
     * @param joinRequest
     * @return 
     */
    @PostMapping("/join")
    public ServiceResult join(JoinRequest joinRequest){
        ServiceResult result = ServiceResultUtils.action(ResultParam.Data, ()->service.join(joinRequest));
        return result;
    }
    
    /**
     * 任务确认
     * @param jobSubmitRequest
     * @return 
     */
    @PostMapping("/jobSubmit")
    public ServiceResult jobSubmit(JobSubmitRequest jobSubmitRequest){
        ServiceResult result = ServiceResultUtils.action(()->service.jobSubmit(jobSubmitRequest));
        return result;
    }
    
    /**
     * 回滚事务
     * @param rollbackRequest
     * @return 
     */
    @PostMapping("/rollback")
    public ServiceResult rollback(RollbackRequest rollbackRequest){
        ServiceResult result = ServiceResultUtils.action(ResultParam.Data, ()->service.rollback(rollbackRequest));
        return result;
    }
    
    /**
     * 提交事务
     * @param submitRequest
     * @return 
     */
    @PostMapping("/submit")
    public ServiceResult submit(SubmitRequest submitRequest){
        ServiceResult result = ServiceResultUtils.action(ResultParam.Data, ()->service.submit(submitRequest));
        return result;
    }
}
