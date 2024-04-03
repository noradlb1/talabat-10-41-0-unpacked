package com.deliveryhero.chatsdk.domain;

import com.deliveryhero.chatsdk.domain.model.messages.Message;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/deliveryhero/chatsdk/domain/model/messages/Message;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ChannelImpl$getMessages$3 extends Lambda implements Function1<List<? extends Message>, Unit> {
    final /* synthetic */ Function1<Result<? extends List<? extends Message>>, Unit> $completionHandler;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelImpl$getMessages$3(Function1<? super Result<? extends List<? extends Message>>, Unit> function1) {
        super(1);
        this.$completionHandler = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends Message>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(List<? extends Message> list) {
        this.$completionHandler.invoke(Result.m6328boximpl(Result.m6329constructorimpl(list)));
    }
}
