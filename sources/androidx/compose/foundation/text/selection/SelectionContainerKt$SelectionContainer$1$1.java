package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SelectionContainerKt$SelectionContainer$1$1 extends Lambda implements Function1<Selection, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<Selection> f3666g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectionContainerKt$SelectionContainer$1$1(MutableState<Selection> mutableState) {
        super(1);
        this.f3666g = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Selection) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Selection selection) {
        SelectionContainerKt.m976SelectionContainer$lambda2(this.f3666g, selection);
    }
}
