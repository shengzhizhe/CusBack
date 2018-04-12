/*
Navicat MySQL Data Transfer

Source Server         : ldtest
Source Server Version : 50717
Source Host           : 192.168.1.130:3306
Source Database       : jpt2

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-04-12 17:31:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account_table
-- ----------------------------
DROP TABLE IF EXISTS `account_table`;
CREATE TABLE `account_table` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `types` int(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_table
-- ----------------------------
INSERT INTO `account_table` VALUES ('1sdf@qq.com', 'MjEyMzFhQWE=', '0');
INSERT INTO `account_table` VALUES ('28756156@qq.com', 'MjEyMzFhQWE=', '0');
INSERT INTO `account_table` VALUES ('287656156@qq.com', 'MTIzNDU2N2FB', '0');
INSERT INTO `account_table` VALUES ('xuesemofa@163.com', 'MTIzNDU2N2FB', '0');

-- ----------------------------
-- Table structure for commodity_table
-- ----------------------------
DROP TABLE IF EXISTS `commodity_table`;
CREATE TABLE `commodity_table` (
  `uuid` varchar(255) NOT NULL,
  `cname` varchar(255) DEFAULT NULL,
  `jg` double(10,2) DEFAULT NULL,
  `dw` varchar(255) DEFAULT NULL,
  `ge` varchar(255) DEFAULT NULL,
  `zt` varchar(255) DEFAULT NULL,
  `pp` varchar(255) DEFAULT NULL,
  `xq` varchar(255) DEFAULT NULL,
  `xl` varchar(255) DEFAULT NULL,
  `busid` varchar(255) DEFAULT NULL,
  `sl` bigint(255) DEFAULT NULL,
  `lm` varchar(255) DEFAULT NULL,
  `sxj` bigint(255) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commodity_table
-- ----------------------------
INSERT INTO `commodity_table` VALUES ('01025b022a1844919f321604b1e8ffcd', '图片', '1.00', '1', '1', 'D:/img/222636af288e4f09a359eeb563e18513.jpg', '1', '1', 'null', 'null', '1', '调料', '1');
INSERT INTO `commodity_table` VALUES ('1bf7ae285af54b459f622a88c6e8f3a1', '4', '4.00', '4', '4', 'null', '4', '4', 'null', 'null', '4', '其它', '1');
INSERT INTO `commodity_table` VALUES ('512a40397f224c47a06cc5697b75e326', '3', '3.00', '3', '3', 'null', '3', '3', 'null', 'null', '3', '其它', '0');
INSERT INTO `commodity_table` VALUES ('75ba79ffbcf047209da7f0386410447a', '5', '5.00', '5', '5', 'null', '5', '5', 'null', 'null', '5', '其它', '0');
INSERT INTO `commodity_table` VALUES ('79e5d5d6cd3544c38ad9ed2f97b4b4bd', '2', '2.00', '2', '2', 'null', '2', '2', 'null', 'null', '2', '其它', '0');
INSERT INTO `commodity_table` VALUES ('7a708c6113fd497489df98de49c1ea23', '11', '11.00', '1', '1', 'null', '1', '1', 'null', 'null', '1', '其它', '0');
INSERT INTO `commodity_table` VALUES ('ce68892f2ffa4a289abeda53edaa72d3', '7', '7.00', '7', '7', 'null', '7', '7', 'null', 'null', '7', '其它', '0');
INSERT INTO `commodity_table` VALUES ('df1ab201ed1248f49e73186d9bbbb324', '6', '6.00', '6', '6', 'null', '6', '6', 'null', 'null', '6', '其它', '0');

-- ----------------------------
-- Table structure for ordersp_table
-- ----------------------------
DROP TABLE IF EXISTS `ordersp_table`;
CREATE TABLE `ordersp_table` (
  `uuid` varchar(255) NOT NULL,
  `spid` varchar(255) DEFAULT NULL,
  `spsl` varchar(255) DEFAULT NULL,
  `spdj` varchar(255) DEFAULT NULL,
  `spzj` varchar(255) DEFAULT NULL,
  `orderid` varchar(255) DEFAULT NULL,
  `zt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ordersp_table
-- ----------------------------
INSERT INTO `ordersp_table` VALUES ('1111111', '1bf7ae285af54b459f622a88c6e8f3a1', '100', '1', '100', '1', '0');

-- ----------------------------
-- Table structure for order_table
-- ----------------------------
DROP TABLE IF EXISTS `order_table`;
CREATE TABLE `order_table` (
  `uuid` varchar(255) NOT NULL,
  `spid` varchar(255) DEFAULT NULL,
  `sl` varchar(255) DEFAULT NULL,
  `psf` double DEFAULT NULL,
  `yhqid` varchar(255) DEFAULT NULL,
  `zj` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `ddbh` varchar(255) DEFAULT NULL,
  `cjtime` varchar(50) DEFAULT NULL,
  `account` varchar(255) DEFAULT NULL,
  `busid` varchar(255) DEFAULT NULL,
  `type` int(2) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_table
-- ----------------------------
INSERT INTO `order_table` VALUES ('1', null, null, null, null, null, '石家庄市桥西区红旗大街125号宫家庄红河小区9号楼2501室', '11111111111', '20180101010101011000', '2018-01-01 01:01:01 1000', 'xuesemofa@163.com', null, '0');
INSERT INTO `order_table` VALUES ('2', null, null, null, null, null, '石家庄放假了大活佛暗示疗法户口落户快', '11111111111', '20180101010101011000', '2018-01-01 01:01:01 1000', 'xuesemofa@163.com', null, '1');
INSERT INTO `order_table` VALUES ('6', null, null, null, null, null, null, null, null, null, null, null, '1');
INSERT INTO `order_table` VALUES ('7', null, null, null, null, null, null, null, null, null, null, null, '1');
INSERT INTO `order_table` VALUES ('8', null, null, null, null, null, null, null, null, null, null, null, '1');
INSERT INTO `order_table` VALUES ('9', null, null, null, null, null, null, null, null, null, null, null, '1');
INSERT INTO `order_table` VALUES ('e', null, null, null, null, null, null, null, null, null, null, null, '1');
INSERT INTO `order_table` VALUES ('q', null, null, null, null, null, null, null, null, null, null, null, '2');

-- ----------------------------
-- Table structure for personal_table
-- ----------------------------
DROP TABLE IF EXISTS `personal_table`;
CREATE TABLE `personal_table` (
  `uuid` varchar(255) NOT NULL,
  `account` varchar(255) DEFAULT NULL,
  `portrait` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `idno` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `wechat` varchar(255) DEFAULT NULL,
  `microblog` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of personal_table
-- ----------------------------
INSERT INTO `personal_table` VALUES ('1', 'xuesmeofa@163.com', null, 'ceshi ', null, null, null, null, null, null, null, null, null);
INSERT INTO `personal_table` VALUES ('6c7ad020bffc43a2ad5e269f6a69e43d', 'AS的', null, 'AS的', '是奥德赛阿瑟', 'AS的AS的', '水电费', '', '实打实', '', '', '', '');
INSERT INTO `personal_table` VALUES ('bf6a42c02f7541deafec8b1964de927a', 'xuesemofa@163.com', null, 'AS的', '是', '爱上', '阿瑟', '阿瑟', '阿瑟', 'asd ', '阿瑟', '是', 'AS的');

-- ----------------------------
-- Table structure for token_table
-- ----------------------------
DROP TABLE IF EXISTS `token_table`;
CREATE TABLE `token_table` (
  `uuid` varchar(255) NOT NULL,
  `account` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `end_time` bigint(255) DEFAULT NULL,
  `is_use` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of token_table
-- ----------------------------
INSERT INTO `token_table` VALUES ('009e62fbdfd9480fbd4bd10bf8691db2', 'xuesemofa@163.com', 'ea32a403b0c5458f83a253203c4dca2f', '1522822548391', 'N');
INSERT INTO `token_table` VALUES ('025e76a58e4641918bc0167cb310b793', 'xuesemofa@163.com', 'aeebf4d9c9a34456915713c113063c00', '1522820192599', 'N');
INSERT INTO `token_table` VALUES ('02b770aacdd84742b614ca8c1a363345', 'null', '87c085445c1b4cffba238cd2484af098', '456850004872800000', 'Y');
INSERT INTO `token_table` VALUES ('036db0a054cd4b9d80de9cc512d6b9d4', 'null', 'cd5542c433474e2daedd420ca7b60481', '456972512147700000', 'Y');
INSERT INTO `token_table` VALUES ('039e2f9c3d444b7b93123ebe23cef8f7', 'null', '6b96f7462f9e4d5ebcfb2f0ad3501483', '456848545970400000', 'N');
INSERT INTO `token_table` VALUES ('0574b4c542324c61bb383a454f0ee630', 'null', 'b375bfda810241c4afcd78eca410a19a', '456976987269900000', 'N');
INSERT INTO `token_table` VALUES ('0578366415b54070a69b02de67513c6b', 'null', 'e5d1e8390d0942f9b31a703c6dc74e6c', '456972038513100000', 'Y');
INSERT INTO `token_table` VALUES ('0591d728b7234011b7809b8c124acf4c', 'xuesemofa@163.com', 'b420d0f040344f4c8d765e4109e53f22', '1522820932067', 'N');
INSERT INTO `token_table` VALUES ('05cb73ab01784f588d99cd69c6b93bc9', 'null', 'dbc704a86cda49499f84a479871c2597', '456850096745400000', 'Y');
INSERT INTO `token_table` VALUES ('063f48ec942d4df19ffc5695e69ac2e4', 'null', 'cc9ccd05af6643a5a28670bed4ff572f', '456850197795600000', 'Y');
INSERT INTO `token_table` VALUES ('06b5f157ccde4280ada3038e73092f5d', 'null', '2cb1abf22c874e5b8450e8b12b93f314', '456972001289400000', 'Y');
INSERT INTO `token_table` VALUES ('0761a3be809c4c4fb5e185b6efb04150', 'null', 'd2c43250573744608281387096af22ad', '456849529025700000', 'Y');
INSERT INTO `token_table` VALUES ('095b00bb15c14a14a8bb751a0dd1aaef', 'null', 'c6202fa6f8314dc78bd38133c7faf47b', '456849004419600000', 'N');
INSERT INTO `token_table` VALUES ('09a1a666c1e0428487f2605f2a91aded', 'null', 'dc74f64b20ac4a30b4cd7ad7e5a958f9', '456848736660900000', 'Y');
INSERT INTO `token_table` VALUES ('0a38930e9b294f6fbed88f9b56695246', 'null', 'b562517c44e543738c20f802d4066f0b', '456849282236700000', 'Y');
INSERT INTO `token_table` VALUES ('0ae55f427738409d97b69471bc1df076', 'null', '2dc54c841cfe4cc790a6e9358a4d7a87', '456849296725200000', 'Y');
INSERT INTO `token_table` VALUES ('0b59db9ebadb4fe69e9c967c3e28f844', 'xuesemofa@163.com', '8ce685bdd19b49fe842bef4494c7d564', '1523256510396', 'N');
INSERT INTO `token_table` VALUES ('0ca0515e3aa84c4685f6cd36c4562720', 'null', 'dbe864dad7fa437499e76e85d4efe467', '456972515607900000', 'Y');
INSERT INTO `token_table` VALUES ('0cab9a5eace344cda3880d44b0ce07a9', 'null', '1d4d24de1b85423989751bbd7427807e', '456848463393000000', 'Y');
INSERT INTO `token_table` VALUES ('0ce4505ed11e4c929e5246e15afc9a0d', 'xuesemofa@163.com', '49fbd466653f44e5a8835cbf68263cf8', '1522825011504', 'N');
INSERT INTO `token_table` VALUES ('0ed387edd69e416297afb24c3d9ece6e', 'null', '3e76714306044c55a4879b8ab54e838b', '456850194153000000', 'Y');
INSERT INTO `token_table` VALUES ('102cd11379bf47eb96cb2fcdf5d9dc2a', 'null', 'b8e65fc7ee064a218298cc09700df0a8', '456848089693500000', 'N');
INSERT INTO `token_table` VALUES ('11b4f968def24117a48f161b150517d9', 'null', '0622c7905cde43df98c416aa5da9327e', '456848452940100000', 'Y');
INSERT INTO `token_table` VALUES ('11e4b39aaa3c421d9dad14b9bb71aab2', 'xuesemofa@163.com', '6625a72ced864dd494a8f098da650aac', '1522822958040', 'N');
INSERT INTO `token_table` VALUES ('129e1f4aa76b45aa9ca7b9aa08501dd2', 'null', 'cd49f4ed74124c2bbe436a6d6611f044', '456849546528600000', 'Y');
INSERT INTO `token_table` VALUES ('145b1f325f2644faa8800a354d3cf522', 'null', 'bf9e6484cd674e27b151a697f9c38c5f', '456849311491500000', 'Y');
INSERT INTO `token_table` VALUES ('147474ad60db454f9e51845c0b4cceb7', 'null', 'bb995b7e323941a2acefc9aa45827ec4', '456849719033400000', 'Y');
INSERT INTO `token_table` VALUES ('1565a8a2d30d4f72be97d5e3c938e0ed', 'null', '0ffb918e1fa146a0a6df4b6a442fe729', '456972651786600000', 'Y');
INSERT INTO `token_table` VALUES ('160b898c9d244ecb98f857226d9db365', 'null', '7a668000ecda45c294d688c93a0b8315', '456972388275000000', 'Y');
INSERT INTO `token_table` VALUES ('1708894dfb5f4bc5903a24a26b87c3dd', 'xuesemofa@163.com', '9d82559f95df4924b6085c34ee2cec6f', '1522824705651', 'N');
INSERT INTO `token_table` VALUES ('17a48f6336ab4a99a54c6abef122ad7b', 'null', 'a8d47863b2fa4e94a53221c04cb4c105', '456848728835700000', 'Y');
INSERT INTO `token_table` VALUES ('18d9b5f8cbf6490a9c85d76e0a3319f5', 'xuesemofa@163.com', 'b4f20cb52e89496d80abd3647dcfb8f5', '1522827470751', 'N');
INSERT INTO `token_table` VALUES ('1b2b4c98739a4ae7b5f7beafd686fd74', 'null', 'c56631882f8b409c86186058eb268473', '456972008487600000', 'Y');
INSERT INTO `token_table` VALUES ('1b8cca77a74f4c59a1019036b54036a0', 'null', 'cdd0888714df400c8b440aebb86f7a1c', '456972512828100000', 'Y');
INSERT INTO `token_table` VALUES ('1cefece5eaea409bbf73cac026d44700', 'null', '3eedd0d83c0f485b808847d4f50a3d2a', '456971969187900000', 'Y');
INSERT INTO `token_table` VALUES ('1d151b2700ce42938ab7928d10374e74', 'null', 'ed86d990ff0d4af7a7e38f3082332e75', '456849021464700000', 'N');
INSERT INTO `token_table` VALUES ('1f5c24412ab44ea3b3873164c433de8c', 'xuesemofa@163.com', 'ee9421019eab4e6e8601a949db93f146', '1522824666418', 'N');
INSERT INTO `token_table` VALUES ('1f75a881203e424bb30de90a7dae8c90', 'xuesemofa@163.com', '344db90b67e54f1bb53d3eedabc9c8d0', '1522823760741', 'N');
INSERT INTO `token_table` VALUES ('1f8ec32c06564b3da4fae41ba9889c8e', 'null', '36cdb3ac98a64f288a980d98b9d527c7', '456972517227300000', 'Y');
INSERT INTO `token_table` VALUES ('1fbd03d56d5f4de5b6d40373fda57591', 'xuesemofa@163.com', '2b73c7295e494a56953dcf3f38ceab48', '1522823212998', 'N');
INSERT INTO `token_table` VALUES ('1ffe23f322ad4b39a45bfe418412d93c', 'null', 'ac262ddc715f48579641bb8a5ece3b98', '456972173622900000', 'Y');
INSERT INTO `token_table` VALUES ('203ded3a36424ff89ce4962412f6ef9e', 'null', '99e424f86d8f4f82817581a11b939c24', '456972464098800000', 'Y');
INSERT INTO `token_table` VALUES ('210aa8166f9840409470dd8a59e29051', 'null', 'de78cdbb958b44bcb8d2dee097c5f3f3', '456850234772400000', 'Y');
INSERT INTO `token_table` VALUES ('229d3388498b4191b3cadfe7dce68fb8', 'xuesemofa@163.com', 'b975686d7dc54e25be6390f6fe7e3999', '1522824323129', 'N');
INSERT INTO `token_table` VALUES ('22cc71bc48a64b08a743bb6281f8433f', 'xuesemofa@163.com', '65609bf81b4741939b10aaaaf6e2482b', '1522825736712', 'N');
INSERT INTO `token_table` VALUES ('23206afc43c94a2696623a75dbc54825', 'null', 'ea83c72712fe4c68abbb0913b34c6a45', '456850179298800000', 'Y');
INSERT INTO `token_table` VALUES ('2355d549206844bfa0da9e684b825b02', 'null', 'f877ae5779e6460ebec6e55331aacd1b', '456972510840000000', 'Y');
INSERT INTO `token_table` VALUES ('24eb843640e74d82be5ea0456370a43e', 'xuesemofa@163.com', '2c1726d35fde4a7f93e6a923db4eeb1f', '1522824349708', 'N');
INSERT INTO `token_table` VALUES ('2618516f486a4b32b26d525fe5864557', 'null', 'd59d7d8279994f4caf1572913a5a3eca', '456848992422600000', 'Y');
INSERT INTO `token_table` VALUES ('28c64fd337c1488692fb7d4ca55883d5', 'xuesemofa@163.com', '0ac523e9d96d49ef9ba61379baaa2380', '1522821704783', 'N');
INSERT INTO `token_table` VALUES ('290b3a06804b4d02aec9efb32cfda503', 'null', '9b05dc6b3e2842e8bd34986382484a5a', '456849348210600000', 'Y');
INSERT INTO `token_table` VALUES ('2b53f77d42e141ce8dc728fec185856a', 'xuesemofa@163.com', 'cb493d5952e94568b702452afd0154d5', '1522821865183', 'N');
INSERT INTO `token_table` VALUES ('2bfb4a7e707a46d5a99e854e98e2f0f3', 'null', '5cd7eda1b30d4e8a9d354846b133867d', '456849188748900000', 'N');
INSERT INTO `token_table` VALUES ('2c2224c28826458cbd70ccb58a3c4150', 'xuesemofa@163.com', '0bfdc48340504ec1b29bf7475848dca0', '1522823999391', 'N');
INSERT INTO `token_table` VALUES ('2c7c8d3c38264ae5bffac5e8e4977abf', 'xuesemofa@163.com', '4c67abaf4dc94e90acf80439b3706a8f', '1522823917099', 'N');
INSERT INTO `token_table` VALUES ('2cb255cb2803429d80f640986f917938', 'null', '0a7a26e06e3541368c2af4736014e7fc', '456976617873900000', 'N');
INSERT INTO `token_table` VALUES ('2e8ed025459947c7ad719686c726a3fe', 'xuesemofa@163.com', 'b358859f7a814098bbc8470c58fc85c1', '1523258175751', 'N');
INSERT INTO `token_table` VALUES ('301af4151bfd43c190893418ac9fda14', 'null', '61c661e7898a4dc4822b754905d4a108', '456850188496200000', 'Y');
INSERT INTO `token_table` VALUES ('302bdbbcf6074d638b01f0973d48906c', 'xuesemofa@163.com', '8afdbdabd784465bab117151821e574d', '1522825709462', 'N');
INSERT INTO `token_table` VALUES ('30aabb36374b4f88a49ea357cb2c6878', 'null', '6fa0b5a8f5b54a4fb61bfb4cac657efa', '456848379414900000', 'N');
INSERT INTO `token_table` VALUES ('30c2fda0b3194eb7b3fc27c648a92b8b', 'null', 'aa74444031ee44eba25ff099569ba5a8', '456972211512900000', 'Y');
INSERT INTO `token_table` VALUES ('3144be09db8b47b4a136604a0c32fb41', 'xuesemofa@163.com', 'c9a4e01537ff4b59bd5b2bc4d286b3ac', '1523256966442', 'N');
INSERT INTO `token_table` VALUES ('31d2eac2cf7244318a62c06d5084abb8', 'null', '7334b1352bd6467fa50698a1b0ad1c73', '456971967002700000', 'Y');
INSERT INTO `token_table` VALUES ('321c00639f8b42d189bf410fa7562786', 'null', '1eb925eac1a948cfbdba804f762e7320', '456972499341600000', 'Y');
INSERT INTO `token_table` VALUES ('3369f9bbd2704726aff445b8382af6b7', 'null', '5124f6f685954ff0910ca368e436a7d9', '456848377000200000', 'Y');
INSERT INTO `token_table` VALUES ('3570c8b5733b430786e9293ad3927bcd', 'null', 'def8a11cbec34932ba080b335da90f4e', '456972042862200000', 'Y');
INSERT INTO `token_table` VALUES ('365e1defac9046a09540a0772523fd56', 'xuesemofa@163.com', 'ed9908113dbf489cb1a1a0ea4b1140a8', '1522824105099', 'N');
INSERT INTO `token_table` VALUES ('38a7d61670b54a10a5830dc891fe3f11', 'null', '48f28db28a9a4ab087968ec1e88526fb', '456972180127800000', 'Y');
INSERT INTO `token_table` VALUES ('38cec14d67284bc1b28eb04b4083533d', 'null', '2c941ef5da8c48cdb501a679daa7734e', '456972636356400000', 'Y');
INSERT INTO `token_table` VALUES ('3917589cec1e4eacb59a65b9070cb17a', 'null', 'a2b3a4622f054e939e45be1c92332a70', '456848733559800000', 'Y');
INSERT INTO `token_table` VALUES ('3941d4126ba947ccb3fbde64804a4a87', 'null', 'cd388e184db4446e97b0d2ff970dfe33', '456976560732300000', 'Y');
INSERT INTO `token_table` VALUES ('399377437152414c8a7ba1710d1b0cdc', 'null', 'f56fd9e14b27438180ce3b580d98830b', '456848878706700000', 'Y');
INSERT INTO `token_table` VALUES ('3b82478d972a424f9fee417552b3f183', 'null', '04db9449a75944de88c69df52b0910a1', '456850180931400000', 'Y');
INSERT INTO `token_table` VALUES ('3bf16a18853648a292c1d15e15b918e7', 'null', '9656b3af34fd49f8b4bb2b6f65c2dc47', '456850177628700000', 'Y');
INSERT INTO `token_table` VALUES ('3c9427a5294848089fbba29976692e41', 'xuesemofa@163.com', '3b3df642928d4b48b1f87ca80ee451f8', '1522821396035', 'N');
INSERT INTO `token_table` VALUES ('3f33cd47f2b541aab52830ca8143e346', 'xuesemofa@163.com', '80d4fdca8e6e435dbb326d25bbbbee35', '1522834016950', 'N');
INSERT INTO `token_table` VALUES ('40206ac038e64cbba00aaffb99891044', 'null', '22308dc508cf451c9cadb21177b70b23', '456972282159300000', 'Y');
INSERT INTO `token_table` VALUES ('4043f61b30434f1085ec5049aa56eec7', 'null', 'b998bb0692484284a3cc6727438bc9f3', '456972616712400000', 'Y');
INSERT INTO `token_table` VALUES ('409d0882db71407eaa257caf1d56dfb0', 'null', '8a03576c614e46389dc7c2e49dd49e76', '456976626215100000', 'Y');
INSERT INTO `token_table` VALUES ('40b6d1e577894085b085c4aff6a30a31', 'null', '33936f9843dd45d6b7323b403b68e9bb', '456849020382300000', 'Y');
INSERT INTO `token_table` VALUES ('40dc75ce89d347f9bf8fec9680f54d2f', 'null', 'bff76271047548d281d00a701e451fb7', '456848976489600000', 'Y');
INSERT INTO `token_table` VALUES ('41514f8647ec452cb94cde425dcf1929', 'null', 'b0d1ce294de54aabb3d2e990a22ec64b', '456849761061000000', 'Y');
INSERT INTO `token_table` VALUES ('44bae2b04ee54a54a7a3681f89cc3636', 'null', '91c70773260f4795a333a86df159791e', '456972513515700000', 'Y');
INSERT INTO `token_table` VALUES ('44c5b306f8744c99b3ac092f6b33624f', 'xuesemofa@163.com', '34b9369bb6da41fe94423966edcf2e01', '1522833868748', 'N');
INSERT INTO `token_table` VALUES ('4525457d5d1044dc9ebe4e0669e61968', 'null', 'fe78a00132c14d70b872d2012fb00686', '456850156986600000', 'Y');
INSERT INTO `token_table` VALUES ('455619c14fc54624bbaf03398ee21714', 'null', 'b2605822ce304697a69d1553b443b675', '456972460755600000', 'Y');
INSERT INTO `token_table` VALUES ('460758c37d4b49cf921c83b234ff2983', 'null', '399810d5290d4e9b8ed038083a7aeb7c', '456976562335500000', 'Y');
INSERT INTO `token_table` VALUES ('483e8ad26d634f648fa365348c96ae29', 'null', '8558fb78f72a495299b0f2d66aef05ba', '456850247201100000', 'Y');
INSERT INTO `token_table` VALUES ('4890464739ce4712aa80ea5c2e5f04cb', 'null', '4379e221d4e94920ba7beebc1a911e1f', '456849347104500000', 'Y');
INSERT INTO `token_table` VALUES ('48d583ae9a324e18ae71707938f04164', 'null', 'e2e0c00d7c8a4307b787f33eeb735813', '456850288789800000', 'Y');
INSERT INTO `token_table` VALUES ('4979ac28bcac45f5b889f98e48fe08a0', 'null', '9904874e84144a609094dfeb8785e69c', '456972193275300000', 'Y');
INSERT INTO `token_table` VALUES ('49f51c1519fb461196d8ed039fe9cc8f', 'null', 'c3bc53066f5a4334b8f8260254f97db9', '456972641889600000', 'Y');
INSERT INTO `token_table` VALUES ('4a6b9a46afd749989f8146a3ff0244e4', 'null', '7c802146bb4541b0823e0bc63ff501fe', '456972194401200000', 'Y');
INSERT INTO `token_table` VALUES ('4a7ece71296e404ca4cf15810763e517', 'null', '05cbd0cdf5a947da81818b6fabaa09bd', '456848463955200000', 'Y');
INSERT INTO `token_table` VALUES ('4f641584f7534964af6db8cea22f93e9', 'null', 'a9adefa9c55d43ce83af1ac2ac107745', '456848454072600000', 'Y');
INSERT INTO `token_table` VALUES ('4fb6f0dd050a40b8adcc54464a6a64ad', 'null', '28f2587f51fd472194871888b7388616', '456972224976000000', 'Y');
INSERT INTO `token_table` VALUES ('5019559e38b2433c8fc1efec6f70af5e', 'xuesemofa@163.com', 'f6b9faf2d5804825aa6058af650f8306', '1522821727975', 'N');
INSERT INTO `token_table` VALUES ('52423ebc4fbc4bd7b35c4ca4851fcc48', 'null', '11445d59f47f41b98b2165f60f4fdd41', '456849543743400000', 'Y');
INSERT INTO `token_table` VALUES ('52589b5c7e1042ff90e789ec7730ea7e', 'null', '2f6c23f18d8c46fe8d6d661212b016df', '456848744496000000', 'Y');
INSERT INTO `token_table` VALUES ('535235c333764cafbe7b41b60a9f6bf6', 'xuesemofa@163.com', 'a6709ab37d384dd98de342f30bdce497', '1522825480420', 'N');
INSERT INTO `token_table` VALUES ('53c00d0e359c4c9a975941eaf76a8aaf', 'null', 'eae247dd5c6549a5bc1a5a01533f3794', '456849187901700000', 'Y');
INSERT INTO `token_table` VALUES ('5443b503b0c44da3a38ce38b992deb53', 'null', '310982a2e8404f51981636ea5fb3adce', '456849527931900000', 'Y');
INSERT INTO `token_table` VALUES ('5760affbf3a34f5093fce86c02b62961', 'xuesemofa@163.com', '351480f8120b40a49d917f8d7956b00f', '1522826999135', 'Y');
INSERT INTO `token_table` VALUES ('5767a84a1fa549bd81b78a9036d5dbe9', 'null', '5bf771ed0d314557ab80b7afd1ac3441', '456972511479900000', 'Y');
INSERT INTO `token_table` VALUES ('5c83ecca9f3f4a708b6ea432cad27c13', 'xuesemofa@163.com', '1c7143b55faa4b2298fc0396cdb7ce82', '1522824153168', 'N');
INSERT INTO `token_table` VALUES ('5dbbdfc720d344ee9603d6681cdd59d1', 'null', '3ad56fc6c3c049c6a02ad78132cd9c57', '456848810236800000', 'Y');
INSERT INTO `token_table` VALUES ('5dbe1137bd8a49b3a8f76e3b16a7d9b7', 'xuesemofa@163.com', '900fa34034254e64bb2c3090086d12cf', '1522823487607', 'N');
INSERT INTO `token_table` VALUES ('5dfa0a4c8a0b4294a559bfc0edd0597f', 'null', '3246df326e3e442995e8f73b8742fa64', '456849310476000000', 'Y');
INSERT INTO `token_table` VALUES ('5e155b9d3d3f4991b21dd8bdaf8b4da7', 'null', 'ff30526ad4fa45e4b13c20c3183969ab', '456848487170700000', 'Y');
INSERT INTO `token_table` VALUES ('5f14416c5852417ea76d97b97d97dd6a', 'null', '2167a8f1d9694ee087647f15b467c50f', '456972295072800000', 'Y');
INSERT INTO `token_table` VALUES ('5fb56c0434b44be6b4add63ec7aa8f15', 'null', 'cf56703497fe4dd99a1912a539b7e9d0', '456972647676600000', 'Y');
INSERT INTO `token_table` VALUES ('600d9dc152934a94ac883ecedff408bc', 'null', '7d5ddf96d1ad4587affe04aa9ea65444', '456848772412500000', 'Y');
INSERT INTO `token_table` VALUES ('6059dc9b5aff436dabd927aff17002ea', 'null', '852ae80dab6a4907b8516265e6c2f60f', '456849431156400000', 'N');
INSERT INTO `token_table` VALUES ('608aad68e8334b72a6de0881630f956a', 'null', '359753a88999488380c6ce087d10ea01', '456972156127800000', 'Y');
INSERT INTO `token_table` VALUES ('60fb76ffa180412ab10f16ebf7746643', 'null', '08a984ee5f80422a8b62493b6e216c0c', '456972471386700000', 'Y');
INSERT INTO `token_table` VALUES ('61721fe7355a4838a33c5c609b4226d2', 'xuesemofa@163.com', '7d1785925b4e43f08eddfb27eb9e7477', '1522831494482', 'Y');
INSERT INTO `token_table` VALUES ('618b059d2cae476b8b1af04bb028706c', 'null', '74b30181638542a19b74b775d690258e', '456972414129000000', 'Y');
INSERT INTO `token_table` VALUES ('62235ee548d446ac81071425af083814', 'null', 'c7ea3a42f3b446e8ad517bf122be2a39', '456849542663400000', 'Y');
INSERT INTO `token_table` VALUES ('62ddf0feb14844c797dde6570e7dfde4', 'null', 'b036d7b0fef543149a45c69eb0490c71', '456848978333700000', 'Y');
INSERT INTO `token_table` VALUES ('6410254c43e84a6ea9a3e4c2ead342d3', 'null', 'f9eade0a3df94795bb15c1653a2d837e', '456848421850200000', 'Y');
INSERT INTO `token_table` VALUES ('64c60c18298242b4b68dc5f08a278b25', 'xuesemofa@163.com', '5c19cf5e10d041b0b71b895910225d27', '1522823098517', 'N');
INSERT INTO `token_table` VALUES ('650767f26e6d4bc7a36e29da65108040', 'null', '280c9e849bca48ba923d6cf55a331e80', '456849076756800000', 'N');
INSERT INTO `token_table` VALUES ('65ac59e464b445e1b874c6c9461b6cf4', 'null', '5dc9c3cb167e4674a43e95b5e46f80ed', '456850094553900000', 'Y');
INSERT INTO `token_table` VALUES ('679938f42eb647c2b7dbb8c412cf36ae', 'null', 'c4ecc91039754a29b7cbdf9361e221a3', '456848773337100000', 'Y');
INSERT INTO `token_table` VALUES ('67fd726f9aec45fb9fbd726a41c37c1d', 'null', '79a479ca9d074274a5bdd18fa9586386', '456972202620900000', 'Y');
INSERT INTO `token_table` VALUES ('69341e42348b482f82ff05a8333901ad', 'xuesemofa@163.com', '169c2b6cbb684b1592ead171640d4cb7', '1522832636485', 'Y');
INSERT INTO `token_table` VALUES ('6a244acc25804c5db6e834d96146b863', 'xuesemofa@163.com', 'd464151ce073403d916bbd661a6aec5a', '1522824599821', 'N');
INSERT INTO `token_table` VALUES ('6ada8bf5f8bf417eaa09298141fc014a', 'null', '86b9dbfc49f445939ea822bd05a5dbc9', '456972386378100000', 'N');
INSERT INTO `token_table` VALUES ('6ae5d81360ec4ae19ed14340752f0832', 'xuesemofa@163.com', '98cfa90b763f40d8880075393b5d6313', '1522827038847', 'Y');
INSERT INTO `token_table` VALUES ('6b169862e35a4336bd188e880f5557a4', 'null', '661bff55e770431297bfc7fad4ae9dbd', '456972443145300000', 'Y');
INSERT INTO `token_table` VALUES ('6b9af4b0546b4fb09fa4b05dc1a7775f', 'xuesemofa@163.com', 'b05804d2ffc44e67887ac49517917a4b', '1522825526473', 'N');
INSERT INTO `token_table` VALUES ('6bd22a2fa6084067b2187a7b9df0cc6c', 'null', '8f5b3bbe3ed04d8f9cff48a85f54ba98', '456850010263500000', 'Y');
INSERT INTO `token_table` VALUES ('6bfaf0d441ab4eacae823e51e0f8654f', 'xuesemofa@163.com', 'fbab1382ddb94f8a9a3a7764120cc7f0', '1522824253180', 'N');
INSERT INTO `token_table` VALUES ('6c4f6e4d1bc44ddb96b8b629bb1c3705', 'xuesemofa@163.com', '681e78e75108436dac1e1188522b0098', '1522830964153', 'Y');
INSERT INTO `token_table` VALUES ('6d08ecb12dce48f2ac989b67d4341362', 'null', 'f049fce5e5ba4212ab836743ae67c671', '456972448795200000', 'Y');
INSERT INTO `token_table` VALUES ('6d426dba9bea4b639252ba99a8d9656a', 'null', '5f0676f14e67476b9a9471c4e3c9c41f', '456848742632100000', 'Y');
INSERT INTO `token_table` VALUES ('6d6c5d9147b04208ab73ad0c994a642c', 'null', 'c4f3ab79b55047ccb74864bcb6015c97', '456850095875700000', 'Y');
INSERT INTO `token_table` VALUES ('6e75dd772f0e4ecab0f194384d4e1169', 'null', 'b36ce27549f44bd9be90417e4d73b8da', '456850272585300000', 'Y');
INSERT INTO `token_table` VALUES ('6f1f919c8a9c4fe0b7956fbef13343b9', 'null', '10e9e8b1a6ef46c48089adeba2e57636', '456972518322900000', 'Y');
INSERT INTO `token_table` VALUES ('7069483a31934eaf819d16157978f096', 'null', '8c0631e7bf22437d9fa47ad149c17182', '456972022727400000', 'Y');
INSERT INTO `token_table` VALUES ('709374e94d9744c5b8df0bbe08f5b348', 'null', '7a18cc94b046430090c1d3a4493668ed', '456976980658200000', 'Y');
INSERT INTO `token_table` VALUES ('720bdc4899d947aab1d0c08a12690eda', 'xuesemofa@163.com', '22fb9c6292374ddab66cfe4b53e9c4e2', '1523257006859', 'Y');
INSERT INTO `token_table` VALUES ('739a7cd0dc2843c791885fc7681f27d7', 'null', 'e85d4bdeff50480f89712f6cd91a3b0e', '456972646315200000', 'Y');
INSERT INTO `token_table` VALUES ('73e5def2440149fba600c7909821ab8d', 'null', '0ed311b475d3481c91779e7e7e473db9', '456849042621600000', 'N');
INSERT INTO `token_table` VALUES ('76a66c8ea22f44afb19fa7e636994cd6', 'null', 'e31e68da9988437683df04d0b4be18e5', '456850290413400000', 'Y');
INSERT INTO `token_table` VALUES ('76c807099fa14a08a34376ada6e49d96', 'null', 'fe40a16702aa4de1ba8fe21dd51ab4c9', '456976979771700000', 'Y');
INSERT INTO `token_table` VALUES ('77c3347b9e56460abeadf8b11aa23fd0', 'xuesemofa@163.com', '7ea66a82e0434448a62ceeeaa3caa187', '1522824472723', 'N');
INSERT INTO `token_table` VALUES ('782f6d7fb1ea4cfb9546e4a3af9c4ef4', 'xuesemofa@163.com', '2806bb8b26ef4865b9dea5110b680dec', '1522824890357', 'N');
INSERT INTO `token_table` VALUES ('78973c7ea06c4b84857daf56cf0377ca', 'null', '9c2eac81fc6048eba6e3261a6f915240', '456972217549500000', 'Y');
INSERT INTO `token_table` VALUES ('7b6f3c173e8b4e90bd478782dea0142e', 'null', '961d99eb8922420faf633dd79ac844a9', '456976616428800000', 'Y');
INSERT INTO `token_table` VALUES ('7b938f712e0a4118b68739da197990d1', 'null', '783c0c8fdbcb4772a687620e9df55661', '456977129308500000', 'N');
INSERT INTO `token_table` VALUES ('7bf3118a46404b33819ca6dde434aeb9', 'null', '954f2651a02d4b0a8b22268087843f8b', '456972163803900000', 'Y');
INSERT INTO `token_table` VALUES ('7c0243d821594141babbefdd1264f9c5', 'null', '115671dbdbbf444eb1eb9abea910879c', '456972510376800000', 'Y');
INSERT INTO `token_table` VALUES ('7d0be0d69a30471fa4c2337ce1bd9cb9', 'null', '19cb5a3d978340f3bd1888b0cbd4a2bd', '456850086493500000', 'Y');
INSERT INTO `token_table` VALUES ('7dfb74bd3ea04c3287f3cbb6eb10e9fe', 'null', 'e69ecc580ab44dc28596347d0fac5c21', '456972516223800000', 'Y');
INSERT INTO `token_table` VALUES ('7e35a403002f44708b83ecc4981ffcad', 'null', '4b1bb83d07ef4f10a394b0580ba2f1af', '456972205221000000', 'Y');
INSERT INTO `token_table` VALUES ('80da288f3e27454faf0fbc3414e8ea62', 'null', '5720962e276c437fbf4aa217e64a59a0', '456848481291600000', 'Y');
INSERT INTO `token_table` VALUES ('810d7a81431e42b98fab648fcb891dae', 'null', '3674737181714a2c8edef009f25a3596', '456971991032100000', 'Y');
INSERT INTO `token_table` VALUES ('81630c062fcd47bb84ff32d468123130', 'xuesemofa@163.com', '413f147b7de54c7a9cee4fd747757669', '1523242189222', 'Y');
INSERT INTO `token_table` VALUES ('81e34382b8cc4ef793c3c03011b37657', 'null', 'c104f0459ee148d1a75370d83559a5aa', '456848397303900000', 'Y');
INSERT INTO `token_table` VALUES ('82b8a6c1f45b4ea685678994201ec578', 'null', '2e5083cf773d40ebbab0f3c2e376a2cc', '456972176771100000', 'Y');
INSERT INTO `token_table` VALUES ('82d60189400f43368ab6c6a842ace905', 'null', 'aecd539fde1d4a0cb7b126899b8076a2', '456849221599200000', 'N');
INSERT INTO `token_table` VALUES ('82d944149ee94d6b998d67c10c85c1c4', 'null', '10397d63a04a4f699913900987b751b2', '456972009470400000', 'Y');
INSERT INTO `token_table` VALUES ('836b22d330674967924bc736fd20531c', 'null', 'a80c8c9f98e94e358b2f61247d3c859e', '456972473988000000', 'Y');
INSERT INTO `token_table` VALUES ('84f6a2ab6fb8435d9c7b8dfa5d13a843', 'null', '0fc092b1bbcb4905b493e56af72263dc', '456847832807400000', 'N');
INSERT INTO `token_table` VALUES ('8612dd9ec4ca4d999e7ad78ee1f04af5', 'null', '621361dc87114c09bc30f33da5a642f7', '456850295092800000', 'Y');
INSERT INTO `token_table` VALUES ('878364f448984e68bb13599e575395db', 'xuesemofa@163.com', '6b85a414a537435f9b40167caf410cb2', '1522824390939', 'N');
INSERT INTO `token_table` VALUES ('88214da80e01457cb27819c572f350ae', 'xuesemofa@163.com', 'de06234c640342879b997266c0c427ff', '1522825284831', 'N');
INSERT INTO `token_table` VALUES ('8a959b1b77b7428b812af0fe319018d0', 'null', 'b0b2fabfd9164a5da8afdb727d2dfd2b', '456972519857400000', 'Y');
INSERT INTO `token_table` VALUES ('8e58b1a99d744b468a3966ceb232def7', 'null', '49a8eb15762748b08e1012b0c5f60f73', '456849298978500000', 'Y');
INSERT INTO `token_table` VALUES ('8eb57629030d4e37b24c203cae79daa7', 'null', '71b5825be2b743c0bba52d863bb7101f', '456848879506800000', 'Y');
INSERT INTO `token_table` VALUES ('8f052beee2b74a3ca92337247538531e', 'null', '05fe5b5732014f00bf1731fd2cbb6c31', '456848737592100000', 'Y');
INSERT INTO `token_table` VALUES ('8f75b8fe8f2948338f63648d9b42e525', 'null', 'd952c827cc8a45fb8438481eed5b5242', '456850064301900000', 'Y');
INSERT INTO `token_table` VALUES ('901ee0b014f14d2f84667873732efdad', 'xuesemofa@163.com', 'f876d896370045c4a5dda5776a16ed84', '1522834145769', 'N');
INSERT INTO `token_table` VALUES ('9072391e9f874f9e99e7ce8a1d1f8f9c', 'null', '6c2267329f7d4ec281b1e94b00918027', '456972514963800000', 'Y');
INSERT INTO `token_table` VALUES ('9087e378d8b24398a607b17f2c87b290', 'null', 'ee3fd39e23b848beb0fa3f76468d4bdb', '456849283206600000', 'Y');
INSERT INTO `token_table` VALUES ('915315a7643e4f73b09797cf8e2cc6f9', 'null', '8baca31a6a394a1089207e36749ae679', '456976586182800000', 'Y');
INSERT INTO `token_table` VALUES ('918a5b0de4aa4f01a4fe76a679db22b6', 'xuesemofa@163.com', '812051d5891c43ba92ef3babce22a631', '1523258434034', 'N');
INSERT INTO `token_table` VALUES ('92053fbc06814621b4cfd0f7fbace3fb', 'null', '7d6ed7c03bfc4c0c87a05bf8409d6884', '456972185655900000', 'Y');
INSERT INTO `token_table` VALUES ('925b058648124ed885fe924aa06878dc', 'null', 'fcf0cb4fe392457baef8ceb8f417d790', '456848466212700000', 'Y');
INSERT INTO `token_table` VALUES ('92a78bfdfdb54ad08a752d2f6b8f6a22', 'xuesemofa@163.com', 'f1041f62891042b3b555616a1c28e0ad', '1522822006547', 'N');
INSERT INTO `token_table` VALUES ('92dc1ac372f94ace93112fc3d3d755f7', 'xuesemofa@163.com', '3dc6488950254fba90dc2c1a01d42fdc', '1522831035407', 'Y');
INSERT INTO `token_table` VALUES ('9476805415ed458d850d4ea9d909b334', 'null', 'e0a84b3708474f668715f529808ce3a4', '456972011679000000', 'Y');
INSERT INTO `token_table` VALUES ('95e753d1a6e0402cbb5a33cbe4201ff9', 'xuesemofa@163.com', '19fe167a9053400295eb3f443173f95c', '1522824624029', 'N');
INSERT INTO `token_table` VALUES ('95ee0c30796f46b3812f9a325be7451b', 'null', 'f23992259c0146079d0d1b4528b84f77', '456849549551400000', 'Y');
INSERT INTO `token_table` VALUES ('96177eb9795d4a138b33a0bf712c0a1d', 'xuesemofa@163.com', 'eb708290813d4224bc2c70ccfc50396d', '1522831754288', 'N');
INSERT INTO `token_table` VALUES ('96e29a1eecaf4219a214ce9b6ed2bf63', 'xuesemofa@163.com', '723ad94318164bde87302aef0f48a859', '1522821030405', 'N');
INSERT INTO `token_table` VALUES ('9922560b04534cd98bbdc1f65d0d9e03', 'xuesemofa@163.com', '9b61d8939d1743d5bc55398c48496ec3', '1522828810560', 'Y');
INSERT INTO `token_table` VALUES ('992b636c83594736b51fdd0c25bf47bc', 'xuesemofa@163.com', '8dff87cdc8434d929f3b7f2f875a6bc7', '1522834127460', 'N');
INSERT INTO `token_table` VALUES ('9937ffaa39c948b3b7f497ee0f02e45b', 'null', 'a423ee342c924c5bb4d5b684e72e6046', '456972206781300000', 'Y');
INSERT INTO `token_table` VALUES ('9a6670d77bd34ecfb2c740d72a77de33', 'xuesemofa@163.com', '606f33fac64347369cdb0c3feeb80058', '1522827508711', 'N');
INSERT INTO `token_table` VALUES ('9c8e3e74f6fc4feea19aa019da00472d', 'xuesemofa@163.com', 'e0216fc35ee448299d17e301757f5e4d', '1522831837236', 'Y');
INSERT INTO `token_table` VALUES ('9d3ddd8a725441a2b868e448f040eb4f', 'null', '2dfcf6a9e62142bea7bce4c92c99908b', '456849041683500000', 'Y');
INSERT INTO `token_table` VALUES ('9dc5ccc04ad64e88958d3c0fd109762c', 'null', '618e004af9174023ae3c41cb8d5dda58', '456976973875800000', 'Y');
INSERT INTO `token_table` VALUES ('9e9adc9c947a4549830b67d5c830feda', 'null', '09baeb77989a4e6f8794f8ec3c1df755', '456972289553100000', 'Y');
INSERT INTO `token_table` VALUES ('9eba6dea92594806b7a4cb43c0b9f2b2', 'null', 'f6201168c1324b0b96d30fa63cbfd077', '456971968424700000', 'Y');
INSERT INTO `token_table` VALUES ('9f4b29d33a584fef8ed95f94a17403d1', 'null', '28c324f3011448e383a613d5da75ab43', '456972165307800000', 'Y');
INSERT INTO `token_table` VALUES ('9f6269c7eae04899a7a12acfbd08a6b8', 'xuesemofa@163.com', 'e4604ed51356466ab38a30fc7b038570', '1522824138839', 'N');
INSERT INTO `token_table` VALUES ('9fea6c66b5e147b8b9fc41bff15c4690', 'null', '7ce3568a71bc4b55941bd7326a931eaa', '456849220627200000', 'Y');
INSERT INTO `token_table` VALUES ('a0c7ae0fc7254762b212012f8e55a7c6', 'xuesemofa@163.com', 'a13b24abf5ea43e8947e9257136fd38c', '1522824863263', 'N');
INSERT INTO `token_table` VALUES ('a0ca1e132b244950aae7adccb45b031f', 'null', '64bf78237c9449febac73f57dd44f678', '456848743945800000', 'Y');
INSERT INTO `token_table` VALUES ('a0f14577c281480bb56e1722a8e41df1', 'null', '99c09c76a75c420480cc8a3fef171129', '456972386354100000', 'Y');
INSERT INTO `token_table` VALUES ('a18b772bae30424985e47ba85e4c7286', 'xuesemofa@163.com', 'e5ff892c73024f828e0a8236467e8d86', '1522822878529', 'N');
INSERT INTO `token_table` VALUES ('a218aedd8f274b679a974afd600889ed', 'null', 'ae92cffd43f14f4dbddb0bbaf0c61360', '456850081853400000', 'Y');
INSERT INTO `token_table` VALUES ('a37580bfbd5a4152b0ad9fee48fea079', 'xuesemofa@163.com', '10d377b360d5483893e4bec90cf8f6c4', '1523256314955', 'Y');
INSERT INTO `token_table` VALUES ('a3b7b4d72ff243ebb7324dd3e4646e26', 'xuesemofa@163.com', '9b262a550ccd4ae495d7869a9093390c', '1522827695421', 'Y');
INSERT INTO `token_table` VALUES ('a3ec5142d50447d8bfbbff10d36bd20d', 'null', '694171c4789d4d0b952672366b764f79', '456972044651400000', 'Y');
INSERT INTO `token_table` VALUES ('a4117fd5634f4fce957f825fd706da81', 'null', '84d012d8f67b49d89f574f7d2a800759', '456849002398500000', 'Y');
INSERT INTO `token_table` VALUES ('a5f58ad2ab5f4a648fc2ad024086f74e', 'xuesemofa@163.com', '4f753e6f14a04f8e8755a38641c73d8f', '1522831632015', 'Y');
INSERT INTO `token_table` VALUES ('a6486123193d4e4d855ee11f5f08bf63', 'null', '15ec7daad9944afeae49d0eea7f27548', '456849853590900000', 'Y');
INSERT INTO `token_table` VALUES ('a7749ceb22324f9fb437ea4418e731b2', 'xuesemofa@163.com', 'b2014e2a93654f0cbc89f221a3133095', '1522822832779', 'N');
INSERT INTO `token_table` VALUES ('a868aa80cfab467ca25e8ccf59159530', 'xuesemofa@163.com', 'cf35e888e0bd40ffb018f89b33701f34', '1522824065884', 'N');
INSERT INTO `token_table` VALUES ('a8f508b2fa2d43f0bf8ccdb9166cdc9d', 'null', '2d423cc7b36f4d9b92d795e038392c5a', '456848730811200000', 'Y');
INSERT INTO `token_table` VALUES ('aa9fdc051611406393037ca2f3cc5561', 'null', '3697c31261e34d498944e8923249c9af', '456972004224300000', 'Y');
INSERT INTO `token_table` VALUES ('ac324f3a1f21443e8266d20a6870d834', 'xuesemofa@163.com', 'a1db2074aa864cbebd616c51e75b364c', '1522820186414', 'N');
INSERT INTO `token_table` VALUES ('ad693824780048c8bdeb1cb4e6a77bcc', 'xuesemofa@163.com', '2011051b75564e928cad9434423aa61a', '1522821890595', 'N');
INSERT INTO `token_table` VALUES ('ada2ea24ec504e9eb154c3cf795105f3', 'xuesemofa@163.com', 'e04d224158ee4719aa1995ebb86b6642', '1522821983057', 'N');
INSERT INTO `token_table` VALUES ('ae0b475cd2b94c6982acc4bd3fc5c0c6', 'xuesemofa@163.com', '38ecb028c0594cbabb62ffeac4b88b73', '1523256517494', 'N');
INSERT INTO `token_table` VALUES ('af82ba6755014eef92161015e5d7d135', 'null', '35d7dd704b274391ab9ed1debcf9aeaa', '456972519272400000', 'Y');
INSERT INTO `token_table` VALUES ('afc36d9c18cf4c65b2adacfa55c02ef9', 'xuesemofa@163.com', 'e932d99e02b341eb894b0bd8e5bad804', '1522822633012', 'N');
INSERT INTO `token_table` VALUES ('affaca9cd4e54232bcd33e12c3017f39', 'xuesemofa@163.com', '8a8ddd17a8cd417fa05c2a178980ace2', '1522825462228', 'N');
INSERT INTO `token_table` VALUES ('afff6087334a4176b0e55ac554470a97', 'null', '271060bb58be43a692242d5b4f730fdb', '456972517571700000', 'Y');
INSERT INTO `token_table` VALUES ('b14499e209df4e3d9cbedcfac156b6d3', 'null', '56dc4e60a53e431ab68ebea2470fdb3e', '456848979204300000', 'Y');
INSERT INTO `token_table` VALUES ('b1761c7d724c49248b70312d7bd3076c', 'xuesemofa@163.com', '6c49fd7d5cf94511a29bc1e81e4d17a9', '1522828884755', 'Y');
INSERT INTO `token_table` VALUES ('b215580330f64d75b009062f408f7a38', 'xuesemofa@163.com', 'b6c9db5c9a1d4b039f6add5afb3b7270', '1522828748221', 'N');
INSERT INTO `token_table` VALUES ('b240fd52356b479bae888391640c2958', 'null', '9f8f1b822ee4409c965113a273209a58', '456848442813000000', 'Y');
INSERT INTO `token_table` VALUES ('b24475d1e5a14d61a40dbaba8a94b9e3', 'null', 'd54a44ed779b4238b68aa8979972405d', '456849309274500000', 'Y');
INSERT INTO `token_table` VALUES ('b35137c83273422c86ed55b9ed7a9cc4', 'xuesemofa@163.com', '87126503dc924da3932e1894501fdaf1', '1522824517408', 'N');
INSERT INTO `token_table` VALUES ('b45f953e171b4b5fbd276ab460040e55', 'null', '1e8343cc6837404cab15c22cde2e032b', '456848517830100000', 'Y');
INSERT INTO `token_table` VALUES ('b6e5409fbd8b4f90bd7b422dfbb7ecf7', 'null', 'a6ed0388de434d5bac5238a6ace5e1db', '456972415352100000', 'Y');
INSERT INTO `token_table` VALUES ('b7c4d407f2f344a486510cc138f2f8ff', 'null', '4ce4dd0fab3348159d3100dbe14e1464', '456848464612200000', 'Y');
INSERT INTO `token_table` VALUES ('b8e4b6afecd243b989a827c31fe5e25b', 'xuesemofa@163.com', 'f118e5f6ff9f456fb9f6048422dd670f', '1522822897353', 'N');
INSERT INTO `token_table` VALUES ('ba1427bf219147c19526880e4f557b06', 'null', '105034aae8704f619651a2dc8c49b3b6', '456848729707500000', 'Y');
INSERT INTO `token_table` VALUES ('ba45cda4956d42ff9cfc8c878dd2203e', 'null', 'a5a6bc78fcd34d16b9946bae2246d8a4', '456972277024500000', 'Y');
INSERT INTO `token_table` VALUES ('ba6e1682f1b64537ac9e60ce693bf34c', 'null', '1f7e384f9a0e4719be649c0d953d314e', '456972351752100000', 'Y');
INSERT INTO `token_table` VALUES ('bfcf44c47a0e441a98212ed23780fe55', 'null', '380b4585275a4c8d93f5eb6ad9ed5183', '456849745239600000', 'Y');
INSERT INTO `token_table` VALUES ('c14c0eb8252248f5a4e7cee90fd975f5', 'xuesemofa@163.com', '976632c9c0684650a2e42efb38b1cac3', '1522823861676', 'N');
INSERT INTO `token_table` VALUES ('c19804bdfbe0423cac247ca6216ebecd', 'xuesemofa@163.com', '3de25c220fd34456b244ba5f022bb859', '1522823361980', 'N');
INSERT INTO `token_table` VALUES ('c1cecd7a603145859a047fa2b9fd193a', 'null', 'df22bd9da79e422b90b0907692795021', '456972376884600000', 'Y');
INSERT INTO `token_table` VALUES ('c2932c02e1264178a5510a34cdd31212', 'xuesemofa@163.com', '2631f62ed7fc4cfd9721a810f960aac5', '1522831376001', 'N');
INSERT INTO `token_table` VALUES ('c2e19cf8fdd5401798b171c0a9d394a7', 'xuesemofa@163.com', 'be17f485194d455aa4b417c8babb192f', '1522831148884', 'Y');
INSERT INTO `token_table` VALUES ('c550d22522f444059fe91ca265be1826', 'null', 'cde2f0aaaa11458c8c2ebbac474c253e', '456976617244500000', 'Y');
INSERT INTO `token_table` VALUES ('c6be5febabe448edb26cebf164b34ee7', 'null', '3c207df7efb84f07a2a603add6950e63', '456972220538100000', 'Y');
INSERT INTO `token_table` VALUES ('c6ee5270248b423f928d55f8d071b453', 'null', '2fb39107801c48f39bf721c70d8b9159', '456848399333100000', 'Y');
INSERT INTO `token_table` VALUES ('c81436d67013459199ec46f242ac0bf4', 'null', 'a10514e7f90543ab94109c47fbfebace', '456848077030500000', 'N');
INSERT INTO `token_table` VALUES ('c9a64bb7e26c4c6f99ce063b44bbae3a', 'null', '8d6e149b53cd46e2b585ed9089c01095', '456848732317200000', 'Y');
INSERT INTO `token_table` VALUES ('ca0886aab50e411e9ae2d86e23ab0f66', 'null', '0d8691c23c434db395318af83b726d62', '456972629498400000', 'Y');
INSERT INTO `token_table` VALUES ('cb178cd5481a419ab4cda62683da98de', 'null', '85589aba846f44609de1a4780df4e9a5', '456972281339700000', 'Y');
INSERT INTO `token_table` VALUES ('cb7e31fa99df47d9aeca574864b29881', 'null', '419489241655441d8d1a8e0a2ded2f09', '456971893334700000', 'Y');
INSERT INTO `token_table` VALUES ('cbe464e230b14d998a7579bfef278541', 'null', '7dd3b11b3a324186bf89b297c71c8ae6', '456850296274200000', 'N');
INSERT INTO `token_table` VALUES ('cc5d6522a0be4ebd88417ad50d887533', 'null', 'c8e6f281e16046c78708ccab49947938', '456849744043800000', 'Y');
INSERT INTO `token_table` VALUES ('cd19f0a3fe544870a14ea6b7bd34971a', 'xuesemofa@163.com', 'b5e36327abb44b78a3e0d3347e0be9c1', '1522821921345', 'N');
INSERT INTO `token_table` VALUES ('cf1e157c5a604445bf5e9250a9d0def1', 'null', '393b3ffa8b2e42489a9d9e8f6614ac03', '456850078214400000', 'Y');
INSERT INTO `token_table` VALUES ('cfc7fe83a6e1425f8969a38175870d05', 'null', '8ae4ee1159df43e6b93188789e25cdc5', '456972453579000000', 'Y');
INSERT INTO `token_table` VALUES ('d0c8fb98cee74074ace0fd6b19fa0715', 'null', '8033c05ddcb84966a7fddcb4f858e5ff', '456972038057100000', 'Y');
INSERT INTO `token_table` VALUES ('d228c92702bb4f77b00c0f79b294d18a', 'xuesemofa@163.com', '29f4e44bd1ed4e228ee043d32403c7c0', '1523256867583', 'N');
INSERT INTO `token_table` VALUES ('d23f833a80fe48c0b3eb8be87c02ded9', 'null', 'ac31c47039304b6c80d70dcc66bea726', '456977128662300000', 'Y');
INSERT INTO `token_table` VALUES ('d2823ce97b4b40fe9c42b9a3dd8f2358', 'null', '77b7faf0c745468d8f7184f84f6a5ad2', '456848735907600000', 'Y');
INSERT INTO `token_table` VALUES ('d3463032b3dd483a9d5bf79cd34630f1', 'xuesemofa@163.com', 'bf545356cdc34e8d9d9a238441a826cb', '1522827857799', 'Y');
INSERT INTO `token_table` VALUES ('d4c030aaf820414dab9c5ce16f90f265', 'xuesemofa@163.com', '4557f1cf8f0f44868e1e68900cf25c90', '1522825315275', 'N');
INSERT INTO `token_table` VALUES ('d526ba1984cd4eba91afe7f6c298227f', 'null', '6813d22891424344a18192468e2f2c7f', '456972189328200000', 'Y');
INSERT INTO `token_table` VALUES ('d5745b2b9ddc426eada6bf374ceb6f0a', 'null', '1ad46b52f82e49d682e207b4e9e8e1a6', '456976591893900000', 'Y');
INSERT INTO `token_table` VALUES ('d60502eb911d480fadf7848d7eb1c87a', 'null', 'd3ef53fe619f4ba3a18825b5b0be116f', '456972514171500000', 'Y');
INSERT INTO `token_table` VALUES ('d6692fb8030b4ad38a2cbd055f27b6e9', 'null', '9dc25cbdcbb9403097da8fb31e30f8fe', '456972200838300000', 'Y');
INSERT INTO `token_table` VALUES ('d6b8d02440cc40e791edfc51f148df5a', 'xuesemofa@163.com', 'b80c2ede1479417fb9ec4a3f20db4b7a', '1522824205707', 'N');
INSERT INTO `token_table` VALUES ('d7cad1b20ae74ea591cb7561dc63b4f3', 'xuesemofa@163.com', '99f3f608c09547f8993a84e71ca89faa', '1522833989112', 'N');
INSERT INTO `token_table` VALUES ('d7df00b80e054bb58506aff9fa1b4c07', 'null', '218400bc752d41fbb61e7905071d605a', '456850085539200000', 'Y');
INSERT INTO `token_table` VALUES ('d959148e15234fdaa41fd69372f4b592', 'null', '555fb2fe4c814f18be50b3f20e98e95e', '456848994405900000', 'Y');
INSERT INTO `token_table` VALUES ('da17e54acefa49c0b7ed8267cdbed5c6', 'xuesemofa@163.com', '7e87a4cbe66e4a3b87983acb5e0b7d12', '1522821952968', 'N');
INSERT INTO `token_table` VALUES ('da73ed8b3ecf4af0906129e93c3cd565', 'null', 'e5a4a651b3d540e4a9102ce97b0ead69', '456976559138700000', 'Y');
INSERT INTO `token_table` VALUES ('da8536cf35a446e09c7ba464cf7295cd', 'null', '2d68ac8929a94aa7a5df3e93c331797e', '456848520331500000', 'Y');
INSERT INTO `token_table` VALUES ('db5b3fd34e394e4da3ae08429261d9ba', 'xuesemofa@163.com', '245b140eb3b0414581eee43e45c3f5c2', '1522820856154', 'N');
INSERT INTO `token_table` VALUES ('dcad2deeee944cd09fe6c554f4b08436', 'null', 'e43b8a6004514dae9c4f31d7f1974161', '456976588456200000', 'Y');
INSERT INTO `token_table` VALUES ('dcee48be1b7242b8872caf8d69e19510', 'xuesemofa@163.com', 'd5f4e7d3fc5f4b8abdf19bf0c7781b46', '1522821420972', 'N');
INSERT INTO `token_table` VALUES ('dd316b5a392f450e842e9b8a3be4804c', 'xuesemofa@163.com', 'b16c455b3ad24bec9cf84c97c7318214', '1523257598050', 'Y');
INSERT INTO `token_table` VALUES ('decc78557fac4029a823fc72432ac851', 'null', 'ba5b9be3faca4e68ba59c5ec831800ce', '456848786597700000', 'Y');
INSERT INTO `token_table` VALUES ('dfc34e90a74f46fda78464064cc65ceb', 'null', '8a4016b80c9546bcad3fca186a1a2e22', '456972168651900000', 'Y');
INSERT INTO `token_table` VALUES ('dff3d7538280404fa5f2539646d084c4', 'null', 'bb92a844971b4b60b3c8518ac0392e34', '456849829779000000', 'Y');
INSERT INTO `token_table` VALUES ('e01afe1b652f4049a478293aaf2b368f', 'xuesemofa@163.com', '53ed7561d2cd4be2981333e1f24c8237', '1522823693130', 'N');
INSERT INTO `token_table` VALUES ('e0516d77d9f84a3ca84d1b10a93b89d3', 'xuesemofa@163.com', '488730a647f94e5baf13304c8fd6f5f6', '1523240539789', 'Y');
INSERT INTO `token_table` VALUES ('e0580f3e0f18454bb78f739fbf13aef1', 'null', '7b43da4dbd1747fa91d626172d557064', '456848743169100000', 'Y');
INSERT INTO `token_table` VALUES ('e1119a3e29184b0993422d256a1a55a8', 'null', '63b93b3b73a4492da3d288ed4ee666d9', '456972398790900000', 'Y');
INSERT INTO `token_table` VALUES ('e178a6b349474b84ada98327ea4a4344', 'null', 'aa5331edc2354c8a82872ed48fb08c8a', '456976635558600000', 'N');
INSERT INTO `token_table` VALUES ('e1a06f626d7b41ea913e81102605035b', 'xuesemofa@163.com', '5c34110cc92c4f90acb73cf656463cac', '1522820857255', 'N');
INSERT INTO `token_table` VALUES ('e20c76234f88408382bd1e1336c32768', 'null', 'bb67416671d34ebba2aeb1b4ec5d7240', '456849075873300000', 'Y');
INSERT INTO `token_table` VALUES ('e2b7da84e7534235a537bf046e9f6116', 'null', '04486272415f4bef845e4e14e53f0297', '456850003876800000', 'Y');
INSERT INTO `token_table` VALUES ('e2cf24a511ae468c8172fdbfcd97b5e0', 'xuesemofa@163.com', 'ea6fa05ae88345419cfd53eacf00fb9c', '1522823126496', 'N');
INSERT INTO `token_table` VALUES ('e3fe5219c73244ec8d62a19c90b54a8c', 'xuesemofa@163.com', '67bfe67ba8294b3cbca7807ce4d2a94c', '1522823528333', 'N');
INSERT INTO `token_table` VALUES ('e43d0e2437ee4205bd764d90a8303c2c', 'null', '11c75fd7c59546c4a0172bac47ec2afd', '456850231942800000', 'Y');
INSERT INTO `token_table` VALUES ('e4d03cd9941e47e4b4794a45dc0a0d99', 'null', '92942d560d9546e89b0be2e29294e796', '456972627062400000', 'Y');
INSERT INTO `token_table` VALUES ('e55b7212875c4843bad2fac6c9400c92', 'null', 'f480a1f7daf64fe1bb78c6c9ee5d1f64', '456976944748500000', 'Y');
INSERT INTO `token_table` VALUES ('e6574dfeac284c129c2eecf387cc993f', 'null', 'b0fd78cad7514634b6979a84e1852481', '456848440635900000', 'Y');
INSERT INTO `token_table` VALUES ('e663c25a36a54c23a7cfe26ca38b4260', 'null', 'a6e64576b4df4c4796311669563972ff', '456972282867900000', 'Y');
INSERT INTO `token_table` VALUES ('e6cf3e4cd7ab4f2f95c60e9e3f951d60', 'null', '5d1dafc856a346548c8a4a06f3aae8ef', '456850065141900000', 'Y');
INSERT INTO `token_table` VALUES ('e723a12d902048cb86bba786f9417e2f', 'xuesemofa@163.com', 'c618f3212e1d43f882bf60ba5d417b66', '1522829990926', 'Y');
INSERT INTO `token_table` VALUES ('e794757fe1394c07bdfe8305cf9788fe', 'null', 'f97f3893f4674bf394da5546253a2a2c', '456976587650700000', 'Y');
INSERT INTO `token_table` VALUES ('e830c896185d47e4bf09dfa8cb0f17f1', 'null', '1d2dd9ca16a044ffbb248c8173df58a7', '456848955911700000', 'Y');
INSERT INTO `token_table` VALUES ('e859c6152368422c94ea407aed3e3fdc', 'null', '6d6b90e666da4e0b9b5369ca3399610b', '456972172476600000', 'Y');
INSERT INTO `token_table` VALUES ('e8d0656e6101417ebfd95c6f237928da', 'null', 'e744acf0ea86403d9ef62af7c97b792b', '456971894230500000', 'Y');
INSERT INTO `token_table` VALUES ('e8e5577e01c447c2b44661e7e80f0310', 'xuesemofa@163.com', 'd23f27accf79480e987e61dafca45126', '1522820468953', 'N');
INSERT INTO `token_table` VALUES ('e918c334e4b3449194dd485c26e6ebdf', 'null', '047b05e45f0a4a8b8035a9ffe84552ba', '456850083983100000', 'Y');
INSERT INTO `token_table` VALUES ('e9191edbddf2436aa937d646333cd0b9', 'null', '340a5927e13e44ef8c77525506840175', '456849550827900000', 'Y');
INSERT INTO `token_table` VALUES ('e944159eec3247fab485eb7c633ab118', 'xuesemofa@163.com', '503df1af65d6484a94c0714716bc4afe', '1522824435152', 'N');
INSERT INTO `token_table` VALUES ('e95edc8397fd4399b64df8d515218e77', 'null', 'f6fa512227c94925bf149cdd39cc0c4e', '456847843103100000', 'N');
INSERT INTO `token_table` VALUES ('e98c1befc69e447bbd34536555fe0771', 'null', '6e7bac3dc9084ec7bcab551e9ce11b75', '456848804709900000', 'Y');
INSERT INTO `token_table` VALUES ('e9d5f20c3c974d93bbffe1a869a8f333', 'xuesemofa@163.com', '74d22bffefd24c07a522b136e40c727f', '1522825773423', 'N');
INSERT INTO `token_table` VALUES ('ea4456a3e4e140088a286f4f22d81c4c', 'null', '6ef866c2ef9f4befa79ee7e230dfd60a', '456849541562400000', 'Y');
INSERT INTO `token_table` VALUES ('ebccbf7fb74148d7b6cc404aa969b459', 'null', '3f86b58d269b4d579b608495894986e0', '456972476587800000', 'Y');
INSERT INTO `token_table` VALUES ('ec0030571cf24e09b994c36d08601c26', 'null', '6d3d20b3c9924d4c8fda1cd9f49809d2', '456848972798400000', 'Y');
INSERT INTO `token_table` VALUES ('ece4b251f68144a7b841f2356834e186', 'xuesemofa@163.com', '90f492eae4974634ae3726bbe2aea0ca', '1522823961487', 'N');
INSERT INTO `token_table` VALUES ('ed34329c616d4c75bb9765b54d93eafd', 'xuesemofa@163.com', 'beac7fed5ed34f62b4d896c88f260ce7', '1522825857526', 'N');
INSERT INTO `token_table` VALUES ('f0983fd682ab4a37807b918fe040f10d', 'null', '66523fa59f3a497996125775ae9299a0', '456848997580500000', 'Y');
INSERT INTO `token_table` VALUES ('f1b92422a0fe404bbf74fd3e3859b504', 'null', 'db9dec6ce0f14e4486ed49f4bb4ae8a0', '456972192994200000', 'Y');
INSERT INTO `token_table` VALUES ('f3e84b2a49194216ba91d94b8333e54b', 'xuesemofa@163.com', '95e00fb46334469084a7ca19e80d3ccf', '1523256989165', 'N');
INSERT INTO `token_table` VALUES ('f554af3839684498afc36086e699edb1', 'null', 'a5d3be4046f840069a71c6d9a79001da', '456849713961900000', 'Y');
INSERT INTO `token_table` VALUES ('f70cd4f49fc44b70bf5935bddbe200cd', 'null', '0bf585dd14cd4223affcc94c0718ccf7', '456972621205200000', 'Y');
INSERT INTO `token_table` VALUES ('f9dc07175d0a4db6ba193e2b9aa435a8', 'null', '272216f64f644e9b86ea0fdbb7b2f52c', '456849003342600000', 'Y');
INSERT INTO `token_table` VALUES ('fa34040bcdfc4a32840c6444e0f3e6e6', 'null', '2c82a069ec0d46a2b430544f9e69907a', '456850291351200000', 'Y');
INSERT INTO `token_table` VALUES ('fab1256300e44f2db0f12130c66ac91b', 'null', 'ab204538f6344f32837fb51a83c84a84', '456972605500800000', 'Y');
INSERT INTO `token_table` VALUES ('fb9bf3c1ca1448fe92cc316e9fa80e7d', 'null', '948ba8027df84a068c97cb81eb39ef20', '456972210566400000', 'Y');
INSERT INTO `token_table` VALUES ('fba50e4ed13e42a6b3a962e20c8c7a57', 'null', '9823fe1fa4db47d2813e4ad52f54e77b', '456849719834100000', 'Y');
INSERT INTO `token_table` VALUES ('fc1c499f55a042cfbacd4b77a638c06b', 'null', '69414885a3dc4e45911f88972194ebf8', '456848805769500000', 'Y');
INSERT INTO `token_table` VALUES ('fd4d6cf47c9748ac8d0cc9a95b05c527', 'xuesemofa@163.com', '608f18e350e5440bbc376801ed9cc9d1', '1522823082519', 'N');
INSERT INTO `token_table` VALUES ('fe6270296bed4819af42b64969e298d0', 'null', '85f22529f66f4c468698d737e1ae6268', '456972408162600000', 'Y');
INSERT INTO `token_table` VALUES ('fef8e6432d414b599bef77d93faaef24', 'null', 'e1f254b5f1f643d19c4ecb57e5e552da', '456976943885100000', 'Y');

-- ----------------------------
-- Table structure for 分公司统计表
-- ----------------------------
DROP TABLE IF EXISTS `分公司统计表`;
CREATE TABLE `分公司统计表` (
  `id` int(11) NOT NULL,
  `分公司名称` varchar(50) DEFAULT NULL,
  `日期` datetime NOT NULL,
  `应收` decimal(10,0) DEFAULT NULL,
  `实收` decimal(10,0) DEFAULT NULL,
  `d_createdate` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 分公司统计表
-- ----------------------------

-- ----------------------------
-- Table structure for 客户资料
-- ----------------------------
DROP TABLE IF EXISTS `客户资料`;
CREATE TABLE `客户资料` (
  `id` int(11) NOT NULL,
  `i_roomid` int(11) NOT NULL,
  `C_RoomNum` varchar(50) DEFAULT NULL,
  `卡号` varchar(50) DEFAULT NULL,
  `名称` varchar(100) DEFAULT NULL,
  `c_enroladdress` varchar(100) DEFAULT NULL,
  `c_idcard` varchar(300) DEFAULT NULL,
  `联系电话` varchar(300) DEFAULT NULL,
  `c_newYear` varchar(9) DEFAULT NULL,
  `当前年度` varchar(9) DEFAULT NULL,
  `供暖面积` decimal(10,0) DEFAULT NULL,
  `建筑面积` decimal(10,0) DEFAULT NULL,
  `超高面积` decimal(10,0) DEFAULT NULL,
  `实供面积` decimal(10,0) DEFAULT NULL,
  `停供暖面积` decimal(10,0) DEFAULT NULL,
  `停超高面积` decimal(10,0) DEFAULT NULL,
  `应收` decimal(10,0) DEFAULT NULL,
  `应交` decimal(10,0) DEFAULT NULL,
  `实收` decimal(10,0) DEFAULT NULL,
  `欠费` decimal(10,0) DEFAULT NULL,
  `是否收费` varchar(10) DEFAULT NULL,
  `开栓状态` varchar(4) DEFAULT NULL,
  `上年欠费` decimal(10,0) DEFAULT NULL,
  `前年欠费` decimal(10,0) DEFAULT NULL,
  `前年以前欠费合计` decimal(10,0) DEFAULT NULL,
  `d_createDate` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 客户资料
-- ----------------------------

-- ----------------------------
-- Table structure for 日期统计表
-- ----------------------------
DROP TABLE IF EXISTS `日期统计表`;
CREATE TABLE `日期统计表` (
  `id` int(11) NOT NULL,
  `日期` datetime NOT NULL,
  `应收` decimal(10,0) DEFAULT NULL,
  `实收` decimal(10,0) DEFAULT NULL,
  `d_createDate` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 日期统计表
-- ----------------------------

-- ----------------------------
-- Table structure for 热站统计表
-- ----------------------------
DROP TABLE IF EXISTS `热站统计表`;
CREATE TABLE `热站统计表` (
  `id` int(11) NOT NULL,
  `分公司名称` varchar(50) DEFAULT NULL,
  `换热站名称` varchar(50) DEFAULT NULL,
  `日期` datetime NOT NULL,
  `应收` decimal(10,0) DEFAULT NULL,
  `实收` decimal(10,0) DEFAULT NULL,
  `d_createdate` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 热站统计表
-- ----------------------------
