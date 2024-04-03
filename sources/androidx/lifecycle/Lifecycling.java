package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.Lifecycle;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.bytebuddy.utility.JavaConstant;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class Lifecycling {
    private static final int GENERATED_CALLBACK = 2;
    private static final int REFLECTIVE_CALLBACK = 1;
    private static Map<Class<?>, Integer> sCallbackCache = new HashMap();
    private static Map<Class<?>, List<Constructor<? extends GeneratedAdapter>>> sClassToAdapters = new HashMap();

    /* renamed from: androidx.lifecycle.Lifecycling$1  reason: invalid class name */
    class AnonymousClass1 implements GenericLifecycleObserver {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LifecycleEventObserver f36048b;

        public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
            this.f36048b.onStateChanged(lifecycleOwner, event);
        }
    }

    private Lifecycling() {
    }

    @NonNull
    public static LifecycleEventObserver a(Object obj) {
        boolean z11 = obj instanceof LifecycleEventObserver;
        boolean z12 = obj instanceof FullLifecycleObserver;
        if (z11 && z12) {
            return new FullLifecycleObserverAdapter((FullLifecycleObserver) obj, (LifecycleEventObserver) obj);
        }
        if (z12) {
            return new FullLifecycleObserverAdapter((FullLifecycleObserver) obj, (LifecycleEventObserver) null);
        }
        if (z11) {
            return (LifecycleEventObserver) obj;
        }
        Class<?> cls = obj.getClass();
        if (getObserverConstructorType(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List list = sClassToAdapters.get(cls);
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(createGeneratedAdapter((Constructor) list.get(0), obj));
        }
        GeneratedAdapter[] generatedAdapterArr = new GeneratedAdapter[list.size()];
        for (int i11 = 0; i11 < list.size(); i11++) {
            generatedAdapterArr[i11] = createGeneratedAdapter((Constructor) list.get(i11), obj);
        }
        return new CompositeGeneratedAdaptersObserver(generatedAdapterArr);
    }

    private static GeneratedAdapter createGeneratedAdapter(Constructor<? extends GeneratedAdapter> constructor, Object obj) {
        try {
            return (GeneratedAdapter) constructor.newInstance(new Object[]{obj});
        } catch (IllegalAccessException e11) {
            throw new RuntimeException(e11);
        } catch (InstantiationException e12) {
            throw new RuntimeException(e12);
        } catch (InvocationTargetException e13) {
            throw new RuntimeException(e13);
        }
    }

    @Nullable
    private static Constructor<? extends GeneratedAdapter> generatedConstructor(Class<?> cls) {
        String str;
        try {
            Package packageR = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            if (packageR != null) {
                str = packageR.getName();
            } else {
                str = "";
            }
            if (!str.isEmpty()) {
                canonicalName = canonicalName.substring(str.length() + 1);
            }
            String adapterName = getAdapterName(canonicalName);
            if (!str.isEmpty()) {
                adapterName = str + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + adapterName;
            }
            Constructor<?> declaredConstructor = Class.forName(adapterName).getDeclaredConstructor(new Class[]{cls});
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e11) {
            throw new RuntimeException(e11);
        }
    }

    public static String getAdapterName(String str) {
        return str.replace(RealDiscoveryConfigurationRepository.VERSION_DELIMETER, JavaConstant.Dynamic.DEFAULT_NAME) + "_LifecycleAdapter";
    }

    private static int getObserverConstructorType(Class<?> cls) {
        Integer num = sCallbackCache.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int resolveObserverCallbackType = resolveObserverCallbackType(cls);
        sCallbackCache.put(cls, Integer.valueOf(resolveObserverCallbackType));
        return resolveObserverCallbackType;
    }

    private static boolean isLifecycleParent(Class<?> cls) {
        return cls != null && LifecycleObserver.class.isAssignableFrom(cls);
    }

    private static int resolveObserverCallbackType(Class<?> cls) {
        ArrayList arrayList;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends GeneratedAdapter> generatedConstructor = generatedConstructor(cls);
        if (generatedConstructor != null) {
            sClassToAdapters.put(cls, Collections.singletonList(generatedConstructor));
            return 2;
        } else if (ClassesInfoCache.f35975a.b(cls)) {
            return 1;
        } else {
            Class<? super Object> superclass = cls.getSuperclass();
            if (!isLifecycleParent(superclass)) {
                arrayList = null;
            } else if (getObserverConstructorType(superclass) == 1) {
                return 1;
            } else {
                arrayList = new ArrayList(sClassToAdapters.get(superclass));
            }
            for (Class cls2 : cls.getInterfaces()) {
                if (isLifecycleParent(cls2)) {
                    if (getObserverConstructorType(cls2) == 1) {
                        return 1;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.addAll(sClassToAdapters.get(cls2));
                }
            }
            if (arrayList == null) {
                return 1;
            }
            sClassToAdapters.put(cls, arrayList);
            return 2;
        }
    }
}
