#protobuf

测试场景：

API接口采用protobuf 序列化方式

过程遇到个坑

springboot 默认不支持 application/x-protobuf  ，需要增加自定义converter

https://www.dazhuanlan.com/2019/11/28/5ddf8dc4b0cfb

https://cloud.tencent.com/developer/article/1504965

protobuf 语法

https://www.cnblogs.com/tohxyblog/p/8974763.html




集成过程

1.本地安装 protobuf 命令行工具

https://github.com/uber/prototool/blob/dev/docs/install.md

2. 编写proto 语法文件

3. 执行生成命令例如

```shell
protoc --proto_path=./src/main/java/com/example/protobuftest/protos --java_out=./src/main/java ./src/main/java/com/example/protobuftest/protos/*.proto

```