package androidx.compose.foundation.selection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ToggleableKt$toggleable$4$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f3251g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f3252h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToggleableKt$toggleable$4$1(Function1<? super Boolean, Unit> function1, boolean z11) {
        super(0);
        this.f3251g = function1;
        this.f3252h = z11;
    }

    public final void invoke() {
        this.f3251g.invoke(Boolean.valueOf(!this.f3252h));
    }
}
