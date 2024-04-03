package androidx.lifecycle;

import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
final class ClassesInfoCache {
    private static final int CALL_TYPE_NO_ARG = 0;
    private static final int CALL_TYPE_PROVIDER = 1;
    private static final int CALL_TYPE_PROVIDER_WITH_EVENT = 2;

    /* renamed from: a  reason: collision with root package name */
    public static ClassesInfoCache f35975a = new ClassesInfoCache();
    private final Map<Class<?>, CallbackInfo> mCallbackMap = new HashMap();
    private final Map<Class<?>, Boolean> mHasLifecycleMethods = new HashMap();

    @Deprecated
    public static class CallbackInfo {

        /* renamed from: a  reason: collision with root package name */
        public final Map<Lifecycle.Event, List<MethodReference>> f35976a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        public final Map<MethodReference, Lifecycle.Event> f35977b;

        public CallbackInfo(Map<MethodReference, Lifecycle.Event> map) {
            this.f35977b = map;
            for (Map.Entry next : map.entrySet()) {
                Lifecycle.Event event = (Lifecycle.Event) next.getValue();
                List list = this.f35976a.get(event);
                if (list == null) {
                    list = new ArrayList();
                    this.f35976a.put(event, list);
                }
                list.add((MethodReference) next.getKey());
            }
        }

        private static void invokeMethodsForEvent(List<MethodReference> list, LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(lifecycleOwner, event, obj);
                }
            }
        }

        public void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            invokeMethodsForEvent(this.f35976a.get(event), lifecycleOwner, event, obj);
            invokeMethodsForEvent(this.f35976a.get(Lifecycle.Event.ON_ANY), lifecycleOwner, event, obj);
        }
    }

    @Deprecated
    public static final class MethodReference {

        /* renamed from: a  reason: collision with root package name */
        public final int f35978a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f35979b;

        public MethodReference(int i11, Method method) {
            this.f35978a = i11;
            this.f35979b = method;
            method.setAccessible(true);
        }

        public void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            try {
                int i11 = this.f35978a;
                if (i11 == 0) {
                    this.f35979b.invoke(obj, new Object[0]);
                } else if (i11 == 1) {
                    this.f35979b.invoke(obj, new Object[]{lifecycleOwner});
                } else if (i11 == 2) {
                    this.f35979b.invoke(obj, new Object[]{lifecycleOwner, event});
                }
            } catch (InvocationTargetException e11) {
                throw new RuntimeException("Failed to call observer method", e11.getCause());
            } catch (IllegalAccessException e12) {
                throw new RuntimeException(e12);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MethodReference)) {
                return false;
            }
            MethodReference methodReference = (MethodReference) obj;
            if (this.f35978a != methodReference.f35978a || !this.f35979b.getName().equals(methodReference.f35979b.getName())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.f35978a * 31) + this.f35979b.getName().hashCode();
        }
    }

    private CallbackInfo createInfo(Class<?> cls, @Nullable Method[] methodArr) {
        int i11;
        CallbackInfo a11;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (!(superclass == null || (a11 = a(superclass)) == null)) {
            hashMap.putAll(a11.f35977b);
        }
        for (Class a12 : cls.getInterfaces()) {
            for (Map.Entry next : a(a12).f35977b.entrySet()) {
                verifyAndPutHandler(hashMap, (MethodReference) next.getKey(), (Lifecycle.Event) next.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = getDeclaredMethods(cls);
        }
        boolean z11 = false;
        for (Method method : methodArr) {
            OnLifecycleEvent onLifecycleEvent = (OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class);
            if (onLifecycleEvent != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i11 = 0;
                } else if (parameterTypes[0].isAssignableFrom(LifecycleOwner.class)) {
                    i11 = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                Lifecycle.Event value = onLifecycleEvent.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(Lifecycle.Event.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (value == Lifecycle.Event.ON_ANY) {
                        i11 = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    verifyAndPutHandler(hashMap, new MethodReference(i11, method), value, cls);
                    z11 = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        CallbackInfo callbackInfo = new CallbackInfo(hashMap);
        this.mCallbackMap.put(cls, callbackInfo);
        this.mHasLifecycleMethods.put(cls, Boolean.valueOf(z11));
        return callbackInfo;
    }

    private Method[] getDeclaredMethods(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e11) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e11);
        }
    }

    private void verifyAndPutHandler(Map<MethodReference, Lifecycle.Event> map, MethodReference methodReference, Lifecycle.Event event, Class<?> cls) {
        Lifecycle.Event event2 = map.get(methodReference);
        if (event2 != null && event != event2) {
            Method method = methodReference.f35979b;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
        } else if (event2 == null) {
            map.put(methodReference, event);
        }
    }

    public CallbackInfo a(Class<?> cls) {
        CallbackInfo callbackInfo = this.mCallbackMap.get(cls);
        if (callbackInfo != null) {
            return callbackInfo;
        }
        return createInfo(cls, (Method[]) null);
    }

    public boolean b(Class<?> cls) {
        Boolean bool = this.mHasLifecycleMethods.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] declaredMethods = getDeclaredMethods(cls);
        for (Method annotation : declaredMethods) {
            if (((OnLifecycleEvent) annotation.getAnnotation(OnLifecycleEvent.class)) != null) {
                createInfo(cls, declaredMethods);
                return true;
            }
        }
        this.mHasLifecycleMethods.put(cls, Boolean.FALSE);
        return false;
    }
}
