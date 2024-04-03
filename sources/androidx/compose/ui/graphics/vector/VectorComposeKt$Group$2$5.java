package androidx.compose.ui.graphics.vector;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class VectorComposeKt$Group$2$5 extends Lambda implements Function2<GroupComponent, Float, Unit> {
    public static final VectorComposeKt$Group$2$5 INSTANCE = new VectorComposeKt$Group$2$5();

    public VectorComposeKt$Group$2$5() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((GroupComponent) obj, ((Number) obj2).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull GroupComponent groupComponent, float f11) {
        Intrinsics.checkNotNullParameter(groupComponent, "$this$set");
        groupComponent.setScaleX(f11);
    }
}
