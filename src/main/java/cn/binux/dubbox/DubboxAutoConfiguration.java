package cn.binux.dubbox;

import com.alibaba.dubbo.config.*;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 * Dubbox自动配置
 *
 * @author xubin.
 * @create 2017-04-05
 */

@Configuration
@EnableConfigurationProperties(DubboxProperties.class)
@ConditionalOnClass(RegistryConfig.class)
public class DubboxAutoConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(DubboxAutoConfiguration.class);

    @Autowired
    private DubboxProperties dubboxProperties;

    @Bean
    public static AnnotationBean annotationBean(@Value("${dubbox.annotation.package:#{null}}") String packageName) {

        AnnotationBean annotationBean = new AnnotationBean();

        if (!StringUtils.isEmpty(packageName)) {

            annotationBean.setPackage(packageName);

            logger.info("DubboxAutoConfiguration.annotationBean ---> " + packageName);

        } else {
            logger.error("请设置'dubbox.annotation.package'值,扫描包路径！");
        }
        return annotationBean;
    }

    @Bean
    public ServiceConfig serviceConfig() {

        logger.info("DubboxAutoConfiguration.serviceConfig ---> " + dubboxProperties.getService());

        return dubboxProperties.getService();
    }

    @Bean
    public ReferenceConfig referenceConfig() {

        logger.info("DubboxAutoConfiguration.referenceConfig ---> " + dubboxProperties.getReference());

        return dubboxProperties.getReference();
    }

    @Bean
    public ProtocolConfig protocolConfig() {

        logger.info("DubboxAutoConfiguration.protocolConfig ---> " + dubboxProperties.getProtocol());

        return dubboxProperties.getProtocol();
    }

    @Bean
    public ApplicationConfig applicationConfig() {

        logger.info("DubboxAutoConfiguration.applicationConfig ---> " + dubboxProperties.getApplication());

        return dubboxProperties.getApplication();
    }

    @Bean
    public ModuleConfig moduleConfig(ApplicationConfig applicationConfig) {

        ModuleConfig moduleConfig = dubboxProperties.getModule();
        if (null == moduleConfig.getName()) {
            moduleConfig.setName(applicationConfig.getName());
        }

        logger.info("DubboxAutoConfiguration.moduleConfig ---> " + dubboxProperties.getModule());

        return moduleConfig;
    }

    @Bean
    public RegistryConfig registry() {

        logger.info("DubboxAutoConfiguration.registry ---> " + dubboxProperties.getRegistry());

        return dubboxProperties.getRegistry();
    }

    //@Bean
    //public MonitorConfig monitorConfig() {
    //
    //    logger.info("DubboxAutoConfiguration.monitorConfig ---> " + dubboxProperties.getMonitor());
    //
    //    return dubboxProperties.getMonitor();
    //}

    @Bean
    public ProviderConfig providerConfig(ApplicationConfig applicationConfig,
                                         RegistryConfig registryConfig,
                                         ProtocolConfig protocolConfig) {

        ProviderConfig providerConfig = dubboxProperties.getProvider();
        providerConfig.setApplication(applicationConfig);
        providerConfig.setRegistry(registryConfig);
        providerConfig.setProtocol(protocolConfig);

        logger.info("DubboxAutoConfiguration.providerConfig ---> " + providerConfig);

        return providerConfig;
    }

    @Bean
    public MethodConfig methodConfig() {

        logger.info("DubboxAutoConfiguration.methodConfig ---> " + dubboxProperties.getMethod());

        return dubboxProperties.getMethod();
    }









}
