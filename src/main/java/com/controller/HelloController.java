package com.controller;

import com.quartz.job.HiJob;
import com.quartz.manager.QuartzJobManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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

        //任务名称
//        String name = request.getParameter("name");
//        //任务组名称
//        String groupName = "task";
//        //cron表达式
//        String cron = "0 0/1 * * * ?";
//        //需要给任务携带的参数
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "张三");
//        map.put("sex", "0");
//        quartzJobManager.addJob(HiJob.class, "HiJob", groupName, cron, map);

        return "Hello this is my first springboot demo";
    }
}