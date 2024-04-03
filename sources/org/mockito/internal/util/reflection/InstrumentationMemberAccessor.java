package org.mockito.internal.util.reflection;

import j$.util.Map;
import java.lang.instrument.Instrumentation;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.MethodCall;
import net.bytebuddy.matcher.ElementMatchers;
import org.mockito.exceptions.base.MockitoInitializationException;
import org.mockito.internal.SuppressSignatureCheck;
import org.mockito.internal.util.StringUtil;
import org.mockito.plugins.MemberAccessor;
import z30.l;

@SuppressSignatureCheck
class InstrumentationMemberAccessor implements MemberAccessor {
    private static final Dispatcher DISPATCHER;
    private static final Throwable INITIALIZATION_ERROR;
    private static final Instrumentation INSTRUMENTATION;
    private static final Map<Class<?>, Class<?>> WRAPPERS;
    private final MethodHandle getModule;
    private final MethodHandle isOpen;
    private final MethodHandle privateLookupIn;
    private final MethodHandle redefineModule;

    public interface Dispatcher {
        MethodHandles.Lookup getLookup();

        Object getModule();

        Object invokeWithArguments(MethodHandle methodHandle, Object... objArr) throws Throwable;

        void setAccessible(AccessibleObject accessibleObject, boolean z11);
    }

    static {
        Throwable th2;
        Dispatcher dispatcher;
        HashMap hashMap = new HashMap();
        WRAPPERS = hashMap;
        Class cls = Boolean.TYPE;
        hashMap.put(cls, Boolean.class);
        hashMap.put(Byte.TYPE, Byte.class);
        hashMap.put(Short.TYPE, Short.class);
        hashMap.put(Character.TYPE, Character.class);
        hashMap.put(Integer.TYPE, Integer.class);
        hashMap.put(Long.TYPE, Long.class);
        hashMap.put(Float.TYPE, Float.class);
        hashMap.put(Double.TYPE, Double.class);
        Instrumentation instrumentation = null;
        try {
            Instrumentation install = ByteBuddyAgent.install();
            dispatcher = (Dispatcher) new ByteBuddy().subclass(Dispatcher.class).method(ElementMatchers.named("getLookup")).intercept(MethodCall.invoke(MethodHandles.class.getMethod("lookup", new Class[0]))).method(ElementMatchers.named("getModule")).intercept(MethodCall.invoke(Class.class.getMethod("getModule", new Class[0])).onMethodCall(MethodCall.invoke(Object.class.getMethod("getClass", new Class[0])))).method(ElementMatchers.named("setAccessible")).intercept(MethodCall.invoke(AccessibleObject.class.getMethod("setAccessible", new Class[]{cls})).onArgument(0).withArgument(1)).method(ElementMatchers.named("invokeWithArguments")).intercept(MethodCall.invoke(MethodHandle.class.getMethod("invokeWithArguments", new Class[]{Object[].class})).onArgument(0).withArgument(1)).make().load(InstrumentationMemberAccessor.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER).getLoaded().getConstructor(new Class[0]).newInstance(new Object[0]);
            th2 = null;
            instrumentation = install;
        } catch (Throwable th3) {
            th2 = th3;
            dispatcher = null;
        }
        INSTRUMENTATION = instrumentation;
        DISPATCHER = dispatcher;
        INITIALIZATION_ERROR = th2;
    }

    public InstrumentationMemberAccessor() {
        Class<Set> cls = Set.class;
        Class<Class> cls2 = Class.class;
        Class<Map> cls3 = Map.class;
        Throwable th2 = INITIALIZATION_ERROR;
        if (th2 == null) {
            try {
                Class<?> cls4 = Class.forName("java.lang.Module");
                this.getModule = MethodHandles.publicLookup().findVirtual(cls2, "getModule", MethodType.methodType(cls4));
                this.isOpen = MethodHandles.publicLookup().findVirtual(cls4, "isOpen", MethodType.methodType(Boolean.TYPE, String.class));
                this.redefineModule = MethodHandles.publicLookup().findVirtual(Instrumentation.class, "redefineModule", MethodType.methodType(Void.TYPE, cls4, new Class[]{cls, cls3, cls3, cls, cls3}));
                this.privateLookupIn = MethodHandles.publicLookup().findStatic(MethodHandles.class, "privateLookupIn", MethodType.methodType(MethodHandles.Lookup.class, cls2, new Class[]{MethodHandles.Lookup.class}));
            } catch (Throwable th3) {
                throw new MockitoInitializationException("Could not resolve instrumentation invoker", th3);
            }
        } else {
            throw new MockitoInitializationException(StringUtil.join("Could not initialize the Mockito instrumentation member accessor", "", "This is unexpected on JVMs from Java 9 or later - possibly, the instrumentation API could not be resolved"), th2);
        }
    }

    private static void assureArguments(AccessibleObject accessibleObject, Object obj, Class<?> cls, Object[] objArr, Class<?>[] clsArr) {
        if (obj != null && !cls.isAssignableFrom(obj.getClass())) {
            throw new IllegalArgumentException("Cannot access " + accessibleObject + " on " + obj);
        } else if (clsArr.length == objArr.length) {
            for (int i11 = 0; i11 < objArr.length; i11++) {
                if (objArr[i11] != null) {
                    Map<Class<?>, Class<?>> map = WRAPPERS;
                    Class<?> cls2 = clsArr[i11];
                    Class cls3 = (Class) Map.EL.getOrDefault(map, cls2, cls2);
                    if (!cls3.isAssignableFrom(objArr[i11].getClass())) {
                        throw new IllegalArgumentException("Cannot assign value of type " + objArr[i11].getClass() + " to " + cls3 + " for " + i11 + " parameter of " + accessibleObject);
                    }
                } else if (clsArr[i11].isPrimitive()) {
                    throw new IllegalArgumentException("Cannot assign null to primitive type " + clsArr[i11].getTypeName() + " for " + i11 + " parameter of " + accessibleObject);
                }
            }
        } else {
            throw new IllegalArgumentException("Incorrect number of arguments for " + accessibleObject + ": expected " + clsArr.length + " but recevied " + objArr.length);
        }
    }

    private void assureOpen(Object obj, String str) throws Throwable {
        Dispatcher dispatcher = DISPATCHER;
        if (!((Boolean) dispatcher.invokeWithArguments(this.isOpen, obj, str)).booleanValue()) {
            dispatcher.invokeWithArguments(this.redefineModule.bindTo(INSTRUMENTATION), obj, Collections.emptySet(), Collections.emptyMap(), Collections.singletonMap(str, Collections.singleton(dispatcher.getModule())), Collections.emptySet(), Collections.emptyMap());
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$newInstance$0(MethodHandle methodHandle, Object[] objArr, AtomicBoolean atomicBoolean) throws InstantiationException, InvocationTargetException, IllegalAccessException {
        try {
            return DISPATCHER.invokeWithArguments(methodHandle, objArr);
        } catch (Throwable th2) {
            atomicBoolean.set(true);
            return th2;
        }
    }

    public Object get(Field field, Object obj) {
        Object obj2;
        if (Modifier.isStatic(field.getModifiers())) {
            obj2 = null;
        } else {
            obj2 = obj;
        }
        assureArguments(field, obj2, field.getDeclaringClass(), new Object[0], new Class[0]);
        try {
            Dispatcher dispatcher = DISPATCHER;
            assureOpen(dispatcher.invokeWithArguments(this.getModule.bindTo(field.getDeclaringClass()), new Object[0]), field.getDeclaringClass().getPackage().getName());
            MethodHandle a11 = ((MethodHandles.Lookup) dispatcher.invokeWithArguments(this.privateLookupIn, field.getDeclaringClass(), dispatcher.getLookup())).unreflectGetter(field);
            if (!Modifier.isStatic(field.getModifiers())) {
                a11 = a11.bindTo(obj);
            }
            return dispatcher.invokeWithArguments(a11, new Object[0]);
        } catch (Throwable th2) {
            throw new IllegalStateException("Could not read " + field + " on " + obj, th2);
        }
    }

    public Object invoke(Method method, Object obj, Object... objArr) throws InvocationTargetException {
        Object obj2;
        if (Modifier.isStatic(method.getModifiers())) {
            obj2 = null;
        } else {
            obj2 = obj;
        }
        assureArguments(method, obj2, method.getDeclaringClass(), objArr, method.getParameterTypes());
        try {
            Dispatcher dispatcher = DISPATCHER;
            assureOpen(dispatcher.invokeWithArguments(this.getModule.bindTo(method.getDeclaringClass()), new Object[0]), method.getDeclaringClass().getPackage().getName());
            MethodHandle a11 = ((MethodHandles.Lookup) dispatcher.invokeWithArguments(this.privateLookupIn, method.getDeclaringClass(), dispatcher.getLookup())).unreflect(method);
            if (!Modifier.isStatic(method.getModifiers())) {
                a11 = a11.bindTo(obj);
            }
            return dispatcher.invokeWithArguments(a11, objArr);
        } catch (InvocationTargetException e11) {
            throw e11;
        } catch (Throwable th2) {
            throw new IllegalStateException("Could not invoke " + method + " on " + obj + " with arguments " + Arrays.toString(objArr), th2);
        }
    }

    public Object newInstance(Constructor<?> constructor, Object... objArr) throws InstantiationException, InvocationTargetException {
        return newInstance(constructor, new l(), objArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x006d, code lost:
        throw new java.lang.IllegalAccessException("Could not make final field " + r8 + " accessible");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006e, code lost:
        r10 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0052 */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void set(java.lang.reflect.Field r8, java.lang.Object r9, java.lang.Object r10) throws java.lang.IllegalAccessException {
        /*
            r7 = this;
            int r0 = r8.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isStatic(r0)
            if (r0 == 0) goto L_0x000c
            r0 = 0
            goto L_0x000d
        L_0x000c:
            r0 = r9
        L_0x000d:
            java.lang.Class r1 = r8.getDeclaringClass()
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r4 = 0
            r3[r4] = r10
            java.lang.Class[] r5 = new java.lang.Class[r2]
            java.lang.Class r6 = r8.getType()
            r5[r4] = r6
            assureArguments(r8, r0, r1, r3, r5)
            org.mockito.internal.util.reflection.InstrumentationMemberAccessor$Dispatcher r0 = DISPATCHER     // Catch:{ all -> 0x00b0 }
            java.lang.invoke.MethodHandle r1 = r7.getModule     // Catch:{ all -> 0x00b0 }
            java.lang.Class r3 = r8.getDeclaringClass()     // Catch:{ all -> 0x00b0 }
            java.lang.invoke.MethodHandle r1 = r1.bindTo(r3)     // Catch:{ all -> 0x00b0 }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ all -> 0x00b0 }
            java.lang.Object r1 = r0.invokeWithArguments(r1, r3)     // Catch:{ all -> 0x00b0 }
            java.lang.Class r3 = r8.getDeclaringClass()     // Catch:{ all -> 0x00b0 }
            java.lang.Package r3 = r3.getPackage()     // Catch:{ all -> 0x00b0 }
            java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x00b0 }
            r7.assureOpen(r1, r3)     // Catch:{ all -> 0x00b0 }
            int r1 = r8.getModifiers()     // Catch:{ all -> 0x00b0 }
            boolean r1 = java.lang.reflect.Modifier.isFinal(r1)     // Catch:{ all -> 0x00b0 }
            if (r1 == 0) goto L_0x0070
            r0.setAccessible(r8, r2)     // Catch:{ all -> 0x0052 }
            r1 = r2
            goto L_0x0071
        L_0x0052:
            java.lang.IllegalAccessException r10 = new java.lang.IllegalAccessException     // Catch:{ all -> 0x006e }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x006e }
            r0.<init>()     // Catch:{ all -> 0x006e }
            java.lang.String r1 = "Could not make final field "
            r0.append(r1)     // Catch:{ all -> 0x006e }
            r0.append(r8)     // Catch:{ all -> 0x006e }
            java.lang.String r1 = " accessible"
            r0.append(r1)     // Catch:{ all -> 0x006e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x006e }
            r10.<init>(r0)     // Catch:{ all -> 0x006e }
            throw r10     // Catch:{ all -> 0x006e }
        L_0x006e:
            r10 = move-exception
            goto L_0x00b2
        L_0x0070:
            r1 = r4
        L_0x0071:
            java.lang.invoke.MethodHandle r3 = r7.privateLookupIn     // Catch:{ all -> 0x00a7 }
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x00a7 }
            java.lang.Class r6 = r8.getDeclaringClass()     // Catch:{ all -> 0x00a7 }
            r5[r4] = r6     // Catch:{ all -> 0x00a7 }
            java.lang.invoke.MethodHandles$Lookup r6 = r0.getLookup()     // Catch:{ all -> 0x00a7 }
            r5[r2] = r6     // Catch:{ all -> 0x00a7 }
            java.lang.Object r3 = r0.invokeWithArguments(r3, r5)     // Catch:{ all -> 0x00a7 }
            java.lang.invoke.MethodHandles$Lookup r3 = (java.lang.invoke.MethodHandles.Lookup) r3     // Catch:{ all -> 0x00a7 }
            java.lang.invoke.MethodHandle r3 = r3.unreflectSetter(r8)     // Catch:{ all -> 0x00a7 }
            int r5 = r8.getModifiers()     // Catch:{ all -> 0x00a7 }
            boolean r5 = java.lang.reflect.Modifier.isStatic(r5)     // Catch:{ all -> 0x00a7 }
            if (r5 != 0) goto L_0x009a
            java.lang.invoke.MethodHandle r3 = r3.bindTo(r9)     // Catch:{ all -> 0x00a7 }
        L_0x009a:
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x00a7 }
            r2[r4] = r10     // Catch:{ all -> 0x00a7 }
            r0.invokeWithArguments(r3, r2)     // Catch:{ all -> 0x00a7 }
            if (r1 == 0) goto L_0x00a6
            r0.setAccessible(r8, r4)     // Catch:{ all -> 0x00b0 }
        L_0x00a6:
            return
        L_0x00a7:
            r10 = move-exception
            if (r1 == 0) goto L_0x00af
            org.mockito.internal.util.reflection.InstrumentationMemberAccessor$Dispatcher r0 = DISPATCHER     // Catch:{ all -> 0x00b0 }
            r0.setAccessible(r8, r4)     // Catch:{ all -> 0x00b0 }
        L_0x00af:
            throw r10     // Catch:{ all -> 0x00b0 }
        L_0x00b0:
            r10 = move-exception
            r2 = r4
        L_0x00b2:
            if (r2 == 0) goto L_0x00b7
            java.lang.IllegalAccessException r10 = (java.lang.IllegalAccessException) r10
            throw r10
        L_0x00b7:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Could not read "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r8 = " on "
            r1.append(r8)
            r1.append(r9)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8, r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mockito.internal.util.reflection.InstrumentationMemberAccessor.set(java.lang.reflect.Field, java.lang.Object, java.lang.Object):void");
    }

    public Object newInstance(Constructor<?> constructor, MemberAccessor.OnConstruction onConstruction, Object... objArr) throws InstantiationException, InvocationTargetException {
        if (!Modifier.isAbstract(constructor.getDeclaringClass().getModifiers())) {
            assureArguments(constructor, (Object) null, (Class<?>) null, objArr, constructor.getParameterTypes());
            try {
                Dispatcher dispatcher = DISPATCHER;
                assureOpen(dispatcher.invokeWithArguments(this.getModule.bindTo(constructor.getDeclaringClass()), new Object[0]), constructor.getDeclaringClass().getPackage().getName());
                MethodHandle a11 = ((MethodHandles.Lookup) dispatcher.invokeWithArguments(this.privateLookupIn, constructor.getDeclaringClass(), dispatcher.getLookup())).unreflectConstructor(constructor);
                AtomicBoolean atomicBoolean = new AtomicBoolean();
                Object invoke = onConstruction.invoke(new a(a11, objArr, atomicBoolean));
                if (!atomicBoolean.get()) {
                    return invoke;
                }
                throw new InvocationTargetException((Throwable) invoke);
            } catch (InvocationTargetException e11) {
                throw e11;
            } catch (Throwable th2) {
                throw new IllegalStateException("Could not construct " + constructor + " with arguments " + Arrays.toString(objArr), th2);
            }
        } else {
            throw new InstantiationException("Cannot instantiate abstract " + constructor.getDeclaringClass().getTypeName());
        }
    }
}
