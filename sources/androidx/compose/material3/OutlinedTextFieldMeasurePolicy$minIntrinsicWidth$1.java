package androidx.compose.material3;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "intrinsicMeasurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "h", "invoke", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;I)Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class OutlinedTextFieldMeasurePolicy$minIntrinsicWidth$1 extends Lambda implements Function2<IntrinsicMeasurable, Integer, Integer> {
    public static final OutlinedTextFieldMeasurePolicy$minIntrinsicWidth$1 INSTANCE = new OutlinedTextFieldMeasurePolicy$minIntrinsicWidth$1();

    public OutlinedTextFieldMeasurePolicy$minIntrinsicWidth$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
    }

    @NotNull
    public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
        return Integer.valueOf(intrinsicMeasurable.minIntrinsicWidth(i11));
    }
}
