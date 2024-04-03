package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ClickableTextKt$ClickableText$2$1 extends Lambda implements Function1<TextLayoutResult, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<TextLayoutResult> f3340g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<TextLayoutResult, Unit> f3341h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClickableTextKt$ClickableText$2$1(MutableState<TextLayoutResult> mutableState, Function1<? super TextLayoutResult, Unit> function1) {
        super(1);
        this.f3340g = mutableState;
        this.f3341h = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextLayoutResult) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull TextLayoutResult textLayoutResult) {
        Intrinsics.checkNotNullParameter(textLayoutResult, "it");
        this.f3340g.setValue(textLayoutResult);
        this.f3341h.invoke(textLayoutResult);
    }
}
