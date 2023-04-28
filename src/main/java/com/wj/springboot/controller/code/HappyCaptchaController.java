package com.wj.springboot.controller.code;
import com.ramostear.captcha.support.CaptchaStyle;
import com.ramostear.captcha.support.CaptchaType;
import com.wj.springboot.controller.pro.MyHappyCaptcha;
import com.wj.springboot.controller.redis.MyJedis;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



    @RestController
    @RequestMapping("/captcha")
    public class HappyCaptchaController {



        /**
         * 算术验证码
         * @param request
         * @param response
         */
        @GetMapping("/arithmetic/generator")
        public void arithmeticCode(HttpServletRequest request, HttpServletResponse response) {

             MyHappyCaptcha.require(request, response)
                    .style(CaptchaStyle.IMG)
                    .type(CaptchaType.ARITHMETIC_ZH)
                    .build().finish();


        }


        @GetMapping("/arithmetic/verify")
        public String arithmeticVerify(String verifyCode, HttpServletRequest request) {
   if (verifyCode!=null)
   {
       MyJedis myJedis=new MyJedis();
       myJedis.initJedis();
       String code = myJedis.jedis.get("happy-captcha");

       boolean aBoolean = verifyCode.equals(code);
       if (aBoolean){
           myJedis.jedis.del("happy-captcha");
           myJedis.jedis.close();
           return "通过";
       }
       myJedis.jedis.close();
   }
            return "不通过";
        }


        /**
         * 数字字母混合
         * @param request
         * @param response
         */
        @GetMapping("/alphanumericMixing/generator")
        public void alphanumericMixingCode(HttpServletRequest request, HttpServletResponse response) {

            MyHappyCaptcha.require(request,response)
                    .style(CaptchaStyle.IMG)
                    .type(CaptchaType.DEFAULT)
                    .build().finish();
        }

        /**
         * 数字算术验证码
         * @param request
         * @param response
         */
        @GetMapping("/alphanumeric/generator")
        public void alphanumericCode(HttpServletRequest request, HttpServletResponse response) {

            MyHappyCaptcha.require(request,response)
                    .style(CaptchaStyle.IMG)
                    .type(CaptchaType.ARITHMETIC)
                    .build().finish();
        }
        /**
         * 数字验证码
         * @param request
         * @param response
         */
        @GetMapping("/digital/generator")
        public void digitalVerificationCode(HttpServletRequest request, HttpServletResponse response) {

            MyHappyCaptcha.require(request,response)
                    .style(CaptchaStyle.IMG)
                    .type(CaptchaType.NUMBER)
                    .build().finish();
        }
}
