package com.deliveryhero.repository.gccchat;

import com.deliveryhero.chatsdk.domain.model.messages.Message;
import com.deliveryhero.contract.ChatLogger;
import com.deliveryhero.contract.idling.ChatIdlingResource;
import com.deliveryhero.contract.model.ConfigMessage;
import com.deliveryhero.contract.model.Events;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Result;", "Lcom/deliveryhero/chatsdk/domain/model/messages/Message;", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GccChatRepositoryImpl$fetchConfig$2 extends Lambda implements Function1<Result<? extends Message>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GccChatRepositoryImpl f30444g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GccChatRepositoryImpl$fetchConfig$2(GccChatRepositoryImpl gccChatRepositoryImpl) {
        super(1);
        this.f30444g = gccChatRepositoryImpl;
    }

    public final void invoke(@NotNull Object obj) {
        ChatLogger chatLogger;
        GccChatRepositoryImpl gccChatRepositoryImpl = this.f30444g;
        if (Result.m6336isSuccessimpl(obj)) {
            gccChatRepositoryImpl.configRelay.setConfig((ConfigMessage) gccChatRepositoryImpl.mapper.map((Message) obj));
        }
        GccChatRepositoryImpl gccChatRepositoryImpl2 = this.f30444g;
        Throwable r42 = Result.m6332exceptionOrNullimpl(obj);
        if (!(r42 == null || (chatLogger = gccChatRepositoryImpl2.chatFeatureCallbacks.getChatLogger()) == null)) {
            chatLogger.log(Events.GCC_MESSAGE_SENT_EVENT, MapsKt__MapsKt.emptyMap(), r42);
        }
        ChatIdlingResource access$getChatIdlingResource$p = this.f30444g.chatIdlingResource;
        if (access$getChatIdlingResource$p != null) {
            access$getChatIdlingResource$p.decrement();
        }
    }
}
