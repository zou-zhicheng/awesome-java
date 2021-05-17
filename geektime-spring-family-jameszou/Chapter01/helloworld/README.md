# 访问
```shell
curl http://localhost:8080/hello
curl http://localhost:8080/actuator/health
```

# maven打包
macos安装
```shell
brew install maven
```
maven打包
```shell
mvn clean package -Dmaven.test.skip
```

# 执行jar包
进入jar包目录
```shell
java -jar jar包名
```