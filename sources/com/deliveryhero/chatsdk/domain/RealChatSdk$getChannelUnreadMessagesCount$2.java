package com.deliveryhero.chatsdk.domain;

import com.deliveryhero.chatsdk.domain.model.messages.UnreadChatDetails;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/deliveryhero/chatsdk/domain/model/messages/UnreadChatDetails;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class RealChatSdk$getChannelUnreadMessagesCount$2 extends Lambda implements Function1<UnreadChatDetails, Unit> {
    final /* synthetic */ Function1<Result<UnreadChatDetails>, Unit> $resultListener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RealChatSdk$getChannelUnreadMessagesCount$2(Function1<? super Result<UnreadChatDetails>, Unit> function1) {
        super(1);
        this.$resultListener = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((UnreadChatDetails) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(UnreadChatDetails unreadChatDetails) {
        this.$resultListener.invoke(Result.m6328boximpl(Result.m6329constructorimpl(unreadChatDetails)));
    }
}
