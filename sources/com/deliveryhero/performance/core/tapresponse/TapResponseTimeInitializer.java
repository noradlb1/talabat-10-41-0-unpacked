package com.deliveryhero.performance.core.tapresponse;

import android.app.Application;
import com.google.android.exoplayer2.util.MimeTypes;
import curtains.Curtains;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/deliveryhero/performance/core/tapresponse/TapResponseTimeInitializer;", "", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "getApplication", "()Landroid/app/Application;", "initialize", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TapResponseTimeInitializer {
    @NotNull
    private final Application application;

    public TapResponseTimeInitializer(@NotNull Application application2) {
        Intrinsics.checkNotNullParameter(application2, MimeTypes.BASE_TYPE_APPLICATION);
        this.application = application2;
    }

    @NotNull
    public final Application getApplication() {
        return this.application;
    }

    public final void initialize() {
        Curtains.getOnRootViewsChangedListeners().add(TapResponseTimeInitializer$initialize$1.INSTANCE);
        GlobalNavHostDestinationChangedListener.Companion.install(this.application, TapResponseTimeInitializer$initialize$2.INSTANCE);
    }
}
