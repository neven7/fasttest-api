package com.weibo.qa.fasttestapi.controller;


import com.weibo.qa.fasttestapi.model.RunInfo;
import com.weibo.qa.fasttestapi.service.EmailSuffixService;
import com.weibo.qa.fasttestapi.service.FastTestJenkinsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 接口/fasttest/run:
 *
 * params:
 *
 * env 测试环境
 * module 模块, 现在仅有BVT模块
 * email 收件人
 *
 *
 * result:
 *
 * {"result":true,"jobId":int值}
 *
 * Created by hugang on 16/9/19.
 */
@RestController
public class RunController {




    @RequestMapping(value = "/fasttest/run.json", method = RequestMethod.POST)
    public RunInfo runFasttest(@RequestParam(value = "env", required = true) String env,
                        @RequestParam(value = "module", required = true, defaultValue = "BVT") String module,
                        @RequestParam(value = "email", required = true, defaultValue = "hugang") String email){

        FastTestJenkinsService fastTestJenkinsService = new FastTestJenkinsService();
        // 添加邮箱后缀
        EmailSuffixService emailSuffix = new EmailSuffixService();

        String receiver = emailSuffix.addEmailSuffix(email);



        int jobId = fastTestJenkinsService.buildJob(env, module, receiver);

        RunInfo runInfo = new RunInfo();

        runInfo.setJobId(jobId);
        runInfo.setResult(true);

        return runInfo;



    }

}
