package com.weibo.qa.fasttestapi.service;

/**
 * Created by hugang on 16/9/20.
 */
public class EmailSuffixService {


    /**
     * 返回全限邮箱
     * 比如: a,b -> a@staff.weibo.com,b@staff.weibo.com
     * @param prefix
     * @return
     */
    public String addEmailSuffix(String prefix){

        String mailSuffix = "@your company mail suffix";
        String receiverList = "";
        String[] receivers = prefix.split(",");
        int size = receivers.length;
        for (String receiver: receivers
                ) {
            size--;
            if(size != 0) {
                receiverList += (receiver + mailSuffix) + ",";
            }else {
                receiverList += (receiver + mailSuffix);
            }

        }

        return receiverList;


    }


}
