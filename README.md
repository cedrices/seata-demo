以下为spring-cloud （netfix）与seata的整合

1.首先启动register-server的module的eureka注册服务发现组件端口为8781

2.解压seata-server-0.9.0_hss.zip压缩包 启动bin文件夹下的
seata-server.bat 将seata注册到eureka

3.启动订单微服务 order-micro-server 、启动商品微服务goods-micro-server、启动账户微服务account-micro-server

4.启动gateway-server的module用于网关

测试
本地mysql数据库创建seata数据库（用于tc控制协调）seata_account（为账户库）seata_goods.sql（为商品库）seata_order.sql（为订单库） 执行脚本用于测试
调用网关接api 例如：postman http://10.10.10.213:8280/api/order?goodsNum=1&goodsId=1&accountId=1  各个数据库中表数据一致
将账户微服务account-micro-server停后测试 发现数据回滚
