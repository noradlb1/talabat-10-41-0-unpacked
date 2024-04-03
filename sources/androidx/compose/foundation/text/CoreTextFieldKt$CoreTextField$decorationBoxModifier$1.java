package androidx.compose.foundation.text;

import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CoreTextFieldKt$CoreTextField$decorationBoxModifier$1 extends Lambda implements Function1<LayoutCoordinates, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldState f3435g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoreTextFieldKt$CoreTextField$decorationBoxModifier$1(TextFieldState textFieldState) {
        super(1);
        this.f3435g = textFieldState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutCoordinates) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "it");
        TextLayoutResultProxy layoutResult = this.f3435g.getLayoutResult();
        if (layoutResult != null) {
            layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
        }
    }
}
