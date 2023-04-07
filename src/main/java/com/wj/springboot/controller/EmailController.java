package com.wj.springboot.controller;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.TimeUnit;


@Controller
public class EmailController {
@Autowired
    StringRedisTemplate redisTemplate;
 @PostMapping("/sendEmail")
    public void SendEmail(String email) {
     Integer code =(int) (Math.random()*10000);
     MailUtil.send(email,"你的验证码是"+code,""+code,false);
    redisTemplate.opsForValue().set("EmailCaptcha",code.toString(),600, TimeUnit.SECONDS);
    }
    @ResponseBody
    @GetMapping("/emailVerify")
    public String verify(@RequestParam("code") String code)
    {
        if (!StringUtils.isEmpty(code))
        {
            String emailCaptcha = redisTemplate.opsForValue().get("EmailCaptcha");
            if (!StringUtils.isEmpty(emailCaptcha)&&emailCaptcha.equals(code)){
                redisTemplate.delete("EmailCaptcha");
                return "通过";
            }
        }
        return "不通过";
    }
}