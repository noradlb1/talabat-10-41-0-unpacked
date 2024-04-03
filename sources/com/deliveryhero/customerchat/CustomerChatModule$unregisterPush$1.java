package com.deliveryhero.customerchat;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CustomerChatModule$unregisterPush$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CustomerChatModule f29792g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f29793h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Throwable, Unit> f29794i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerChatModule$unregisterPush$1(CustomerChatModule customerChatModule, Function0<Unit> function0, Function1<? super Throwable, Unit> function1) {
        super(0);
        this.f29792g = customerChatModule;
        this.f29793h = function0;
        this.f29794i = function1;
    }

    public final void invoke() {
        this.f29792g.getChatService().unregisterPush(this.f29793h, this.f29794i);
    }
}
