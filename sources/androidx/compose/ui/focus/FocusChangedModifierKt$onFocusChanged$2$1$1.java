package androidx.compose.ui.focus;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class FocusChangedModifierKt$onFocusChanged$2$1$1 extends Lambda implements Function1<FocusState, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<FocusState> f9589g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<FocusState, Unit> f9590h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FocusChangedModifierKt$onFocusChanged$2$1$1(MutableState<FocusState> mutableState, Function1<? super FocusState, Unit> function1) {
        super(1);
        this.f9589g = mutableState;
        this.f9590h = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FocusState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull FocusState focusState) {
        Intrinsics.checkNotNullParameter(focusState, "it");
        if (!Intrinsics.areEqual((Object) this.f9589g.getValue(), (Object) focusState)) {
            this.f9589g.setValue(focusState);
            this.f9590h.invoke(focusState);
        }
    }
}
