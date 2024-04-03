package com.deliveryhero.repository.gccchat;

import com.deliveryhero.chatsdk.domain.model.messages.UnreadChatDetails;
import com.deliveryhero.contract.ChatLogger;
import com.deliveryhero.contract.model.Events;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "result", "Lkotlin/Result;", "Lcom/deliveryhero/chatsdk/domain/model/messages/UnreadChatDetails;", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GccChatRepositoryImpl$getUnreadCount$1 extends Lambda implements Function1<Result<? extends UnreadChatDetails>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<Integer, Unit> f30452g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GccChatRepositoryImpl f30453h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f30454i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<Throwable, Unit> f30455j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GccChatRepositoryImpl$getUnreadCount$1(Function1<? super Integer, Unit> function1, GccChatRepositoryImpl gccChatRepositoryImpl, String str, Function1<? super Throwable, Unit> function12) {
        super(1);
        this.f30452g = function1;
        this.f30453h = gccChatRepositoryImpl;
        this.f30454i = str;
        this.f30455j = function12;
    }

    public final void invoke(@NotNull Object obj) {
        Function1<Integer, Unit> function1 = this.f30452g;
        if (Result.m6336isSuccessimpl(obj)) {
            function1.invoke(Integer.valueOf(((UnreadChatDetails) obj).getCount()));
        }
        GccChatRepositoryImpl gccChatRepositoryImpl = this.f30453h;
        String str = this.f30454i;
        Function1<Throwable, Unit> function12 = this.f30455j;
        Throwable r52 = Result.m6332exceptionOrNullimpl(obj);
        if (r52 != null) {
            ChatLogger chatLogger = gccChatRepositoryImpl.chatFeatureCallbacks.getChatLogger();
            if (chatLogger != null) {
                chatLogger.log(Events.GCC_CHANNEL_UNREAD_COUNT_EVENT, MapsKt__MapsJVMKt.mapOf(TuplesKt.to(Events.PARAM_CHANNEL_ID, str)), r52);
            }
            function12.invoke(r52);
        }
    }
}
