# cloud
SpringBoot 多模块启动项目，集成SSM, 支持i18n，自动分页

## 模块
```
cloud-base 基础模块

cloud-pojo 实体模块

cloud-dao  DAO模块

cloud-service service模块

cloud-api-response API模块

cloud-mvc  API扩展模块

```

## 业务模块
```

server-vhr VHr生产者模块
server-vhr-consumer VHr 消费者模块

```

spring-boot-starter-parent继承spring-boot-dependencies,spring-boot-dependencies 里有常见依赖的默认值

Hystrix

降级 fallback--》 兜底方案-》if else default -》稍后再试试，可能会成功
熔断 break -》达到最大访问后，拒绝访问量或者降级
限流 flowlimit -》排队



