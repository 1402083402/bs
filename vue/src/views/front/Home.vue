<template>
  <div>
    <div style="margin: 10px 0">
      <el-carousel height="450px" :interval="10000">
        <el-carousel-item v-for="item in imgs" :key="item">
          <img :src="item" alt="" style="width: 100%">
        </el-carousel-item>
      </el-carousel>
    </div>

    <section>
      <h2>什么是验证码？</h2>
      <p>
        验证码，全称为“图像验证码”或“字符验证码”，是一种计算机程序用来确认网站用户是否为真实人类的测试。验证码是由一系列
        随机生成的文字、数字、图形等元素组成的图片，用户需要通过正确地输入验证码才能进行一些操作，如注册、登录等。
      </p>
    </section>
    <section>
      <h2>验证码分类</h2>
      <ul>
        <li>字符验证码：由一组随机生成的字母、数字组成的图片，需要用户正确输入。</li>
        <li>图形验证码：由一组随机生成的图形元素组成的图片，需要用户正确输入。</li>
        <li>滑动验证码：需要用户在图片上进行滑动操作以通过验证。</li>
        <li>点击验证码：需要用户在指定的区域内点击正确的元素以通过验证。</li>
      </ul>
    </section>
    <section>
      <h2>验证码生成</h2>
      <p>
        验证码的生成方式有多种，常见的方式包括：
      </p>
      <ul>
        <li>随机数生成：使用随机数生成算法生成一组随机的字母、数字等元素组成的图片。</li>
        <li>图形扭曲：在随机数生成的基础上，对图片进行一定程度的扭曲、干扰，增加图像识别的难度。</li>
        <li>语音验证码：通过播放数字或字母等的语音，让用户听到并输入正确的信息。</li>
      </ul>
    </section>
    <section>
      <h2>使用场景</h2>
      <p>
        验证码广泛应用于需要用户登录、注册、找回密码等操作的网站和应用程序中，它可以有效地防止机器恶意攻击、
        垃圾信息注册等问题，保障了用户的合法权益和安全。
      </p>
    </section>
    <section>
      <h2>常见问题</h2>
      <p>以下是一些关于验证码的常见问题：</p>
      <ul>
        <li>为什么要使用验证码？</li>
        <li>验证码容易被攻破吗？</li>
        <li>验证码对用户有什么影响？</li>
        <li>如何设计更好的验证码？</li>
      </ul>
    </section>
  </div>


</template>

<script>
export default {
  name: "FrontHome",
  data() {
    return {
      imgs: [
        'https://camo.githubusercontent.com/012bd7199b4303a6ed1ce4566c8b456af24f0dc914e6d5174d20aed0ed3398fd/68747470733a2f2f63646e2e72616d6f73746561722e636f6d2f32303230303531372d32633163613765353538643234373862396133366339386534653236666164392e676966',
        'https://camo.githubusercontent.com/da2b78ffff9ddf035fa12c0baaef0be2d8a36db8309a02f633b14c1ebcbba363/68747470733a2f2f63646e2e72616d6f73746561722e636f6d2f32303230303531372d32613438366166643137306234306531383464363830393465383538306131652e676966'
      ],
      files: []
    }
  },

  methods: {

  }
}
</script>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  font-family: 'Helvetica Neue', 'Helvetica', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei', sans-serif;
  color: #333;
}

.container {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

header {
  text-align: center;
  margin-bottom: 40px;
}

h1 {
  font-size: 48px;
  font-weight: bold;
  color: #0084ff;
}

h2 {
  font-size: 28px;
  font-weight: bold;
  color: #0084ff;
  margin-bottom: 20px;
}

p {
  font-size: 16px;
  line-height: 1.5;
  margin-bottom: 20px;
}

ul {
  font-size: 16px;
  line-height: 1.5;
  margin-bottom: 20px;
  list-style: disc;
  padding-left: 30px;
}

li {
  margin-bottom: 10px;
}

a {
  color: #0084ff;
  text-decoration: none;
  transition: all 0.3s ease;
}

a:hover {
  color: #0062cc;
}

.text-center {
  text-align: center;
}

.btn {
  display: inline-block;
  padding: 10px 20px;
  background-color: #0084ff;
  color: #fff;
  border-radius: 5px;
  transition: all 0.3s ease;
}

.btn:hover {
  background-color: #0062cc;
}
</style>
