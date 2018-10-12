package org.miser.quartz.task;

import org.springframework.stereotype.Component;

/**
 * 定时任务调度测试
 *
 * @author Barry
 */
@Component("demoTask")
public class DemoTask {
    public void demoParams(String params) {
        System.out.println("执行有参方法：" + params);
    }

    public void demoNoParams() {
        System.out.println("执行无参方法");
    }
}
