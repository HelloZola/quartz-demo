package com.controller;

import com.quartz.job.HelloJob;
import com.quartz.job.HiJob;
import com.quartz.manager.QuartzJobManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    QuartzJobManager quartzJobManager;

    /**
     * http://localhost:8090/hello/add
     *
     * @param request
     * @return
     */
    @RequestMapping("add")
    public String add(HttpServletRequest request) {

        //创建job
//        createJobDemoByList(request);
        createJobDemo(request);
//        createJobDemo2(request);
        createJobDemo3(request);

        return "Hello this is my first springboot demo";
    }

    private void createJobDemoByList(HttpServletRequest request) {

        int seq = 0;

        List<String> cronList = getCronList();
        for (String cron : cronList) {
            seq++;
            //任务名称
            String name = request.getParameter("name");
            //任务组名称
            String groupName = "task";
            //cron表达式
//            String cron = "0 0/1 * * * ?";
            //需要给任务携带的参数
            Map<String, Object> map = new HashMap<>();
            map.put("name", "张三" + seq);
            map.put("sex", "0");
            quartzJobManager.addJob(HiJob.class, "HiJob" + seq, groupName, cron, map);
        }
    }


    private void createJobDemo(HttpServletRequest request) {
//        任务名称
        String name = request.getParameter("name");
        //任务组名称
        String groupName = "task";
        //cron表达式
        String cron = "0 0/1 * * * ?";
        //需要给任务携带的参数
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("sex", "0");
        quartzJobManager.addJob(HiJob.class, "HiJob", groupName, cron, map);
    }

    private void createJobDemo2(HttpServletRequest request) {
//        任务名称
        String name = request.getParameter("name");
        //任务组名称
        String groupName = "task";
        //cron表达式
        String cron = "50 * * * * ? ";
        //需要给任务携带的参数
        Map<String, Object> map = new HashMap<>();
        map.put("name", "李四");
        map.put("sex", "1");
        quartzJobManager.addJob(HelloJob.class, "HelloJob", groupName, cron, map);
    }

    private void createJobDemo3(HttpServletRequest request) {
//        任务名称
        String name = request.getParameter("name");
        //任务组名称
        String groupName = "task";
        //cron表达式
        String cron = "0 0/1 * * * ?";
        //需要给任务携带的参数
        Map<String, Object> map = new HashMap<>();
        map.put("name", "李四");
        map.put("sex", "1");
        quartzJobManager.addJob(HelloJob.class, "HelloJob2", groupName, cron, map);
    }

    public static List getCronList() {

        List<String> cronList = new ArrayList<>();
        String s = "0 0 0 1 1 ? 2099-2100 , " +
                "0 0 0 1 1 ? 2099-2100 , " +
                "0 0 0 1 1 ? 2099-2100 , " +
                "0 0 9 * * ? , " +
                "0 0 15 * * ? , " +
                "0 0/10 9-18 * * ? , " +
                "0 0 15 * * ? , " +
                "0 30 19 * * ? , " +
                "0 0/30 * * * ? , " +
                "0 1/30 * * * ? , " +
                "0 7 1/5 * * ? , " +
                "0 0/10 * * * ? , " +
                "0 0 1 * * ? , " +
                "0 5/30 * * * ? , " +
                "0 0/10 * * * ? , " +
                "0 30 23 * * ? , " +
                "0 0 10 * * ? , " +
                "0 0 10 * * ? , " +
                "0 0 10 * * ? , " +
                "0 0 10 * * ? , " +
                "0 0 10 * * ? , " +
                "0 0 10 * * ? , " +
                "0 0 10,15 * * ? , " +
                "0 30 1,17,20 * * ? , " +
                "0 0 20 * * ? , " +
                "0 0 17 * * ? , " +
                "0 0 3 * * ? , " +
                "0 0 3 * * ? * , " +
                "0 0/3 * * * ? , " +
                "1/30 * * * * ? * 2000 , " +
                "0 0/30 * * * ? , " +
                "0 20 0 * * ? , " +
                "0 30 8 * * ? , " +
                "0 0 3 * * ? , " +
                "0 0 1 * * ? , " +
                "0 3/5 * * * ? * , " +
                "0 30 8 * * ? , " +
                "0 0 0/2 * * ? , " +
                "0 0 1,3,5,7 * * ? , " +
                "0 5 0 * * ? , " +
                "0 0 8 * * ? , " +
                "0 0/30 * * * ? , " +
                "0 0 8 * * ? , " +
                "0 0/30 * * * ? , " +
                "0 5 0 * * ? , " +
                "0 0 8 * * ? , " +
                "0 0/30 * * * ? , " +
                "0 0/20 8-23 * * ? , " +
                "0 1/30 * * * ? , " +
                "0 40 3 * * ? , " +
                "0 0/5 * * * ? , " +
                "0 0/30 * * * ? , " +
                "0 0 10,15 * * ? , " +
                "0 0 08 * * ? , " +
                "0 7/12 * * * ? , " +
                "0 30 3 * * ? , " +
                "0 0 * * * ? , " +
                "0 0/15 0-7 * * ? , " +
                "0 0 9 * * ? , " +
                "0 0 18 * * ? , " +
                "0 40 7 * * ? , " +
                "0 20 8 * * ? , " +
                "0 0 5 * * ? * , " +
                "0 30 12 * * ? , " +
                "0 0 13 * * ? , " +
                "0 0/5 2-23 * * ? , " +
                "0 2/5 * * * ? , " +
                "0 0/5 * * * ? , " +
                "0 0/10 * * * ? , " +
                "0 35 23 * * ? , " +
                "0 3/30 * * * ? , " +
                "0 0/10 * * * ? , " +
                "0 5/30 * * * ? , " +
                "0 7/30 * * * ? , " +
                "0 3/20 * * * ? , " +
                "0 0/2 * * * ? , " +
                "0 0/20 * * * ? , " +
                "0 7 5 1 1-12 ? * , " +
                "0 0 2 * * ? , " +
                "0 3/5 * * * ? , " +
                "0 0/1 * * * ? , " +
                "0 1 * * * ?  , " +
                "0 0/50 * * * ? , " +
                "0 25 1/3 * * ? , " +
                "0 07 3/6 * * ? , " +
                "0 0/10 * * * ? , " +
                "0 2 * * * ? , " +
                "0 3 * * * ? , " +
                "0 4 * * * ? , " +
                "0 10 0 * * ? , " +
                "0 10 0 * * ? , ";

        String[] cron = s.split(",");
        for (String s2 : cron) {
            s2 = s2.substring(0, s2.indexOf("?") + 1);
            if (s2.startsWith(" ")) {
                s2 = s2.substring(1, s2.indexOf("?") + 1);
            }
            if (!StringUtils.isEmpty(s2)) {
                cronList.add(s2);
            }
        }
        return cronList;
    }

}