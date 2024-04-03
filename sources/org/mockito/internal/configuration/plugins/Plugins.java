package org.mockito.internal.configuration.plugins;

import java.util.List;
import org.mockito.plugins.AnnotationEngine;
import org.mockito.plugins.InstantiatorProvider2;
import org.mockito.plugins.MemberAccessor;
import org.mockito.plugins.MockMaker;
import org.mockito.plugins.MockResolver;
import org.mockito.plugins.MockitoLogger;
import org.mockito.plugins.MockitoPlugins;
import org.mockito.plugins.StackTraceCleanerProvider;

public final class Plugins {
    private static final PluginRegistry registry = new PluginRegistry();

    private Plugins() {
    }

    public static AnnotationEngine getAnnotationEngine() {
        return registry.a();
    }

    public static InstantiatorProvider2 getInstantiatorProvider() {
        return registry.b();
    }

    public static MemberAccessor getMemberAccessor() {
        return registry.c();
    }

    public static MockMaker getMockMaker() {
        return registry.d();
    }

    public static List<MockResolver> getMockResolvers() {
        return registry.e();
    }

    public static MockitoLogger getMockitoLogger() {
        return registry.f();
    }

    public static MockitoPlugins getPlugins() {
        return new DefaultMockitoPlugins();
    }

    public static StackTraceCleanerProvider getStackTraceCleanerProvider() {
        return registry.g();
    }
}
