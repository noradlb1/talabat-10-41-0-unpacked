package androidx.compose.material;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class CheckboxKt$Checkbox$2$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f4266g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f4267h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckboxKt$Checkbox$2$1(Function1<? super Boolean, Unit> function1, boolean z11) {
        super(0);
        this.f4266g = function1;
        this.f4267h = z11;
    }

    public final void invoke() {
        this.f4266g.invoke(Boolean.valueOf(!this.f4267h));
    }
}
