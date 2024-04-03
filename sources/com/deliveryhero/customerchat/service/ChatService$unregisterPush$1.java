package com.deliveryhero.customerchat.service;

import com.deliveryhero.customerchat.telephony.domain.TokuUserStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ChatService$unregisterPush$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ChatService f30047g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30048h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Throwable, Unit> f30049i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatService$unregisterPush$1(ChatService chatService, Function0<Unit> function0, Function1<? super Throwable, Unit> function1) {
        super(0);
        this.f30047g = chatService;
        this.f30048h = function0;
        this.f30049i = function1;
    }

    public final void invoke() {
        this.f30047g.repository.unregisterFromPushes(this.f30048h, this.f30049i);
        this.f30047g.updateTokuUserStatus(TokuUserStatus.USER_STATUS_OFFLINE);
    }
}
