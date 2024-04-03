package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0000H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "R", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class UnbiasedSelectBuilderImpl$onTimeout$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ UnbiasedSelectBuilderImpl<R> f26359g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f26360h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Continuation<? super R>, Object> f26361i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnbiasedSelectBuilderImpl$onTimeout$1(UnbiasedSelectBuilderImpl<? super R> unbiasedSelectBuilderImpl, long j11, Function1<? super Continuation<? super R>, ? extends Object> function1) {
        super(0);
        this.f26359g = unbiasedSelectBuilderImpl;
        this.f26360h = j11;
        this.f26361i = function1;
    }

    public final void invoke() {
        this.f26359g.getInstance().onTimeout(this.f26360h, this.f26361i);
    }
}
