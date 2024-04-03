package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.Brush;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class VectorComposeKt$Path$2$6 extends Lambda implements Function2<PathComponent, Brush, Unit> {
    public static final VectorComposeKt$Path$2$6 INSTANCE = new VectorComposeKt$Path$2$6();

    public VectorComposeKt$Path$2$6() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((PathComponent) obj, (Brush) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull PathComponent pathComponent, @Nullable Brush brush) {
        Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
        pathComponent.setStroke(brush);
    }
}
