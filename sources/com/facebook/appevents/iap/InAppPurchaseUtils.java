package com.facebook.appevents.iap;

import android.content.Context;
import com.braze.ui.actions.brazeactions.steps.StepData;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.newrelic.agent.android.agentdata.HexAttribute;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J#\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\nJE\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u001e\u0010\u000f\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0010\"\b\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0001¢\u0006\u0004\b\u0011\u0010\u0012JC\u0010\u0013\u001a\u0004\u0018\u00010\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u001e\u0010\u000f\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0010\"\b\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\u0012JE\u0010\u0014\u001a\u0004\u0018\u00010\u00012\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0010\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseUtils;", "", "()V", "getClass", "Ljava/lang/Class;", "className", "", "getClassFromContext", "context", "Landroid/content/Context;", "getClassFromContext$facebook_core_release", "getDeclaredMethod", "Ljava/lang/reflect/Method;", "clazz", "methodName", "args", "", "getDeclaredMethod$facebook_core_release", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "getMethod", "invokeMethod", "method", "obj", "(Ljava/lang/Class;Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class InAppPurchaseUtils {
    @NotNull
    public static final InAppPurchaseUtils INSTANCE = new InAppPurchaseUtils();

    private InAppPurchaseUtils() {
    }

    @JvmStatic
    @Nullable
    public static final Class<?> getClass(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, HexAttribute.HEX_ATTR_CLASS_NAME);
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final Class<?> getClassFromContext$facebook_core_release(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, HexAttribute.HEX_ATTR_CLASS_NAME);
        try {
            return context.getClassLoader().loadClass(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final Method getDeclaredMethod$facebook_core_release(@NotNull Class<?> cls, @NotNull String str, @NotNull Class<?>... clsArr) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(str, HexAttribute.HEX_ATTR_METHOD_NAME);
        Intrinsics.checkNotNullParameter(clsArr, StepData.ARGS);
        try {
            return cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final Method getMethod(@NotNull Class<?> cls, @NotNull String str, @NotNull Class<?>... clsArr) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(str, HexAttribute.HEX_ATTR_METHOD_NAME);
        Intrinsics.checkNotNullParameter(clsArr, StepData.ARGS);
        try {
            return cls.getMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final Object invokeMethod(@NotNull Class<?> cls, @NotNull Method method, @Nullable Object obj, @NotNull Object... objArr) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
        if (obj != null) {
            obj = cls.cast(obj);
        }
        try {
            return method.invoke(obj, Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }
}
