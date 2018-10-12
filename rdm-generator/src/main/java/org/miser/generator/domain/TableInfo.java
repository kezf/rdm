package org.miser.generator.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.miser.common.base.BaseEntity;
import org.miser.common.utils.StringUtils;

import java.util.List;

/**
 * ry 数据库表
 *
 * @author Barry
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TableInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 表名称
     */
    private String tableName;

    /**
     * 表描述
     */
    private String tableComment;

    /**
     * 表的主键列信息
     */
    private ColumnInfo primaryKey;

    /**
     * 表的列名(不包含主键)
     */
    private List<ColumnInfo> columns;

    /**
     * 类名(第一个字母大写)
     */
    private String className;

    /**
     * 类名(第一个字母小写)
     */
    private String sClassName;

    public ColumnInfo getColumnsLast() {
        ColumnInfo columnInfo = null;
        if (StringUtils.isNotNull(columns) && columns.size() > 0) {
            columnInfo = columns.get(0);
        }
        return columnInfo;
    }

}
