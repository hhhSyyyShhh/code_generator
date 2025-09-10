package org.shuhao.generater;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.shuhao.Main;
import org.shuhao.model.MainTemplateConfig;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *  动态文件生成
 */
public class DynamicGenerator {

    public static void main(String[] args ) throws IOException, TemplateException {

        //new 出 configuration 对象，参数输设置为Freemarker版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        //设置文件路径
        configuration.setDirectoryForTemplateLoading(
                new File("/Users/yangshuhao/Desktop/" +
                        "Ysh_generater/Ysh_generater_basic/src/main/resources/templates"));
        //设置字符集
        configuration.setDefaultEncoding("UTF-8");

        //获取指定模版
        Template template = configuration.getTemplate("MainTemplate.java.ftl");

        //创建数据模型
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();

        mainTemplateConfig.setAuthor("YSH");

        //不使用循环
        mainTemplateConfig.setLoop(false);

        mainTemplateConfig.setOutputText("求和结果：");

        Writer out = new FileWriter("MainTemplate.java");

        template.process(mainTemplateConfig, out);

        // 关闭
        out.close();

    }
}