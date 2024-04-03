package com.deliveryhero.performance.firebase;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.perf.FirebasePerformance;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0004\n\u0002\b\u0005¨\u0006\u000b"}, d2 = {"Lcom/deliveryhero/performance/firebase/FirebasePerformanceProvider;", "", "()V", "INSTANCE", "Lcom/deliveryhero/performance/firebase/FirebasePerformanceTracker;", "INSTANCE$1", "getInstance", "initialize", "", "context", "Landroid/content/Context;", "firebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FirebasePerformanceProvider {
    @NotNull
    public static final FirebasePerformanceProvider INSTANCE = new FirebasePerformanceProvider();
    @Nullable
    private static FirebasePerformanceTracker INSTANCE$1;

    private FirebasePerformanceProvider() {
    }

    @JvmStatic
    @NotNull
    public static final FirebasePerformanceTracker getInstance() {
        FirebasePerformanceTracker firebasePerformanceTracker;
        FirebasePerformanceTracker firebasePerformanceTracker2 = INSTANCE$1;
        if (firebasePerformanceTracker2 != null) {
            return firebasePerformanceTracker2;
        }
        synchronized (INSTANCE) {
            firebasePerformanceTracker = INSTANCE$1;
            if (firebasePerformanceTracker == null) {
                FirebasePerformance instance = FirebasePerformance.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
                firebasePerformanceTracker = new FirebasePerformanceTracker(instance);
                INSTANCE$1 = firebasePerformanceTracker;
            }
        }
        return firebasePerformanceTracker;
    }

    @JvmStatic
    public static final void initialize(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        FirebaseApp.initializeApp(context);
    }
}
