package org.mockito.internal.configuration.plugins;

import java.util.HashMap;
import java.util.Map;
import org.mockito.plugins.AnnotationEngine;
import org.mockito.plugins.InstantiatorProvider2;
import org.mockito.plugins.MemberAccessor;
import org.mockito.plugins.MockMaker;
import org.mockito.plugins.MockitoLogger;
import org.mockito.plugins.MockitoPlugins;
import org.mockito.plugins.PluginSwitch;
import org.mockito.plugins.StackTraceCleanerProvider;

class DefaultMockitoPlugins implements MockitoPlugins {
    private static final Map<String, String> DEFAULT_PLUGINS;

    static {
        HashMap hashMap = new HashMap();
        DEFAULT_PLUGINS = hashMap;
        hashMap.put(PluginSwitch.class.getName(), DefaultPluginSwitch.class.getName());
        hashMap.put(MockMaker.class.getName(), "org.mockito.internal.creation.bytebuddy.ByteBuddyMockMaker");
        hashMap.put(StackTraceCleanerProvider.class.getName(), "org.mockito.internal.exceptions.stacktrace.DefaultStackTraceCleanerProvider");
        hashMap.put(InstantiatorProvider2.class.getName(), "org.mockito.internal.creation.instance.DefaultInstantiatorProvider");
        hashMap.put(AnnotationEngine.class.getName(), "org.mockito.internal.configuration.InjectingAnnotationEngine");
        hashMap.put("mock-maker-inline", "org.mockito.internal.creation.bytebuddy.InlineByteBuddyMockMaker");
        hashMap.put("mock-maker-proxy", "org.mockito.internal.creation.proxy.ProxyMockMaker");
        hashMap.put(MockitoLogger.class.getName(), "org.mockito.internal.util.ConsoleMockitoLogger");
        hashMap.put(MemberAccessor.class.getName(), "org.mockito.internal.util.reflection.ReflectionMemberAccessor");
        hashMap.put("member-accessor-module", "org.mockito.internal.util.reflection.ModuleMemberAccessor");
    }

    private <T> T create(Class<T> cls, String str) {
        if (str != null) {
            try {
                return cls.cast(Class.forName(str).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (Exception e11) {
                throw new IllegalStateException("Internal problem occurred, please report it. Mockito is unable to load the default implementation of class that is a part of Mockito distribution. Failed to load " + cls, e11);
            }
        } else {
            throw new IllegalStateException("No default implementation for requested Mockito plugin type: " + cls.getName() + "\nIs this a valid Mockito plugin type? If yes, please report this problem to Mockito team.\nOtherwise, please check if you are passing valid plugin type.\nExamples of valid plugin types: MockMaker, StackTraceCleanerProvider.");
        }
    }

    public String a(String str) {
        return DEFAULT_PLUGINS.get(str);
    }

    public <T> T getDefaultPlugin(Class<T> cls) {
        return create(cls, DEFAULT_PLUGINS.get(cls.getName()));
    }

    public MockMaker getInlineMockMaker() {
        return (MockMaker) create(MockMaker.class, DEFAULT_PLUGINS.get("mock-maker-inline"));
    }
}
