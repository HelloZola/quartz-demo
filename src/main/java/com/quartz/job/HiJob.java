package com.quartz.job;

import com.utils.FireUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 简单的执行任务, 打印时间和你好
 * 实现接口Job 从写方法execute
 * 该方法就是你定时器执行任务的逻辑
 */
public class HiJob implements Job {

    private static List<String> exeTimeList = new ArrayList<>();

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        String jobKey = jobExecutionContext.getTrigger().getJobKey().getName();
        System.out.println("HiJob:" + Thread.currentThread().getId());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = simpleDateFormat.format(new Date());
        exeTimeList.add(nowTime);

        System.out.println("*****************************");
        System.out.println(jobKey + " HiJob的执行时间");
        for (String exeTime : exeTimeList) {
            System.out.println(exeTime);
        }
        System.out.println("*****************************");
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        FireUtil.printFire();

        //这里为了演示, 只进行打印
        System.out.println(nowTime + ":你好" + " HiJob  Thread.id" + Thread.currentThread().getId());
    }

}