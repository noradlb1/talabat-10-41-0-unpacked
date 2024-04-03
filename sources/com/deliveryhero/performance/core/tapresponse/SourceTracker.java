package com.deliveryhero.performance.core.tapresponse;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/deliveryhero/performance/core/tapresponse/SourceTracker;", "", "()V", "value", "", "sourceScreen", "getSourceScreen", "()Ljava/lang/String;", "setSourceScreen", "(Ljava/lang/String;)V", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SourceTracker {
    @NotNull
    public static final SourceTracker INSTANCE = new SourceTracker();
    @Nullable
    private static String sourceScreen;

    private SourceTracker() {
    }

    @Nullable
    public final String getSourceScreen() {
        return sourceScreen;
    }

    public final void setSourceScreen(@Nullable String str) {
        if (TapTracker.INSTANCE.isTapInProgress()) {
            sourceScreen = str;
        }
    }
}
