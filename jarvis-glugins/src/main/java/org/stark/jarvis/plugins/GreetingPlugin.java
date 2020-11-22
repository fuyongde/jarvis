package org.stark.jarvis.plugins;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * @author fuyongde
 * @date 2020/11/22 15:44
 */
public class GreetingPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        System.out.println("Greeting Plugin!");
        project.getTasks().register(
                "hello",
                task -> task.doLast(s-> System.out.println("Greeting From GreetingPlugin"))
        );
    }
}
