package androidx.compose.animation.core;

import androidx.compose.ui.unit.DpOffset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/AnimationVector2D;", "it", "Landroidx/compose/ui/unit/DpOffset;", "invoke-jo-Fl9I", "(J)Landroidx/compose/animation/core/AnimationVector2D;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class VectorConvertersKt$DpOffsetToVector$1 extends Lambda implements Function1<DpOffset, AnimationVector2D> {
    public static final VectorConvertersKt$DpOffsetToVector$1 INSTANCE = new VectorConvertersKt$DpOffsetToVector$1();

    public VectorConvertersKt$DpOffsetToVector$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m148invokejoFl9I(((DpOffset) obj).m5547unboximpl());
    }

    @NotNull
    /* renamed from: invoke-jo-Fl9I  reason: not valid java name */
    public final AnimationVector2D m148invokejoFl9I(long j11) {
        return new AnimationVector2D(DpOffset.m5539getXD9Ej5fM(j11), DpOffset.m5541getYD9Ej5fM(j11));
    }
}
