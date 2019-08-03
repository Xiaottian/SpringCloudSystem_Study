API网关服务
spring-cloud-starter-zuul，不仅包含了netflix zuul的核心依赖zuul-core，
还包含了spring-cloud-starter-hystrix：用来在网关服务中实现对微服务转发时候的保护机制，通过线程隔离和断路器，防止微服务
的故障引发api网关资源无法释放，从而影响其他应用的对外服务
spring-cloud-starter-ribbon:改依赖用来实现在网关服务进行路由转发时候的客户端负载均衡以及请求重试
spring-boot-starter-actuator：该依赖用来提供常规的微服务管理端点，另外，在spring cloud zuul中还特别提供了
/routes端点来返回当前的所有路由规则。

请求过滤功能：在api网关上定义过滤器实现对请求的拦截与过滤。继承zuulfilter抽象类并实现它的4个抽象函数即可

动态加载：动态更新内部逻辑：动态修改路由规则、动态添加/删除过滤器等

properties配置文件的配置内容无法保证有序性，出现这种情况时，为了保证路由的优先顺序，我们需要使用
YAML文件来配置，以实现有序的路由规则