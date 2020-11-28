package com.example.microservice.infra.utils;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {
    public static void main(String[] args) {
        // ================= 必须修改的配置 start =================

        // 数据源配置
        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/authority?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
        String jdbcDriver = "com.mysql.jdbc.Driver";
        String jdbcUsername = "root";
        String jdbcPassword = "root1234";

        // 父级包名配置
        String parentPackage = "com.example.microservice";

        // 生成代码的 @author 值
        String author = "钟玖林10265666";

        // 要生成代码的表名配置
        String[] tables = {
                "user"
        };

        // ================= 必须修改的配置 end =================

        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(author);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        // 生成完毕后是否打开输出目录
        gc.setOpen(false);
        // 为true时生成entity将继承Model类，单类即可完成基于单表的业务逻辑操作，按需开启
        gc.setActiveRecord(false);

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sRepository");
        gc.setXmlName("%sRepository");
        gc.setServiceName("I%sMapper");
        gc.setServiceImplName("%sMapperImpl");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(jdbcUrl);
        dsc.setDriverName(jdbcDriver);
        dsc.setUsername(jdbcUsername);
        dsc.setPassword(jdbcPassword);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        // 父级包名，按需修改
        pc.setParent(parentPackage);
        // 设置模块名, 会在parent包下生成一个指定的模块包
        pc.setModuleName(null);
        pc.setService("infra.mapper");
        pc.setServiceImpl("infra.mapper.impl");
        pc.setEntity("domain");
        pc.setMapper("infra.mapper.repository");
        mpg.setPackageInfo(pc);

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/repository/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Repository" + StringPool.DOT_XML;
            }
        });

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setInclude(tables);
        // 写于父类中的公共字段
        strategy.setSuperEntityClass("com.example.microservice.domain.BaseEntity");
        strategy.setSuperEntityColumns("enabled_flag","created_by","creation_date","last_updated_by","last_update_date","ENABLED_FLAG","CREATED_BY","CREATION_DATE","LAST_UPDATED_BY","LAST_UPDATE_DATE");
        strategy.setLogicDeleteFieldName("enabledFlag");
        // Controller驼峰连字符，如开启，则requestMapping由 helloWorld 变为 hello-world 默认false
        strategy.setControllerMappingHyphenStyle(false);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        // 开启后将使用lombok注解代替set-get方法，false则生成set-get方法
        strategy.setEntityLombokModel(true);
        // 在实体类中移除is前缀
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
