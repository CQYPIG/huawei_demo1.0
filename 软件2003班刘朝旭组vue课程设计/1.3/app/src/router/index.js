// 该文件专门用于创建整个应用的路由器
import VueRouter from 'vue-router'
//引入组件
import Login from '../pages/Login'
import ShopCart from '../pages/ShopCart'
import ZhiXuan from '../pages/ZhiXuan'
import Home from '../pages/Home'
import Search from '../pages/Search'
import Detalls from '../pages/Detalls'

//秒杀主页相关路由
import MiaoShahome from '../pages/Home/MiaoSha/MiaoShahome'
import PinLei from '../pages/Home/MiaoSha/PinLei'
import XianShi from '../pages/Home/MiaoSha/XianShi'
import Xshigou from '../pages/Home/XianShigou/Xshigou'

//订单相关路由
import MyOrder from '../pages/MyOrder'
import MyOrderLast from '../pages/MyOrder/myordermin/My-Order-Last.vue'
import MyOrders from '../pages/MyOrder/myordermin/My-Orders.vue'
import MyOrderAgo from '../pages/MyOrder/myordermin/My-Order-Ago.vue'
//注册相关路由
import ZhuCe from '../pages/ZhuCe'
import Shouji from '../pages/ZhuCe/Shouji'
import Email from '../pages/ZhuCe/Email'



//创建并暴露一个路由器
const router = new VueRouter({
	routes: [
		{
			name: 'login',
			path: '/Login',
			component: Login,
			meta: {
				showfooter: true,
				showheader2: false,
				title: '华为商城—登录'
			},

		},
		{
			name: 'zhuce',
			path: '/ZhuCe',
			component: ZhuCe,
			redirect: '/Shouji',
			children: [
				{
					path: '/Shouji',
					component: Shouji,
					// redirect: '/Shouji',
					meta: {
						showfooter: true,
						showheader2: false,
						title: '华为商城—注册-手机'
					},
				},
				{
					path: '/Email',
					component: Email,
					meta: {
						showfooter: true,
						showheader2: false,
						title: '华为商城—注册-邮箱'
					},
				},
			],
			meta: {
				showfooter: false,
				showheader2: false,
				title: '华为商城—注册'
			},
		},
		{
			name: 'myorder',
			path: '/MyOrder',
			component: MyOrder,
			redirect: '/last',
			children: [
				{
					path: '/myOrder',
					component: MyOrders,
					redirect: '/last',
					children: [
						{
							path: '/last',
							component: MyOrderLast,
							meta: {
								showfooter: true,
								showheader2: false,
								title: '华为商城—我的订单'
							},
						},
						{
							path: '/ago',
							component: MyOrderAgo,
							meta: {
								showfooter: true,
								showheader2: false,
								title: '华为商城—我的订单'
							},
						},
					],
					meta: {
						showfooter: true,
						showheader2: false,
						title: '华为商城—我的订单'
					},
				},
			],
			meta: {
				showfooter: true,
				showheader2: false,
				title: '华为商城—我的订单'

			},
		},
		{
			name: 'shopcart',
			path: '/ShopCart',
			component: ShopCart,
			meta: {
				showfooter: false,
				showheader2: true,
				title: '华为商城—我的购物车'

			},
		},
		{
			name: 'zhixuan',
			path: '/ZhiXuan',
			component: ZhiXuan,
			children: [

			],
			meta: {
				showfooter: true,
				showheader2: true,
				title: '华为商城—华为智轩'

			},
		},

		{
			name: 'home',
			path: '/Home',
			component: Home,
			children: [
			],
			meta: {
				showfooter: true,
				showheader2: true,
				title: '华为商城—首页—华为专区'

			},
		},

		//重定向到首页
		{
			path: '/',
			redirect: '/home',
			meta: {
				showfooter: true,
				showheader2: true,
				title: '华为商城—首页—华为专区'
			},
		},
		{
			name: 'miaoshahome',
			path: '/MiaoShahome',
			component: MiaoShahome,
			redirect: "/MiaoShahome/XianShi",
			children: [
				{
					path: 'PinLei',
					component: PinLei,
					meta: {
						showfooter: true,
						showheader2: false,
						title: '华为商城—品类秒杀'

					},
				},
				{
					path: 'XianShi',
					component: XianShi,
					meta: {
						showfooter: true,
						showheader2: false,
						title: '华为商城—限时秒杀'

					},
				},
			],
			meta: {
				showfooter: true,
				showheader2: false,
				title: '华为商城—秒杀'

			},
		},
		{
			name: 'search',
			path: '/Search',
			component: Search,
			meta: {
				showfooter: true,
				showheader2: true,
				title: '华为商城—搜索'

			},
		}
		,
		{
			name: 'detalls',
			path: '/Detalls',
			component: Detalls,
			meta: {
				showfooter: true,
				showheader2: true,
				title: '华为商城—商品详情'

			},
		}
		,
		{
			name: 'xshigou',
			path: '/Xshigou',
			component: Xshigou,
			meta: {
				showfooter: true,
				showheader2: true,
				title: '华为商城—限时购'

			},
		}
	]

})
// 全局后置钩子
router.afterEach(to => {
	// 设置title
	document.title = to.meta.title;
})

export default router;