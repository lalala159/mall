# mall
# mall
nacos配置中文注解时启动方式。
java -Dfile.encoding=utf-8 -jar xxx.jar
#构建镜像
mvn package docker:build
#查看镜像
docker images
#运行镜像
docker run -p 8080:18900 -t springboot/mall-auth
