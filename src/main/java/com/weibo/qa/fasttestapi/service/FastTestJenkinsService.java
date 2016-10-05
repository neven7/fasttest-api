package com.weibo.qa.fasttestapi.service;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;
import com.offbytwo.jenkins.model.JobWithDetails;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hugang on 16/9/19.
 */
public class FastTestJenkinsService {



    /**
     *
     * @param env 测试环境
     * @param module 测试模块
     * @param email  收件人
     * @return jobId
     */
    public int buildJob(String env, String module, String email) {

        int buildNumber = 0;
        try{


            JenkinsServer jenkinsServer = new JenkinsServer(new URI("http://ip:port/jenkins"), "user", "pwd");

            Map<String, Job> jobs = jenkinsServer.getJobs();

            JobWithDetails job = jobs.get("FastTest").details();

            // 即将执行任务的jobId
            buildNumber = job.getNextBuildNumber();

            // 参数化构建
            Map<String, String> params = new HashMap<String, String>();
            params.put("environment", env);
            params.put("module", module);
            params.put("mailer", email);
            job.build(params);


        }catch (Exception e){
            e.printStackTrace();
        } finally {

        }
        return buildNumber;
    }


    /**
     *
     * @param jobId
     * @return 是否执行结束
     */
    public boolean isJobFinish(int jobId)  {

        if(jobId <=0){
            throw new IllegalArgumentException("jodId must greater than 0!");
        }


        try{

            JenkinsServer jenkinsServer = new JenkinsServer(new URI("http://ip:port/jenkins"), "user", "pwd");

            Map<String, Job> jobs = jenkinsServer.getJobs();

            JobWithDetails job = jobs.get("FastTest").details();

            boolean isBuilding = job.getBuildByNumber(jobId).details().isBuilding();

            return !isBuilding;

        } catch (Exception e){
            e.printStackTrace();
        } finally{

        }

        return false;
    }


}
