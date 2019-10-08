
#端口
#环境端口
http://localhost:8080/env
用于排查问题，例如查询@Value(${server.port})中的值
#问答环节
1.yaml具有严格的格式限制，一定要用的小心。例如空格
2.注解编程模式与接口编程模式。
3.怎么防止Order一样？
    Spring Boot和Spring Cloud里面没有办法，在Spring Security 通过异常去实现。
    
# 遇到的问题
1.在配置服务端uri之后无法访问服务端git配置资源？
#解决办法 删除参数配置（原因是该参数生成了随机端口8888）
--spring.cloud.bootstrap.name=abc --spring.cloud.bootstrap.location=my.properties