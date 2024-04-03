package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public final class EdgeEffectCompat {
    private final EdgeEffect mEdgeEffect;

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static void onPull(EdgeEffect edgeEffect, float f11, float f12) {
            edgeEffect.onPull(f11, f12);
        }
    }

    @RequiresApi(31)
    public static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        public static EdgeEffect create(Context context, AttributeSet attributeSet) {
            try {
                return new EdgeEffect(context, attributeSet);
            } catch (Throwable unused) {
                return new EdgeEffect(context);
            }
        }

        @DoNotInline
        public static float getDistance(EdgeEffect edgeEffect) {
            try {
                return edgeEffect.getDistance();
            } catch (Throwable unused) {
                return 0.0f;
            }
        }

        @DoNotInline
        public static float onPullDistance(EdgeEffect edgeEffect, float f11, float f12) {
            try {
                return edgeEffect.onPullDistance(f11, f12);
            } catch (Throwable unused) {
                edgeEffect.onPull(f11, f12);
                return 0.0f;
            }
        }
    }

    @Deprecated
    public EdgeEffectCompat(Context context) {
        this.mEdgeEffect = new EdgeEffect(context);
    }

    @NonNull
    public static EdgeEffect create(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.create(context, attributeSet);
        }
        return new EdgeEffect(context);
    }

    public static float getDistance(@NonNull EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.getDistance(edgeEffect);
        }
        return 0.0f;
    }

    public static float onPullDistance(@NonNull EdgeEffect edgeEffect, float f11, float f12) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.onPullDistance(edgeEffect, f11, f12);
        }
        onPull(edgeEffect, f11, f12);
        return f11;
    }

    @Deprecated
    public boolean draw(Canvas canvas) {
        return this.mEdgeEffect.draw(canvas);
    }

    @Deprecated
    public void finish() {
        this.mEdgeEffect.finish();
    }

    @Deprecated
    public boolean isFinished() {
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public boolean onAbsorb(int i11) {
        this.mEdgeEffect.onAbsorb(i11);
        return true;
    }

    @Deprecated
    public boolean onPull(float f11) {
        this.mEdgeEffect.onPull(f11);
        return true;
    }

    @Deprecated
    public boolean onRelease() {
        this.mEdgeEffect.onRelease();
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public void setSize(int i11, int i12) {
        this.mEdgeEffect.setSize(i11, i12);
    }

    @Deprecated
    public boolean onPull(float f11, float f12) {
        onPull(this.mEdgeEffect, f11, f12);
        return true;
    }

    public static void onPull(@NonNull EdgeEffect edgeEffect, float f11, float f12) {
        Api21Impl.onPull(edgeEffect, f11, f12);
    }
}
