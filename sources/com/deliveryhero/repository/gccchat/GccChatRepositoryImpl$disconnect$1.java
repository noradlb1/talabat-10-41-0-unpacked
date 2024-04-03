package com.deliveryhero.repository.gccchat;

import com.deliveryhero.contract.ChatLogger;
import com.deliveryhero.contract.model.Events;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Result;", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GccChatRepositoryImpl$disconnect$1 extends Lambda implements Function1<Result<? extends Unit>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GccChatRepositoryImpl f30442g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30443h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GccChatRepositoryImpl$disconnect$1(GccChatRepositoryImpl gccChatRepositoryImpl, Function0<Unit> function0) {
        super(1);
        this.f30442g = gccChatRepositoryImpl;
        this.f30443h = function0;
    }

    public final void invoke(@NotNull Object obj) {
        ChatLogger chatLogger = this.f30442g.chatFeatureCallbacks.getChatLogger();
        if (chatLogger != null) {
            chatLogger.log(Events.GCC_DISCONNECTION_EVENT, MapsKt__MapsJVMKt.mapOf(TuplesKt.to(Events.PARAM_RESULT, String.valueOf(Result.m6336isSuccessimpl(obj)))));
        }
        this.f30443h.invoke();
    }
}
