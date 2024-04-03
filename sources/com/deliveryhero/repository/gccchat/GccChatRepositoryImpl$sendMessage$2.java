package com.deliveryhero.repository.gccchat;

import com.deliveryhero.chatsdk.Channel;
import com.deliveryhero.chatsdk.domain.model.UserInfo;
import com.deliveryhero.chatsdk.domain.model.messages.Message;
import com.deliveryhero.contract.ChatLogger;
import com.deliveryhero.contract.idling.ChatIdlingResource;
import com.deliveryhero.contract.model.BaseMessage;
import com.deliveryhero.contract.model.Events;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "result", "Lkotlin/Result;", "Lcom/deliveryhero/chatsdk/domain/model/messages/Message;", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GccChatRepositoryImpl$sendMessage$2 extends Lambda implements Function1<Result<? extends Message>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GccChatRepositoryImpl f30474g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<BaseMessage, Unit> f30475h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<BaseMessage, Throwable, Unit> f30476i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GccChatRepositoryImpl$sendMessage$2(GccChatRepositoryImpl gccChatRepositoryImpl, Function1<? super BaseMessage, Unit> function1, Function2<? super BaseMessage, ? super Throwable, Unit> function2) {
        super(1);
        this.f30474g = gccChatRepositoryImpl;
        this.f30475h = function1;
        this.f30476i = function2;
    }

    public final void invoke(@NotNull Object obj) {
        GccChatRepositoryImpl gccChatRepositoryImpl = this.f30474g;
        Function1<BaseMessage, Unit> function1 = this.f30475h;
        if (Result.m6336isSuccessimpl(obj)) {
            Message message = (Message) obj;
            ChatLogger chatLogger = gccChatRepositoryImpl.chatFeatureCallbacks.getChatLogger();
            if (chatLogger != null) {
                Pair[] pairArr = new Pair[3];
                Channel access$getChannel$p = gccChatRepositoryImpl.channel;
                if (access$getChannel$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("channel");
                    access$getChannel$p = null;
                }
                pairArr[0] = TuplesKt.to(Events.PARAM_CHANNEL_ID, access$getChannel$p.getChannelId());
                pairArr[1] = TuplesKt.to(Events.PARAM_MESSAGE_ID, message.getId());
                UserInfo access$getGccUserInfo$p = gccChatRepositoryImpl.gccUserInfo;
                if (access$getGccUserInfo$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gccUserInfo");
                    access$getGccUserInfo$p = null;
                }
                pairArr[2] = TuplesKt.to(Events.PARAM_USER_ID, access$getGccUserInfo$p.getUserId());
                chatLogger.log(Events.GCC_MESSAGE_SENT_EVENT, MapsKt__MapsKt.mapOf(pairArr));
            }
            function1.invoke(gccChatRepositoryImpl.mapper.map(message));
        }
        GccChatRepositoryImpl gccChatRepositoryImpl2 = this.f30474g;
        Function2<BaseMessage, Throwable, Unit> function2 = this.f30476i;
        Throwable r32 = Result.m6332exceptionOrNullimpl(obj);
        if (r32 != null) {
            ChatLogger chatLogger2 = gccChatRepositoryImpl2.chatFeatureCallbacks.getChatLogger();
            if (chatLogger2 != null) {
                Pair[] pairArr2 = new Pair[2];
                Channel access$getChannel$p2 = gccChatRepositoryImpl2.channel;
                if (access$getChannel$p2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("channel");
                    access$getChannel$p2 = null;
                }
                pairArr2[0] = TuplesKt.to(Events.PARAM_CHANNEL_ID, access$getChannel$p2.getChannelId());
                UserInfo access$getGccUserInfo$p2 = gccChatRepositoryImpl2.gccUserInfo;
                if (access$getGccUserInfo$p2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gccUserInfo");
                    access$getGccUserInfo$p2 = null;
                }
                pairArr2[1] = TuplesKt.to(Events.PARAM_USER_ID, access$getGccUserInfo$p2.getUserId());
                chatLogger2.log(Events.GCC_MESSAGE_SENT_EVENT, MapsKt__MapsKt.mapOf(pairArr2), r32);
            }
            function2.invoke(null, r32);
        }
        ChatIdlingResource access$getChatIdlingResource$p = this.f30474g.chatIdlingResource;
        if (access$getChatIdlingResource$p != null) {
            access$getChatIdlingResource$p.decrement();
        }
    }
}
