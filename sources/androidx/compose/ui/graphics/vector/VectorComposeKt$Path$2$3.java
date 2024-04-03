package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.PathFillType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class VectorComposeKt$Path$2$3 extends Lambda implements Function2<PathComponent, PathFillType, Unit> {
    public static final VectorComposeKt$Path$2$3 INSTANCE = new VectorComposeKt$Path$2$3();

    public VectorComposeKt$Path$2$3() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        m3546invokepweu1eQ((PathComponent) obj, ((PathFillType) obj2).m3164unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-pweu1eQ  reason: not valid java name */
    public final void m3546invokepweu1eQ(@NotNull PathComponent pathComponent, int i11) {
        Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
        pathComponent.m3529setPathFillTypeoQ8Xj4U(i11);
    }
}
