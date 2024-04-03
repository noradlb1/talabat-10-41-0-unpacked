package androidx.compose.foundation;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class MagnifierKt$magnifier$4$2$1 extends Lambda implements Function1<LayoutCoordinates, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<Offset> f1758g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MagnifierKt$magnifier$4$2$1(MutableState<Offset> mutableState) {
        super(1);
        this.f1758g = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutCoordinates) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "it");
        MagnifierKt$magnifier$4.m239invoke$lambda2(this.f1758g, LayoutCoordinatesKt.positionInRoot(layoutCoordinates));
    }
}
