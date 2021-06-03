package com.evol.protobuftest.util;

import java.io.File;
import java.io.IOException;

public class ProtoGenerator {

    public static void main(String[] args) {
        File file1 = new File("./src/main/java/com/example/protobuftest/domain");
        File file2 = new File("./src/main/java/com/example/protobuftest/protos/");
        if(!file1.exists()){
            System.out.println("目录不存在：" + file1.getAbsolutePath());
            return;
        }
        if(!file2.exists()){
            System.out.println("目录不存在：" + file2.getAbsolutePath());
            return;
        }
        String strCmd = "protoc --proto_path=./src/main/java/com/example/protobuftest/protos --java_out=" +
                "./src/main/java ./src/main/java/com/example/protobuftest/protos/*.proto";
        try {
            Process process = Runtime.getRuntime().exec(strCmd);
            process.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }//通过执行cmd命令调用protoc.exe进程

    }

}
