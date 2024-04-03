package com.instabug.library.networkv2.limitation;

import com.instabug.library.networkv2.RateLimitedException;
import com.instabug.library.networkv2.limitation.RateLimitationSettings;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.TimeUtils;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class RateLimiter<M, T extends RateLimitationSettings> {
    @Nullable
    private final RateLimitedFeature feature;
    @NotNull
    private final Function1<M, Unit> onLimitationApplied;
    @NotNull
    private final T settings;

    public RateLimiter(@NotNull T t11, @NotNull Function1<? super M, Unit> function1, @Nullable RateLimitedFeature rateLimitedFeature) {
        Intrinsics.checkNotNullParameter(t11, "settings");
        Intrinsics.checkNotNullParameter(function1, "onLimitationApplied");
        this.settings = t11;
        this.onLimitationApplied = function1;
        this.feature = rateLimitedFeature;
    }

    private final void logFeatureIsRateLimited() {
        RateLimitedFeature rateLimitedFeature = this.feature;
        if (rateLimitedFeature != null) {
            String format = String.format(RateLimitedException.RATE_LIMIT_REACHED, Arrays.copyOf(new Object[]{rateLimitedFeature.getFeatureName()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            InstabugSDKLogger.d("IBG-Core", format);
        }
    }

    public final boolean applyIfPossible(M m11) {
        if (!this.settings.isRateLimited()) {
            this.settings.setLastRequestStartedAt(TimeUtils.currentTimeMillis());
            return false;
        }
        this.onLimitationApplied.invoke(m11);
        logFeatureIsRateLimited();
        return true;
    }

    public final boolean inspect(@NotNull Throwable th2, M m11) {
        Intrinsics.checkNotNullParameter(th2, "throwable");
        if (!(th2 instanceof RateLimitedException)) {
            return false;
        }
        this.settings.setLimitedUntil(((RateLimitedException) th2).getPeriod());
        this.onLimitationApplied.invoke(m11);
        logFeatureIsRateLimited();
        return true;
    }

    public final void reset() {
        this.settings.setLastRequestStartedAt(0);
        this.settings.setLimitedUntil(0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RateLimiter(RateLimitationSettings rateLimitationSettings, Function1 function1, RateLimitedFeature rateLimitedFeature, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(rateLimitationSettings, function1, (i11 & 4) != 0 ? null : rateLimitedFeature);
    }
}
