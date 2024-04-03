package androidx.compose.animation.core;

import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/IntSize;", "it", "Landroidx/compose/animation/core/AnimationVector2D;", "invoke-YEO4UFw", "(Landroidx/compose/animation/core/AnimationVector2D;)J"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class VectorConvertersKt$IntSizeToVector$2 extends Lambda implements Function1<AnimationVector2D, IntSize> {
    public static final VectorConvertersKt$IntSizeToVector$2 INSTANCE = new VectorConvertersKt$IntSizeToVector$2();

    public VectorConvertersKt$IntSizeToVector$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return IntSize.m5630boximpl(m155invokeYEO4UFw((AnimationVector2D) obj));
    }

    /* renamed from: invoke-YEO4UFw  reason: not valid java name */
    public final long m155invokeYEO4UFw(@NotNull AnimationVector2D animationVector2D) {
        Intrinsics.checkNotNullParameter(animationVector2D, "it");
        return IntSizeKt.IntSize(MathKt__MathJVMKt.roundToInt(animationVector2D.getV1()), MathKt__MathJVMKt.roundToInt(animationVector2D.getV2()));
    }
}
