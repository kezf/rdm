package org.miser.quartz.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.miser.common.annotation.Excel;
import org.miser.common.base.BaseEntity;

/**
 * 定时任务调度日志表 sys_job_log
 *
 * @author Barry
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysJobLog extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @Excel(name = "日志序号")
    private Long jobLogId;

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
     * 日志信息
     */
    @Excel(name = "日志信息")
    private String jobMessage;

    /**
     * 执行状态（0正常 1失败）
     */
    @Excel(name = "执行状态")
    private String status;

    /**
     * 异常信息
     */
    @Excel(name = "异常信息")
    private String exceptionInfo;

}
