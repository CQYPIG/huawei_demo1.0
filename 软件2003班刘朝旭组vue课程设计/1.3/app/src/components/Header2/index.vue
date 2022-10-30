<template>
	<div class="topover">
		<div id="divheader">
			<!-- 头部 -->
			<header>
				<!--头部第二行 搜索区域-->
				<!-- 子元素垂直水平居中//align-items-center -->
				<div class="header2 d-flex justify-content-between align-items-center  login-center">
					<router-link to="/">
						<h1 class="img">
							<a class="logo" title="华为商城" href="###" target="_blank">
								<img src="./images/logo_app.png" alt="">
							</a>
						</h1>
					</router-link>
					<div class="btn-group mx-5">
						<router-link to="/Home">
							<button type="button" class="btn" data-target="#registerModal">华为专区</button>
						</router-link>
						<button type="button" class="btn disabled" data-target="#registerModal">鸿蒙智联</button>
						<button type="button" class="btn disabled" data-target="#registerModal">莫塞尔</button>
						<router-link to="/ZhiXuan">
							<button type="button" class="btn" data-target="#registerModal">华为智选</button>
						</router-link>
						<button type="button" class="btn disabled" data-target="#registerModal">HarmonyOS</button>
						<button type="button" class="btn disabled" data-target="#registerModal">特惠企采</button>
						<button type="button" class="btn disabled" data-target="#registerModal">教育购</button>
					</div>
					<div class="">
						<form action="###" class="searchForm">
							<div class="input-group  input-group-sm ">
								<input type="text" class="searchinput form-control" placeholder="	">
								<router-link to="/search">
									<button type="button" class="btn btn-secondary btn-sm btnsosuo  ">搜</button>
								</router-link>
							</div>
						</form>
					</div>
				</div>
			</header>
		</div>

	</div>



</template>
<script>
	export default {
		//给组件起一个名字,开发者工具中显示这个组件的时候，显示的就是这个名字
		name: "Header2",
	};
</script>
<style scoped>
	.topover {
		/* background: rgb(241, 243, 245); */
		border-bottom: rgb(239, 239, 239) solid 1px;
	}

	#divheader {
		width: 1200px;
		margin: 0 auto;
		overflow: hidden;
	}

	.header {
		height: 30px;
		background: #000 !important;
	}

	.header2 {
		height: 80px;
	}

	img {
		width: 100px;
	}

	.btn-group .btn:focus,
	.btn-group .btn.focus {
		box-shadow: none !important;
	}

	.input-group .btn:focus,
	.input-group .btn.focus {
		box-shadow: none !important;
	}

	.btn-group .btn {
		font-weight: 500 !important;

	}

	.btn-group .btn:hover {
		color: red !important;


	}

	.searchinput {
		border-radius: 50px !important;
	}

	.searchinput.searchinput:focus,
	.searchinput.searchinput.focus {
		box-shadow: none;
		border: rgb(209, 209, 209) solid 1px;

	}

	.searchinput.searchinput:checked {
		/* box-shadow: none; */
		border: rgb(209, 209, 209) solid 1px;

	}

	.btnsosuo {
		border-radius: 50%;
		width: 30px;
		height: 30px;
	}
</style>