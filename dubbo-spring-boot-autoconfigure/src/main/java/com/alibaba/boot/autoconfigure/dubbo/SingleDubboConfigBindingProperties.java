package com.alibaba.boot.autoconfigure.dubbo;

import com.alibaba.dubbo.config.*;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfigBinding;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import static com.alibaba.boot.autoconfigure.dubbo.DubboAutoConfiguration.PREFIX_PROPERTY_NAME;


/**
 * Single Dubbo Config Binding{@link ConfigurationProperties Properties} with prefix "dubbo."
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see ConfigurationProperties
 * @see EnableDubboConfigBinding
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = PREFIX_PROPERTY_NAME)
public class SingleDubboConfigBindingProperties {

    /**
     * {@link ApplicationConfig} property
     */
    @NestedConfigurationProperty
    private ApplicationConfig application;

    /**
     * {@link ModuleConfig} property
     */
    @NestedConfigurationProperty
    private ModuleConfig module;

    /**
     * {@link RegistryConfig} property
     */
    @NestedConfigurationProperty
    private RegistryConfig registry;

    /**
     * {@link ProtocolConfig} property
     */
    @NestedConfigurationProperty
    private ProtocolConfig protocol;

    /**
     * {@link MonitorConfig} property
     */
    @NestedConfigurationProperty
    private MonitorConfig monitor;

    /**
     * {@link ProviderConfig} property
     */
    @NestedConfigurationProperty
    private ProviderConfig provider;

    /**
     * {@link ConsumerConfig} property
     */
    @NestedConfigurationProperty
    private ConsumerConfig consumer;

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

    public ProtocolConfig getProtocol() {
        return protocol;
    }

    public void setProtocol(ProtocolConfig protocol) {
        this.protocol = protocol;
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

    public ConsumerConfig getConsumer() {
        return consumer;
    }

    public void setConsumer(ConsumerConfig consumer) {
        this.consumer = consumer;
    }

}
