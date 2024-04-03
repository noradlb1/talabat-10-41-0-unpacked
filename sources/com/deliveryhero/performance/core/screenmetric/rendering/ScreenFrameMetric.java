package com.deliveryhero.performance.core.screenmetric.rendering;

import kotlin.Metadata;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JY\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006%"}, d2 = {"Lcom/deliveryhero/performance/core/screenmetric/rendering/ScreenFrameMetric;", "", "totalFrames", "", "frozenFrames", "frozenFramesRate", "defaultSlowFrames", "defaultSlowFramesRate", "dynamicSlowFrames", "dynamicSlowFramesRate", "deviceRefreshRate", "(JJJJJJJJ)V", "getDefaultSlowFrames", "()J", "getDefaultSlowFramesRate", "getDeviceRefreshRate", "getDynamicSlowFrames", "getDynamicSlowFramesRate", "getFrozenFrames", "getFrozenFramesRate", "getTotalFrames", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScreenFrameMetric {
    private final long defaultSlowFrames;
    private final long defaultSlowFramesRate;
    private final long deviceRefreshRate;
    private final long dynamicSlowFrames;
    private final long dynamicSlowFramesRate;
    private final long frozenFrames;
    private final long frozenFramesRate;
    private final long totalFrames;

    public ScreenFrameMetric(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18) {
        this.totalFrames = j11;
        this.frozenFrames = j12;
        this.frozenFramesRate = j13;
        this.defaultSlowFrames = j14;
        this.defaultSlowFramesRate = j15;
        this.dynamicSlowFrames = j16;
        this.dynamicSlowFramesRate = j17;
        this.deviceRefreshRate = j18;
    }

    public static /* synthetic */ ScreenFrameMetric copy$default(ScreenFrameMetric screenFrameMetric, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, int i11, Object obj) {
        ScreenFrameMetric screenFrameMetric2 = screenFrameMetric;
        int i12 = i11;
        return screenFrameMetric.copy((i12 & 1) != 0 ? screenFrameMetric2.totalFrames : j11, (i12 & 2) != 0 ? screenFrameMetric2.frozenFrames : j12, (i12 & 4) != 0 ? screenFrameMetric2.frozenFramesRate : j13, (i12 & 8) != 0 ? screenFrameMetric2.defaultSlowFrames : j14, (i12 & 16) != 0 ? screenFrameMetric2.defaultSlowFramesRate : j15, (i12 & 32) != 0 ? screenFrameMetric2.dynamicSlowFrames : j16, (i12 & 64) != 0 ? screenFrameMetric2.dynamicSlowFramesRate : j17, (i12 & 128) != 0 ? screenFrameMetric2.deviceRefreshRate : j18);
    }

    public final long component1() {
        return this.totalFrames;
    }

    public final long component2() {
        return this.frozenFrames;
    }

    public final long component3() {
        return this.frozenFramesRate;
    }

    public final long component4() {
        return this.defaultSlowFrames;
    }

    public final long component5() {
        return this.defaultSlowFramesRate;
    }

    public final long component6() {
        return this.dynamicSlowFrames;
    }

    public final long component7() {
        return this.dynamicSlowFramesRate;
    }

    public final long component8() {
        return this.deviceRefreshRate;
    }

    @NotNull
    public final ScreenFrameMetric copy(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18) {
        return new ScreenFrameMetric(j11, j12, j13, j14, j15, j16, j17, j18);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScreenFrameMetric)) {
            return false;
        }
        ScreenFrameMetric screenFrameMetric = (ScreenFrameMetric) obj;
        return this.totalFrames == screenFrameMetric.totalFrames && this.frozenFrames == screenFrameMetric.frozenFrames && this.frozenFramesRate == screenFrameMetric.frozenFramesRate && this.defaultSlowFrames == screenFrameMetric.defaultSlowFrames && this.defaultSlowFramesRate == screenFrameMetric.defaultSlowFramesRate && this.dynamicSlowFrames == screenFrameMetric.dynamicSlowFrames && this.dynamicSlowFramesRate == screenFrameMetric.dynamicSlowFramesRate && this.deviceRefreshRate == screenFrameMetric.deviceRefreshRate;
    }

    public final long getDefaultSlowFrames() {
        return this.defaultSlowFrames;
    }

    public final long getDefaultSlowFramesRate() {
        return this.defaultSlowFramesRate;
    }

    public final long getDeviceRefreshRate() {
        return this.deviceRefreshRate;
    }

    public final long getDynamicSlowFrames() {
        return this.dynamicSlowFrames;
    }

    public final long getDynamicSlowFramesRate() {
        return this.dynamicSlowFramesRate;
    }

    public final long getFrozenFrames() {
        return this.frozenFrames;
    }

    public final long getFrozenFramesRate() {
        return this.frozenFramesRate;
    }

    public final long getTotalFrames() {
        return this.totalFrames;
    }

    public int hashCode() {
        return (((((((((((((a.a(this.totalFrames) * 31) + a.a(this.frozenFrames)) * 31) + a.a(this.frozenFramesRate)) * 31) + a.a(this.defaultSlowFrames)) * 31) + a.a(this.defaultSlowFramesRate)) * 31) + a.a(this.dynamicSlowFrames)) * 31) + a.a(this.dynamicSlowFramesRate)) * 31) + a.a(this.deviceRefreshRate);
    }

    @NotNull
    public String toString() {
        return "ScreenFrameMetric(totalFrames=" + this.totalFrames + ", frozenFrames=" + this.frozenFrames + ", frozenFramesRate=" + this.frozenFramesRate + ", defaultSlowFrames=" + this.defaultSlowFrames + ", defaultSlowFramesRate=" + this.defaultSlowFramesRate + ", dynamicSlowFrames=" + this.dynamicSlowFrames + ", dynamicSlowFramesRate=" + this.dynamicSlowFramesRate + ", deviceRefreshRate=" + this.deviceRefreshRate + ')';
    }
}
