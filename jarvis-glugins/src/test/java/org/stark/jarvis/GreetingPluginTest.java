package org.stark.jarvis;

import org.gradle.testfixtures.ProjectBuilder;
import org.gradle.api.Project;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A simple unit test for the 'org.stark.jarvis.greeting' plugin.
 */
public class GreetingPluginTest {

    @Test
    public void pluginRegistersATask() {
        // Create a test project and apply the plugin
        Project project = ProjectBuilder.builder().build();
        project.getPlugins().apply("org.stark.jarvis.greeting");

        // Verify the result
        assertNotNull(project.getTasks().findByName("greeting"));
    }
}
