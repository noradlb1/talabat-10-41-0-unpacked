package com.deliveryhero.customerchat;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CustomerChatModule$getUnreadCount$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CustomerChatModule f29768g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f29769h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Integer, Unit> f29770i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<Throwable, Unit> f29771j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerChatModule$getUnreadCount$1(CustomerChatModule customerChatModule, String str, Function1<? super Integer, Unit> function1, Function1<? super Throwable, Unit> function12) {
        super(0);
        this.f29768g = customerChatModule;
        this.f29769h = str;
        this.f29770i = function1;
        this.f29771j = function12;
    }

    public final void invoke() {
        this.f29768g.getChatService().getUnreadCount(this.f29769h, this.f29770i, this.f29771j);
    }
}
