package com.talabat.talabatcore.functional;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0007\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00012\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "C", "A", "B", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class EitherKt$c$1 extends Lambda implements Function1<A, C> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<B, C> f12020g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<A, B> f12021h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EitherKt$c$1(Function1<? super B, ? extends C> function1, Function1<? super A, ? extends B> function12) {
        super(1);
        this.f12020g = function1;
        this.f12021h = function12;
    }

    public final C invoke(A a11) {
        return this.f12020g.invoke(this.f12021h.invoke(a11));
    }
}
