<template>
  <div>
    <div style="margin: 10px 0">
      <el-carousel height="450px" :interval="10000">
        <el-carousel-item v-for="item in imgs" :key="item">
          <img :src="item" alt="" style="width: 100%">
        </el-carousel-item>
      </el-carousel>
    </div>

    <div style="margin: 10px 0">
      <el-row :gutter="10">
        <el-col :span="6" v-for="item in files" :key="item.id" style="margin-bottom: 10px">

          <div style="border: 1px solid #ccc; padding-bottom: 10px">
            <img :src="item.url" alt="" style="width: 100%">
            <div style="color: #666; padding: 10px">{{ item.name }}</div>
            <div style="padding: 10px"><el-button type="primary">详情</el-button></div>
          </div>
        </el-col>
      </el-row>
    </div>
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
  created() {
    this.request.get("/echarts/file/front/all").then(res => {
      console.log(res.data)
      this.files = res.data.filter(v => v.type === 'png' || v.type === 'jpg' || v.type === 'webp')
    })
  },
  methods: {

  }
}
</script>

<style>

</style>
