package org.stark.jarvis.mybatis.generator;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.Date;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;

/**
 * @author fuyongde
 * @date 2020/12/13 20:33
 */
public class JarvisCommentGenerator implements CommentGenerator {

    private static final String EASY_DATE_PATTERN = "yyyy/MM/dd HH:mm:ss";

    /**
     * 添加需要配置的属性
     *
     * @param properties properties
     */
    @Override
    public void addConfigurationProperties(Properties properties) {
        // 无需配置任何属性
    }

    /**
     * 为实体类的成员变量添加注释，这里取数据库中每个字段的注释来作为注释即可
     *
     * @param field              成员变量
     * @param introspectedTable  表
     * @param introspectedColumn 字段
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        field.addJavaDocLine("/**");
        field.addJavaDocLine(" * " + introspectedColumn.getRemarks() + "（" + introspectedTable.getFullyQualifiedTable() + "." + introspectedColumn.getActualColumnName() + "）");
        field.addJavaDocLine(" */");
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
    }

    /**
     * 为实体类添加注释
     *
     * @param topLevelClass     topLevelClass
     * @param introspectedTable introspectedTable
     */
    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(" * 该类由 Jarvis MyBatis Generator 通过 " + introspectedTable.getFullyQualifiedTable() + " 表自动生成。");
        topLevelClass.addJavaDocLine(" *");
        topLevelClass.addJavaDocLine(" * @author " + SystemUtils.getUserName("Jarvis MyBatis Generator"));
        topLevelClass.addJavaDocLine(" * @date " + DateFormatUtils.format(new Date(), EASY_DATE_PATTERN));
        topLevelClass.addJavaDocLine(" */");
    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
        // 内部类相关的注释，暂时不需要
    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
        // 内部类相关的注释，暂时不需要
    }

    @Override
    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
        // 内部类相关的注释，暂时不需要
    }

    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        // 实体类的 Getter 方法的注释，暂时不需要
    }

    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        // 实体类的 Getter 方法的注释，暂时不需要
    }

    /**
     * 为 Mapper 中的方法生成对应的注释
     *
     * @param method            方法
     * @param introspectedTable 表
     */
    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
        // 这里由于需要生成的方法是非常明确的，可以根据需要生成的方法名，来固定生成更为明确的注释
        method.addJavaDocLine("/**");
        method.addJavaDocLine(" * 该方法由 Jarvis MyBatis Generator 自动生成");
        method.addJavaDocLine(" *");
        Optional.ofNullable(method.getParameters())
                .orElse(Lists.newArrayList())
                .forEach(parameter -> method.addJavaDocLine(" * @param " + parameter.getName() + " 请替换为该参数正确的含义"));
        method.addJavaDocLine(" * @return 请替换为该返回值正确的含义");
        method.addJavaDocLine(" */");
    }

    /**
     * Java 文件头的注释，会在 Entity、Mapper 对应的 Java 文件头部生成
     *
     * @param compilationUnit compilationUnit
     */
    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        // 一般文件头部会写版权相关的注释，暂时不需要
    }

    /**
     * Mapper 对应的 XML 文件注释
     *
     * @param xmlElement xmlElement
     */
    @Override
    public void addComment(XmlElement xmlElement) {
        // 暂时不需要
    }

    @Override
    public void addRootComment(XmlElement rootElement) {
        // 暂时不需要
    }

    @Override
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> imports) {
        // 暂时不需要
    }

    @Override
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> imports) {
        // 暂时不需要
    }

    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> imports) {
        // 暂时不需要
    }

    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> imports) {
        // 暂时不需要
    }

    @Override
    public void addClassAnnotation(InnerClass innerClass, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> imports) {
        // 暂时不需要
    }
}
