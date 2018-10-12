package org.miser.generator.util;

import org.apache.velocity.VelocityContext;
import org.miser.common.config.Global;
import org.miser.common.constant.Constants;
import org.miser.common.utils.DateUtils;
import org.miser.common.utils.StringUtils;
import org.miser.generator.domain.ColumnInfo;
import org.miser.generator.domain.TableInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 代码生成器 工具类
 *
 * @author Barry
 */
public class GenUtils {
    /**
     * 项目源码路径
     */
    private static final String SOURCE_PATH = "main/java";

    /**
     * mybatis空间路径
     */
    private static final String MYBATIS_PATH = "main/resources/mybatis";

    /**
     * html空间路径
     */
    private static final String TEMPLATES_PATH = "main/resources/templates";

    /**
     * 类型转换
     */
    public static Map<String, String> javaTypeMap = new HashMap<String, String>();

    static {
        javaTypeMap.put("tinyint", "Integer");
        javaTypeMap.put("smallint", "Integer");
        javaTypeMap.put("mediumint", "Integer");
        javaTypeMap.put("int", "Integer");
        javaTypeMap.put("integer", "integer");
        javaTypeMap.put("bigint", "Long");
        javaTypeMap.put("float", "Float");
        javaTypeMap.put("double", "Double");
        javaTypeMap.put("decimal", "BigDecimal");
        javaTypeMap.put("bit", "Boolean");
        javaTypeMap.put("char", "String");
        javaTypeMap.put("varchar", "String");
        javaTypeMap.put("tinytext", "String");
        javaTypeMap.put("text", "String");
        javaTypeMap.put("mediumtext", "String");
        javaTypeMap.put("longtext", "String");
        javaTypeMap.put("time", "Date");
        javaTypeMap.put("date", "Date");
        javaTypeMap.put("datetime", "Date");
        javaTypeMap.put("timestamp", "Date");
    }

    /**
     * 设置列信息
     */
    public static List<ColumnInfo> transColums(List<ColumnInfo> columns) {
        // 列信息
        List<ColumnInfo> columsList = new ArrayList<>();
        for (ColumnInfo column : columns) {
            // 列名转换成Java属性名
            String attrName = StringUtils.convertToCamelCase(column.getColumnName());
            column.setAttrName(attrName);
            column.setSAttrName(StringUtils.uncapitalize(attrName));

            // 列的数据类型，转换成Java类型
            String attrType = javaTypeMap.get(column.getDataType());
            column.setAttrType(attrType);

            columsList.add(column);
        }
        return columsList;
    }

    /**
     * 获取模板信息
     *
     * @return 模板列表
     */
    public static VelocityContext getVelocityContext(TableInfo table) {
        // java对象数据传递到模板文件vm
        VelocityContext velocityContext = new VelocityContext();
        String packageName = Global.getPackageName();
        velocityContext.put("tableName", table.getTableName());
        velocityContext.put("tableComment", replaceKeyword(table.getTableComment()));
        velocityContext.put("primaryKey", table.getPrimaryKey());
        velocityContext.put("className", table.getSClassName());
        velocityContext.put("sClassName", table.getSClassName());
        velocityContext.put("moduleName", GenUtils.getModuleName(packageName));
        velocityContext.put("columns", table.getColumns());
        velocityContext.put("package", packageName + "." + table.getSClassName());
        velocityContext.put("author", Global.getAuthor());
        velocityContext.put("datetime", DateUtils.getDate());
        return velocityContext;
    }

    /**
     * 获取模板信息
     *
     * @return 模板列表
     */
    public static List<String> getTemplates() {
        List<String> templates = new ArrayList<String>();
        templates.add("templates/vm/java/domain.java.vm");
        templates.add("templates/vm/java/Mapper.java.vm");
        templates.add("templates/vm/java/Service.java.vm");
        templates.add("templates/vm/java/ServiceImpl.java.vm");
        templates.add("templates/vm/java/Controller.java.vm");
        templates.add("templates/vm/xml/Mapper.xml.vm");
        templates.add("templates/vm/html/list.html.vm");
        templates.add("templates/vm/html/add.html.vm");
        templates.add("templates/vm/html/edit.html.vm");
        templates.add("templates/vm/sql/sql.vm");
        return templates;
    }

    /**
     * 表名转换成Java类名
     */
    public static String tableToJava(String tableName) {
        if (Constants.AUTO_REOMVE_PRE.equals(Global.getAutoRemovePre())) {
            tableName = tableName.substring(tableName.indexOf("_") + 1);
        }
        if (StringUtils.isNotEmpty(Global.getTablePrefix())) {
            tableName = tableName.replace(Global.getTablePrefix(), "");
        }
        return StringUtils.convertToCamelCase(tableName);
    }

    /**
     * 获取文件名
     */
    public static String getFileName(String template, TableInfo table, String modulePath, String moduleName) {
        // 小写类名
        String sClassName = table.getSClassName();
        // 大写类名
        String className = table.getClassName();
        String javaPath = SOURCE_PATH + "/" + modulePath + "/";
        String mybatisPath = MYBATIS_PATH + "/" + moduleName + "/" + className;
        String htmlPath = TEMPLATES_PATH + "/" + moduleName + "/" + sClassName;

        if (StringUtils.isNotEmpty(sClassName)) {
            javaPath += sClassName.replace(".", "/") + "/";
        }

        if (template.contains("domain.java.vm")) {
            return javaPath + "domain" + "/" + className + ".java";
        }

        if (template.contains("Mapper.java.vm")) {
            return javaPath + "mapper" + "/" + className + "Mapper.java";
        }

        if (template.contains("Service.java.vm")) {
            return javaPath + "service" + "/" + "I" + className + "Service.java";
        }

        if (template.contains("ServiceImpl.java.vm")) {
            return javaPath + "service" + "/" + className + "ServiceImpl.java";
        }

        if (template.contains("Controller.java.vm")) {
            return javaPath + "controller" + "/" + className + "Controller.java";
        }

        if (template.contains("Mapper.xml.vm")) {
            return mybatisPath + "Mapper.xml";
        }

        if (template.contains("list.html.vm")) {
            return htmlPath + "/" + sClassName + ".html";
        }
        if (template.contains("add.html.vm")) {
            return htmlPath + "/" + "add.html";
        }
        if (template.contains("edit.html.vm")) {
            return htmlPath + "/" + "edit.html";
        }
        if (template.contains("sql.vm")) {
            return sClassName + "Menu.sql";
        }
        return null;
    }

    /**
     * 获取模块名
     *
     * @param packageName 包名
     * @return 模块名
     */
    public static String getModuleName(String packageName) {
        int lastIndex = packageName.lastIndexOf(".");
        int nameLength = packageName.length();
        String moduleName = StringUtils.substring(packageName, lastIndex + 1, nameLength);
        return moduleName;
    }

    /**
     * 获取模块完整路径
     *
     * @param packageName 包名
     * @return 模块名
     */
    public static String getModulePath(String packageName) {
        String moduleName = packageName.replace(".", "/");
        return moduleName;
    }

    public static String replaceKeyword(String keyword) {
        String keyName = keyword.replaceAll("(?:表|信息)", "");
        return keyName;
    }
}
