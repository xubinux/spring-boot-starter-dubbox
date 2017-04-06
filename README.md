##spring-boot-starter-dubbox

##配置示例
```yml
#DUBBOX
dubbox:
	application:
		name: server-service
		organization: dubbox
		owner: binux
	registry:
		protocol: zookeeper
		address: 192.168.125.128:2181
	annotation:
		package: cn.binux.dubbox
	protocol:
		name: dubbo
		port: 20880
		host: 192.168.125.1
		timeout: 30000
		threadpool: fixed
		threads: 500
		accepts: 1000
		serialization: kryo
		optimizer: cn.binux.serial.SerializationOptimizerImpl
```

查看[dubbo全部配置](http://dubbo.io/User+Guide-zh.htm#UserGuide-zh-Xml配置)

基本全部配置都可以配置

需要配置的属性如果有`SetXx`方法,则属性可以配置,并且配置名为`xx`