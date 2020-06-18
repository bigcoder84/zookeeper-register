# zookeeper-register
`zookeeper-register`是一个利用Zookeeper实现的服务注册与发现案例，它简单的阐释了Zookeeper作为注册中心的原理。

项目分为两个模块：

- product：模拟商品服务
- order：模拟订单服务

在`订单`服务中拥有一个接口`/order`，它内部调用了`商品`服务中的`/product`接口。
这种依赖通过Zookeeper进行解耦，当`商品`服务启动时会在Zookeeper
中“注册”自己的服务，当`订单`模块需要调用`商品`模块服务时，会去注册中心获取能够提供服务的列表，然后通过随机数抽取其中某个节点作为服务提供者，从而完成整个服务注册与发现的流程。