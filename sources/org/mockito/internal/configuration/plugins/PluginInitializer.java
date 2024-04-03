package org.mockito.internal.configuration.plugins;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import org.mockito.internal.util.collections.Iterables;
import org.mockito.plugins.PluginSwitch;

class PluginInitializer {
    private final Set<String> alias;
    private final PluginSwitch pluginSwitch;
    private final DefaultMockitoPlugins plugins;

    public PluginInitializer(PluginSwitch pluginSwitch2, Set<String> set, DefaultMockitoPlugins defaultMockitoPlugins) {
        this.pluginSwitch = pluginSwitch2;
        this.alias = set;
        this.plugins = defaultMockitoPlugins;
    }

    public <T> T loadImpl(Class<T> cls) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            contextClassLoader = ClassLoader.getSystemClassLoader();
        }
        try {
            Enumeration<URL> resources = contextClassLoader.getResources("mockito-extensions/" + cls.getName());
            try {
                String a11 = new PluginFinder(this.pluginSwitch).a(Iterables.toIterable(resources));
                if (a11 == null) {
                    return null;
                }
                if (this.alias.contains(a11)) {
                    a11 = this.plugins.a(a11);
                }
                return cls.cast(contextClassLoader.loadClass(a11).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (Exception e11) {
                throw new IllegalStateException("Failed to load " + cls + " implementation declared in " + resources, e11);
            }
        } catch (IOException e12) {
            throw new IllegalStateException("Failed to load " + cls, e12);
        }
    }

    public <T> List<T> loadImpls(Class<T> cls) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            contextClassLoader = ClassLoader.getSystemClassLoader();
        }
        try {
            Enumeration<URL> resources = contextClassLoader.getResources("mockito-extensions/" + cls.getName());
            try {
                List<String> b11 = new PluginFinder(this.pluginSwitch).b(Iterables.toIterable(resources));
                ArrayList arrayList = new ArrayList();
                for (String next : b11) {
                    if (this.alias.contains(next)) {
                        next = this.plugins.a(next);
                    }
                    arrayList.add(cls.cast(contextClassLoader.loadClass(next).getDeclaredConstructor(new Class[0]).newInstance(new Object[0])));
                }
                return arrayList;
            } catch (Exception e11) {
                throw new IllegalStateException("Failed to load " + cls + " implementation declared in " + resources, e11);
            }
        } catch (IOException e12) {
            throw new IllegalStateException("Failed to load " + cls, e12);
        }
    }
}
