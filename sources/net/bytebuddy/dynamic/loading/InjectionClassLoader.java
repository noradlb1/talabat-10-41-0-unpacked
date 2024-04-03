package net.bytebuddy.dynamic.loading;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import net.bytebuddy.description.type.TypeDescription;

public abstract class InjectionClassLoader extends ClassLoader {
    private final AtomicBoolean sealed;

    public enum Strategy implements ClassLoadingStrategy<InjectionClassLoader> {
        INSTANCE;

        public Map<TypeDescription, Class<?>> load(InjectionClassLoader injectionClassLoader, Map<TypeDescription, byte[]> map) {
            if (injectionClassLoader != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                HashMap hashMap = new HashMap();
                for (Map.Entry next : map.entrySet()) {
                    linkedHashMap.put(((TypeDescription) next.getKey()).getName(), next.getValue());
                    hashMap.put(((TypeDescription) next.getKey()).getName(), next.getKey());
                }
                HashMap hashMap2 = new HashMap();
                try {
                    for (Map.Entry next2 : injectionClassLoader.defineClasses(linkedHashMap).entrySet()) {
                        hashMap2.put(hashMap.get(next2.getKey()), next2.getValue());
                    }
                    return hashMap2;
                } catch (ClassNotFoundException e11) {
                    throw new IllegalStateException("Cannot load classes: " + map, e11);
                }
            } else {
                throw new IllegalArgumentException("Cannot add types to bootstrap class loader: " + map);
            }
        }
    }

    static {
        doRegisterAsParallelCapable();
    }

    public InjectionClassLoader(ClassLoader classLoader, boolean z11) {
        super(classLoader);
        this.sealed = new AtomicBoolean(z11);
    }

    @SuppressFBWarnings(justification = "Must be invoked from targeting ClassLoader class.", value = {"DP_DO_INSIDE_DO_PRIVILEGED"})
    private static void doRegisterAsParallelCapable() {
        try {
            Method declaredMethod = ClassLoader.class.getDeclaredMethod("registerAsParallelCapable", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke((Object) null, new Object[0]);
        } catch (Throwable unused) {
        }
    }

    public abstract Map<String, Class<?>> a(Map<String, byte[]> map) throws ClassNotFoundException;

    public Class<?> defineClass(String str, byte[] bArr) throws ClassNotFoundException {
        return defineClasses(Collections.singletonMap(str, bArr)).get(str);
    }

    public Map<String, Class<?>> defineClasses(Map<String, byte[]> map) throws ClassNotFoundException {
        if (!this.sealed.get()) {
            return a(map);
        }
        throw new IllegalStateException("Cannot inject classes into a sealed class loader");
    }

    public boolean isSealed() {
        return this.sealed.get();
    }

    public boolean seal() {
        return !this.sealed.getAndSet(true);
    }
}
