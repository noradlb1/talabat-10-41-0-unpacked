package net.bytebuddy.agent.builder;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.instrument.ClassFileTransformer;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.loading.ClassInjector;
import net.bytebuddy.implementation.auxiliary.TypeProxy;

@HashCodeAndEqualsPlugin.Enhance
public class LambdaFactory {
    @SuppressFBWarnings(justification = "The field must be accessible by different class loader instances", value = {"MS_MUTABLE_COLLECTION_PKGPROTECT"})
    public static final Map<ClassFileTransformer, LambdaFactory> CLASS_FILE_TRANSFORMERS = new ConcurrentHashMap();
    private static final String FIELD_NAME = "CLASS_FILE_TRANSFORMERS";
    private final Method dispatcher;
    private final Object target;

    public LambdaFactory(Object obj, Method method) {
        this.target = obj;
        this.dispatcher = method;
    }

    private byte[] invoke(Object obj, String str, Object obj2, Object obj3, Object obj4, Object obj5, boolean z11, List<Class<?>> list, List<?> list2, Collection<ClassFileTransformer> collection) {
        try {
            return (byte[]) this.dispatcher.invoke(this.target, new Object[]{obj, str, obj2, obj3, obj4, obj5, Boolean.valueOf(z11), list, list2, collection});
        } catch (RuntimeException e11) {
            throw e11;
        } catch (Exception e12) {
            throw new IllegalStateException("Cannot create class for lambda expression", e12);
        }
    }

    public static byte[] make(Object obj, String str, Object obj2, Object obj3, Object obj4, Object obj5, boolean z11, List<Class<?>> list, List<?> list2) {
        Map<ClassFileTransformer, LambdaFactory> map = CLASS_FILE_TRANSFORMERS;
        return map.values().iterator().next().invoke(obj, str, obj2, obj3, obj4, obj5, z11, list, list2, map.keySet());
    }

    public static boolean register(ClassFileTransformer classFileTransformer, Object obj) {
        Class cls;
        Map map;
        boolean isEmpty;
        ClassFileTransformer classFileTransformer2 = classFileTransformer;
        try {
            TypeDescription of2 = TypeDescription.ForLoadedType.of(LambdaFactory.class);
            cls = ClassInjector.UsingReflection.ofSystemClassLoader().inject(Collections.singletonMap(of2, ClassFileLocator.ForClassLoader.read((Class<?>) LambdaFactory.class))).get(of2);
            map = (Map) cls.getField(FIELD_NAME).get((Object) null);
            synchronized (map) {
                isEmpty = map.isEmpty();
                map.put(classFileTransformer2, cls.getConstructor(new Class[]{Object.class, Method.class}).newInstance(new Object[]{obj, obj.getClass().getMethod(TypeProxy.REFLECTION_METHOD, new Class[]{Object.class, String.class, Object.class, Object.class, Object.class, Object.class, Boolean.TYPE, List.class, List.class, Collection.class})}));
            }
            return isEmpty;
        } catch (RuntimeException e11) {
            throw e11;
        } catch (Exception e12) {
            throw new IllegalStateException("Could not register class file transformer", e12);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static boolean release(ClassFileTransformer classFileTransformer) {
        boolean z11;
        try {
            Map map = (Map) ClassLoader.getSystemClassLoader().loadClass(LambdaFactory.class.getName()).getField(FIELD_NAME).get((Object) null);
            synchronized (map) {
                if (map.remove(classFileTransformer) == null || !map.isEmpty()) {
                    z11 = false;
                } else {
                    z11 = true;
                }
            }
            return z11;
        } catch (RuntimeException e11) {
            throw e11;
        } catch (Exception e12) {
            throw new IllegalStateException("Could not release class file transformer", e12);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LambdaFactory lambdaFactory = (LambdaFactory) obj;
        return this.target.equals(lambdaFactory.target) && this.dispatcher.equals(lambdaFactory.dispatcher);
    }

    public int hashCode() {
        return (((getClass().hashCode() * 31) + this.target.hashCode()) * 31) + this.dispatcher.hashCode();
    }
}
