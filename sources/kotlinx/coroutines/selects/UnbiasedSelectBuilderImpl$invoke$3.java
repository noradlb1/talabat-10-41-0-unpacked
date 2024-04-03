package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0006\b\u0002\u0010\u0004 \u0000H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "P", "Q", "R", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class UnbiasedSelectBuilderImpl$invoke$3 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SelectClause2<P, Q> f26355g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ UnbiasedSelectBuilderImpl<R> f26356h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ P f26357i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Q, Continuation<? super R>, Object> f26358j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnbiasedSelectBuilderImpl$invoke$3(SelectClause2<? super P, ? extends Q> selectClause2, UnbiasedSelectBuilderImpl<? super R> unbiasedSelectBuilderImpl, P p11, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        super(0);
        this.f26355g = selectClause2;
        this.f26356h = unbiasedSelectBuilderImpl;
        this.f26357i = p11;
        this.f26358j = function2;
    }

    public final void invoke() {
        this.f26355g.registerSelectClause2(this.f26356h.getInstance(), this.f26357i, this.f26358j);
    }
}
