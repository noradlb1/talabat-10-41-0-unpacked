package androidx.compose.foundation.text;

import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CoreTextFieldKt$CoreTextField$drawModifier$1 extends Lambda implements Function1<DrawScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldState f3436g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TextFieldValue f3437h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ OffsetMapping f3438i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoreTextFieldKt$CoreTextField$drawModifier$1(TextFieldState textFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
        super(1);
        this.f3436g = textFieldState;
        this.f3437h = textFieldValue;
        this.f3438i = offsetMapping;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawBehind");
        TextLayoutResultProxy layoutResult = this.f3436g.getLayoutResult();
        if (layoutResult != null) {
            TextFieldValue textFieldValue = this.f3437h;
            OffsetMapping offsetMapping = this.f3438i;
            TextFieldState textFieldState = this.f3436g;
            Canvas canvas = drawScope.getDrawContext().getCanvas();
            TextFieldDelegate.Companion.draw$foundation_release(canvas, textFieldValue, offsetMapping, layoutResult.getValue(), textFieldState.getSelectionPaint());
        }
    }
}
