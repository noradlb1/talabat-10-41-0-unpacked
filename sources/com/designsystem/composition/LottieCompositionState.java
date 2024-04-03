package com.designsystem.composition;

import androidx.annotation.FloatRange;
import androidx.compose.runtime.internal.StabilityInferred;
import com.airbnb.lottie.compose.LottieCompositionResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/designsystem/composition/LottieCompositionState;", "", "lottieCompositionResult", "Lcom/airbnb/lottie/compose/LottieCompositionResult;", "progress", "", "(Lcom/airbnb/lottie/compose/LottieCompositionResult;F)V", "getLottieCompositionResult", "()Lcom/airbnb/lottie/compose/LottieCompositionResult;", "getProgress", "()F", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LottieCompositionState {
    public static final int $stable = 0;
    @NotNull
    private final LottieCompositionResult lottieCompositionResult;
    private final float progress;

    public LottieCompositionState(@NotNull LottieCompositionResult lottieCompositionResult2, @FloatRange(from = 0.0d, to = 1.0d) float f11) {
        Intrinsics.checkNotNullParameter(lottieCompositionResult2, "lottieCompositionResult");
        this.lottieCompositionResult = lottieCompositionResult2;
        this.progress = f11;
    }

    public static /* synthetic */ LottieCompositionState copy$default(LottieCompositionState lottieCompositionState, LottieCompositionResult lottieCompositionResult2, float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            lottieCompositionResult2 = lottieCompositionState.lottieCompositionResult;
        }
        if ((i11 & 2) != 0) {
            f11 = lottieCompositionState.progress;
        }
        return lottieCompositionState.copy(lottieCompositionResult2, f11);
    }

    @NotNull
    public final LottieCompositionResult component1() {
        return this.lottieCompositionResult;
    }

    public final float component2() {
        return this.progress;
    }

    @NotNull
    public final LottieCompositionState copy(@NotNull LottieCompositionResult lottieCompositionResult2, @FloatRange(from = 0.0d, to = 1.0d) float f11) {
        Intrinsics.checkNotNullParameter(lottieCompositionResult2, "lottieCompositionResult");
        return new LottieCompositionState(lottieCompositionResult2, f11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LottieCompositionState)) {
            return false;
        }
        LottieCompositionState lottieCompositionState = (LottieCompositionState) obj;
        return Intrinsics.areEqual((Object) this.lottieCompositionResult, (Object) lottieCompositionState.lottieCompositionResult) && Intrinsics.areEqual((Object) Float.valueOf(this.progress), (Object) Float.valueOf(lottieCompositionState.progress));
    }

    @NotNull
    public final LottieCompositionResult getLottieCompositionResult() {
        return this.lottieCompositionResult;
    }

    public final float getProgress() {
        return this.progress;
    }

    public int hashCode() {
        return (this.lottieCompositionResult.hashCode() * 31) + Float.floatToIntBits(this.progress);
    }

    @NotNull
    public String toString() {
        return "LottieCompositionState(lottieCompositionResult=" + this.lottieCompositionResult + ", progress=" + this.progress + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LottieCompositionState(LottieCompositionResult lottieCompositionResult2, float f11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(lottieCompositionResult2, (i11 & 2) != 0 ? 1.0f : f11);
    }
}
