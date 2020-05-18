package com.zy.zydtm.service.impl;

import cn.whl.commonutils.token.SimpleLongToken;
import cn.whl.commonutils.token.TokenUtils;
import com.alibaba.fastjson.JSON;
import com.zy.zydtm.optimistic.domain.po.Job;
import com.zy.zydtm.optimistic.domain.po.Transaction;
import com.zy.zydtm.optimistic.domain.vo.CreateRequest;
import com.zy.zydtm.optimistic.domain.vo.CreateResponse;
import com.zy.zydtm.optimistic.domain.vo.JobSubmitRequest;
import com.zy.zydtm.optimistic.domain.vo.JoinRequest;
import com.zy.zydtm.optimistic.domain.vo.JoinResponse;
import com.zy.zydtm.optimistic.domain.vo.RollbackRequest;
import com.zy.zydtm.optimistic.domain.vo.RollbackResponse;
import com.zy.zydtm.optimistic.domain.vo.SubmitRequest;
import com.zy.zydtm.optimistic.domain.vo.SubmitResponse;
import com.zy.zydtm.service.OptimisticService;
import com.zy.zydtm.utils.HttpUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 乐观机制业务层实现
 * @author wuhailong
 */
@Service
public class OptimisticServiceImpl implements OptimisticService{
   
    private static Map<String, Transaction> transtions = new HashMap<>();

    @Override
    public CreateResponse create(CreateRequest createTransactionRequest) throws Exception{
        String transactionToken = TokenUtils.createToken(new Date().getTime() + "", new SimpleLongToken());
        Transaction newTransaction = new Transaction();
        newTransaction.setCreateUserId(createTransactionRequest.getCreateUserId());
        
        newTransaction.setJobs(new ArrayList<>());
        transtions.put(transactionToken, newTransaction);
        CreateResponse response = new CreateResponse();
        response.setTransactionToken(transactionToken);
        return response;
    }

    @Override
    public JoinResponse join(JoinRequest joinRequest) {
        String jobJson = joinRequest.getJobJson();
        Job job = JSON.parseObject(jobJson, Job.class);
        transtions.get(joinRequest.getTransactionToken()).getJobs().add(job);
        JoinResponse response = new JoinResponse();
        response.setTransactionToken(joinRequest.getTransactionToken());
        response.setJobIndex(transtions.get(joinRequest.getTransactionToken()).getJobs().size());
        return response;
    }
    
    @Override
    public void jobSubmit(JobSubmitRequest jobSubmitRequest) throws Exception {
        Job job = transtions.get(jobSubmitRequest.getTransactionToken()).getJobs().get(jobSubmitRequest.getJobIndex() - 1);
        job.setSuccess(true);
    }


    @Override
    public RollbackResponse rollback(RollbackRequest rollbackRequest) {
        Transaction transaction = transtions.get(rollbackRequest.getTransactionToken());
        if(transaction.getCreateUserId().equals(rollbackRequest.getCreateUserId())
                && transaction.getCreateUserToken().equals(rollbackRequest.getCreateUserToken())){
            List<Job> jobs = transaction.getJobs();
            for(Job job : jobs){
                if(job.isSuccess()){
                    //回滚请求
                    if("get".equals(job.getRequestMethod())){
                        String url = job.getUrl() + "&rollbackSign=true"; 
                        HttpUtil.doGet(url);
                    }else{
                        Map<String, String> requestParameters = job.getRequestParameters();
                        requestParameters.put("rollbackSign", "true");
                        HttpUtil.doPost(job.getUrl(), requestParameters);
                    }
                }
            }
        }
        RollbackResponse response = new RollbackResponse();
        return response;
    }

    @Override
    public SubmitResponse submit(SubmitRequest submitRequest) {
        Transaction transaction = transtions.get(submitRequest.getTransactionToken());
        if(transaction.getCreateUserId().equals(submitRequest.getCreateUserId())
                && transaction.getCreateUserToken().equals(submitRequest.getCreateUserToken())){
            transtions.remove(submitRequest.getTransactionToken());
        }
        SubmitResponse response = new SubmitResponse();
        return response;
    }
    
}
