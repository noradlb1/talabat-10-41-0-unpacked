package com.deliveryhero.customerchat.service;

import com.deliveryhero.customerchat.telephony.domain.TokuUserStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ChatService$registerToken$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ChatService f30039g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f30040h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30041i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<Throwable, Unit> f30042j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatService$registerToken$1(ChatService chatService, String str, Function0<Unit> function0, Function1<? super Throwable, Unit> function1) {
        super(0);
        this.f30039g = chatService;
        this.f30040h = str;
        this.f30041i = function0;
        this.f30042j = function1;
    }

    public final void invoke() {
        this.f30039g.repository.registerToken(this.f30040h, this.f30041i, this.f30042j);
        this.f30039g.updateTokuUserStatus(TokuUserStatus.USER_STATUS_ONLINE);
    }
}
