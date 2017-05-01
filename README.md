功能介绍
=========
---------
**smart-web2** 是一套相对简单的OA系统；包含了流程设计器，表单设计器，权限管理等功能；
系统后端基于SpringMVC+Spring+Hibernate框架，前端页面采用JQuery+Bootstrap等主流技术；
流程引擎基于Snaker工作流；表单设计器基于雷劈网WEB表单设计器。
系统主要功能有：
 >1.系统管理
 >>系统管理包含有：基础信息管理、系统权限管理、版本管理、子系统管理。
 >
 >2.流程管理
 >>流程管理包含有：流程设计器、流程实例管理、流程页面模版管理等功能。
 >
 >3.表单管理
 >>表单管理包含有：表单设计器、表管理、表单帮助信息管理等。
 >
 >4.我的办公
 >>我的待办、我的已办;

使用说明
=======
-------
---数据库MySQL5.6以上 <br/>
---下载后把data目录下的smart_web2.zip解压；然后解压出来的脚本文件（“smart_web2.sql”）导入到mysql数据库中；注：建库时，字符集编码为：utf8（utf8_general_ci）<br/>
---修改配置文件“jdbc.properties”，改成对应数据库的用户名和密码 <br/>
---“sysconfig.properties”系统配置文件；需要修改“root.dir”属性，设置为系统上传文件时用来存放的根目录 <br/>
----系统管理员用户名为：admin；密码为：123456 <br/>

[演示地址](http://39.108.2.10:8080)
-------
地址：http://39.108.2.10:8080 <br/>
用户名：test；密码：123456
