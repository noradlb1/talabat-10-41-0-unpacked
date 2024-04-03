package com.deliveryhero.performance.core.screenmetric.rendering;

import android.app.Activity;
import android.os.Build;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.app.FrameMetricsAggregator;
import androidx.fragment.app.Fragment;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0001!B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\n\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0002J\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\tJ\b\u0010\u001d\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001c\u001a\u00020\tJ\u0014\u0010\u001f\u001a\u00020\u0014*\u00020\u00142\u0006\u0010 \u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/deliveryhero/performance/core/screenmetric/rendering/FrameMetricsRecorder;", "", "activity", "Landroid/app/Activity;", "frameMetricsAggregator", "Landroidx/core/app/FrameMetricsAggregator;", "(Landroid/app/Activity;Landroidx/core/app/FrameMetricsAggregator;)V", "fragmentSnapshotMap", "", "Landroidx/fragment/app/Fragment;", "Lcom/deliveryhero/performance/core/screenmetric/rendering/ScreenFrameMetric;", "isRecording", "", "calculateFrameMetrics", "frameTimes", "Landroid/util/SparseIntArray;", "deltaFrameMetricsFromSnapshot", "metricStart", "metricEnd", "deviceRefreshRate", "", "dynamicSlowFrameDuration", "getScreenDisplay", "Landroid/view/Display;", "snapshotMetrics", "start", "", "startFragment", "fragment", "stop", "stopFragment", "frameRateOrZero", "total", "Companion", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FrameMetricsRecorder {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final long FROZEN_FRAME_THRESHOLD = 700;
    @Deprecated
    public static final long SLOW_FRAME_THRESHOLD = 16;
    /* access modifiers changed from: private */
    @NotNull
    @Deprecated
    public static final String TAG;
    @NotNull
    private final Activity activity;
    @NotNull
    private final Map<Fragment, ScreenFrameMetric> fragmentSnapshotMap;
    @NotNull
    private final FrameMetricsAggregator frameMetricsAggregator;
    private boolean isRecording;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/deliveryhero/performance/core/screenmetric/rendering/FrameMetricsRecorder$Companion;", "", "()V", "FROZEN_FRAME_THRESHOLD", "", "SLOW_FRAME_THRESHOLD", "TAG", "", "getTAG", "()Ljava/lang/String;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return FrameMetricsRecorder.TAG;
        }
    }

    static {
        String simpleName = FrameMetricsRecorder.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "FrameMetricsRecorder::class.java.simpleName");
        TAG = simpleName;
    }

    public FrameMetricsRecorder(@NotNull Activity activity2, @NotNull FrameMetricsAggregator frameMetricsAggregator2) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(frameMetricsAggregator2, "frameMetricsAggregator");
        this.activity = activity2;
        this.frameMetricsAggregator = frameMetricsAggregator2;
        this.fragmentSnapshotMap = new LinkedHashMap();
    }

    private final ScreenFrameMetric calculateFrameMetrics(SparseIntArray sparseIntArray) {
        long j11;
        long j12;
        long j13;
        long j14;
        SparseIntArray sparseIntArray2 = sparseIntArray;
        long dynamicSlowFrameDuration = dynamicSlowFrameDuration(this.activity);
        int size = sparseIntArray.size();
        long j15 = 0;
        if (size > 0) {
            j12 = 0;
            j11 = 0;
            int i11 = 0;
            j13 = 0;
            while (true) {
                int i12 = i11 + 1;
                int keyAt = sparseIntArray2.keyAt(i11);
                long valueAt = (long) sparseIntArray2.valueAt(i11);
                j14 = j15 + valueAt;
                long j16 = (long) keyAt;
                if (j16 > 700) {
                    j13 += valueAt;
                }
                if (j16 > dynamicSlowFrameDuration) {
                    j12 += valueAt;
                }
                if (j16 > 16) {
                    j11 += valueAt;
                }
                if (i12 >= size) {
                    break;
                }
                sparseIntArray2 = sparseIntArray;
                i11 = i12;
                j15 = j14;
            }
            j15 = j14;
        } else {
            j13 = 0;
            j12 = 0;
            j11 = 0;
        }
        return new ScreenFrameMetric(j15, j13, frameRateOrZero(j13, j15), j11, frameRateOrZero(j11, j15), j12, frameRateOrZero(j12, j15), deviceRefreshRate(this.activity));
    }

    private final ScreenFrameMetric deltaFrameMetricsFromSnapshot(ScreenFrameMetric screenFrameMetric, ScreenFrameMetric screenFrameMetric2) {
        long totalFrames = screenFrameMetric2.getTotalFrames() - screenFrameMetric.getTotalFrames();
        long frozenFrames = screenFrameMetric2.getFrozenFrames() - screenFrameMetric.getFrozenFrames();
        long defaultSlowFrames = screenFrameMetric2.getDefaultSlowFrames() - screenFrameMetric.getDefaultSlowFrames();
        long dynamicSlowFrames = screenFrameMetric2.getDynamicSlowFrames() - screenFrameMetric.getDynamicSlowFrames();
        long j11 = dynamicSlowFrames;
        long j12 = dynamicSlowFrames;
        return new ScreenFrameMetric(totalFrames, frozenFrames, frameRateOrZero(frozenFrames, totalFrames), defaultSlowFrames, frameRateOrZero(defaultSlowFrames, totalFrames), j11, frameRateOrZero(j12, totalFrames), screenFrameMetric2.getDeviceRefreshRate());
    }

    private final long deviceRefreshRate(Activity activity2) {
        Float f11;
        Display screenDisplay = getScreenDisplay(activity2);
        if (screenDisplay == null) {
            f11 = null;
        } else {
            f11 = Float.valueOf(screenDisplay.getRefreshRate());
        }
        float f12 = 60.0f;
        if (f11 != null && RangesKt__RangesKt.rangeTo(30.0f, 200.0f).contains(f11)) {
            f12 = f11.floatValue();
        }
        return (long) f12;
    }

    private final long dynamicSlowFrameDuration(Activity activity2) {
        return TimeUnit.SECONDS.toMillis(1) / (deviceRefreshRate(activity2) - 1);
    }

    private final long frameRateOrZero(long j11, long j12) {
        if (j12 > 0) {
            return (long) ((((float) j11) / ((float) j12)) * ((float) 100));
        }
        return 0;
    }

    private final Display getScreenDisplay(Activity activity2) {
        WindowManager windowManager;
        if (Build.VERSION.SDK_INT >= 30) {
            return activity2.getDisplay();
        }
        Window window = activity2.getWindow();
        if (window == null || (windowManager = window.getWindowManager()) == null) {
            return null;
        }
        return windowManager.getDefaultDisplay();
    }

    private final ScreenFrameMetric snapshotMetrics() {
        SparseIntArray sparseIntArray;
        if (!this.isRecording) {
            return null;
        }
        SparseIntArray[] metrics = this.frameMetricsAggregator.getMetrics();
        if (metrics == null) {
            sparseIntArray = null;
        } else {
            sparseIntArray = metrics[0];
        }
        if (sparseIntArray == null) {
            return null;
        }
        return calculateFrameMetrics(sparseIntArray);
    }

    public final void start() {
        if (this.isRecording) {
            Intrinsics.stringPlus("FrameMetricsAggregator is already recording ", this.activity.getClass().getSimpleName());
            return;
        }
        this.frameMetricsAggregator.add(this.activity);
        this.isRecording = true;
    }

    public final void startFragment(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (this.isRecording) {
            if (this.fragmentSnapshotMap.containsKey(fragment)) {
                Intrinsics.stringPlus("Cannot start Fragment recording, already ongoing ", fragment.getClass().getSimpleName());
                return;
            }
            ScreenFrameMetric snapshotMetrics = snapshotMetrics();
            if (snapshotMetrics == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("startFragment(");
                sb2.append(fragment.getClass().getSimpleName());
                sb2.append("): snapshot() failed");
                return;
            }
            this.fragmentSnapshotMap.put(fragment, snapshotMetrics);
        }
    }

    @Nullable
    public final ScreenFrameMetric stop() {
        if (!this.isRecording) {
            return null;
        }
        ScreenFrameMetric snapshotMetrics = snapshotMetrics();
        FrameMetricsRecorderKt.tryRemoveActivity(this.frameMetricsAggregator, this.activity, TAG);
        this.frameMetricsAggregator.reset();
        this.isRecording = false;
        return snapshotMetrics;
    }

    @Nullable
    public final ScreenFrameMetric stopFragment(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (!this.isRecording) {
            return null;
        }
        if (!this.fragmentSnapshotMap.containsKey(fragment)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Fragment recording associated with ");
            sb2.append(fragment.getClass().getSimpleName());
            sb2.append(" was not started");
            return null;
        }
        ScreenFrameMetric remove = this.fragmentSnapshotMap.remove(fragment);
        ScreenFrameMetric snapshotMetrics = snapshotMetrics();
        if (snapshotMetrics != null && remove != null) {
            return deltaFrameMetricsFromSnapshot(remove, snapshotMetrics);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("stopFragment(");
        sb3.append(fragment.getClass().getSimpleName());
        sb3.append("): currentMetrics() failed");
        return null;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FrameMetricsRecorder(Activity activity2, FrameMetricsAggregator frameMetricsAggregator2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity2, (i11 & 2) != 0 ? new FrameMetricsAggregator() : frameMetricsAggregator2);
    }
}
