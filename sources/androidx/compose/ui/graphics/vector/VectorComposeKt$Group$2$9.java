package androidx.compose.ui.graphics.vector;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class VectorComposeKt$Group$2$9 extends Lambda implements Function2<GroupComponent, List<? extends PathNode>, Unit> {
    public static final VectorComposeKt$Group$2$9 INSTANCE = new VectorComposeKt$Group$2$9();

    public VectorComposeKt$Group$2$9() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((GroupComponent) obj, (List<? extends PathNode>) (List) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull GroupComponent groupComponent, @NotNull List<? extends PathNode> list) {
        Intrinsics.checkNotNullParameter(groupComponent, "$this$set");
        Intrinsics.checkNotNullParameter(list, "it");
        groupComponent.setClipPathData(list);
    }
}
