package com.talabat.observabilityNew.performance;

import android.content.Context;
import com.deliveryhero.performance.firebase.FirebasePerformanceProvider;
import com.talabat.core.context.domain.ApplicationContext;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/talabat/observabilityNew/performance/FirebasePerformanceProviderInitializer;", "Lcom/talabat/observabilityNew/performance/PerformanceTrackingInitializer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "initialize", "", "com_talabat_core_observability_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FirebasePerformanceProviderInitializer implements PerformanceTrackingInitializer {
    @NotNull
    private final Context context;

    @Inject
    public FirebasePerformanceProviderInitializer(@NotNull @ApplicationContext Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public void initialize() {
        FirebasePerformanceProvider.initialize(this.context);
    }
}
