package com.google.android.recaptcha.internal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class zzbc implements InvocationHandler {
    @Nullable
    private final Object zza;

    public zzbc(@Nullable Object obj) {
        this.zza = obj;
    }

    @NotNull
    public final Object invoke(@NotNull Object obj, @NotNull Method method, @Nullable Object[] objArr) {
        Object obj2;
        if (Intrinsics.areEqual((Object) method.getName(), (Object) "toString") && method.getParameterTypes().length == 0) {
            return "Proxy@".concat(String.valueOf(Integer.toHexString(obj.hashCode())));
        }
        if (Intrinsics.areEqual((Object) method.getName(), (Object) "hashCode") && method.getParameterTypes().length == 0) {
            return Integer.valueOf(System.identityHashCode(obj));
        }
        if (Intrinsics.areEqual((Object) method.getName(), (Object) "equals") && method.getParameterTypes().length != 0) {
            boolean z11 = false;
            if (!(objArr == null || objArr.length == 0 || objArr[0].hashCode() != obj.hashCode())) {
                z11 = true;
            }
            return Boolean.valueOf(z11);
        } else if (!zza(obj, method, objArr)) {
            return Unit.INSTANCE;
        } else {
            if ((this.zza != null || !Intrinsics.areEqual((Object) method.getReturnType(), (Object) Void.TYPE)) && ((obj2 = this.zza) == null || !Intrinsics.areEqual((Object) zzep.zza(obj2.getClass()), (Object) zzep.zza(method.getReturnType())))) {
                Object obj3 = this.zza;
                Class<?> returnType = method.getReturnType();
                throw new IllegalArgumentException(obj3 + " cannot be returned from method with return type " + returnType);
            }
            Object obj4 = this.zza;
            if (obj4 == null) {
                return Unit.INSTANCE;
            }
            return obj4;
        }
    }

    public abstract boolean zza(@NotNull Object obj, @NotNull Method method, @Nullable Object[] objArr);
}
