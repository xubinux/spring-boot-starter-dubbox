package cn.binux.dubbox;

import com.alibaba.dubbo.config.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Dubbox配置
 *
 * @author xubin.
 * @create 2017-04-05
 */

@ConfigurationProperties(prefix = "dubbox")
public class DubboxProperties {

    public DubboxProperties() {

        this.service = new ServiceConfig();
        this.reference = new ReferenceConfig();
        this.protocol = new ProtocolConfig();
        this.application = new ApplicationConfig();
        this.module = new ModuleConfig();
        this.registry = new RegistryConfig();
        this.monitor = new MonitorConfig();
        this.provider = new ProviderConfig();
        this.method = new MethodConfig();
        this.argument = new ArgumentConfig();
    }

    /**
     * 服务配置，用于暴露一个服务，定义服务的元信息，一个服务可以用多个协议暴露，一个服务也可以注册到多个注册中心。(使用注解代替！)
     */
    protected ServiceConfig service;

    /**
     * 引用配置，用于创建一个远程服务代理，一个引用可以指向多个注册中心。(使用注解代替！)
     */
    protected ReferenceConfig reference;

    /**
     * 协议配置，用于配置提供服务的协议信息，协议由提供方指定，消费方被动接受。
     */
    protected ProtocolConfig protocol;

    /**
     * 应用配置，用于配置当前应用信息，不管该应用是提供者还是消费者。
     */
    protected ApplicationConfig application;

    /**
     * 模块配置，用于配置当前模块信息，可选。
     */
    protected ModuleConfig module;

    /**
     * 注册中心配置，用于配置连接注册中心相关信息。
     */
    protected RegistryConfig registry;

    /**
     * 监控中心配置，用于配置连接监控中心相关信息，可选。
     */
    protected MonitorConfig monitor;

    /**
     * 提供方的缺省值，当ProtocolConfig和ServiceConfig某属性没有配置时，采用此缺省值，可选。
     */
    protected ProviderConfig provider;

    /**
     * 方法配置，用于ServiceConfig和ReferenceConfig指定方法级的配置信息。
     */
    protected MethodConfig method;

    /**
     * 用于指定方法参数配置。
     */
    protected ArgumentConfig argument;


    public ServiceConfig getService() {
        return service;
    }

    public void setService(ServiceConfig service) {
        this.service = service;
    }

    public ReferenceConfig getReference() {
        return reference;
    }

    public void setReference(ReferenceConfig reference) {
        this.reference = reference;
    }

    public ProtocolConfig getProtocol() {
        return protocol;
    }

    public void setProtocol(ProtocolConfig protocol) {
        this.protocol = protocol;
    }

    public ApplicationConfig getApplication() {
        return application;
    }

    public void setApplication(ApplicationConfig application) {
        this.application = application;
    }

    public ModuleConfig getModule() {
        return module;
    }

    public void setModule(ModuleConfig module) {
        this.module = module;
    }

    public RegistryConfig getRegistry() {
        return registry;
    }

    public void setRegistry(RegistryConfig registry) {
        this.registry = registry;
    }

    public MonitorConfig getMonitor() {
        return monitor;
    }

    public void setMonitor(MonitorConfig monitor) {
        this.monitor = monitor;
    }

    public ProviderConfig getProvider() {
        return provider;
    }

    public void setProvider(ProviderConfig provider) {
        this.provider = provider;
    }

    public MethodConfig getMethod() {
        return method;
    }

    public void setMethod(MethodConfig method) {
        this.method = method;
    }

    public ArgumentConfig getArgument() {
        return argument;
    }

    public void setArgument(ArgumentConfig argument) {
        this.argument = argument;
    }
}
