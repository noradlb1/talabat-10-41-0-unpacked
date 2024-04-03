package com.skydoves.landscapist;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/skydoves/landscapist/CircularReveal;", "", "duration", "", "onFinishListener", "Lcom/skydoves/landscapist/CircularRevealFinishListener;", "(ILcom/skydoves/landscapist/CircularRevealFinishListener;)V", "getDuration", "()I", "getOnFinishListener", "()Lcom/skydoves/landscapist/CircularRevealFinishListener;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "landscapist_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CircularReveal {
    public static final int $stable = 8;
    private final int duration;
    @Nullable
    private final CircularRevealFinishListener onFinishListener;

    public CircularReveal() {
        this(0, (CircularRevealFinishListener) null, 3, (DefaultConstructorMarker) null);
    }

    public CircularReveal(int i11, @Nullable CircularRevealFinishListener circularRevealFinishListener) {
        this.duration = i11;
        this.onFinishListener = circularRevealFinishListener;
    }

    public static /* synthetic */ CircularReveal copy$default(CircularReveal circularReveal, int i11, CircularRevealFinishListener circularRevealFinishListener, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = circularReveal.duration;
        }
        if ((i12 & 2) != 0) {
            circularRevealFinishListener = circularReveal.onFinishListener;
        }
        return circularReveal.copy(i11, circularRevealFinishListener);
    }

    public final int component1() {
        return this.duration;
    }

    @Nullable
    public final CircularRevealFinishListener component2() {
        return this.onFinishListener;
    }

    @NotNull
    public final CircularReveal copy(int i11, @Nullable CircularRevealFinishListener circularRevealFinishListener) {
        return new CircularReveal(i11, circularRevealFinishListener);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CircularReveal)) {
            return false;
        }
        CircularReveal circularReveal = (CircularReveal) obj;
        return this.duration == circularReveal.duration && Intrinsics.areEqual((Object) this.onFinishListener, (Object) circularReveal.onFinishListener);
    }

    public final int getDuration() {
        return this.duration;
    }

    @Nullable
    public final CircularRevealFinishListener getOnFinishListener() {
        return this.onFinishListener;
    }

    public int hashCode() {
        int i11 = this.duration * 31;
        CircularRevealFinishListener circularRevealFinishListener = this.onFinishListener;
        return i11 + (circularRevealFinishListener == null ? 0 : circularRevealFinishListener.hashCode());
    }

    @NotNull
    public String toString() {
        int i11 = this.duration;
        CircularRevealFinishListener circularRevealFinishListener = this.onFinishListener;
        return "CircularReveal(duration=" + i11 + ", onFinishListener=" + circularRevealFinishListener + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CircularReveal(int i11, CircularRevealFinishListener circularRevealFinishListener, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 350 : i11, (i12 & 2) != 0 ? null : circularRevealFinishListener);
    }
}
