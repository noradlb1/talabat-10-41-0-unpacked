package kotlin.reflect.jvm;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.calls.Caller;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\",\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"value", "", "isAccessible", "Lkotlin/reflect/KCallable;", "(Lkotlin/reflect/KCallable;)Z", "setAccessible", "(Lkotlin/reflect/KCallable;Z)V", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
@JvmName(name = "KCallablesJvm")
public final class KCallablesJvm {
    public static final boolean isAccessible(@NotNull KCallable<?> kCallable) {
        boolean z11;
        Object obj;
        boolean z12;
        boolean z13;
        Caller<?> defaultCaller;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z21;
        boolean z22;
        boolean z23;
        Intrinsics.checkNotNullParameter(kCallable, "<this>");
        if (kCallable instanceof KMutableProperty) {
            KProperty kProperty = (KProperty) kCallable;
            Field javaField = ReflectJvmMapping.getJavaField(kProperty);
            if (javaField != null) {
                z21 = javaField.isAccessible();
            } else {
                z21 = true;
            }
            if (!z21) {
                return false;
            }
            Method javaGetter = ReflectJvmMapping.getJavaGetter(kProperty);
            if (javaGetter != null) {
                z22 = javaGetter.isAccessible();
            } else {
                z22 = true;
            }
            if (!z22) {
                return false;
            }
            Method javaSetter = ReflectJvmMapping.getJavaSetter((KMutableProperty) kCallable);
            if (javaSetter != null) {
                z23 = javaSetter.isAccessible();
            } else {
                z23 = true;
            }
            if (!z23) {
                return false;
            }
        } else if (kCallable instanceof KProperty) {
            KProperty kProperty2 = (KProperty) kCallable;
            Field javaField2 = ReflectJvmMapping.getJavaField(kProperty2);
            if (javaField2 != null) {
                z18 = javaField2.isAccessible();
            } else {
                z18 = true;
            }
            if (!z18) {
                return false;
            }
            Method javaGetter2 = ReflectJvmMapping.getJavaGetter(kProperty2);
            if (javaGetter2 != null) {
                z19 = javaGetter2.isAccessible();
            } else {
                z19 = true;
            }
            if (!z19) {
                return false;
            }
        } else if (kCallable instanceof KProperty.Getter) {
            Field javaField3 = ReflectJvmMapping.getJavaField(((KProperty.Getter) kCallable).getProperty());
            if (javaField3 != null) {
                z16 = javaField3.isAccessible();
            } else {
                z16 = true;
            }
            if (!z16) {
                return false;
            }
            Method javaMethod = ReflectJvmMapping.getJavaMethod((KFunction) kCallable);
            if (javaMethod != null) {
                z17 = javaMethod.isAccessible();
            } else {
                z17 = true;
            }
            if (!z17) {
                return false;
            }
        } else if (kCallable instanceof KMutableProperty.Setter) {
            Field javaField4 = ReflectJvmMapping.getJavaField(((KMutableProperty.Setter) kCallable).getProperty());
            if (javaField4 != null) {
                z14 = javaField4.isAccessible();
            } else {
                z14 = true;
            }
            if (!z14) {
                return false;
            }
            Method javaMethod2 = ReflectJvmMapping.getJavaMethod((KFunction) kCallable);
            if (javaMethod2 != null) {
                z15 = javaMethod2.isAccessible();
            } else {
                z15 = true;
            }
            if (!z15) {
                return false;
            }
        } else if (kCallable instanceof KFunction) {
            KFunction kFunction = (KFunction) kCallable;
            Method javaMethod3 = ReflectJvmMapping.getJavaMethod(kFunction);
            if (javaMethod3 != null) {
                z11 = javaMethod3.isAccessible();
            } else {
                z11 = true;
            }
            if (!z11) {
                return false;
            }
            KCallableImpl<?> asKCallableImpl = UtilKt.asKCallableImpl(kCallable);
            AccessibleObject accessibleObject = null;
            if (asKCallableImpl == null || (defaultCaller = asKCallableImpl.getDefaultCaller()) == null) {
                obj = null;
            } else {
                obj = defaultCaller.getMember();
            }
            if (obj instanceof AccessibleObject) {
                accessibleObject = (AccessibleObject) obj;
            }
            if (accessibleObject != null) {
                z12 = accessibleObject.isAccessible();
            } else {
                z12 = true;
            }
            if (!z12) {
                return false;
            }
            Constructor javaConstructor = ReflectJvmMapping.getJavaConstructor(kFunction);
            if (javaConstructor != null) {
                z13 = javaConstructor.isAccessible();
            } else {
                z13 = true;
            }
            if (!z13) {
                return false;
            }
        } else {
            throw new UnsupportedOperationException("Unknown callable: " + kCallable + " (" + kCallable.getClass() + ')');
        }
        return true;
    }

    public static final void setAccessible(@NotNull KCallable<?> kCallable, boolean z11) {
        Object obj;
        Caller<?> defaultCaller;
        Intrinsics.checkNotNullParameter(kCallable, "<this>");
        if (kCallable instanceof KMutableProperty) {
            KProperty kProperty = (KProperty) kCallable;
            Field javaField = ReflectJvmMapping.getJavaField(kProperty);
            if (javaField != null) {
                javaField.setAccessible(z11);
            }
            Method javaGetter = ReflectJvmMapping.getJavaGetter(kProperty);
            if (javaGetter != null) {
                javaGetter.setAccessible(z11);
            }
            Method javaSetter = ReflectJvmMapping.getJavaSetter((KMutableProperty) kCallable);
            if (javaSetter != null) {
                javaSetter.setAccessible(z11);
            }
        } else if (kCallable instanceof KProperty) {
            KProperty kProperty2 = (KProperty) kCallable;
            Field javaField2 = ReflectJvmMapping.getJavaField(kProperty2);
            if (javaField2 != null) {
                javaField2.setAccessible(z11);
            }
            Method javaGetter2 = ReflectJvmMapping.getJavaGetter(kProperty2);
            if (javaGetter2 != null) {
                javaGetter2.setAccessible(z11);
            }
        } else if (kCallable instanceof KProperty.Getter) {
            Field javaField3 = ReflectJvmMapping.getJavaField(((KProperty.Getter) kCallable).getProperty());
            if (javaField3 != null) {
                javaField3.setAccessible(z11);
            }
            Method javaMethod = ReflectJvmMapping.getJavaMethod((KFunction) kCallable);
            if (javaMethod != null) {
                javaMethod.setAccessible(z11);
            }
        } else if (kCallable instanceof KMutableProperty.Setter) {
            Field javaField4 = ReflectJvmMapping.getJavaField(((KMutableProperty.Setter) kCallable).getProperty());
            if (javaField4 != null) {
                javaField4.setAccessible(z11);
            }
            Method javaMethod2 = ReflectJvmMapping.getJavaMethod((KFunction) kCallable);
            if (javaMethod2 != null) {
                javaMethod2.setAccessible(z11);
            }
        } else if (kCallable instanceof KFunction) {
            KFunction kFunction = (KFunction) kCallable;
            Method javaMethod3 = ReflectJvmMapping.getJavaMethod(kFunction);
            if (javaMethod3 != null) {
                javaMethod3.setAccessible(z11);
            }
            KCallableImpl<?> asKCallableImpl = UtilKt.asKCallableImpl(kCallable);
            AccessibleObject accessibleObject = null;
            if (asKCallableImpl == null || (defaultCaller = asKCallableImpl.getDefaultCaller()) == null) {
                obj = null;
            } else {
                obj = defaultCaller.getMember();
            }
            if (obj instanceof AccessibleObject) {
                accessibleObject = (AccessibleObject) obj;
            }
            if (accessibleObject != null) {
                accessibleObject.setAccessible(true);
            }
            Constructor javaConstructor = ReflectJvmMapping.getJavaConstructor(kFunction);
            if (javaConstructor != null) {
                javaConstructor.setAccessible(z11);
            }
        } else {
            throw new UnsupportedOperationException("Unknown callable: " + kCallable + " (" + kCallable.getClass() + ')');
        }
    }
}
