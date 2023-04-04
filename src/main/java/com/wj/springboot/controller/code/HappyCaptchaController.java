package com.wj.springboot.controller.code;

import com.ramostear.captcha.HappyCaptcha;
import com.ramostear.captcha.support.CaptchaStyle;
import com.ramostear.captcha.support.CaptchaType;
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

            HappyCaptcha.require(request,response)
                    .style(CaptchaStyle.ANIM)
                    .type(CaptchaType.ARITHMETIC_ZH)
                    .build().finish();
        }


        @GetMapping("/arithmetic/verify")
        public String arithmeticVerify(String verifyCode, HttpServletRequest request) {

            boolean aBoolean = HappyCaptcha.verification(request,verifyCode,true);
            if (aBoolean){
                HappyCaptcha.remove(request);
                return "通过";
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

            HappyCaptcha.require(request,response)
                    .style(CaptchaStyle.ANIM)
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

            HappyCaptcha.require(request,response)
                    .style(CaptchaStyle.ANIM)
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

            HappyCaptcha.require(request,response)
                    .style(CaptchaStyle.ANIM)
                    .type(CaptchaType.NUMBER)
                    .build().finish();
        }
}
