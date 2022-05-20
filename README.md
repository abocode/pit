<p align="center">
	<img alt="logo" src="https://sourcebyte.cn/assets/logo_c_64.5eb3acc5.png">
</p>
<h1 align="center" style="margin: 30px 0 30px; font-weight: bold;">Source-Vue v1.0.0</h1>
<h4 align="center">基于SpringBoot+Vue前后端分离的Java快速开发框架</h4>

### 平台简介
开源字节是一套全部开源的快速开发平台，毫无保留给个人及企业免费使用。拒绝虚假开源，售卖商业版，程序员不骗程序员！！

* PC端采用Vue、Element UI。
* 后端采用Spring Boot、Mybatis、Spring Security、Redis & Jwt。
* 移动端采用Vue、Uniapp、Uview。
* 使用Flowable、Bpmn.io实现工作流。
* 使用Gantt-elastic实现甘特图任务计划。
* 使用T-io,Websocket实现即时通讯。
* 使用Handsontable实现类Excel拖拽赋值的Web数据录入。
* 使用Vxe-table实现单行编辑，即时保存效果。
* 使用IReport实现企业级Web报表。
* 使用DataV展示可视化大屏数据。
* 使用kkFileView实现在线预览，支持doc,docx,Excel,pdf,txt,zip,rar,图片等
* 使用JustAuth实现三方应用OAuth 2授权 。
* 支持多种登录方式（扫码登录，验证码登录，密码登录）
* 支持加载动态权限菜单，控制菜单权限，按钮权限，数据权限。
* 高效率开发，使用代码生成器可以一键生成前后端代码。

### 在线体验

* 演示地址：http://boot.sourcebyte.cn:8081/login
* 开发文档：http://doc.sourcebyte.cn:8082/index.html
* 官网地址：https://sourcebyte.cn

### 内置系统功能

1.  用户管理：用户是系统操作者，该功能主要完成系统用户配置。
2.  部门管理：配置系统组织机构（公司、部门、小组），树结构展现支持数据权限。
3.  岗位管理：配置系统用户所属担任职务。
4.  菜单管理：配置系统菜单，操作权限，按钮权限标识等。
5.  角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。
6.  字典管理：对系统中经常使用的一些较为固定的数据进行维护。
7.  参数管理：对系统动态配置常用参数。
8.  通知公告：系统通知公告信息发布维护。
9.  操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。
10. 登录日志：系统登录日志记录查询包含登录异常。
11. 在线用户：当前系统中活跃用户状态监控。
12. 定时任务：在线（添加、修改、删除)任务调度包含执行结果日志。
13. 代码生成：前后端代码的生成（java、html、xml、sql）支持CRUD下载 。
14. 系统接口：根据业务代码自动生成相关的api接口文档。
15. 服务监控：监视当前系统CPU、内存、磁盘、堆栈等相关信息。
16. 缓存监控：对系统的缓存信息查询，命令统计等。
17. 在线构建器：拖动表单元素生成相应的HTML代码。
18. 连接池监视：监视当前系统数据库连接池状态，可进行分析SQL找出系统性能瓶颈。
19. [更多系统功能](http://47.243.114.191:8081)

### 内置业务功能 

1.  [内容管理](https://sourcebyte.cn)
2.  [智慧租房](http://47.243.114.191:8080/house)
3.  [智慧党建](http://8.141.150.22)
4.  [智慧相亲](http://47.243.114.191:8080/love)
5.  [智慧电商](https://sourcebyte.cn)
6.  [智慧仓储](https://sourcebyte.cn)
7.  [智慧医疗](https://sourcebyte.cn)
8.  [智慧家居](http://47.243.114.191:8080/home)
9.  [更多精彩内容](https://sourcebyte.cn)

### 平台架构
![输入图片说明](https://gitee.com/open-source-byte/source-mall/raw/master/doc/boot0.png)

### 整体架构
![输入图片说明](https://gitee.com/open-source-byte/source-mall/raw/master/doc/boot1.png)

### 技术架构
![输入图片说明](https://gitee.com/open-source-byte/source-mall/raw/master/doc/boot2.png)

### 番外篇

 **企业为什么需要低代码开发平台？零代码开发还不够吗？** 

答：如果大家都使用零代码开发平台（即不需要编码，通过表单拖拉拽完成系统研发），那程序员岂不是要失业了。程序员也要吃饭，所以不研发零代码开发平台，只专心做低代码开发平台。

> 以上纯属开个玩笑，下面说说我的看法

要想解答这个问题，首先得弄清楚他们的区别。零代码开发是一种完全不需要任何代码的开发方式，主要是通过可视化模块方式设计数据结构，用户交互形式、设置访问权限和定义工作流程的平台；零代码开发平台非常适合构建针对特定场景的小型应用程序，如问卷调查等。

低代码开发是通过工具/系统自带的组件组合拖放快速生成我们所需要的应用，在特定的环节里还能够允许写入少量的脚本代码来扩充一定的功能。低代码开发平台不仅适用于特定的小型应用程序，对于大型企业的复杂的应用程序都是可以轻松驾驭的。

此外，面对一些复杂的场景零代码便难以胜任，即使能够完成也得借助其他系统的二次开发来完成部署，用低代码开发平台则可以用代码轻松完成复杂场景的应用部署。并且低代码开发平台本身就比零代码更加灵活，甚至有的产品还支持开源，在面对企业需要二次开发时可以轻松做到，没有什么顾虑。

 **综上，低代码平台包含零代码平台的所有能力，从企业经营长远发展目标考虑，便捷的开发形式+卓越的拓展能力是核心，低代码平台能够帮助企业解决业务多重挑战。** 

```
🕙 分享是一种美德，右上随手点个 🌟 Star，谢谢
```