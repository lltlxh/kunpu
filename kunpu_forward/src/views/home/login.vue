<template>
  <el-dialog v-model="visible" @close="close" destroy-on-close align-center width="30%">
    <div>
      <div style="
          padding: 20px 0px 60px 0px;
          text-align: center;
          color: #c7cfd6;
          font-size: 50px;
          font-weight: bold;
          letter-spacing: 3px;
        ">KUNPU
      </div>
      <el-form ref="loginForm" :model="loginUser" :rules="rulesLog" size="large" label-position="right" label-width="70px"
        style="width: 360px; margin: 0px auto" v-show="ifLog">
        <el-form-item label="账号" prop="userName">
          <el-input v-model="loginUser.userName"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="pwd">
          <el-input type="password" v-model="loginUser.pwd" show-password></el-input>
        </el-form-item>
        <el-form-item label="验证码" prop="verificationCode">
          <el-input v-model="loginUser.verificationCode" style="width: 200px;">
            <template #suffix>
              <el-image style="overflow: visible; position: relative; left: 110px;" :src="codeSrc" @click="getCode"></el-image>
            </template>
          </el-input>
        </el-form-item>
      </el-form>
      <el-form ref="regForm" :model="regUser" :rules="rulesReg" size="large" label-position="right" label-width="70px"
        style="width: 360px; margin: 0px auto" v-show="ifReg">
        <el-form-item label="账号" prop="userName">
          <el-input v-model="regUser.userName"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="pwd">
          <el-input type="password" v-model="regUser.pwd" show-password></el-input>
        </el-form-item>
        <el-form-item label="再次确认密码" prop="pwdAgain">
          <el-input type="passwordAgain" v-model="regUser.pwdAgain" show-password></el-input>
        </el-form-item>
      </el-form>
      <div style="text-align: center; width: 100%; margin: 40px auto 0px">
        <el-button @click="login" type="primary" size="large" style="width: 40%" v-show="ifLog">登录</el-button>
        <el-button @click="toSign" type="primary" size="large" style="width: 40%" v-show="ifLog">注册</el-button>
        <el-button @click="register" type="primary" size="large" style="width: 40%;" v-show="ifReg">确认</el-button>
        <el-button @click="toLog" type="primary" size="large" style="width: 40%;" v-show="ifReg">返回</el-button>
      </div>
    </div>
  </el-dialog>
</template>

<script setup>
import { reactive, ref } from "vue";
import { useRouter } from "vue-router";
import { get, post, tip, setLocalToken, API_BASE_URL } from "@/common";
//import { sign } from "crypto";

const visible = ref(false);
const ifLog = ref(true);
const ifReg = ref(false);
const emit = defineEmits(["ok"]);

const loginForm = ref();
const regForm = ref();

const router = useRouter(); // 获取路由器

const loginUser = reactive({
  userName: "",
  pwd: "",
  verificationCode: "",
  verificationKey: "",
});
const regUser = reactive({
  userName: "",
  pwd: "",
  pwdAgain: "",
})

// 验证码后台接口
// const codeSrc = ref(API_BASE_URL + "/captcha/captchaImage");
const codeSrc = ref(); // 验证码图片url
// 获取验证码
const getCode = () => {
  get('/captcha/captchaImage').then(res => {
    // 图片的src属性显示为：前缀+后台传递的Base64验证码图片编码
    // 验证码可以正常显示
    codeSrc.value = 'data:image/jpg;base64,' + res.data.imgUrl;
    loginUser.verificationKey = res.data.imgKey; // redis存储验证码的key
  })
}
getCode();

const rulesLog = reactive({
  userName: [
    {
      required: true,
      message: "请输入账号！",
      trigger: "blur"
    },
  ],
  pwd: [
    {
      required: true,
      message: "请输入密码！",
      trigger: "blur"
    },
  ],
  verificationCode: [
    {
      min: 4,
      max: 4,
      required: true,
      message: "请输入正确的验证码！",
      trigger: "blur"
    }
  ]
});
const rulesReg = reactive({
  userName: [
    {
      required: true,
      message: "请输入账号！",
      trigger: "blur"
    },
  ],
  pwd: [
    {
      required: true,
      message: "请输入密码！",
      trigger: "blur"
    },
  ],
  pwdAgain: [
    {
      required: true,
      message: "请确认密码！",
      trigger: "blur"
    },
  ],
});

// 回车登录
window.onkeydown = ($event) => {
  if ($event.key && $event.key == 'Enter') {
    login();
  }
}

const login = () => {
  loginForm.value.validate((valid) => {
    if (valid) {
      // 向服务端发出post请求
      post("/role/role-login", loginUser).then(result => {
        // 从回送结果中取出令牌，并将令牌存于客户端
        setLocalToken(result.data);
        tip.success("登录成功！");
        // 通过路由导航到home页面
        emit("ok");
        visible.value = false;
        // router.push({ path: "/home" });  
      });
    }
  });
};

const register = () => {
  regForm.value.validate((valid) => {
    if (valid) {
      // 向服务端发出post请求
      post("/role/role-register", regUser).then(result => {
        // 从回送结果中取出令牌，并将令牌存于客户端
        setLocalToken(result.data);
        tip.success("注册成功！");
        emit("ok");
        visible.value = false;
        // router.push({ path: "/home" });
      });
    }
  });
}

const toSign = () => {
  ifLog.value = false;
  ifReg.value = true;
}

const toLog = () => {
  ifLog.value = true;
  ifReg.value = false;
}

const close = () => {
  loginUser.userName = "",
    loginUser.pwd = "",
    visible.value = false;
}

const open = () => {
  visible.value = true;
}
defineExpose({ open });
</script>


<style scoped>

</style>
