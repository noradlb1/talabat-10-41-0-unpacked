package com.facebook.internal.instrument.crashshield;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.ExceptionAnalyzer;
import com.facebook.internal.instrument.InstrumentData;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\nH\u0007J\u001a\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0001H\u0007J\b\u0010\u0010\u001a\u00020\bH\u0007J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0001H\u0007J\u0012\u0010\u0012\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0007J\b\u0010\u0013\u001a\u00020\nH\u0007J\b\u0010\u0014\u001a\u00020\nH\u0007J\u0012\u0010\u0015\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007R2\u0010\u0003\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00010\u0001 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/facebook/internal/instrument/crashshield/CrashShieldHandler;", "", "()V", "crashingObjects", "", "kotlin.jvm.PlatformType", "", "enabled", "", "disable", "", "enable", "handleThrowable", "e", "", "o", "isDebug", "isObjectCrashing", "methodFinished", "reset", "resetCrashingObjects", "scheduleCrashInDebug", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CrashShieldHandler {
    @NotNull
    public static final CrashShieldHandler INSTANCE = new CrashShieldHandler();
    private static final Set<Object> crashingObjects = Collections.newSetFromMap(new WeakHashMap());
    private static boolean enabled;

    private CrashShieldHandler() {
    }

    @JvmStatic
    @VisibleForTesting
    public static final void disable() {
        enabled = false;
    }

    @JvmStatic
    public static final void enable() {
        enabled = true;
    }

    @JvmStatic
    public static final void handleThrowable(@Nullable Throwable th2, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "o");
        if (enabled) {
            crashingObjects.add(obj);
            if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                ExceptionAnalyzer.execute(th2);
                InstrumentData.Builder builder = InstrumentData.Builder.INSTANCE;
                InstrumentData.Builder.build(th2, InstrumentData.Type.CrashShield).save();
            }
            scheduleCrashInDebug(th2);
        }
    }

    @JvmStatic
    @VisibleForTesting
    public static final boolean isDebug() {
        return false;
    }

    @JvmStatic
    public static final boolean isObjectCrashing(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "o");
        return crashingObjects.contains(obj);
    }

    @JvmStatic
    public static final void methodFinished(@Nullable Object obj) {
    }

    @JvmStatic
    public static final void reset() {
        resetCrashingObjects();
    }

    @JvmStatic
    public static final void resetCrashingObjects() {
        crashingObjects.clear();
    }

    @JvmStatic
    @VisibleForTesting
    public static final void scheduleCrashInDebug(@Nullable Throwable th2) {
        if (isDebug()) {
            new Handler(Looper.getMainLooper()).post(new CrashShieldHandler$scheduleCrashInDebug$1(th2));
        }
    }
}
