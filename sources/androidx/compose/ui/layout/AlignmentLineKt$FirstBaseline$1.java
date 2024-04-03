package androidx.compose.ui.layout;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public /* synthetic */ class AlignmentLineKt$FirstBaseline$1 extends FunctionReferenceImpl implements Function2<Integer, Integer, Integer> {
    public static final AlignmentLineKt$FirstBaseline$1 INSTANCE = new AlignmentLineKt$FirstBaseline$1();

    public AlignmentLineKt$FirstBaseline$1() {
        super(2, MathKt.class, "min", "min(II)I", 1);
    }

    @NotNull
    public final Integer invoke(int i11, int i12) {
        return Integer.valueOf(Math.min(i11, i12));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), ((Number) obj2).intValue());
    }
}
