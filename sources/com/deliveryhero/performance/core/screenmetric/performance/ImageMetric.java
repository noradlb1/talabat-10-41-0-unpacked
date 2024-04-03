package com.deliveryhero.performance.core.screenmetric.performance;

import kotlin.Metadata;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/deliveryhero/performance/core/screenmetric/performance/ImageMetric;", "", "count", "", "p50", "", "p75", "p95", "max", "(IJJJJ)V", "getCount", "()I", "getMax", "()J", "getP50", "getP75", "getP95", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImageMetric {
    private final int count;
    private final long max;
    private final long p50;
    private final long p75;
    private final long p95;

    public ImageMetric(int i11, long j11, long j12, long j13, long j14) {
        this.count = i11;
        this.p50 = j11;
        this.p75 = j12;
        this.p95 = j13;
        this.max = j14;
    }

    public static /* synthetic */ ImageMetric copy$default(ImageMetric imageMetric, int i11, long j11, long j12, long j13, long j14, int i12, Object obj) {
        ImageMetric imageMetric2 = imageMetric;
        return imageMetric.copy((i12 & 1) != 0 ? imageMetric2.count : i11, (i12 & 2) != 0 ? imageMetric2.p50 : j11, (i12 & 4) != 0 ? imageMetric2.p75 : j12, (i12 & 8) != 0 ? imageMetric2.p95 : j13, (i12 & 16) != 0 ? imageMetric2.max : j14);
    }

    public final int component1() {
        return this.count;
    }

    public final long component2() {
        return this.p50;
    }

    public final long component3() {
        return this.p75;
    }

    public final long component4() {
        return this.p95;
    }

    public final long component5() {
        return this.max;
    }

    @NotNull
    public final ImageMetric copy(int i11, long j11, long j12, long j13, long j14) {
        return new ImageMetric(i11, j11, j12, j13, j14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageMetric)) {
            return false;
        }
        ImageMetric imageMetric = (ImageMetric) obj;
        return this.count == imageMetric.count && this.p50 == imageMetric.p50 && this.p75 == imageMetric.p75 && this.p95 == imageMetric.p95 && this.max == imageMetric.max;
    }

    public final int getCount() {
        return this.count;
    }

    public final long getMax() {
        return this.max;
    }

    public final long getP50() {
        return this.p50;
    }

    public final long getP75() {
        return this.p75;
    }

    public final long getP95() {
        return this.p95;
    }

    public int hashCode() {
        return (((((((this.count * 31) + a.a(this.p50)) * 31) + a.a(this.p75)) * 31) + a.a(this.p95)) * 31) + a.a(this.max);
    }

    @NotNull
    public String toString() {
        return "ImageMetric(count=" + this.count + ", p50=" + this.p50 + ", p75=" + this.p75 + ", p95=" + this.p95 + ", max=" + this.max + ')';
    }
}
