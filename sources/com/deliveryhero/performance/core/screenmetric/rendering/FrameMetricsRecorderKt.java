package com.deliveryhero.performance.core.screenmetric.rendering;

import android.app.Activity;
import android.os.Build;
import androidx.core.app.FrameMetricsAggregator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"tryRemoveActivity", "", "Landroidx/core/app/FrameMetricsAggregator;", "activity", "Landroid/app/Activity;", "logTag", "", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FrameMetricsRecorderKt {
    public static final void tryRemoveActivity(@NotNull FrameMetricsAggregator frameMetricsAggregator, @NotNull Activity activity, @NotNull String str) {
        Intrinsics.checkNotNullParameter(frameMetricsAggregator, "<this>");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "logTag");
        try {
            frameMetricsAggregator.remove(activity);
        } catch (IllegalArgumentException e11) {
            Intrinsics.stringPlus("View not hardware accelerated. Unable to collect FrameMetrics. ", e11);
        } catch (NullPointerException e12) {
            if (Build.VERSION.SDK_INT > 28) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unexpected error: ");
                sb2.append(e12);
                sb2.append(". NPE on devices above API 28. This exception is fixed in API 29");
            }
            Intrinsics.stringPlus("View not hardware accelerated. Unable to collect FrameMetrics. ", e12);
        }
    }
}
