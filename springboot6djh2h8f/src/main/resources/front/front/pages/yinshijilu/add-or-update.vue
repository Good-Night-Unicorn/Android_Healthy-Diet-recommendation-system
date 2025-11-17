<template>
<view class="content">
	<view :style='{"minHeight":"100vh","width":"100%","padding":"24rpx","position":"relative","background":"#fff3e8","height":"auto"}'>
		<form :style='{"width":"100%","padding":"48rpx 0 48rpx","background":"none","display":"block","height":"auto"}' class="app-update-pv">
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#dfdfdf","alignItems":"center","borderRadius":"0px","borderWidth":"0px 0 2rpx 0","background":"none","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","color":"#666","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">记录标题</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.jilubiaoti" v-model="ruleForm.jilubiaoti" placeholder="记录标题"  type="text"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#dfdfdf","alignItems":"center","borderRadius":"0px","borderWidth":"0px 0 2rpx 0","background":"none","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="" @tap="tupianTap">
				<view :style='{"padding":"0 20rpx 0 0","color":"#666","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">图片</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-if="ruleForm.tupian" :src="baseUrl+ruleForm.tupian.split(',')[0]" mode="aspectFill"></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#dfdfdf","alignItems":"center","borderRadius":"0px","borderWidth":"0px 0 2rpx 0","background":"none","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 20rpx 0 0","color":"#666","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">记录类型</view>
				<picker :disabled="ro.jiluleixing" :style='{"width":"100%","flex":"1","height":"auto"}' @change="jiluleixingChange" :value="jiluleixingIndex" :range="jiluleixingOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"30rpx","color":"#fa861c"}' class="uni-input">{{ruleForm.jiluleixing?ruleForm.jiluleixing:"请选择记录类型"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#dfdfdf","alignItems":"center","borderRadius":"0px","borderWidth":"0px 0 2rpx 0","background":"none","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 20rpx 0 0","color":"#666","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">记录时间</view>
				<picker  :disabled="ro.jilushijian" :style='{"width":"100%","flex":"1","height":"auto"}' mode="date" :value="ruleForm.jilushijian" @change="jilushijianChange">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"30rpx","color":"#fa861c"}' class="uni-input">{{ruleForm.jilushijian?ruleForm.jilushijian:"请选择记录时间"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#dfdfdf","alignItems":"center","borderRadius":"0px","borderWidth":"0px 0 2rpx 0","background":"none","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","color":"#666","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">分量</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.fenliang" v-model="ruleForm.fenliang" placeholder="分量"  type="text"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#dfdfdf","alignItems":"center","borderRadius":"0px","borderWidth":"0px 0 2rpx 0","background":"none","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","color":"#666","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">饮食热量</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.yinshireliang" v-model.number="ruleForm.yinshireliang" placeholder="饮食热量" type="digit"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#dfdfdf","alignItems":"center","borderRadius":"0px","borderWidth":"0px 0 2rpx 0","background":"none","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","color":"#666","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">账号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.zhanghao" v-model="ruleForm.zhanghao" placeholder="账号"  type="text"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#dfdfdf","alignItems":"center","borderRadius":"0px","borderWidth":"0px 0 2rpx 0","background":"none","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","color":"#666","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">姓名</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.xingming" v-model="ruleForm.xingming" placeholder="姓名"  type="text"></input>
			</view>
         
			<view :style='{"padding":"10rpx 20rpx","margin":"0","borderColor":"#1ccb96","borderRadius":"20rpx","borderWidth":"0px 0","background":"none","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"30rpx","color":"#666","fontWeight":"500"}' class="title">饮食内容</view>
				<xia-editor ref="yinshineirong" :style='{"minHeight":"300rpx","border":"2rpx solid #dfdfdf","padding":"20rpx","borderRadius":"20rpx","width":"100%","fontSize":"30rpx","height":"auto"}' v-model="ruleForm.yinshineirong" placeholder="饮食内容" @editorChange="yinshineirongChange"></xia-editor>
			</view>
			
			<view :style='{"width":"100%","margin":"40rpx 0","flexDirection":"column","justifyContent":"center","display":"flex","height":"auto"}' class="btn" >
				<button :style='{"border":"0","padding":"0","margin":"0 0 40rpx 0","color":"rgb(255, 255, 255)","borderRadius":"16rpx","background":"#fa861c","width":"100%","lineHeight":"96rpx","fontSize":"30rpx","height":"96rpx"}' @tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

	</view>
</view>
</template>

<script>
	import wPicker from "@/components/w-picker/w-picker.vue";
	import xiaEditor from '@/components/xia-editor/xia-editor';
	import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
				cross:'',
				ruleForm: {
				jilubiaoti: '',
				tupian: '',
				jiluleixing: '',
				jilushijian: '',
				fenliang: '',
				yinshireliang: '',
				yinshineirong: '',
				zhanghao: '',
				xingming: '',
				},
				jiluleixingOptions: [],
				jiluleixingIndex: 0,
				// 登录用户信息
				user: {},
				ro:{
				   jilubiaoti : false,
				   tupian : false,
				   jiluleixing : false,
				   jilushijian : false,
				   fenliang : false,
				   yinshireliang : false,
				   yinshineirong : false,
				   zhanghao : false,
				   xingming : false,
				},
				virtualPay: false,
			}
		},
		components: {
			wPicker,
			xiaEditor,
			multipleSelect,
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},



		},
		async onLoad(options) {
			if(options.virtualPay){
				this.virtualPay = true
			}
			this.ruleForm.jilushijian = this.$utils.getCurDate();
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			
			// ss读取
			this.ruleForm.zhanghao = this.user.zhanghao
			this.ro.zhanghao = true;
			this.ruleForm.xingming = this.user.xingming
			this.ro.xingming = true;


			// 自定义下拉框值
			this.jiluleixingOptions = "早餐,午餐,晚餐".split(',')

			// 如果有登录，获取登录后保存的userid
			this.ruleForm.userid = uni.getStorageSync("appUserid")
			if (options.refid) {
				// 如果上一级页面传递了refid，获取改refid数据信息
				this.ruleForm.refid = Number(options.refid);
				this.ruleForm.nickname = uni.getStorageSync("nickname");
			}
			// 如果是更新操作
			if (options.id) {
				this.ruleForm.id = options.id;
				// 获取信息
				res = await this.$api.info(`yinshijilu`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			this.cross = options.cross;
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
					if(o=='jilubiaoti'){
						this.ruleForm.jilubiaoti = obj[o];
						this.ro.jilubiaoti = true;
						continue;
					}
					if(o=='tupian'){
						this.ruleForm.tupian = obj[o].split(",")[0];
						this.ro.tupian = true;
						continue;
					}
					if(o=='jiluleixing'){
						this.ruleForm.jiluleixing = obj[o];
						this.ro.jiluleixing = true;
						continue;
					}
					if(o=='jilushijian'){
						this.ruleForm.jilushijian = obj[o];
						this.ro.jilushijian = true;
						continue;
					}
					if(o=='fenliang'){
						this.ruleForm.fenliang = obj[o];
						this.ro.fenliang = true;
						continue;
					}
					if(o=='yinshireliang'){
						this.ruleForm.yinshireliang = obj[o];
						this.ro.yinshireliang = true;
						continue;
					}
					if(o=='yinshineirong'){
						this.ruleForm.yinshineirong = obj[o];
						this.ro.yinshineirong = true;
						continue;
					}
					if(o=='zhanghao'){
						this.ruleForm.zhanghao = obj[o];
						this.ro.zhanghao = true;
						continue;
					}
					if(o=='xingming'){
						this.ruleForm.xingming = obj[o];
						this.ro.xingming = true;
						continue;
					}
				}
			}
			this.styleChange()
			this.$forceUpdate()
			if (uni.getStorageSync('raffleType') && uni.getStorageSync('raffleType') != null) {
				uni.removeStorageSync('raffleType')
				setTimeout(() => {
					this.onSubmitTap()
				}, 300)
			}
		},
		methods: {
			yinshineirongChange(e) {
				this.ruleForm.yinshineirong = e
			},
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.app-update-pv . .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.addUpdateForm.input.content.backgroundColor
					// })
				})
			},

			// 多级联动参数

			jilushijianChange(e) {
				this.ruleForm.jilushijian = e.target.value;
				this.$forceUpdate();
			},


			// 下拉变化
			jiluleixingChange(e) {
				this.jiluleixingIndex = e.target.value
				this.ruleForm.jiluleixing = this.jiluleixingOptions[this.jiluleixingIndex]
			},

			tupianTap() {
				let _this = this;
				if(this.ro.tupian){
					return false
				}
				this.$api.upload(function(res) {
					_this.ruleForm.tupian = 'upload/' + res.file;
					_this.$forceUpdate();
					_this.$nextTick(()=>{
						_this.styleChange()
					})
				});
			},

			getUUID () {
				return new Date().getTime();
			},
			async onSubmitTap() {
				let that = this
				//跨表计算判断
				var obj;
				if(this.ruleForm.yinshireliang&&(!this.$validate.isNumber(this.ruleForm.yinshireliang))){
					this.$utils.msg(`饮食热量应输入数字`);
					return
				}
				//更新跨表属性
				var crossuserid;
				var crossrefid;
				var crossoptnum;
				if(this.cross){
					var statusColumnName = uni.getStorageSync('statusColumnName');
					var statusColumnValue = uni.getStorageSync('statusColumnValue');
					if(statusColumnName!='') {
						if(!obj) {
							obj = uni.getStorageSync('crossObj');
						}
						if(!statusColumnName.startsWith("[")) {
							for (var o in obj){
								if(o==statusColumnName){
									obj[o] = statusColumnValue;
								}

							}
							var table = uni.getStorageSync('crossTable');
							await this.$api.update(`${table}`, obj);
						} else {
							   crossuserid=Number(uni.getStorageSync('appUserid'));
							   crossrefid=obj['id'];
							   crossoptnum=uni.getStorageSync('statusColumnName');
							   crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
						}
					}
				}
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid=crossuserid;
					this.ruleForm.crossrefid=crossrefid;
					let params = {
						page: 1,
						limit:10,
						crossuserid:crossuserid,
						crossrefid:crossrefid,
					}
					let res = await this.$api.list(`yinshijilu`, params);
					if (res.data.total >= crossoptnum) {
						this.$utils.msg(uni.getStorageSync('tips'));
						uni.removeStorageSync('crossCleanType');
						return false;
					} else {
				//跨表计算
						let oet = {}
						if(this.ruleForm.id){
							await this.$api.update(`yinshijilu`, this.ruleForm);
						}else{
							oet = await this.$api.add(`yinshijilu`, this.ruleForm);
						}
						if(this.cross){
							uni.setStorageSync('crossCleanType',true);
						}
						this.$utils.msgBack('提交成功');
					}
				} else {
				//跨表计算
					let oet = {}
					if(this.ruleForm.id){
						await this.$api.update(`yinshijilu`, this.ruleForm);
					}else{
						oet = await this.$api.add(`yinshijilu`, this.ruleForm);
					}
					if(this.cross){
						uni.setStorageSync('crossCleanType',true);
					}
					this.$utils.msgBack('提交成功');
				}
			},
			optionsChange(e) {
				this.index = e.target.value
			},
			bindDateChange(e) {
				this.date = e.target.value
			},
			getDate(type) {
				const date = new Date();
				let year = date.getFullYear();
				let month = date.getMonth() + 1;
				let day = date.getDate();
				if (type === 'start') {
					year = year - 60;
				} else if (type === 'end') {
					year = year + 2;
				}
				month = month > 9 ? month : '0' + month;;
				day = day > 9 ? day : '0' + day;
				return `${year}-${month}-${day}`;
			},
			toggleTab(str) {
				if(this.ro[str]){
					return false
				}
				this.$refs[str].show();
			},
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
