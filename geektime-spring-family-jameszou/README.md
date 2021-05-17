# 第一章: 初识 Spring

## macos动态切换java版本

在macOS中安装jdk，并查看是否安装成功

```shell
jameszou@JamesZOUdeMacBook-Pro target % /usr/libexec/java_home -V
Matching Java Virtual Machines (2):
    11.0.7 (x86_64) "Oracle Corporation" - "Java SE 11.0.7" /Library/Java/JavaVirtualMachines/jdk-11.0.7.jdk/Contents/Home
    1.8.0_251 (x86_64) "Oracle Corporation" - "Java SE 8" /Library/Java/JavaVirtualMachines/jdk1.8.0_251.jdk/Contents/Home
/Library/Java/JavaVirtualMachines/jdk-11.0.7.jdk/Contents/Home
```

打开根目录下的隐藏文件.bash_profile进行环境配置

打开 .bash_profile，没有的话创建

```
vim ~/.bash_profile
```

写入以下内容

```shell
export JAVA_8_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_251.jdk/Contents/Home
export JAVA_11_HOME=/Library/Java/JavaVirtualMachines/jdk-11.0.7.jdk/Contents/Home
alias jdk8="export JAVA_HOME=$JAVA_8_HOME" #编辑一个命令jdk8，输入则转至jdk1.8
alias jdk11="export JAVA_HOME=$JAVA_11_HOME" #编辑一个命令jdk11，输入则转至jdk1.11
export JAVA_HOME=`/usr/libexec/java_home`  #最后安装的版本，这样当自动更新时，始终指向最新版本
```

执行命令生效

```shell
source ~/.bash_profil
```

使用jdk？实现终端命令的自由切换

```shell
jameszou@JamesZOUdeMacBook-Pro helloworld % jdk11
jameszou@JamesZOUdeMacBook-Pro helloworld % java -version
java version "11.0.7" 2020-04-14 LTS
Java(TM) SE Runtime Environment 18.9 (build 11.0.7+8-LTS)
Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.7+8-LTS, mixed mode)

jameszou@JamesZOUdeMacBook-Pro helloworld % jdk8
jameszou@JamesZOUdeMacBook-Pro helloworld % java -version
java version "1.8.0_251"
Java(TM) SE Runtime Environment (build 1.8.0_251-b08)
Java HotSpot(TM) 64-Bit Server VM (build 25.251-b08, mixed mode)
```

## 生成骨架

[Spring Initializr](https://start.spring.io/)

## 访问

[localhost:8080/hello](http://localhost:8080/hello)

[localhost:8080/actuator/health](http://localhost:8080/actuator/health)

## 编译

```shell
mvn clean package -Dmaven.test.skip
```

编译之后在target目录生成文件

helloworld-0.0.1-SNAPSHOT.jar

```shell
jameszou@JamesZOUdeMacBook-Pro target % ls -al
total 37096
drwxr-xr-x   8 jameszou  staff       256  5 17 09:54 .
drwxr-xr-x@ 14 jameszou  staff       448  5 17 09:54 ..
drwxr-xr-x   4 jameszou  staff       128  5 17 09:54 classes
drwxr-xr-x   3 jameszou  staff        96  5 17 09:54 generated-sources
-rw-r--r--   1 jameszou  staff  18985235  5 17 09:54 helloworld-0.0.1-SNAPSHOT.jar
-rw-r--r--   1 jameszou  staff      3053  5 17 09:54 helloworld-0.0.1-SNAPSHOT.jar.original
drwxr-xr-x   3 jameszou  staff        96  5 17 09:54 maven-archiver
drwxr-xr-x   3 jameszou  staff        96  5 17 09:54 maven-status
```

## 执行

停止ide中运行的进程

```
java -jar helloworld-0.0.1-SNAPSHOT.jar
```

