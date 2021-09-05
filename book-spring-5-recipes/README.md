# spring-recipes-4th
Source Code for Spring Recipes the 4th Edition

[![CircleCI](https://circleci.com/gh/mdeinum/spring-recipes-4th.svg?style=svg&circle-token=0cc7b13bad66aec69f031d50d9ef63a65dc91bd7)](https://circleci.com/gh/mdeinum/spring-recipes-4th)



# 源代码编译

一定要安装使用 gradle 4.6, gradle 6 和 7 测试不通过

进入目录，执行

```
gradle build
```

会将所有子目录都编译完成

需要下载很多东西, 请耐心等待

# 第2章: Spring核心任务

## 代码观察

```java
import org.springframework.stereotype.Component;

```

### recipe_2_03_iii

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
@Bean

import org.springframework.beans.factory.annotation.Autowired;
@Autowired
```

