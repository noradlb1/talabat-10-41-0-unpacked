package androidx.compose.foundation.text.selection;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/AnimationVector2D;", "it", "Landroidx/compose/ui/geometry/Offset;", "invoke-k-4lQ0M", "(J)Landroidx/compose/animation/core/AnimationVector2D;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$1 extends Lambda implements Function1<Offset, AnimationVector2D> {
    public static final SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$1 INSTANCE = new SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$1();

    public SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m985invokek4lQ0M(((Offset) obj).m2686unboximpl());
    }

    @NotNull
    /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
    public final AnimationVector2D m985invokek4lQ0M(long j11) {
        if (OffsetKt.m2695isSpecifiedk4lQ0M(j11)) {
            return new AnimationVector2D(Offset.m2676getXimpl(j11), Offset.m2677getYimpl(j11));
        }
        return SelectionMagnifierKt.UnspecifiedAnimationVector2D;
    }
}
