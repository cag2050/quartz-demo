### 步骤：
1. IDEA初始化项目：1.Spring Initializr的Server URL，改为：http://start.aliyun.com （才会有Java版本8）；2.Java版本选择：8；3.选择需要的Spring Boot版本。
2. 配置：src/main/resources/application.yml、src/main/resources/db/migration/V1__Init.sql（quartz用的表）
3. 启动

资料 | 说明
--- | ---
10.4　实战：实现分布式定时任务 | https://weread.qq.com/web/reader/0f832150727abda40f80656
任务调度框架 Quartz 保姆级教程（超详细） | https://zhuanlan.zhihu.com/p/522284183
quartz-2.3.x的mysql表 | https://github.com/quartz-scheduler/quartz/blob/quartz-2.3.x/quartz-core/src/main/resources/org/quartz/impl/jdbcjobstore/tables_mysql.sql
