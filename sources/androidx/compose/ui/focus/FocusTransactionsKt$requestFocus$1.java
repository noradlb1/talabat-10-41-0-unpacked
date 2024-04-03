package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/focus/FocusModifier;", "invoke", "(Landroidx/compose/ui/focus/FocusModifier;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class FocusTransactionsKt$requestFocus$1 extends Lambda implements Function1<FocusModifier, Boolean> {
    public static final FocusTransactionsKt$requestFocus$1 INSTANCE = new FocusTransactionsKt$requestFocus$1();

    public FocusTransactionsKt$requestFocus$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "it");
        FocusTransactionsKt.requestFocus(focusModifier);
        return Boolean.TRUE;
    }
}
