package org.stark.jarvis.mybatis.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ShellCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * @author fuyongde
 * @date 2020/12/13 20:42
 */
public class MyBatisGeneratorRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyBatisGeneratorRunner.class);

    public static void generate(File configurationFile) {
        List<String> warnings = Collections.emptyList();
        ConfigurationParser parser = new ConfigurationParser(warnings);
        try {
            Configuration configuration = parser.parseConfiguration(configurationFile);
            ShellCallback shellCallback = new DefaultShellCallback(false);
            MyBatisGenerator generator = new MyBatisGenerator(configuration, shellCallback, warnings);
            generator.generate(null);
        } catch (IOException | XMLParserException | InvalidConfigurationException | InterruptedException | SQLException e) {
            LOGGER.error("根据配置文件生成文件失败", e);
            throw new RuntimeException(e);
        }
    }
}
