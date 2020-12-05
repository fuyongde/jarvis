package org.stark.jarvis;

import org.gradle.testfixtures.ProjectBuilder;
import org.gradle.api.Project;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A simple unit test for the 'org.stark.jarvis.plugins.greeting' plugin.
 */
public class GreetingPluginTest {

    @Test
    public void pluginRegistersATask() {
        Project project = ProjectBuilder.builder().build();
        project.getPlugins().apply("org.stark.jarvis.plugins.greeting");

        assertNotNull(project.getTasks().findByName("hello"));
    }
}
