客户端以授权码方式访问OAuth2服务器案例，使用rest template
======

# 实验注意事项

1. 该实验开始前需要预先安装mysql数据库，再使用mysql workbench预先执行sql脚本src\main\resources\db\oauth_client.sql

   

2. 该案例需先启动lab01中的支持授权码模式的OAuth2服务器(authcode-server)，端口在8080。

3. 再运行本案例web应用，端口在9001，浏览器访问http://locahost:9001， 按提示操作即可。

4. 该案例授权成功后，客户端会在数据库中缓存访问令牌（可通过mysql workbench查看），如果OAuth2服务器使用内存模式，则重启OAuth2服务器后原访问令牌将失效，需要清除数据库令牌再重新授权。

# 代码解析

## io.spring2go.clientresttemplate.oauth

### AuthorizationCodeConfiguration



### AuthorizationCodeTokenService

### OAuth2Token



## io.spring2go.clientresttemplate.security

### ClientUserDetails

### ClientUserDetailsService

### SecurityConfiguration

```java
@Configuration
@EnableWebSecurity
```



## io.spring2go.clientresttemplate.user

### ClientUser

### Entry

### MainPage

核心的控制器

```java
@Controller
```



### UserInfo



## resources.templates

# 问题

## 运行不起来

# 运行

将程序运行

访问

http://localhost:9001

点击 "go to your main page"

出现 "Login with Username and Password"页面

输入数据库中定义的用户名密码

点击 Login, 注意这里的login是web应用程序的login

输入正确之后, 弹出 http://localhost:8080 对话框, 输入用户名密码, 注意这里是授权服务器的用户名和密码, 在application.properties中定义



