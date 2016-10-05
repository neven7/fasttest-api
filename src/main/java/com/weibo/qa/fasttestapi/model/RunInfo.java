package com.weibo.qa.fasttestapi.model;

/**
 * 执行用例接口返回的数据
 * Created by hugang on 16/9/19.
 */
public class RunInfo {
    private boolean result;
    private int jobId;


    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }
}
