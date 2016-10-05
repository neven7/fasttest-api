package com.weibo.qa.fasttestapi.controller;

import com.weibo.qa.fasttestapi.model.FinishInfo;
import com.weibo.qa.fasttestapi.service.FastTestJenkinsService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hugang on 16/9/20.
 */

@RestController

public class FinishController {

    @RequestMapping(value = "/fasttest/finish.json",method = RequestMethod.GET)
    public @ResponseBody
    FinishInfo isFinish(@RequestParam(value = "job_id", required = true)int job_id) {

        FastTestJenkinsService fastTestJenkinsService = new FastTestJenkinsService();

        boolean isFinish = fastTestJenkinsService.isJobFinish(job_id);

        FinishInfo finishInfo = new FinishInfo();

        finishInfo.setFinished(isFinish);

        return finishInfo;

    }
}
