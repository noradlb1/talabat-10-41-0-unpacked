package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

public final class LazyScopeAdapter$lazyScope$1 extends Lambda implements Function0<MemberScope> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<MemberScope> f24817g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyScopeAdapter$lazyScope$1(Function0<? extends MemberScope> function0) {
        super(0);
        this.f24817g = function0;
    }

    @NotNull
    public final MemberScope invoke() {
        MemberScope invoke = this.f24817g.invoke();
        return invoke instanceof AbstractScopeAdapter ? ((AbstractScopeAdapter) invoke).getActualScope() : invoke;
    }
}
