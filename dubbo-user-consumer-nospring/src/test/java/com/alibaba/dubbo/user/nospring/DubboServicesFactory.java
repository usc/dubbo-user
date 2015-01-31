package com.alibaba.dubbo.user.nospring;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 *
 * @author Shunli
 */
@SuppressWarnings("unchecked")
public class DubboServicesFactory {
    private static final LoadingCache<String, Object> cache =
            CacheBuilder.newBuilder().build(new CacheLoader<String, Object>() {
                @Override
                public Object load(String interfaceName) throws Exception {
                    ApplicationConfig application = new ApplicationConfig();
                    application.setName("dubbo-user-consumer-nospring");
                    application.setOwner("lishunli");
                    application.setOrganization("alibaba");

                    RegistryConfig registry = new RegistryConfig("zookeeper://127.0.0.1:2181");

                    @SuppressWarnings("rawtypes")
                    ReferenceConfig reference = new ReferenceConfig();
                    reference.setApplication(application);
                    reference.setRegistry(registry);
                    reference.setInterface(interfaceName);

                    // 用string 做key是为了根据ServiceName 分开配置 ReferenceConfig的配置选项

                    return reference.get();
                }
            });

    public static <T> T getService(Class<T> interfaceClass) {
        try {
            return (T) cache.get(interfaceClass.getName());
        } catch (Exception e) {
            return null;
        }
    }

    public static void refresh() {
        cache.invalidateAll();
    }

    public static void refresh(String interfaceName) {
        if (interfaceName == null) {
            refresh();
        } else {
            cache.refresh(interfaceName);
        }
    }

}
