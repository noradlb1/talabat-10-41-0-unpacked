package org.mockito.internal.configuration;

import java.io.Serializable;
import org.mockito.configuration.DefaultMockitoConfiguration;
import org.mockito.configuration.IMockitoConfiguration;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.plugins.AnnotationEngine;
import org.mockito.stubbing.Answer;

public class GlobalConfiguration implements IMockitoConfiguration, Serializable {
    private static final ThreadLocal<IMockitoConfiguration> GLOBAL_CONFIGURATION = new ThreadLocal<>();
    private static final long serialVersionUID = -2860353062105505938L;

    public GlobalConfiguration() {
        ThreadLocal<IMockitoConfiguration> threadLocal = GLOBAL_CONFIGURATION;
        if (threadLocal.get() == null) {
            threadLocal.set(createConfig());
        }
    }

    private IMockitoConfiguration createConfig() {
        DefaultMockitoConfiguration defaultMockitoConfiguration = new DefaultMockitoConfiguration();
        IMockitoConfiguration loadConfiguration = new ClassPathLoader().loadConfiguration();
        if (loadConfiguration != null) {
            return loadConfiguration;
        }
        return defaultMockitoConfiguration;
    }

    public static void validate() {
        new GlobalConfiguration();
    }

    public boolean cleansStackTrace() {
        return GLOBAL_CONFIGURATION.get().cleansStackTrace();
    }

    public boolean enableClassCache() {
        return GLOBAL_CONFIGURATION.get().enableClassCache();
    }

    public Answer<Object> getDefaultAnswer() {
        return GLOBAL_CONFIGURATION.get().getDefaultAnswer();
    }

    public AnnotationEngine tryGetPluginAnnotationEngine() {
        return Plugins.getAnnotationEngine();
    }
}
