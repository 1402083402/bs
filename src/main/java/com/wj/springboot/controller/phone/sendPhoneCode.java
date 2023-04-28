package com.wj.springboot.controller.phone;

import com.wj.springboot.entity.phoneCode;
import com.wj.springboot.utils.HttpUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class sendPhoneCode {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @PostMapping("/sendPhoneCode")
    public void sendCode(@RequestBody phoneCode phone)
 {
     String code = UUID.randomUUID().toString().substring(0, 5);
        String host = "https://dfsns.market.alicloudapi.com";
        String path = "/data/send_sms";
        String method = "POST";
        String appcode = "51070d83172c4851a730541e1de330da";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("content", "code:"+code);
        bodys.put("phone_number", phone.getPhone());
        bodys.put("template_id", "TPL_0000");


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        stringRedisTemplate.opsForValue().set(phone.getPhone(),code,600, TimeUnit.SECONDS);

 }
    @PostMapping("/phoneCode/varify")
    public String varifyPhoneCode(@RequestBody phoneCode code){


        String phone = code.getPhone();

        String phoneCode = stringRedisTemplate.opsForValue().get(phone);
        if (!StringUtils.isEmpty(code.getCode())&&!StringUtils.isEmpty(phoneCode))
        {
            if (code.getCode().equals(phoneCode))
            {
                return "通过";
            }
        }
        return "不通过";
    }
}
