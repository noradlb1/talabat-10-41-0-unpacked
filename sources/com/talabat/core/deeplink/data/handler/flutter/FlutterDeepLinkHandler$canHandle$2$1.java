package com.talabat.core.deeplink.data.handler.flutter;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "result", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FlutterDeepLinkHandler$canHandle$2$1 extends Lambda implements Function1<Boolean, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Continuation<Boolean> f55812g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlutterDeepLinkHandler$canHandle$2$1(Continuation<? super Boolean> continuation) {
        super(1);
        this.f55812g = continuation;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z11) {
        this.f55812g.resumeWith(Result.m6329constructorimpl(Boolean.valueOf(z11)));
    }
}
