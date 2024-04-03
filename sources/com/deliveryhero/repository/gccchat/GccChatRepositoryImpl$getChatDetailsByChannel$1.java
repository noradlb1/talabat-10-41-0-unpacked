package com.deliveryhero.repository.gccchat;

import com.deliveryhero.chatsdk.domain.model.UserInfo;
import com.deliveryhero.chatsdk.domain.model.messages.UnreadChatDetails;
import com.deliveryhero.contract.ChatLogger;
import com.deliveryhero.contract.idling.ChatIdlingResource;
import com.deliveryhero.contract.model.ChatDetails;
import com.deliveryhero.contract.model.Events;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "result", "Lkotlin/Result;", "Lcom/deliveryhero/chatsdk/domain/model/messages/UnreadChatDetails;", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GccChatRepositoryImpl$getChatDetailsByChannel$1 extends Lambda implements Function1<Result<? extends UnreadChatDetails>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GccChatRepositoryImpl f30445g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<ChatDetails, Unit> f30446h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f30447i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<Throwable, Unit> f30448j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GccChatRepositoryImpl$getChatDetailsByChannel$1(GccChatRepositoryImpl gccChatRepositoryImpl, Function1<? super ChatDetails, Unit> function1, String str, Function1<? super Throwable, Unit> function12) {
        super(1);
        this.f30445g = gccChatRepositoryImpl;
        this.f30446h = function1;
        this.f30447i = str;
        this.f30448j = function12;
    }

    public final void invoke(@NotNull Object obj) {
        Function1<ChatDetails, Unit> function1 = this.f30446h;
        String str = this.f30447i;
        if (Result.m6336isSuccessimpl(obj)) {
            UnreadChatDetails unreadChatDetails = (UnreadChatDetails) obj;
            function1.invoke(new ChatDetails(str, unreadChatDetails.getCount(), unreadChatDetails.getHasUnRepliedMessage()));
        }
        GccChatRepositoryImpl gccChatRepositoryImpl = this.f30445g;
        String str2 = this.f30447i;
        Function1<Throwable, Unit> function12 = this.f30448j;
        Throwable r72 = Result.m6332exceptionOrNullimpl(obj);
        if (r72 != null) {
            ChatLogger chatLogger = gccChatRepositoryImpl.chatFeatureCallbacks.getChatLogger();
            if (chatLogger != null) {
                Pair[] pairArr = new Pair[2];
                UserInfo access$getGccUserInfo$p = gccChatRepositoryImpl.gccUserInfo;
                if (access$getGccUserInfo$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gccUserInfo");
                    access$getGccUserInfo$p = null;
                }
                pairArr[0] = TuplesKt.to(Events.PARAM_USER_ID, access$getGccUserInfo$p.getUserId());
                pairArr[1] = TuplesKt.to(Events.PARAM_CHANNEL_ID, str2);
                chatLogger.log(Events.GCC_CHAT_DETAILS_EVENT, MapsKt__MapsKt.mapOf(pairArr), r72);
            }
            function12.invoke(r72);
        }
        ChatIdlingResource access$getChatIdlingResource$p = this.f30445g.chatIdlingResource;
        if (access$getChatIdlingResource$p != null) {
            access$getChatIdlingResource$p.decrement();
        }
    }
}
