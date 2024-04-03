package com.deliveryhero.repository.gccchat;

import com.deliveryhero.chatsdk.domain.model.messages.Message;
import com.deliveryhero.contract.ChatLogger;
import com.deliveryhero.contract.idling.ChatIdlingResource;
import com.deliveryhero.contract.model.BaseMessage;
import com.deliveryhero.contract.model.Events;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Result;", "Lcom/deliveryhero/chatsdk/domain/model/messages/Message;", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GccChatRepositoryImpl$sendLocationMessage$2 extends Lambda implements Function1<Result<? extends Message>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GccChatRepositoryImpl f30471g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<BaseMessage, Unit> f30472h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<BaseMessage, Throwable, Unit> f30473i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GccChatRepositoryImpl$sendLocationMessage$2(GccChatRepositoryImpl gccChatRepositoryImpl, Function1<? super BaseMessage, Unit> function1, Function2<? super BaseMessage, ? super Throwable, Unit> function2) {
        super(1);
        this.f30471g = gccChatRepositoryImpl;
        this.f30472h = function1;
        this.f30473i = function2;
    }

    public final void invoke(@NotNull Object obj) {
        Function1<BaseMessage, Unit> function1 = this.f30472h;
        GccChatRepositoryImpl gccChatRepositoryImpl = this.f30471g;
        if (Result.m6336isSuccessimpl(obj)) {
            function1.invoke(gccChatRepositoryImpl.mapper.map((Message) obj));
            ChatLogger chatLogger = gccChatRepositoryImpl.chatFeatureCallbacks.getChatLogger();
            if (chatLogger != null) {
                chatLogger.log(Events.GCC_MESSAGE_SENT_EVENT, MapsKt__MapsKt.emptyMap());
            }
        }
        Function2<BaseMessage, Throwable, Unit> function2 = this.f30473i;
        GccChatRepositoryImpl gccChatRepositoryImpl2 = this.f30471g;
        Throwable r62 = Result.m6332exceptionOrNullimpl(obj);
        if (r62 != null) {
            function2.invoke(null, r62);
            ChatLogger chatLogger2 = gccChatRepositoryImpl2.chatFeatureCallbacks.getChatLogger();
            if (chatLogger2 != null) {
                chatLogger2.log(Events.GCC_MESSAGE_SENT_EVENT, MapsKt__MapsKt.emptyMap(), r62);
            }
        }
        ChatIdlingResource access$getChatIdlingResource$p = this.f30471g.chatIdlingResource;
        if (access$getChatIdlingResource$p != null) {
            access$getChatIdlingResource$p.decrement();
        }
    }
}
