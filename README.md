# mall
# mall
nacos配置中文注解时启动方式。
java -Dfile.encoding=utf-8 -jar xxx.jar
#构建镜像
mvn clean package -Dmaven.test.skip=true docker:build
#查看镜像
docker images
#运行镜像
docker run -p 9527:9527 -t springboot/mall-getway

#导出镜像
docker save  -o   D:\dockerImage\mall-getway.tar    docker.io/springboot/mall-getway:latest(id)

docker load -i D:\dockerImage\mall-getway.tar

docker rmi ${id}
maven仓库目录不能加下划线、会导致编译找不到类
