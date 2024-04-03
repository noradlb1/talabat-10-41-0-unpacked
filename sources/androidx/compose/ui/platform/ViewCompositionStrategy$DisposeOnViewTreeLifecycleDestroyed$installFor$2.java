package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Function0<Unit>> f10058g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$2(Ref.ObjectRef<Function0<Unit>> objectRef) {
        super(0);
        this.f10058g = objectRef;
    }

    public final void invoke() {
        ((Function0) this.f10058g.element).invoke();
    }
}
