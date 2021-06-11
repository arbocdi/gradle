### Tasks

* build.gradle - это build script для gradle
* Создадим билд скрипт с  задачами taskOne,taskTwo,
вторая задача выполняется только после первой,
* doLast - метод, выполняющийся по окончанию задачи:

```java
task taskOne {
  doLast {
    println "task one completed"
  }
}
task taskTwo {
  doLast {
    println "task two completed"
  }
}
taskTwo.dependsOn taskOne

```
* Сокращенная форма записи doLast
```java
task taskTwo << {
  println "task two completed"
}
```
* выполним задачу taskOne
```bash
gradle taskOne
```
* выполним задачу taskTwo<br>
taskOne тоже выполнится
```bash
gradle taskTwo
```
* посмотрим все задачи, которые есть в build.gradle,<br>
-q сокращенный вывод<br>
-all по умолчанию показывается только финальная задача taskTwo,
эта опция покажет все задачи, от которых зависит taskTwo:
```bash
gradle -q tasks --all
```
* Gradle поддерживает аббревиатуры составленные из начальных букв слов, входящих в имя задачи:
```bash
gradle taskOne
#эквивалентно
gradle tO
```
* Чтобы сократить время сборки можно запустить Gradle как демон:
```bash
gradle --daemon
# и выполнить задачу 1
gradle tO --daemon
```
