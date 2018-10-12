package org.miser.common.annotation;

import org.miser.common.enums.AccessType;
import org.miser.common.enums.BusinessAction;

import java.lang.annotation.*;

/**
 * 自定义操作日志记录注解
 *
 * @author Barry
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 模块
     */
    String title() default "";

    /**
     * 业务功能
     */
    BusinessAction businessAction() default BusinessAction.OTHER;

    /**
     * 访问类别
     */
    AccessType accessType() default AccessType.MANAGE;

    /**
     * 是否保存请求的参数
     */
    boolean isSaveRequestData() default true;
}
