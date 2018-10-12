package org.miser.system.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.miser.common.annotation.Excel;
import org.miser.common.base.BaseEntity;

import java.util.Date;

/**
 * 操作日志记录表 oper_log
 *
 * @author Barry
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysOperLog extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 日志主键
     */
    @Excel(name = "操作序号")
    private Long operId;

    /**
     * 操作模块
     */
    @Excel(name = "操作模块")
    private String title;

    /**
     * 业务类型（0其它 1新增 2修改 3删除）
     */
    @Excel(name = "业务功能")
    private Integer action;

    /**
     * 请求方法
     */
    @Excel(name = "请求方法")
    private String method;

    /**
     * 操作类别（0其它 1后台用户 2手机端用户）
     */
    @Excel(name = "访问类型")
    private Integer access;

    /**
     * 操作人员
     */
    @Excel(name = "操作人员")
    private String operName;

    /**
     * 部门名称
     */
    @Excel(name = "部门名称")
    private String deptName;

    /**
     * 请求url
     */
    @Excel(name = "请求地址")
    private String operUrl;

    /**
     * 操作地址
     */
    @Excel(name = "操作地址")
    private String operIp;

    /**
     * 操作地点
     */
    @Excel(name = "操作地点")
    private String operLocation;

    /**
     * 请求参数
     */
    @Excel(name = "请求参数")
    private String operParam;

    /**
     * 操作状态（0正常 1异常）
     */
    @Excel(name = "状态")
    private Integer status;

    /**
     * 错误消息
     */
    @Excel(name = "错误消息")
    private String errorMsg;

    /**
     * 操作时间
     */
    @Excel(name = "操作时间")
    private Date operTime;

}
