package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.StrokeCap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class VectorComposeKt$Path$2$10 extends Lambda implements Function2<PathComponent, StrokeCap, Unit> {
    public static final VectorComposeKt$Path$2$10 INSTANCE = new VectorComposeKt$Path$2$10();

    public VectorComposeKt$Path$2$10() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        m3545invokeCSYIeUk((PathComponent) obj, ((StrokeCap) obj2).m3252unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-CSYIeUk  reason: not valid java name */
    public final void m3545invokeCSYIeUk(@NotNull PathComponent pathComponent, int i11) {
        Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
        pathComponent.m3530setStrokeLineCapBeK7IIE(i11);
    }
}
