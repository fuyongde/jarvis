package org.stark.jarvis.mybatis.generator;

import org.junit.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author fuyongde
 * @date 2020/12/13 21:01
 */
public class MyBatisGeneratorRunnerTest {

    @Test
    public void generate() throws URISyntaxException {
        URL url = MyBatisGeneratorRunnerTest.class.getResource("/generatorConfig.xml");
        File file = new File(url.toURI());
        MyBatisGeneratorRunner.generate(file);
    }
}