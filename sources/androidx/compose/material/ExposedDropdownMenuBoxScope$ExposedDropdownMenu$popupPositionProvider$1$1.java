package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.unit.IntRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1 extends Lambda implements Function2<IntRect, IntRect, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<TransformOrigin> f4526g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1(MutableState<TransformOrigin> mutableState) {
        super(2);
        this.f4526g = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((IntRect) obj, (IntRect) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull IntRect intRect, @NotNull IntRect intRect2) {
        Intrinsics.checkNotNullParameter(intRect, "parentBounds");
        Intrinsics.checkNotNullParameter(intRect2, "menuBounds");
        this.f4526g.setValue(TransformOrigin.m3279boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
    }
}
