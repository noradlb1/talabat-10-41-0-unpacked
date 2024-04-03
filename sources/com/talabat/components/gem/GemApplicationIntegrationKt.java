package com.talabat.components.gem;

import android.app.Application;
import com.talabat.gem.integration.Gem;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\b\u001a\u00020\t*\u00020\n\"\u001b\u0010\u0000\u001a\u00020\u00018@X\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0000\u0010\u0002\"\u001b\u0010\u0005\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0006\u0010\u0002¨\u0006\u000b"}, d2 = {"isGemFloatingButtonExperimentEnabled", "", "()Ljava/lang/String;", "isGemFloatingButtonExperimentEnabled$delegate", "Lkotlin/Lazy;", "showGemPopup", "getShowGemPopup", "showGemPopup$delegate", "initializeGemIntegration", "", "Landroid/app/Application;", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemApplicationIntegrationKt {
    @NotNull
    private static final Lazy isGemFloatingButtonExperimentEnabled$delegate;
    @NotNull
    private static final Lazy showGemPopup$delegate;

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        showGemPopup$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, GemApplicationIntegrationKt$showGemPopup$2.INSTANCE);
        isGemFloatingButtonExperimentEnabled$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, GemApplicationIntegrationKt$isGemFloatingButtonExperimentEnabled$2.INSTANCE);
    }

    /* access modifiers changed from: private */
    public static final String getShowGemPopup() {
        return (String) showGemPopup$delegate.getValue();
    }

    public static final void initializeGemIntegration(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "<this>");
        Gem.GemIntegration(application, GemApplicationIntegrationKt$initializeGemIntegration$1.INSTANCE);
    }

    @NotNull
    public static final String isGemFloatingButtonExperimentEnabled() {
        return (String) isGemFloatingButtonExperimentEnabled$delegate.getValue();
    }
}
