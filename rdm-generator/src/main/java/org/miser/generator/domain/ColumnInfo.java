package org.miser.generator.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ry数据库表列信息
 *
 * @author Barry
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ColumnInfo {
    /**
     * 字段名称
     */
    private String columnName;

    /**
     * 字段类型
     */
    private String dataType;

    /**
     * 列描述
     */
    private String columnComment;

    /**
     * Java属性类型
     */
    private String attrType;

    /**
     * Java属性名称(第一个字母大写)，如：user_name => UserName
     */
    private String attrName;

    /**
     * Java属性名称(第一个字母小写)，如：user_name => userName
     */
    private String sAttrName;

}
