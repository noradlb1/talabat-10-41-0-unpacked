package com.deliveryhero.customerchat;

import com.deliveryhero.contract.model.ChatDetails;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CustomerChatModule$getChatDetailsByChannel$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CustomerChatModule f29760g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f29761h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<ChatDetails, Unit> f29762i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<Throwable, Unit> f29763j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerChatModule$getChatDetailsByChannel$1(CustomerChatModule customerChatModule, String str, Function1<? super ChatDetails, Unit> function1, Function1<? super Throwable, Unit> function12) {
        super(0);
        this.f29760g = customerChatModule;
        this.f29761h = str;
        this.f29762i = function1;
        this.f29763j = function12;
    }

    public final void invoke() {
        this.f29760g.getChatService().getChatDetailsByChannel(this.f29761h, (Function1<? super ChatDetails, Unit>) this.f29762i, (Function1<? super Throwable, Unit>) this.f29763j);
    }
}
