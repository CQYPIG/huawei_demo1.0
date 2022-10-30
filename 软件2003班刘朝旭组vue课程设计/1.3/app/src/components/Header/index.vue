// 头部导航栏仓库
<template>
	<div id="divheaderover">
		<div id="divheader">
			<!-- 头部 -->
			<header>
				<!-- 头部的第一行 -->
				<!-- 小屏幕上水平导航栏会切换为垂直的 -->
				<nav class="header  navbar navbar-expand-sm bg-light d-flex justify-content-between bg-dark ">
					<!-- Links -->
					<ul class=" navbar-nav">
						<li class="nav-item">
							<router-link to="/">
								<a class="nav-link text-muted">首页</a>
							</router-link>
						</li>
						<li class="nav-item">
							<router-link to="/">
								<a class="nav-link text-muted " href="#">华为官网</a>
							</router-link>
						</li>
						<li class="nav-item">
							<router-link to="/">
								<a class="nav-link text-muted " href="#">花粉俱乐部</a>
							</router-link>
						</li>
						<li class="nav-item">
							<router-link to="/">
								<a class="nav-link text-muted " href="#">V码(优购码)</a>
							</router-link>
						</li>
						<li class="nav-item">
							<router-link to="/">
								<a class="nav-link text-muted " href="#">企业购</a>
							</router-link>
						</li>
						<li class="nav-item">
							<router-link to="/">
								<a class="nav-link text-muted " href="#">更多精彩</a>
							</router-link>
						</li>
					</ul>

					<ul class="navbar-nav">

						<li class="nav-item">
							<router-link to="/Login">
								<a class="nav-link text-muted" href="#">请登录</a>
							</router-link>
						</li>
						<li class="nav-item">
							<router-link to="/ZhuCe">
								<a class="nav-link text-muted" href="#">注册</a>
							</router-link>
						</li>
						<li class="nav-item">
							<router-link to="/MyOrder">
								<a class="nav-link text-muted" href="#">我的订单</a>
							</router-link>
						</li>
						<li class="nav-item">
							<router-link to="/">
								<a class="nav-link text-muted " href="#">客服</a>
							</router-link>
						</li>

						<li class="nav-item">
							<router-link to="/">
								<a class="nav-link text-muted " href="#">网站导航</a>
							</router-link>
						</li>
						<li class="nav-item">
							<router-link to="/">
								<a class="nav-link text-muted 	" href="#">手机版</a>
							</router-link>
						</li>
						<li class="nav-item">
							<router-link to="/ShopCart">
								<a id="gwc" class="nav-link" href="#">购物车(0)</a>
							</router-link>
						</li>
					</ul>
				</nav>
			</header>
		</div>
	</div>

</template>
<script>
export default {
	//给组件起一个名字,开发者工具中显示这个组件的时候，显示的就是这个名字
	name: "Header",
};
</script>
<style scoped>
#divheaderover {
	background: #000 !important;
}

#divheader {
	width: 1200px;
	margin: 0 auto;
	overflow: hidden;
}

.header {
	height: 35px;
	background: #000 !important;
}

.header2 {
	height: 80px;
}

img {
	width: 125px;
}

.btn-group .btn:focus,
.btn-group .btn.focus {
	box-shadow: none !important;
}

.input-group .btn:focus,
.input-group .btn.focus {
	box-shadow: none !important;
}

.navbar-nav .nav-item a {

	text-decoration: none !important;
	/* 去除默认的下划线 */
	font-size: 10px;
	color: rgb(153, 153, 153) !important;
	padding: 9px 8px;
	font-weight: 700 !important;


}

.navbar-nav .nav-item a:hover {

	text-decoration: none !important;


	color: aliceblue !important;


}

#gwc {
	background: rgb(66, 66, 66) !important;
	color: rgb(179, 179, 179) !important;

}

#gwc:hover {
	background: rgb(255, 255, 255) !important;
	color: red !important;
}

/* .huaderlia li a {
	text-decoration: none !important;

} */
</style>