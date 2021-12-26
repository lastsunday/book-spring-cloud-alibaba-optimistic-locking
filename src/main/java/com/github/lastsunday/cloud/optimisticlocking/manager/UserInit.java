package com.github.lastsunday.cloud.optimisticlocking.manager;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class UserInit {

    @Resource
    private UserManager userManager;

    @PostConstruct
    public void init(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new OptLockThread(userManager));
    }
}
