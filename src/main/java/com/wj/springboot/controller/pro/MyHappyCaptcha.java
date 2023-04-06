package com.wj.springboot.controller.pro;


import com.ramostear.captcha.common.Fonts;
import com.ramostear.captcha.core.AnimCaptcha;
import com.ramostear.captcha.core.Captcha;
import com.ramostear.captcha.support.CaptchaStyle;
import com.ramostear.captcha.support.CaptchaType;
import com.wj.springboot.controller.redis.MyJedis;
import org.springframework.data.redis.core.StringRedisTemplate;


import java.awt.Font;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHappyCaptcha  {
    @Resource
    StringRedisTemplate redisTemplate;
    public static final String SESSION_KEY = "happy-captcha";
    private CaptchaType type;
    private CaptchaStyle style;
    private Font font;
    private int width;
    private int height;
    private int length;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public static MyHappyCaptcha.Builder require(HttpServletRequest request, HttpServletResponse response) {
        return new MyHappyCaptcha.Builder(request, response);
    }

    public boolean finish() {
        try {
            boolean flag = false;
            if (this.style.equals(CaptchaStyle.IMG)) {
                Captcha captcha = new Captcha();
                captcha.setType(this.type);
                captcha.setWidth(this.width);
                captcha.setHeight(this.height);
                captcha.setLength(this.length);
                captcha.setFont(this.font);
                this.setHeader(this.response);
                this.request.getSession().setAttribute("happy-captcha", captcha.getCaptchaCode());
                MyJedis myJedis = new MyJedis();
                myJedis.initJedis();
                myJedis.jedis.set("happy-captcha",captcha.getCaptchaCode());
                //redisTemplate.opsForValue().set("happy-captcha",captcha.getCaptchaCode());
                myJedis.jedis.close();
                captcha.render(this.response.getOutputStream());
                return true;
            } else if (this.style.equals(CaptchaStyle.ANIM)) {
                AnimCaptcha captcha = new AnimCaptcha();
                captcha.setType(this.type);
                captcha.setWidth(this.width);
                captcha.setHeight(this.height);
                captcha.setLength(this.length);
                captcha.setFont(this.font);
                this.setHeader(this.response);
                MyJedis myJedis = new MyJedis();
                myJedis.initJedis();
                myJedis.jedis.set("happy-captcha",captcha.getCaptchaCode());
                //this.request.getSession().setAttribute("happy-captcha", captcha.getCaptchaCode());
                myJedis.jedis.close();
                captcha.render(this.response.getOutputStream());
                return true;
            } else {
                return false;
            }
        } catch (Exception var3) {
            var3.printStackTrace();
            return false;
        }
    }

    public static boolean verification(HttpServletRequest request, String code, boolean ignoreCase) {
        if (code != null && !code.trim().equals("")) {
            String captcha = (String)request.getSession().getAttribute("happy-captcha");
            return ignoreCase ? code.equalsIgnoreCase(captcha) : code.equals(captcha);
        } else {
            return false;
        }
    }

    public static void remove(HttpServletRequest request) {
        request.getSession().removeAttribute("happy-captcha");
    }

    public void setHeader(HttpServletResponse response) {
        response.setContentType("image/gif");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0L);
    }

    private MyHappyCaptcha(MyHappyCaptcha.Builder builder) {
        this.type = builder.type;
        this.style = builder.style;
        this.font = builder.font;
        this.width = builder.width;
        this.height = builder.height;
        this.length = builder.length;
        this.request = builder.request;
        this.response = builder.response;
    }

    public static class Builder {
        private CaptchaType type;
        private CaptchaStyle style;
        private Font font;
        private int width;
        private int height;
        private int length;
        private final HttpServletRequest request;
        private final HttpServletResponse response;

        public Builder(HttpServletRequest request, HttpServletResponse response) {
            this.type = CaptchaType.DEFAULT;
            this.style = CaptchaStyle.IMG;
            this.font = Fonts.getInstance().defaultFont();
            this.width = 160;
            this.height = 50;
            this.length = 5;
            this.request = request;
            this.response = response;
        }

        public MyHappyCaptcha build() {
            return new MyHappyCaptcha(this);
        }

        public MyHappyCaptcha.Builder type(CaptchaType type) {
            this.type = type;
            return this;
        }

        public MyHappyCaptcha.Builder style(CaptchaStyle style) {
            this.style = style;
            return this;
        }

        public MyHappyCaptcha.Builder width(int width) {
            this.width = width;
            return this;
        }

        public MyHappyCaptcha.Builder height(int height) {
            this.height = height;
            return this;
        }

        public MyHappyCaptcha.Builder length(int length) {
            this.length = length;
            return this;
        }

        public MyHappyCaptcha.Builder font(Font font) {
            this.font = font;
            return this;
        }
    }
}
