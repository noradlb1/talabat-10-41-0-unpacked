package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003 \u0000H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Q", "R", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class UnbiasedSelectBuilderImpl$invoke$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SelectClause1<Q> f26352g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ UnbiasedSelectBuilderImpl<R> f26353h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Q, Continuation<? super R>, Object> f26354i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnbiasedSelectBuilderImpl$invoke$2(SelectClause1<? extends Q> selectClause1, UnbiasedSelectBuilderImpl<? super R> unbiasedSelectBuilderImpl, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        super(0);
        this.f26352g = selectClause1;
        this.f26353h = unbiasedSelectBuilderImpl;
        this.f26354i = function2;
    }

    public final void invoke() {
        this.f26352g.registerSelectClause1(this.f26353h.getInstance(), this.f26354i);
    }
}
