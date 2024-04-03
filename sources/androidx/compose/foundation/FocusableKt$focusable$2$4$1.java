package androidx.compose.foundation;

import androidx.compose.foundation.lazy.layout.PinnableParent;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class FocusableKt$focusable$2$4$1 extends Lambda implements Function1<PinnableParent, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<PinnableParent> f1652g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FocusableKt$focusable$2$4$1(MutableState<PinnableParent> mutableState) {
        super(1);
        this.f1652g = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PinnableParent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable PinnableParent pinnableParent) {
        FocusableKt$focusable$2.m221invoke$lambda3(this.f1652g, pinnableParent);
    }
}
