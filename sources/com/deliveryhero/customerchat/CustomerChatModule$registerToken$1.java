package com.deliveryhero.customerchat;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CustomerChatModule$registerToken$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CustomerChatModule f29775g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f29776h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f29777i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<Throwable, Unit> f29778j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerChatModule$registerToken$1(CustomerChatModule customerChatModule, String str, Function0<Unit> function0, Function1<? super Throwable, Unit> function1) {
        super(0);
        this.f29775g = customerChatModule;
        this.f29776h = str;
        this.f29777i = function0;
        this.f29778j = function1;
    }

    public final void invoke() {
        this.f29775g.getChatService().registerToken(this.f29776h, this.f29777i, this.f29778j);
    }
}
