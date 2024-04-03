package com.deliveryhero.chatsdk.domain;

import com.deliveryhero.chatsdk.domain.model.messages.Message;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ChannelImpl$getMessages$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ Function1<Result<? extends List<? extends Message>>, Unit> $completionHandler;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelImpl$getMessages$2(Function1<? super Result<? extends List<? extends Message>>, Unit> function1) {
        super(1);
        this.$completionHandler = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        Function1<Result<? extends List<? extends Message>>, Unit> function1 = this.$completionHandler;
        Result.Companion companion = Result.Companion;
        function1.invoke(Result.m6328boximpl(Result.m6329constructorimpl(ResultKt.createFailure(th2))));
    }
}
