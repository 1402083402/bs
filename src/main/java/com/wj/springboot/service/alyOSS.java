package com.wj.springboot.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;

import java.io.FileInputStream;
import java.io.InputStream;

import com.aliyun.oss.ClientException;
import org.springframework.web.multipart.MultipartFile;

public class alyOSS {

    public static String uoloadAly(MultipartFile file) throws Exception {
        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        String endpoint = "oss-cn-chengdu.aliyuncs.com";
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = "LTAI5tEDLJuJj6Mjb7MhpRZ9";
        String accessKeySecret = "ZFjmPIHZWUO8w6FcK83CWvTIreqKLQ";
        // 填写Bucket名称，例如examplebucket。
        String bucketName = "wangjiang-mall";
        // 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt。
        String objectName = "exampledir/exampleobject/"+file.getOriginalFilename();
        // 填写本地文件的完整路径，例如D:\\localpath\\examplefile.txt。
        // 如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
        //String filePath= "C:\\Users\\Administrator\\Desktop\\乐子\\api-passenger.md";
        InputStream fileInputStream = file.getInputStream();
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            //InputStream inputStream = new FileInputStream(filePath);
            // 创建PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, fileInputStream);
            // 设置该属性可以返回response。如果不设置，则返回的response为空。
            putObjectRequest.setProcess("true");
            // 创建PutObject请求。
            PutObjectResult result = ossClient.putObject(putObjectRequest);
            //文件url
             String uri = result.getResponse().getUri();
            return uri;

        }finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }
}