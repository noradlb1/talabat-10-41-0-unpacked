package androidx.compose.animation;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "invoke", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AnimatedContentMeasurePolicy$maxIntrinsicWidth$1 extends Lambda implements Function1<IntrinsicMeasurable, Integer> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f1087g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatedContentMeasurePolicy$maxIntrinsicWidth$1(int i11) {
        super(1);
        this.f1087g = i11;
    }

    @NotNull
    public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable) {
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "it");
        return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(this.f1087g));
    }
}
