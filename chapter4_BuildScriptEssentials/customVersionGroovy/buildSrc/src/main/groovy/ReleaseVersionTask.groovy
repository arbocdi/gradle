import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

class ReleaseVersionTask extends DefaultTask {
    @Input
    Boolean release
    @OutputFile
    File destFile

    ProjectVersionSerializer serializer = new ProjectVersionSerializer();


    ReleaseVersionTask() {
        group = 'versioning'
        description = 'Makes project a release version.'
    }

    @TaskAction
    void start() {
        project.version.release = true
        serializer.writeVersion(destFile,project.version);
//        ant.propertyfile(file: destFile) {
//            entry(key: 'release', type: 'string', operation: '=', value: 'true')
//        }
    }
}
