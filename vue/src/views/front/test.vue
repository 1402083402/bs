<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>文本框中的验证码</title>
  <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
  <script src="https://unpkg.com/vue/dist/vue.js"></script>
  <script src="https://unpkg.com/element-ui/lib/index.js"></script>
  <style>
    body {
      font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
      background-color: #f4f4f4;
    }

    .el-row {
      margin-bottom: 20px;
    }

    .el-col {
      padding: 10px;
    }

    h1 {
      font-size: 32px;
      font-weight: 700;
      text-align: center;
      margin-top: 50px;
      margin-bottom: 50px;
    }

    .text-content {
      font-size: 16px;
      line-height: 1.6;
      margin-bottom: 30px;
    }
  </style>
</head>
<body>
<div id="app">
  <el-container>
    <el-header>
      <h1>文本框中的验证码</h1>
    </el-header>
    <el-main>
      <el-row>
        <el-col :span="12" :offset="6">
          <el-form>
            <el-form-item label="验证码">
              <el-input placeholder="请输入验证码"></el-input>
            </el-form-item>
          </el-form>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12" :offset="6">
          <div class="text-content">
            <p>
              验证码是指通过一些手段来防止非人类操作的程序，比如自动化的脚本、恶意软件等等。验证码可以防止机器人的恶意攻击和垃圾信息的注册，保障了用户的合法权益和安全。
            </p>
            <p>
              验证码通常被应用在需要用户登录、注册、找回密码等操作的网站和应用程序中，它可以有效地防止机器恶意攻击、垃圾信息注册等问题，保障了用户的合法权益和安全。
            </p>
            <p>
              在某些应用场景中，验证码还可以使用语音或图形等方式进行验证，以增加识别难度，提高安全性。
            </p>
          </div>
        </el-col>
      </el-row>
    </el-main>
    <el-footer>
      <p style="text-align: center;">&copy; 2023</p>
    </el-footer>
  </el-container>
</div>
</body>
</html>
