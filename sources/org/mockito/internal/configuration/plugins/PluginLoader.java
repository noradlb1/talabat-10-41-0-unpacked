package org.mockito.internal.configuration.plugins;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.mockito.plugins.PluginSwitch;

class PluginLoader {
    private final PluginInitializer initializer;
    private final DefaultMockitoPlugins plugins;

    public PluginLoader(DefaultMockitoPlugins defaultMockitoPlugins, PluginInitializer pluginInitializer) {
        this.plugins = defaultMockitoPlugins;
        this.initializer = pluginInitializer;
    }

    public <T> T a(Class<T> cls) {
        return b(cls, (Class) null);
    }

    public <PreferredT, AlternateType> Object b(final Class<PreferredT> cls, final Class<AlternateType> cls2) {
        AlternateType loadImpl;
        try {
            PreferredT loadImpl2 = this.initializer.loadImpl(cls);
            if (loadImpl2 != null) {
                return loadImpl2;
            }
            if (cls2 == null || (loadImpl = this.initializer.loadImpl(cls2)) == null) {
                return this.plugins.getDefaultPlugin(cls);
            }
            return loadImpl;
        } catch (Throwable th2) {
            return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() {
                public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                    throw new IllegalStateException("Could not initialize plugin: " + cls + " (alternate: " + cls2 + ")", th2);
                }
            });
        }
    }

    public <T> List<T> c(final Class<T> cls) {
        try {
            return this.initializer.loadImpls(cls);
        } catch (Throwable th2) {
            return Collections.singletonList(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() {
                public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                    throw new IllegalStateException("Could not initialize plugin: " + cls, th2);
                }
            }));
        }
    }

    public PluginLoader(PluginSwitch pluginSwitch) {
        this(new DefaultMockitoPlugins(), new PluginInitializer(pluginSwitch, Collections.emptySet(), new DefaultMockitoPlugins()));
    }

    public PluginLoader(PluginSwitch pluginSwitch, String... strArr) {
        this(new DefaultMockitoPlugins(), new PluginInitializer(pluginSwitch, new HashSet(Arrays.asList(strArr)), new DefaultMockitoPlugins()));
    }
}
