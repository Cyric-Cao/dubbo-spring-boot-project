package com.alibaba.boot.autoconfigure.dubbo;

import com.alibaba.dubbo.config.*;
import com.alibaba.dubbo.config.spring.beans.factory.annotation.ReferenceAnnotationBeanPostProcessor;
import com.alibaba.dubbo.config.spring.beans.factory.annotation.ServiceAnnotationBeanPostProcessor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * {@link DubboAutoConfiguration} Test On single Dubbo Configuration
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(
        properties = {
                "dubbo.application.name = dubbo-demo-application",
                "dubbo.module.name = dubbo-demo-module",
                "dubbo.registry.address = zookeeper://192.168.99.100:32770",
                "dubbo.protocol.name=dubbo",
                "dubbo.protocol.port=20880",
                "dubbo.monitor.address=zookeeper://127.0.0.1:32770",
                "dubbo.provider.host=127.0.0.1",
                "dubbo.consumer.client=netty"
        }
)
@SpringApplicationConfiguration(
        classes = {DubboAutoConfiguration.class}
)
@IntegrationTest
public class DubboAutoConfigurationOnSingleConfigTest {

    @Autowired
    private ApplicationConfig applicationConfig;

    @Autowired
    private ModuleConfig moduleConfig;

    @Autowired
    private RegistryConfig registryConfig;

    @Autowired
    private MonitorConfig monitorConfig;

    @Autowired
    private ProviderConfig providerConfig;

    @Autowired
    private ConsumerConfig consumerConfig;

    @Autowired
    private ProtocolConfig protocolConfig;

    @Autowired(required = false)
    private DubboAutoConfiguration.MultipleDubboConfigConfiguration multipleDubboConfigConfiguration;

    @Autowired
    private DubboAutoConfiguration.SingleDubboConfigConfiguration singleDubboConfigConfiguration;

    @Autowired
    private Environment environment;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired(required = false)
    private ServiceAnnotationBeanPostProcessor serviceAnnotationBeanPostProcessor;

    @Autowired
    private ReferenceAnnotationBeanPostProcessor referenceAnnotationBeanPostProcessor;

    @Autowired
    private DubboScanProperties dubboScanProperties;

    @Autowired
    private DubboConfigProperties dubboConfigProperties;

    @Autowired
    private SingleDubboConfigBindingProperties singleDubboConfigBindingProperties;


    @Test
    public void testDubboScanProperties() {

        Assert.assertTrue(dubboScanProperties.getPackages().isEmpty());

    }

    @Test
    public void testDubboConfigProperties() {

        Assert.assertFalse(dubboConfigProperties.isMultiple());

    }

    @Test
    public void testSingleDubboConfigBindingProperties() {

        Assert.assertNotNull(singleDubboConfigBindingProperties.getApplication());
        Assert.assertNotNull(singleDubboConfigBindingProperties.getConsumer());
        Assert.assertNotNull(singleDubboConfigBindingProperties.getModule());
        Assert.assertNotNull(singleDubboConfigBindingProperties.getMonitor());
        Assert.assertNotNull(singleDubboConfigBindingProperties.getProtocol());
        Assert.assertNotNull(singleDubboConfigBindingProperties.getProvider());
        Assert.assertNotNull(singleDubboConfigBindingProperties.getRegistry());

    }

    @Test
    public void testApplicationConfig() {

        Assert.assertEquals("dubbo-demo-application", applicationConfig.getName());

    }

    @Test
    public void testModuleConfig() {

        Assert.assertEquals("dubbo-demo-module", moduleConfig.getName());

    }

    @Test
    public void testRegistryConfig() {

        Assert.assertEquals("zookeeper://192.168.99.100:32770", registryConfig.getAddress());

    }

    @Test
    public void testMonitorConfig() {

        Assert.assertEquals("zookeeper://127.0.0.1:32770", monitorConfig.getAddress());

    }

    @Test
    public void testProtocolConfig() {

        Assert.assertEquals("dubbo", protocolConfig.getName());
        Assert.assertEquals(Integer.valueOf(20880), protocolConfig.getPort());

    }

    @Test
    public void testProviderConfig() {

        Assert.assertEquals("127.0.0.1", providerConfig.getHost());

    }

    @Test
    public void testConsumerConfig() {

        Assert.assertEquals("netty", consumerConfig.getClient());

    }

    @Test
    public void testMultipleDubboConfigConfiguration() {
        Assert.assertNull(multipleDubboConfigConfiguration);
    }

    @Test
    public void testSingleDubboConfigConfiguration() {
        Assert.assertNotNull(singleDubboConfigConfiguration);
    }

    @Test
    public void testServiceAnnotationBeanPostProcessor() {
        Assert.assertNull(multipleDubboConfigConfiguration);
    }

}
