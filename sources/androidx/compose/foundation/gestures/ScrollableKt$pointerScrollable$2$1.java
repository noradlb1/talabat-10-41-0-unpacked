package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ScrollableKt$pointerScrollable$2$1 extends Lambda implements Function0<Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ State<ScrollingLogic> f2174g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollableKt$pointerScrollable$2$1(State<ScrollingLogic> state) {
        super(0);
        this.f2174g = state;
    }

    @NotNull
    public final Boolean invoke() {
        return Boolean.valueOf(this.f2174g.getValue().shouldScrollImmediately());
    }
}
