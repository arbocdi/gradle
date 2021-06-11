public class ProjectVersionSerializer {
    public ProjectVersion readVersion(File versionFile) {
        if (!versionFile.exists()) {
            throw new Exception("Required version file does not exist:$versionFile.canonicalPath")
        }
        Properties versionProps = new Properties()
        //читаем свойства из файла
        versionFile.withInputStream { stream ->
            versionProps.load(stream)
        }
        return new ProjectVersion(versionProps.major.toInteger(),
                versionProps.minor.toInteger(),
                versionProps.release.toBoolean())
    }

    public ProjectVersion writeVersion(File versionFile, ProjectVersion projectVersion) {
        Properties properties = new Properties();
        properties.setProperty("major", "${projectVersion.major}");
        properties.setProperty("minor", "${projectVersion.minor}");
        properties.setProperty("release", "${projectVersion.release}");
        versionFile.withOutputStream { stream ->
            properties.store(stream,null);
        }
        return projectVersion;
    }
}