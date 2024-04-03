package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0012\u0010\r\u001a\u00020\u000e*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u0011\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\u0012\u0010\u0014\u001a\u00020\u000e*\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0004R\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/EdgeEffectCompat;", "", "()V", "distanceCompat", "", "Landroid/widget/EdgeEffect;", "getDistanceCompat", "(Landroid/widget/EdgeEffect;)F", "create", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "onAbsorbCompat", "", "velocity", "", "onPullDistanceCompat", "deltaDistance", "displacement", "onReleaseWithOppositeDelta", "delta", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EdgeEffectCompat {
    @NotNull
    public static final EdgeEffectCompat INSTANCE = new EdgeEffectCompat();

    private EdgeEffectCompat() {
    }

    @NotNull
    public final EdgeEffect create(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.INSTANCE.create(context, attributeSet);
        }
        return new GlowEdgeEffectCompat(context);
    }

    public final float getDistanceCompat(@NotNull EdgeEffect edgeEffect) {
        Intrinsics.checkNotNullParameter(edgeEffect, "<this>");
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.INSTANCE.getDistance(edgeEffect);
        }
        return 0.0f;
    }

    public final void onAbsorbCompat(@NotNull EdgeEffect edgeEffect, int i11) {
        Intrinsics.checkNotNullParameter(edgeEffect, "<this>");
        if (Build.VERSION.SDK_INT >= 31) {
            edgeEffect.onAbsorb(i11);
        } else if (edgeEffect.isFinished()) {
            edgeEffect.onAbsorb(i11);
        }
    }

    public final float onPullDistanceCompat(@NotNull EdgeEffect edgeEffect, float f11, float f12) {
        Intrinsics.checkNotNullParameter(edgeEffect, "<this>");
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.INSTANCE.onPullDistance(edgeEffect, f11, f12);
        }
        edgeEffect.onPull(f11, f12);
        return f11;
    }

    public final void onReleaseWithOppositeDelta(@NotNull EdgeEffect edgeEffect, float f11) {
        Intrinsics.checkNotNullParameter(edgeEffect, "<this>");
        if (edgeEffect instanceof GlowEdgeEffectCompat) {
            ((GlowEdgeEffectCompat) edgeEffect).releaseWithOppositeDelta(f11);
        } else {
            edgeEffect.onRelease();
        }
    }
}
