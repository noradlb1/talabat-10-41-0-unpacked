package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.StrokeJoin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class VectorComposeKt$Path$2$9 extends Lambda implements Function2<PathComponent, StrokeJoin, Unit> {
    public static final VectorComposeKt$Path$2$9 INSTANCE = new VectorComposeKt$Path$2$9();

    public VectorComposeKt$Path$2$9() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        m3547invokekLtJ_vA((PathComponent) obj, ((StrokeJoin) obj2).m3262unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-kLtJ_vA  reason: not valid java name */
    public final void m3547invokekLtJ_vA(@NotNull PathComponent pathComponent, int i11) {
        Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
        pathComponent.m3531setStrokeLineJoinWw9F2mQ(i11);
    }
}
