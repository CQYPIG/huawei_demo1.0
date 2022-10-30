<template>
	<div id="divfooterover">

		<!-- 底部 -->


		<div class="footer-container">
			<div id="divfooter">
				<div class="row">

					<div class="col">
						<ul class="footerItemCon">
							<p>购物指南</p>
							<li>免息分期</li>
							<li>以旧换新</li>
							<li>众测活动</li>
							<li>企业购</li>
							<li>O2O采购</li>
						</ul>

					</div>
					<div class="col">
						<ul class="footerItemCon">
							<p>售后服务</p>
							<li>门店维修</li>
							<li>保修政策</li>
							<li>防伪查询</li>
							<li>退换货政策</li>
							<li>手机寄修服务</li>
							<li>维修备件价格查询</li>
						</ul>
					</div>
					<div class="col">
						<ul class="footerItemCon">
							<p>维修与技术支持</p>
							<li>服务店</li>
							<li>预约维修</li>
							<li>手机寄修</li>
							<li>备件价格查询</li>
							<li>上门服务</li>
						</ul>
					</div>
					<div class="col">
						<ul class="footerItemCon">
							<p>特色服务</p>
							<li>防伪查询</li>
							<li>补购保障</li>
							<li>以旧换新</li>
							<li>礼品包装</li>
						</ul>
					</div>
					<div class="col">
						<ul class="footerItemCon">
							<p>关于我们</p>
							<li>公司介绍</li>
							<li>华为零售店</li>
							<li>商家中心</li>
							<li>意见反馈</li>
						</ul>
					</div>
					<div class="col">
						<ul class="footerItemCon">
							<p>友情链接</p>
							<li>华为集团</li>
							<li>华为零售店</li>
							<li>华为CBG官网</li>
							<li>花粉俱乐部</li>
							<li>华为云</li>
							<li>华为应用市场</li>
						</ul>
					</div>
					<div class="col bttn">
						<h5>950805</h5>
						<p>7 x 24 小时客服热线</p>
						<router-link to="/">

							<button class="btn btn-dark rounded-pill">在线客服</button><br>

						</router-link>
						<img src="./images/logo_app.png">
					</div>
				</div>
			</div>
		</div>
		<div id="divfooter">
			<div class="row">
				<div class="col-2">
					<img src="./images/logo_app.png" alt="" srcset="">
				</div>
				<div class="col footer-small">
					<div class="row">
						华为集团
						华为CBG官网
						花粉俱乐部
						华为应用市场
						HarmonyOS
						华为终端云空间
						开发者联盟
						华为商城手机版
						网站地图
					</div>
					<div class="row">隐私声明 服务协议 COOKIES Copyright © 2012-2022 华为终端有限公司 版权所有 粤ICP备19015064号|粤公网安备
						44190002003939号</div>
					<div class="row">
						增值电信业务经营许可证：粤B2-20190762|备案主体编号：44201919072182|粤新出网备（2021）2号|（粤）网械平台备字[2022]第00005号</div>
					<div class="row">互联网药品信息服务资格证（粤）-非经营性-2020-0102 | 粤东食药监械经营备20203930 | 广东省网络食品交易第三方平台备案：GDWS10168
					</div>

				</div>
				<div class="col-1">
				</div>
			</div>
		</div>
	</div>

</template>

<script>
export default {
	//给组件起一个名字,开发者工具中显示这个组件的时候，显示的就是这个名字
	name: "Footer",
};
</script>

<style scoped>
/* footer */
#divfooterover{
	/* background: rgb(247, 244, 244); */
	border-top: solid 1px rgb(225,225,226);
}
#divfooter {
	width: 1200px;
	margin: 0 auto;
	overflow: hidden;
}

#divfooter {
	width: 1200px;
	margin: 0 auto;
	overflow: hidden;
}

.footer-container p {
	margin-top: 10px;
	font-size: 12px;
}

.footerItemCon li {
	list-style-type: none;
	color: darkgray;
	font-size: 10px;
}

img {
	width: 100px;
}

.footer-small {
	font-size: 8px;
	color: darkgray;
}

.bttn .btn:focus,
.bttn .btn.focus {
	box-shadow: none !important;
}

.bttn {
	padding-top: 5px;
}

/* .jumbotron{
	border-top: 1px solid rgb(226, 226, 226);
} */
</style>
