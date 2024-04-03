package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.unit.IntRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1 extends Lambda implements Function2<IntRect, IntRect, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<TransformOrigin> f6355g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(MutableState<TransformOrigin> mutableState) {
        super(2);
        this.f6355g = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((IntRect) obj, (IntRect) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull IntRect intRect, @NotNull IntRect intRect2) {
        Intrinsics.checkNotNullParameter(intRect, "parentBounds");
        Intrinsics.checkNotNullParameter(intRect2, "menuBounds");
        this.f6355g.setValue(TransformOrigin.m3279boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
    }
}
