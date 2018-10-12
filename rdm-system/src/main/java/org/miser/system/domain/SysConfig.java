package org.miser.system.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.miser.common.annotation.Excel;
import org.miser.common.base.BaseEntity;

/**
 * 参数配置表 sys_config
 *
 * @author Barry
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysConfig extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 参数主键
     */
    @Excel(name = "参数主键")
    private Long configId;

    /**
     * 参数名称
     */
    @Excel(name = "参数名称")
    private String configName;

    /**
     * 参数键名
     */
    @Excel(name = "参数键名")
    private String configKey;

    /**
     * 参数键值
     */
    @Excel(name = "参数键值")
    private String configValue;

    /**
     * 系统内置（Y是 N否）
     */
    @Excel(name = "系统内置")
    private String configType;

}
