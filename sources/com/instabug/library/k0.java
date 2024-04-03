package com.instabug.library;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.internal.utils.stability.handler.exception.ExceptionHandler;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class k0 {

    /* renamed from: a  reason: collision with root package name */
    private static final ExceptionHandler f50576a = new ExceptionHandler().withPenaltyLog("ReflectionUtils");

    @Nullable
    public static Field a(@NonNull Class cls, @NonNull String str) {
        return (Field) f50576a.executeAndGet(new h0(cls, str));
    }

    @Nullable
    public static Method b(@NonNull Class cls, @NonNull String str) {
        return (Method) f50576a.executeAndGet(new j0(cls, str));
    }

    @Nullable
    public static Object a(@NonNull Field field, @NonNull Object obj) {
        return f50576a.executeAndGet(new i0(field, obj));
    }
}
