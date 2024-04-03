package androidx.compose.ui.graphics;

import android.graphics.RenderEffect;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresApi(31)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J7\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ'\u0010\u000e\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/graphics/RenderEffectVerificationHelper;", "", "()V", "createBlurEffect", "Landroid/graphics/RenderEffect;", "inputRenderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "radiusX", "", "radiusY", "edgeTreatment", "Landroidx/compose/ui/graphics/TileMode;", "createBlurEffect-8A-3gB4", "(Landroidx/compose/ui/graphics/RenderEffect;FFI)Landroid/graphics/RenderEffect;", "createOffsetEffect", "offset", "Landroidx/compose/ui/geometry/Offset;", "createOffsetEffect-Uv8p0NA", "(Landroidx/compose/ui/graphics/RenderEffect;J)Landroid/graphics/RenderEffect;", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class RenderEffectVerificationHelper {
    @NotNull
    public static final RenderEffectVerificationHelper INSTANCE = new RenderEffectVerificationHelper();

    private RenderEffectVerificationHelper() {
    }

    @NotNull
    @DoNotInline
    /* renamed from: createBlurEffect-8A-3gB4  reason: not valid java name */
    public final RenderEffect m3196createBlurEffect8A3gB4(@Nullable RenderEffect renderEffect, float f11, float f12, int i11) {
        if (renderEffect == null) {
            RenderEffect a11 = RenderEffect.createBlurEffect(f11, f12, AndroidTileMode_androidKt.m2820toAndroidTileMode0vamqd0(i11));
            Intrinsics.checkNotNullExpressionValue(a11, "{\n            android.gr…)\n            )\n        }");
            return a11;
        }
        RenderEffect a12 = RenderEffect.createBlurEffect(f11, f12, renderEffect.asAndroidRenderEffect(), AndroidTileMode_androidKt.m2820toAndroidTileMode0vamqd0(i11));
        Intrinsics.checkNotNullExpressionValue(a12, "{\n            android.gr…)\n            )\n        }");
        return a12;
    }

    @NotNull
    @DoNotInline
    /* renamed from: createOffsetEffect-Uv8p0NA  reason: not valid java name */
    public final RenderEffect m3197createOffsetEffectUv8p0NA(@Nullable RenderEffect renderEffect, long j11) {
        if (renderEffect == null) {
            RenderEffect a11 = RenderEffect.createOffsetEffect(Offset.m2676getXimpl(j11), Offset.m2677getYimpl(j11));
            Intrinsics.checkNotNullExpressionValue(a11, "{\n            android.gr…et.x, offset.y)\n        }");
            return a11;
        }
        RenderEffect a12 = RenderEffect.createOffsetEffect(Offset.m2676getXimpl(j11), Offset.m2677getYimpl(j11), renderEffect.asAndroidRenderEffect());
        Intrinsics.checkNotNullExpressionValue(a12, "{\n            android.gr…)\n            )\n        }");
        return a12;
    }
}
