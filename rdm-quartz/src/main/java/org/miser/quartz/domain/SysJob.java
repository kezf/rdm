package org.miser.quartz.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.miser.common.annotation.Excel;
import org.miser.common.base.BaseEntity;
import org.miser.common.constant.ScheduleConstants;

import java.io.Serializable;

/**
 * 定时任务调度表 sys_job
 *
 * @author Barry
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysJob extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 任务ID
     */
    @Excel(name = "任务序号")
    private Long jobId;

    /**
     * 任务名称
     */
    @Excel(name = "任务名称")
    private String jobName;

    /**
     * 任务组名
     */
    @Excel(name = "任务组名")
    private String jobGroup;

    /**
     * 任务方法
     */
    @Excel(name = "任务方法")
    private String methodName;

    /**
     * 方法参数
     */
    @Excel(name = "方法参数")
    private String methodParams;

    /**
     * cron执行表达式
     */
    @Excel(name = "执行表达式 ")
    private String cronExpression;

    /**
     * cron计划策略
     */
    @Excel(name = "计划策略 ")
    private String misfirePolicy = ScheduleConstants.MISFIRE_DEFAULT;

    /**
     * 任务状态（0正常 1暂停）
     */
    @Excel(name = "任务状态")
    private String status;

}
