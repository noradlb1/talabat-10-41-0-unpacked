package com.deliveryhero.customerchat.service;

import com.deliveryhero.contract.model.ChatDetails;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ChatService$getChatDetailsByChannel$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ChatService f30010g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f30011h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<ChatDetails, Unit> f30012i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<Throwable, Unit> f30013j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatService$getChatDetailsByChannel$1(ChatService chatService, String str, Function1<? super ChatDetails, Unit> function1, Function1<? super Throwable, Unit> function12) {
        super(0);
        this.f30010g = chatService;
        this.f30011h = str;
        this.f30012i = function1;
        this.f30013j = function12;
    }

    public final void invoke() {
        this.f30010g.repository.getChatDetailsByChannel(this.f30011h, this.f30012i, this.f30013j);
    }
}
