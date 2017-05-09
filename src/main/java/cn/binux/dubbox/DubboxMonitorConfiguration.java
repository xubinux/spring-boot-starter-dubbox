package cn.binux.dubbox;

import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Dubbox自动配置
 *
 * @author xubin.
 * @create 2017-04-05
 */

@Configuration
@EnableConfigurationProperties(DubboxProperties.class)
@ConditionalOnProperty(prefix = "dubbox.monitor",havingValue = "true",value = "enabled",matchIfMissing = false)
@ConditionalOnClass(RegistryConfig.class)
public class DubboxMonitorConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(DubboxMonitorConfiguration.class);

    @Autowired
    private DubboxProperties dubboxProperties;


    @Bean
    public MonitorConfig monitorConfig() {

        logger.info("DubboxAutoConfiguration.monitorConfig ---> " + dubboxProperties.getMonitor());

        return dubboxProperties.getMonitor();
    }



}
