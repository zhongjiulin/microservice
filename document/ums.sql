-- ----------------------------
-- Table structure for ums_admin
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin`;
CREATE TABLE `ums_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `icon` varchar(500) DEFAULT NULL COMMENT '头像',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `nick_name` varchar(200) DEFAULT NULL COMMENT '昵称',
  `note` varchar(500) DEFAULT NULL COMMENT '备注信息',
  `status` int(1) DEFAULT '1' COMMENT '帐号启用状态：0->禁用；1->启用',
  `created_by` varchar(100) DEFAULT NULL,
  `creation_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_updated_by` varchar(100) DEFAULT NULL,
  `last_update_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `enabled_flag` varchar(100) DEFAULT 'Y',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='后台用户表';

-- ----------------------------
-- Records of ums_admin
-- ----------------------------
INSERT INTO `ums_admin` VALUES ('1', 'test', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg', 'test@qq.com', '测试账号', null, '1', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_admin` VALUES ('2', 'admin', '$2a$10$.E1FokumK5GIXWgKlg.Hc.i/0/2.qdAwYFL1zc5QHdyzpXOr38RZO', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg', 'admin@163.com', '系统管理员', '系统管理员', '1', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_admin` VALUES ('3', 'macro', '$2a$10$Bx4jZPR7GhEpIQfefDQtVeS58GfT5n6mxs/b4nLLK65eMFa16topa', 'string', 'macro@qq.com', 'macro', 'macro专用', '1', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_admin` VALUES ('4', 'orderAdmin', '$2a$10$UqEhA9UZXjHHA3B.L9wNG.6aerrBjC6WHTtbv1FdvYPUI.7lkL6E.', null, 'order@qq.com', '订单管理员', '只有订单管理权限', '1', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');

-- ----------------------------
-- Table structure for ums_admin_login_log
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin_login_log`;
CREATE TABLE `ums_admin_login_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) DEFAULT NULL,
  `ip` varchar(64) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `user_agent` varchar(100) DEFAULT NULL COMMENT '浏览器登录类型',
  `created_by` varchar(100) DEFAULT NULL,
  `creation_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_updated_by` varchar(100) DEFAULT NULL,
  `last_update_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `enabled_flag` varchar(100) DEFAULT 'Y',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=196 DEFAULT CHARSET=utf8 COMMENT='后台用户登录日志表';

-- ----------------------------
-- Records of ums_admin_login_log
-- ----------------------------
INSERT INTO `ums_admin_login_log` VALUES ('1', '2', '0:0:0:0:0:0:0:1', null, null, '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_admin_login_log` VALUES ('2', '3', '0:0:0:0:0:0:0:1', null, null, '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_admin_login_log` VALUES ('3', '2', '0:0:0:0:0:0:0:1', null, null, '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_admin_login_log` VALUES ('4', '2', '0:0:0:0:0:0:0:1', null, null, '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_admin_login_log` VALUES ('5', '4', '0:0:0:0:0:0:0:1', null, null, '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');


-- ----------------------------
-- Table structure for ums_role
-- ----------------------------
DROP TABLE IF EXISTS `ums_role`;
CREATE TABLE `ums_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `admin_count` int(11) DEFAULT NULL COMMENT '后台用户数量',
  `status` int(1) DEFAULT '1' COMMENT '启用状态：0->禁用；1->启用',
  `sort` int(11) DEFAULT '0',
  `created_by` varchar(100) DEFAULT NULL,
  `creation_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_updated_by` varchar(100) DEFAULT NULL,
  `last_update_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `enabled_flag` varchar(100) DEFAULT 'Y',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='后台用户角色表';

-- ----------------------------
-- Records of ums_role
-- ----------------------------
INSERT INTO `ums_role` VALUES ('1', '订单管理员', '只能查看及操作订单', '0', '1', '0', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_role` VALUES ('2', '超级管理员', '拥有所有查看和操作功能', '0', '1', '0', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');


-- ----------------------------
-- Table structure for ums_permission
-- ----------------------------
DROP TABLE IF EXISTS `ums_permission`;
CREATE TABLE `ums_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pid` bigint(20) DEFAULT NULL COMMENT '父级权限id',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `value` varchar(200) DEFAULT NULL COMMENT '权限值',
  `icon` varchar(500) DEFAULT NULL COMMENT '图标',
  `type` int(1) DEFAULT NULL COMMENT '权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）',
  `uri` varchar(200) DEFAULT NULL COMMENT '前端资源路径',
  `status` int(1) DEFAULT NULL COMMENT '启用状态；0->禁用；1->启用',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `created_by` varchar(100) DEFAULT NULL,
  `creation_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_updated_by` varchar(100) DEFAULT NULL,
  `last_update_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `enabled_flag` varchar(100) DEFAULT 'Y',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='后台用户权限表';

-- ----------------------------
-- Records of ums_permission
-- ----------------------------
INSERT INTO `ums_permission` VALUES ('1', '0', '订单', null, null, '0', null, '1', '0', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_permission` VALUES ('2', '1', '订单列表', 'oms:order:read', null, '1', '/oms/order/index', '1', '0', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_permission` VALUES ('3', '1', '订单删除', 'oms:order:delete', null, '1', '/oms/order/delete', '1', '0', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_permission` VALUES ('4', '0', '首页', null, null, '0', null, '1', '0', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');

-- ----------------------------
-- Table structure for ums_admin_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin_role_relation`;
CREATE TABLE `ums_admin_role_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `creation_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_updated_by` varchar(100) DEFAULT NULL,
  `last_update_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `enabled_flag` varchar(100) DEFAULT 'Y',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='后台用户和角色关系表';

-- ----------------------------
-- Records of ums_admin_role_relation
-- ----------------------------
INSERT INTO `ums_admin_role_relation` VALUES ('1', '2', '2', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_admin_role_relation` VALUES ('2', '3', '1', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_admin_role_relation` VALUES ('4', '1', '2', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_admin_role_relation` VALUES ('5', '4', '2', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');

-- ----------------------------
-- Table structure for ums_role_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_role_permission_relation`;
CREATE TABLE `ums_role_permission_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `creation_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_updated_by` varchar(100) DEFAULT NULL,
  `last_update_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `enabled_flag` varchar(100) DEFAULT 'Y',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='后台用户角色和权限关系表';

-- ----------------------------
-- Records of ums_role_permission_relation
-- ----------------------------
INSERT INTO `ums_role_permission_relation` VALUES ('1', '2', '1', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_role_permission_relation` VALUES ('2', '2', '2', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_role_permission_relation` VALUES ('3', '2', '3', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_role_permission_relation` VALUES ('4', '2', '4', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_role_permission_relation` VALUES ('5', '1', '1', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_role_permission_relation` VALUES ('6', '1', '2', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');



-- ----------------------------
-- Table structure for ums_admin_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin_permission_relation`;
CREATE TABLE `ums_admin_permission_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  `type` int(1) DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `creation_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_updated_by` varchar(100) DEFAULT NULL,
  `last_update_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `enabled_flag` varchar(100) DEFAULT 'Y',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台用户和权限关系表(除角色中定义的权限以外的加减权限)';

-- ----------------------------
-- Records of ums_admin_permission_relation 用户可单独赋予某些权限
-- ----------------------------

-- ----------------------------
-- Table structure for ums_menu
-- ----------------------------
DROP TABLE IF EXISTS `ums_menu`;
CREATE TABLE `ums_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父级ID',
  `title` varchar(100) DEFAULT NULL COMMENT '菜单名称',
  `level` int(4) DEFAULT NULL COMMENT '菜单级数',
  `sort` int(4) DEFAULT NULL COMMENT '菜单排序',
  `name` varchar(100) DEFAULT NULL COMMENT '前端名称',
  `icon` varchar(200) DEFAULT NULL COMMENT '前端图标',
  `hidden` int(1) DEFAULT NULL COMMENT '前端隐藏',
  `created_by` varchar(100) DEFAULT NULL,
  `creation_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_updated_by` varchar(100) DEFAULT NULL,
  `last_update_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `enabled_flag` varchar(100) DEFAULT 'Y',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='后台菜单表';

-- ----------------------------
-- Records of ums_menu
-- ----------------------------
INSERT INTO `ums_menu` VALUES ('1', '0', '订单', '0', '0', 'oms', 'order', '0', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_menu` VALUES ('2', '1', '订单列表', '1', '0', 'order', 'product-list', '0', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_menu` VALUES ('3', '1', '退货原因设置', '1', '0', 'returnReason', 'order-return-reason', '0', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_menu` VALUES ('4', '0', '权限', '0', '0', 'ums', 'ums', '0', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_menu` VALUES ('5', '4', '用户列表', '1', '0', 'admin', 'ums-admin', '0', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_menu` VALUES ('6', '4', '角色列表', '1', '0', 'role', 'ums-role', '0', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_menu` VALUES ('7', '4', '菜单列表', '1', '0', 'menu', 'ums-menu', '0', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_menu` VALUES ('8', '4', '资源列表', '1', '0', 'resource', 'ums-resource', '0', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');


-- ----------------------------
-- Table structure for ums_role_menu_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_role_menu_relation`;
CREATE TABLE `ums_role_menu_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  `created_by` varchar(100) DEFAULT NULL,
  `creation_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_updated_by` varchar(100) DEFAULT NULL,
  `last_update_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `enabled_flag` varchar(100) DEFAULT 'Y',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8 COMMENT='后台角色菜单关系表';

-- ----------------------------
-- Records of ums_role_menu_relation
-- ----------------------------
INSERT INTO `ums_role_menu_relation` VALUES ('1', '1', '1', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_role_menu_relation` VALUES ('2', '1', '2', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_role_menu_relation` VALUES ('3', '1', '3', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_role_menu_relation` VALUES ('4', '2', '1', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_role_menu_relation` VALUES ('5', '2', '2', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_role_menu_relation` VALUES ('6', '2', '3', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_role_menu_relation` VALUES ('7', '2', '4', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_role_menu_relation` VALUES ('8', '2', '5', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_role_menu_relation` VALUES ('9', '2', '6', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_role_menu_relation` VALUES ('10', '2', '7', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
INSERT INTO `ums_role_menu_relation` VALUES ('11', '2', '8', '钟玖林', '2018-09-29 13:55:30', '钟玖林', '2018-09-29 13:55:30', 'Y');
