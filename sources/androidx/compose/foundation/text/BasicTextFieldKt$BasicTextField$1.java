package androidx.compose.foundation.text;

import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class BasicTextFieldKt$BasicTextField$1 extends Lambda implements Function1<TextLayoutResult, Unit> {
    public static final BasicTextFieldKt$BasicTextField$1 INSTANCE = new BasicTextFieldKt$BasicTextField$1();

    public BasicTextFieldKt$BasicTextField$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextLayoutResult) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull TextLayoutResult textLayoutResult) {
        Intrinsics.checkNotNullParameter(textLayoutResult, "it");
    }
}
