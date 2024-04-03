package com.deliveryhero.chatsdk.domain;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class RealChatSdk$registerDevicePushToken$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<Result<Unit>, Unit> $resultListener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RealChatSdk$registerDevicePushToken$2(Function1<? super Result<Unit>, Unit> function1) {
        super(0);
        this.$resultListener = function1;
    }

    public final void invoke() {
        Function1<Result<Unit>, Unit> function1 = this.$resultListener;
        Result.Companion companion = Result.Companion;
        function1.invoke(Result.m6328boximpl(Result.m6329constructorimpl(Unit.INSTANCE)));
    }
}
