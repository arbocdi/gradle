### Customizing java plugin
* set sources,version,manifest
```java
version = 0.1
sourceCompatibility = 1.6
jar {
  manifest {
    attributes 'Main-class':'main class name'
  }
}
```
* переопределим каталоги для исходиников, тестов и билда:
```java
sourceSets {
  main{
    java{
      srcDirs:['src']
    }
  }
  test{
    java{
      srcDirs:['test']
    }
  }
}
buildDir = 'out'
```
