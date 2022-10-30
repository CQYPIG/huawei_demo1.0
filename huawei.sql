/*
 Navicat Premium Data Transfer

 Source Server         : MYSQL80
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : huawei

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 24/10/2022 07:49:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for banners
-- ----------------------------
DROP TABLE IF EXISTS `banners`;
CREATE TABLE `banners`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `imgUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of banners
-- ----------------------------
INSERT INTO `banners` VALUES (1, '/images/banner/ci1.webp');
INSERT INTO `banners` VALUES (2, '/images/banner/ci2.webp');
INSERT INTO `banners` VALUES (3, '/images/banner/ci3.webp');

-- ----------------------------
-- Table structure for commodity
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `sort_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `commodity_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `describe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `now_price` decimal(10, 2) NULL DEFAULT NULL,
  `price` int(0) NULL DEFAULT NULL,
  `imgUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `isHome` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `repertory` int(0) NULL DEFAULT NULL,
  `limit_number` int(0) NULL DEFAULT NULL,
  `options` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of commodity
-- ----------------------------
INSERT INTO `commodity` VALUES (1, '手机', 'HUAWEI Mate 40 Pro 8GB+128GB', '超轻薄|超可靠', 5999.00, 6099, '\\images\\commodity\\phone\\huawei mate 50\\zi\\428_428_9CEBFA89B1C6840AAE12B3D491D0D72F.webp', 1, 3, 2, '颜色：冰霜、密语&套餐：单品、听书vip（季卡）-99、超级音乐vip（季卡）-199');
INSERT INTO `commodity` VALUES (2, '电脑', '【键盘+手写笔】HUAWEI MatePad Pro', '轻薄长续航', NULL, 7399, '/images/commodity/shouji2.webp', 1, 3, 2, '颜色：冰霜、密语&套餐：单品、听书vip（季卡）-99、超级音乐vip（季卡）-199');
INSERT INTO `commodity` VALUES (3, '电脑', 'HUAWEI MateBook X Pro i7 3.1K原色全面屏', '颜值超高|经济实惠', NULL, 6599, '\\images\\commodity\\computer\\matebook x pro\\matebook x pro.png', NULL, 0, 2, '颜色：冰霜、密语&套餐：单品、听书vip（季卡）-99、超级音乐vip（季卡）-199');
INSERT INTO `commodity` VALUES (4, '手机', 'HUAWEI Mate 50 Pro 256GB', NULL, NULL, 4999, '\\images\\commodity\\phone\\huawei mate 50\\800_800_FD0A7FB44AC89E470F23E19F6AA06544mp.webp', NULL, 5, 2, '颜色：曜金黑、冰霜银、流光紫、昆仑霞光-10000&版本：128GB、256GB-199、512GB-299&套餐：官方标配');

-- ----------------------------
-- Table structure for commodity_color_img
-- ----------------------------
DROP TABLE IF EXISTS `commodity_color_img`;
CREATE TABLE `commodity_color_img`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `commodity_id` int(0) NOT NULL,
  `color` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '存放颜色的图片路径、这个一般放四个',
  `logo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '是否是能明显标识出这个颜色的',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of commodity_color_img
-- ----------------------------
INSERT INTO `commodity_color_img` VALUES (1, 3, '冰霜', '\\images\\commodity\\computer\\matebook x pro\\color_img\\bai\\1matebook x pro.png', NULL);
INSERT INTO `commodity_color_img` VALUES (2, 3, '冰霜', '\\images\\commodity\\computer\\matebook x pro\\color_img\\bai\\3matebook x pro.png', NULL);
INSERT INTO `commodity_color_img` VALUES (3, 3, '冰霜', '\\images\\commodity\\computer\\matebook x pro\\color_img\\bai\\4matebook x pro.png', NULL);
INSERT INTO `commodity_color_img` VALUES (4, 3, '冰霜', '\\images\\commodity\\computer\\matebook x pro\\color_img\\bai\\5matebook x pro.png', NULL);
INSERT INTO `commodity_color_img` VALUES (5, 3, '密语', '\\images\\commodity\\computer\\matebook x pro\\color_img\\lan\\1matebook x pro.png', NULL);
INSERT INTO `commodity_color_img` VALUES (6, 3, '密语', '\\images\\commodity\\computer\\matebook x pro\\color_img\\lan\\2matebook x pro.png', NULL);
INSERT INTO `commodity_color_img` VALUES (7, 3, '密语', '\\images\\commodity\\computer\\matebook x pro\\color_img\\lan\\3matebook x pro.png', NULL);
INSERT INTO `commodity_color_img` VALUES (8, 3, '密语', '\\images\\commodity\\computer\\matebook x pro\\color_img\\lan\\4matebook x pro.png', NULL);
INSERT INTO `commodity_color_img` VALUES (9, 4, '曜金黑', '\\images\\commodity\\phone\\huawei mate 50\\hei\\428_428_0ABB0B6CB93826BC6CB6E01EB85842B4mp.webp', 'isLogo');
INSERT INTO `commodity_color_img` VALUES (10, 4, '曜金黑', '\\images\\commodity\\phone\\huawei mate 50\\hei\\428_428_986B81EFE4E235775C0328B7EB3A0494.webp', NULL);
INSERT INTO `commodity_color_img` VALUES (11, 4, '曜金黑', '\\images\\commodity\\phone\\huawei mate 50\\hei\\428_428_18581043098906498F1E3A1E3CA14A24.webp', NULL);
INSERT INTO `commodity_color_img` VALUES (12, 4, '曜金黑', '\\images\\commodity\\phone\\huawei mate 50\\hei\\428_428_a_web8BB5C83C2ABE71E8AAB540C695FC8AEF.webp', NULL);
INSERT INTO `commodity_color_img` VALUES (13, 4, '曜金黑', '\\images\\commodity\\phone\\huawei mate 50\\hei\\428_428_B9C1580CB3E2B17EE85963C9C9046210.webp', NULL);
INSERT INTO `commodity_color_img` VALUES (14, 4, '昆仑霞光', '\\images\\commodity\\phone\\huawei mate 50\\xiaguang\\428_428_020C7E495E7CFB291ECE776501CAF343.webp', NULL);
INSERT INTO `commodity_color_img` VALUES (15, 4, '昆仑霞光', '\\images\\commodity\\phone\\huawei mate 50\\xiaguang\\428_428_63231C6237D2E438FEE8AD60C182613Amp.webp', 'isLogo');
INSERT INTO `commodity_color_img` VALUES (16, 4, '昆仑霞光', '\\images\\commodity\\phone\\huawei mate 50\\xiaguang\\428_428_985633887F96D700149F2EA783B2D4CA.webp', NULL);
INSERT INTO `commodity_color_img` VALUES (17, 4, '昆仑霞光', '\\images\\commodity\\phone\\huawei mate 50\\xiaguang\\428_428_a_web8BB5C83C2ABE71E8AAB540C695FC8AEF (1).webp', NULL);
INSERT INTO `commodity_color_img` VALUES (18, 4, '昆仑霞光', '\\images\\commodity\\phone\\huawei mate 50\\xiaguang\\428_428_A9E9858B455EEFF53AC52DF8EF0B1645.webp', NULL);
INSERT INTO `commodity_color_img` VALUES (19, 4, '冰霜银', '\\images\\commodity\\phone\\huawei mate 50\\yin\\428_428_45E1F29053D1178375ED3F7828CC9E11.webp', NULL);
INSERT INTO `commodity_color_img` VALUES (20, 4, '冰霜银', '\\images\\commodity\\phone\\huawei mate 50\\yin\\428_428_7061A05733603B92D91AEA0DCF5901B5.webp', NULL);
INSERT INTO `commodity_color_img` VALUES (21, 4, '冰霜银', '\\images\\commodity\\phone\\huawei mate 50\\yin\\428_428_a_web8BB5C83C2ABE71E8AAB540C695FC8AEF (1).webp', NULL);
INSERT INTO `commodity_color_img` VALUES (22, 4, '冰霜银', '\\images\\commodity\\phone\\huawei mate 50\\yin\\428_428_F689791A3F9798C41F2D682DCFFE2127.webp', NULL);
INSERT INTO `commodity_color_img` VALUES (23, 4, '冰霜银', '\\images\\commodity\\phone\\huawei mate 50\\yin\\428_428_FD0A7FB44AC89E470F23E19F6AA06544mp.webp', 'isLogo');
INSERT INTO `commodity_color_img` VALUES (24, 4, '流光紫', '\\images\\commodity\\phone\\huawei mate 50\\zi\\428_428_9CEBFA89B1C6840AAE12B3D491D0D72F.webp', NULL);
INSERT INTO `commodity_color_img` VALUES (25, 4, '流光紫', '\\images\\commodity\\phone\\huawei mate 50\\zi\\428_428_68F6D3BF0826688E2D6F5219036671A5.webp', NULL);
INSERT INTO `commodity_color_img` VALUES (26, 4, '流光紫', '\\images\\commodity\\phone\\huawei mate 50\\zi\\428_428_83D7C9116A9582438048481884565126.webp', NULL);
INSERT INTO `commodity_color_img` VALUES (27, 4, '流光紫', '\\images\\commodity\\phone\\huawei mate 50\\zi\\428_428_99620BF917220D5B8B60AA0930833175mp.webp', 'isLogo');
INSERT INTO `commodity_color_img` VALUES (28, 4, '流光紫', '\\images\\commodity\\phone\\huawei mate 50\\zi\\428_428_a_web8BB5C83C2ABE71E8AAB540C695FC8AEF.webp', NULL);

-- ----------------------------
-- Table structure for commodity_detail_img
-- ----------------------------
DROP TABLE IF EXISTS `commodity_detail_img`;
CREATE TABLE `commodity_detail_img`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `commodity_id` int(0) NOT NULL,
  `img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of commodity_detail_img
-- ----------------------------
INSERT INTO `commodity_detail_img` VALUES (1, 3, '\\images\\commodity\\computer\\matebook x pro\\1matebook x pro.png');
INSERT INTO `commodity_detail_img` VALUES (2, 3, '\\images\\commodity\\computer\\matebook x pro\\2matebook x pro.png');
INSERT INTO `commodity_detail_img` VALUES (3, 3, '\\images\\commodity\\computer\\matebook x pro\\3matebook x pro.png');
INSERT INTO `commodity_detail_img` VALUES (4, 3, '\\images\\commodity\\computer\\matebook x pro\\4matebook x pro.png');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `order_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '订单唯一标识',
  `user_id` int(0) NOT NULL COMMENT '订单所属用户id',
  `order_price` int(0) NULL DEFAULT NULL COMMENT '订单价格',
  `order_time` timestamp(0) NULL DEFAULT NULL COMMENT '订单创建时间',
  `yx` tinyint(1) NULL DEFAULT NULL COMMENT '订单是否有效',
  `dfk` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '订单是否付款',
  `dsh` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '订单是否已收货',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 70 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (62, 1, 41092, '2022-10-22 23:44:18', 1, 0, 1);
INSERT INTO `orders` VALUES (63, 1, 4999, '2022-10-23 00:11:20', 0, 1, 0);
INSERT INTO `orders` VALUES (65, 1, 51788, '2022-10-23 12:12:25', 0, 1, 0);
INSERT INTO `orders` VALUES (66, 1, 0, '2022-10-23 12:12:59', 0, 1, 0);
INSERT INTO `orders` VALUES (67, 1, 15298, '2022-10-23 12:14:59', 0, 1, 0);
INSERT INTO `orders` VALUES (68, 1, 30992, '2022-10-23 12:16:23', 0, 1, 0);
INSERT INTO `orders` VALUES (69, 1, 36190, '2022-10-23 12:18:00', 0, 1, 0);

-- ----------------------------
-- Table structure for orders_commodity
-- ----------------------------
DROP TABLE IF EXISTS `orders_commodity`;
CREATE TABLE `orders_commodity`  (
  `order_commodity_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '在当前表的唯一标识',
  `belong_order_id` int(0) NOT NULL COMMENT '当前商品选购的信息所属的订单id',
  `commodity_id` int(0) NOT NULL COMMENT '当前选购商品id',
  `commodity_number` int(0) NULL DEFAULT NULL COMMENT '当前选购商品的数量',
  `commodity_options` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '选购当前商品的配置信息',
  `commodity_price` int(0) NULL DEFAULT NULL COMMENT '选择的单品商品价格',
  `commodity_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`order_commodity_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders_commodity
-- ----------------------------
INSERT INTO `orders_commodity` VALUES (37, 62, 4, 1, '颜色:流光紫,版本:256GB,套餐:官方标配,', 5198, '\\images\\commodity\\phone\\huawei mate 50\\zi\\428_428_99620BF917220D5B8B60AA0930833175mp.webp');
INSERT INTO `orders_commodity` VALUES (38, 62, 4, 1, '颜色:流光紫,版本:512GB,套餐:官方标配,', 5298, '\\images\\commodity\\phone\\huawei mate 50\\zi\\428_428_99620BF917220D5B8B60AA0930833175mp.webp');
INSERT INTO `orders_commodity` VALUES (39, 62, 4, 1, '颜色:昆仑霞光,版本:512GB,套餐:官方标配,', 15298, '\\images\\commodity\\phone\\huawei mate 50\\xiaguang\\428_428_63231C6237D2E438FEE8AD60C182613Amp.webp');
INSERT INTO `orders_commodity` VALUES (40, 62, 4, 1, '颜色:昆仑霞光,版本:512GB,套餐:官方标配,', 15298, '\\images\\commodity\\phone\\huawei mate 50\\xiaguang\\428_428_63231C6237D2E438FEE8AD60C182613Amp.webp');
INSERT INTO `orders_commodity` VALUES (41, 63, 4, 1, '颜色:曜金黑,版本:128GB,套餐:官方标配,', 4999, '\\images\\commodity\\phone\\huawei mate 50\\hei\\428_428_0ABB0B6CB93826BC6CB6E01EB85842B4mp.webp');
INSERT INTO `orders_commodity` VALUES (45, 65, 4, 2, '颜色:昆仑霞光,版本:512GB,套餐:官方标配,', 15298, '\\images\\commodity\\phone\\huawei mate 50\\xiaguang\\428_428_63231C6237D2E438FEE8AD60C182613Amp.webp');
INSERT INTO `orders_commodity` VALUES (46, 65, 4, 2, '颜色:冰霜银,版本:512GB,套餐:官方标配,', 5298, '\\images\\commodity\\phone\\huawei mate 50\\yin\\428_428_FD0A7FB44AC89E470F23E19F6AA06544mp.webp');
INSERT INTO `orders_commodity` VALUES (47, 65, 4, 2, '颜色:流光紫,版本:512GB,套餐:官方标配,', 5298, '\\images\\commodity\\phone\\huawei mate 50\\zi\\428_428_99620BF917220D5B8B60AA0930833175mp.webp');
INSERT INTO `orders_commodity` VALUES (48, 67, 4, 1, '颜色:昆仑霞光,版本:512GB,套餐:官方标配,', 15298, '\\images\\commodity\\phone\\huawei mate 50\\xiaguang\\428_428_63231C6237D2E438FEE8AD60C182613Amp.webp');
INSERT INTO `orders_commodity` VALUES (49, 68, 4, 1, '颜色:昆仑霞光,版本:512GB,套餐:官方标配,', 15298, '\\images\\commodity\\phone\\huawei mate 50\\xiaguang\\428_428_63231C6237D2E438FEE8AD60C182613Amp.webp');
INSERT INTO `orders_commodity` VALUES (50, 68, 4, 2, '颜色:流光紫,版本:256GB,套餐:官方标配,', 5198, '\\images\\commodity\\phone\\huawei mate 50\\zi\\428_428_99620BF917220D5B8B60AA0930833175mp.webp');
INSERT INTO `orders_commodity` VALUES (51, 68, 4, 1, '颜色:曜金黑,版本:512GB,套餐:官方标配,', 5298, '\\images\\commodity\\phone\\huawei mate 50\\hei\\428_428_0ABB0B6CB93826BC6CB6E01EB85842B4mp.webp');
INSERT INTO `orders_commodity` VALUES (52, 69, 4, 1, '颜色:昆仑霞光,版本:512GB,套餐:官方标配,', 15298, '\\images\\commodity\\phone\\huawei mate 50\\xiaguang\\428_428_63231C6237D2E438FEE8AD60C182613Amp.webp');
INSERT INTO `orders_commodity` VALUES (53, 69, 4, 2, '颜色:曜金黑,版本:256GB,套餐:官方标配,', 5198, '\\images\\commodity\\phone\\huawei mate 50\\hei\\428_428_0ABB0B6CB93826BC6CB6E01EB85842B4mp.webp');
INSERT INTO `orders_commodity` VALUES (54, 69, 4, 1, '颜色:冰霜银,版本:512GB,套餐:官方标配,', 5298, '\\images\\commodity\\phone\\huawei mate 50\\yin\\428_428_FD0A7FB44AC89E470F23E19F6AA06544mp.webp');
INSERT INTO `orders_commodity` VALUES (55, 69, 4, 1, '颜色:流光紫,版本:256GB,套餐:官方标配,', 5198, '\\images\\commodity\\phone\\huawei mate 50\\zi\\428_428_99620BF917220D5B8B60AA0930833175mp.webp');

-- ----------------------------
-- Table structure for shop_car
-- ----------------------------
DROP TABLE IF EXISTS `shop_car`;
CREATE TABLE `shop_car`  (
  `shop_car_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '购物车关联的用户id',
  `sc_commodity_id` int(0) NULL DEFAULT NULL COMMENT '购物车关联的商品id',
  `sc_commodity_price` int(0) NULL DEFAULT NULL,
  `sc_commodity_number` int(0) NULL DEFAULT NULL COMMENT '购物车关联的商品的数量',
  `sc_commodity_options` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '关联商品的数量',
  `sc_commodity_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品配置对应的图片地址',
  PRIMARY KEY (`shop_car_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 77 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop_car
-- ----------------------------

-- ----------------------------
-- Table structure for sort
-- ----------------------------
DROP TABLE IF EXISTS `sort`;
CREATE TABLE `sort`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sort
-- ----------------------------
INSERT INTO `sort` VALUES (1, '手机');
INSERT INTO `sort` VALUES (2, '甄选推荐');
INSERT INTO `sort` VALUES (3, '电脑');
INSERT INTO `sort` VALUES (4, '限时秒杀');

-- ----------------------------
-- Table structure for sort_img
-- ----------------------------
DROP TABLE IF EXISTS `sort_img`;
CREATE TABLE `sort_img`  (
  `sort_img_id` int(0) NOT NULL AUTO_INCREMENT,
  `sort_id` int(0) NOT NULL,
  `sort_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sort_img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sort_img_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sort_img
-- ----------------------------
INSERT INTO `sort_img` VALUES (1, 1, '畅想系列', '/images/sort/手机/畅想系列.webp');
INSERT INTO `sort_img` VALUES (2, 1, 'nova系列', '/images/sort/手机/畅想系列.webp');
INSERT INTO `sort_img` VALUES (3, 1, 'p系列', '/images/sort/手机/畅想系列.webp');
INSERT INTO `sort_img` VALUES (4, 2, 'matebox X系列', '/images/sort/电脑/matebox X系列.webp');
INSERT INTO `sort_img` VALUES (5, 2, 'matebox系列', '/images/sort/电脑/matebox系列.webp');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (0000000001, 'admin', '123456');

SET FOREIGN_KEY_CHECKS = 1;
