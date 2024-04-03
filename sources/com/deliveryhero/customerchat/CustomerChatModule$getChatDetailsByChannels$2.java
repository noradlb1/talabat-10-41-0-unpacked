package com.deliveryhero.customerchat;

import com.deliveryhero.contract.model.ChatDetails;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CustomerChatModule$getChatDetailsByChannels$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CustomerChatModule f29764g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<String> f29765h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<List<ChatDetails>, Unit> f29766i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<Throwable, Unit> f29767j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerChatModule$getChatDetailsByChannels$2(CustomerChatModule customerChatModule, List<String> list, Function1<? super List<ChatDetails>, Unit> function1, Function1<? super Throwable, Unit> function12) {
        super(0);
        this.f29764g = customerChatModule;
        this.f29765h = list;
        this.f29766i = function1;
        this.f29767j = function12;
    }

    public final void invoke() {
        this.f29764g.getChatService().getChatDetailsByChannels(this.f29765h, this.f29766i, this.f29767j);
    }
}
