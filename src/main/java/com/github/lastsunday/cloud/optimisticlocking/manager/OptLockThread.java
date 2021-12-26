package com.github.lastsunday.cloud.optimisticlocking.manager;

public class OptLockThread implements Runnable{

    private UserManager userManager;

    public OptLockThread(UserManager userManger){
        this.userManager = userManger;
    }

    @Override
    public void run() {
        userManager.updateByEntity();
    }
}
