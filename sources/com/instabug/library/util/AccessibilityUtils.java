package com.instabug.library.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.instabug.library.Instabug;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class AccessibilityUtils {
    @NotNull
    public static final AccessibilityUtils INSTANCE = new AccessibilityUtils();

    private AccessibilityUtils() {
    }

    private final AccessibilityManager getAccessibilityManager() {
        Object obj;
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext == null) {
            obj = null;
        } else {
            obj = applicationContext.getSystemService("accessibility");
        }
        return (AccessibilityManager) obj;
    }

    public static final boolean isAccessibilityServiceEnabled() {
        AccessibilityManager accessibilityManager = INSTANCE.getAccessibilityManager();
        if (accessibilityManager == null) {
            return false;
        }
        return accessibilityManager.isEnabled();
    }

    @JvmStatic
    public static /* synthetic */ void isAccessibilityServiceEnabled$annotations() {
    }

    @JvmStatic
    @SuppressLint({"InlinedApi"})
    public static final void sendTextEvent(@NotNull String str) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "message");
        Integer valueOf = Integer.valueOf(Build.VERSION.SDK_INT);
        if (valueOf.intValue() < 16 || !isAccessibilityServiceEnabled()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            valueOf = null;
        }
        if (valueOf != null) {
            valueOf.intValue();
            AccessibilityEvent obtain = AccessibilityEvent.obtain(16384);
            if (obtain != null) {
                obtain.getText().add(str);
                AccessibilityManager accessibilityManager = INSTANCE.getAccessibilityManager();
                if (accessibilityManager != null) {
                    accessibilityManager.sendAccessibilityEvent(obtain);
                }
            }
        }
    }
}
