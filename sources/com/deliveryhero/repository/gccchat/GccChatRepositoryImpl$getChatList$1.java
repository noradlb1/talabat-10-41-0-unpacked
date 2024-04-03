package com.deliveryhero.repository.gccchat;

import com.deliveryhero.chatsdk.Channel;
import com.deliveryhero.chatsdk.domain.model.UserInfo;
import com.deliveryhero.chatsdk.domain.model.messages.Message;
import com.deliveryhero.contract.ChatLogger;
import com.deliveryhero.contract.idling.ChatIdlingResource;
import com.deliveryhero.contract.model.BaseMessage;
import com.deliveryhero.contract.model.Events;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "result", "Lkotlin/Result;", "", "Lcom/deliveryhero/chatsdk/domain/model/messages/Message;", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GccChatRepositoryImpl$getChatList$1 extends Lambda implements Function1<Result<? extends List<? extends Message>>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GccChatRepositoryImpl f30449g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<List<? extends BaseMessage>, Unit> f30450h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Throwable, Unit> f30451i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GccChatRepositoryImpl$getChatList$1(GccChatRepositoryImpl gccChatRepositoryImpl, Function1<? super List<? extends BaseMessage>, Unit> function1, Function1<? super Throwable, Unit> function12) {
        super(1);
        this.f30449g = gccChatRepositoryImpl;
        this.f30450h = function1;
        this.f30451i = function12;
    }

    public final void invoke(@NotNull Object obj) {
        UserInfo userInfo;
        GccChatRepositoryImpl gccChatRepositoryImpl = this.f30449g;
        Function1<List<? extends BaseMessage>, Unit> function1 = this.f30450h;
        if (Result.m6336isSuccessimpl(obj)) {
            List list = (List) obj;
            ChatLogger chatLogger = gccChatRepositoryImpl.chatFeatureCallbacks.getChatLogger();
            if (chatLogger != null) {
                Pair[] pairArr = new Pair[3];
                Channel access$getChannel$p = gccChatRepositoryImpl.channel;
                if (access$getChannel$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("channel");
                    access$getChannel$p = null;
                }
                pairArr[0] = TuplesKt.to(Events.PARAM_CHANNEL_ID, access$getChannel$p.getChannelId());
                pairArr[1] = TuplesKt.to(Events.PARAM_MESSAGE_COUNT, String.valueOf(list.size()));
                UserInfo access$getGccUserInfo$p = gccChatRepositoryImpl.gccUserInfo;
                if (access$getGccUserInfo$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gccUserInfo");
                    access$getGccUserInfo$p = null;
                }
                pairArr[2] = TuplesKt.to(Events.PARAM_USER_ID, access$getGccUserInfo$p.getUserId());
                chatLogger.log(Events.GCC_MESSAGE_HISTORY_LOADED, MapsKt__MapsKt.mapOf(pairArr));
            }
            function1.invoke(gccChatRepositoryImpl.mapper.map((List<? extends Message>) list));
        }
        GccChatRepositoryImpl gccChatRepositoryImpl2 = this.f30449g;
        Function1<Throwable, Unit> function12 = this.f30451i;
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
                    userInfo = null;
                } else {
                    userInfo = access$getGccUserInfo$p2;
                }
                pairArr2[1] = TuplesKt.to(Events.PARAM_USER_ID, userInfo.getUserId());
                chatLogger2.log(Events.GCC_MESSAGE_HISTORY_LOADED, MapsKt__MapsKt.mapOf(pairArr2), r32);
            }
            function12.invoke(r32);
        }
        ChatIdlingResource access$getChatIdlingResource$p = this.f30449g.chatIdlingResource;
        if (access$getChatIdlingResource$p != null) {
            access$getChatIdlingResource$p.decrement();
        }
    }
}
