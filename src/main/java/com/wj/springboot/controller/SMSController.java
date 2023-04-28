//package com.wj.springboot.controller;
//
//import com.wj.springboot.utils.SmsComponent;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.UUID;
//import java.util.concurrent.TimeUnit;
//
//@RestController
//public class SMSController {
//
//    @Autowired
//    private SmsComponent smsComponent;
//    @Autowired
//    StringRedisTemplate stringRedisTemplate;
//    /**
//     * 调用短信服务商提供的短信API发送短信
//     */
//    @GetMapping("/sms/sendcode")
//    public void sendSmsCode(@RequestParam("phone") String phone){
//        // 生成随机的验证码
//        String code = UUID.randomUUID().toString().substring(0, 5);
//        stringRedisTemplate.opsForValue().set("phoneCode",code,600, TimeUnit.SECONDS);
//        smsComponent.sendSmsCode(phone+"phoneCode",code);
//        ThreadLocal<String> threadLocal = new ThreadLocal<String>();
//        threadLocal.set(phone);
//
//    }
//    @GetMapping("/sms/verify")
//    public String phoneVerify(String code)
//    {
//        String phone=new ThreadLocal<String>().get();
//        String c = stringRedisTemplate.opsForValue().get((phone + "phoneCode"));
//
//        if (!StringUtils.isEmpty(code))
//        {
//            if (code.equals(c))
//            {
//                stringRedisTemplate.delete(phone + "phoneCode");
//                return "通过";
//            }
//        }
//
//            return "不通过";
//    }
//}