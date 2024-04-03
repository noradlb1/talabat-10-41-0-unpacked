package org.mockito.internal.configuration.plugins;

import java.util.List;
import org.mockito.plugins.AnnotationEngine;
import org.mockito.plugins.InstantiatorProvider2;
import org.mockito.plugins.MemberAccessor;
import org.mockito.plugins.MockMaker;
import org.mockito.plugins.MockResolver;
import org.mockito.plugins.MockitoLogger;
import org.mockito.plugins.PluginSwitch;
import org.mockito.plugins.StackTraceCleanerProvider;

class PluginRegistry {
    private final AnnotationEngine annotationEngine;
    private final InstantiatorProvider2 instantiatorProvider;
    private final MemberAccessor memberAccessor;
    private final MockMaker mockMaker;
    private final List<MockResolver> mockResolvers;
    private final MockitoLogger mockitoLogger;
    private final PluginSwitch pluginSwitch;
    private final StackTraceCleanerProvider stackTraceCleanerProvider;

    public PluginRegistry() {
        PluginSwitch pluginSwitch2 = (PluginSwitch) new PluginLoader(new DefaultPluginSwitch()).a(PluginSwitch.class);
        this.pluginSwitch = pluginSwitch2;
        this.mockMaker = (MockMaker) new PluginLoader(pluginSwitch2, "mock-maker-inline", "mock-maker-proxy").a(MockMaker.class);
        this.memberAccessor = (MemberAccessor) new PluginLoader(pluginSwitch2, "member-accessor-module").a(MemberAccessor.class);
        this.stackTraceCleanerProvider = (StackTraceCleanerProvider) new PluginLoader(pluginSwitch2).a(StackTraceCleanerProvider.class);
        this.annotationEngine = (AnnotationEngine) new PluginLoader(pluginSwitch2).a(AnnotationEngine.class);
        this.mockitoLogger = (MockitoLogger) new PluginLoader(pluginSwitch2).a(MockitoLogger.class);
        this.mockResolvers = new PluginLoader(pluginSwitch2).c(MockResolver.class);
        this.instantiatorProvider = (InstantiatorProvider2) new PluginLoader(pluginSwitch2).a(InstantiatorProvider2.class);
    }

    public AnnotationEngine a() {
        return this.annotationEngine;
    }

    public InstantiatorProvider2 b() {
        return this.instantiatorProvider;
    }

    public MemberAccessor c() {
        return this.memberAccessor;
    }

    public MockMaker d() {
        return this.mockMaker;
    }

    public List<MockResolver> e() {
        return this.mockResolvers;
    }

    public MockitoLogger f() {
        return this.mockitoLogger;
    }

    public StackTraceCleanerProvider g() {
        return this.stackTraceCleanerProvider;
    }
}
