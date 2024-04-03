package androidx.compose.foundation.text;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextController$createSemanticsModifierFor$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AnnotatedString f3537g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TextController f3538h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextController$createSemanticsModifierFor$1(AnnotatedString annotatedString, TextController textController) {
        super(1);
        this.f3537g = annotatedString;
        this.f3538h = textController;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setText(semanticsPropertyReceiver, this.f3537g);
        final TextController textController = this.f3538h;
        SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, (String) null, new Function1<List<TextLayoutResult>, Boolean>() {
            @NotNull
            public final Boolean invoke(@NotNull List<TextLayoutResult> list) {
                boolean z11;
                Intrinsics.checkNotNullParameter(list, "it");
                if (textController.getState().getLayoutResult() != null) {
                    TextLayoutResult layoutResult = textController.getState().getLayoutResult();
                    Intrinsics.checkNotNull(layoutResult);
                    list.add(layoutResult);
                    z11 = true;
                } else {
                    z11 = false;
                }
                return Boolean.valueOf(z11);
            }
        }, 1, (Object) null);
    }
}
