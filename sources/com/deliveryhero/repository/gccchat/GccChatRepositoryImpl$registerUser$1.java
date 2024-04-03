package com.deliveryhero.repository.gccchat;

import com.deliveryhero.contract.idling.ChatIdlingResource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GccChatRepositoryImpl$registerUser$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GccChatRepositoryImpl f30466g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30467h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GccChatRepositoryImpl$registerUser$1(GccChatRepositoryImpl gccChatRepositoryImpl, Function0<Unit> function0) {
        super(0);
        this.f30466g = gccChatRepositoryImpl;
        this.f30467h = function0;
    }

    public final void invoke() {
        String token = this.f30466g.pushConfigRepository.getToken();
        if (token != null) {
            this.f30466g.registerToken(token, GccChatRepositoryImpl$registerUser$1$1$1.INSTANCE, GccChatRepositoryImpl$registerUser$1$1$2.INSTANCE);
        }
        this.f30467h.invoke();
        ChatIdlingResource access$getChatIdlingResource$p = this.f30466g.chatIdlingResource;
        if (access$getChatIdlingResource$p != null) {
            access$getChatIdlingResource$p.decrement();
        }
    }
}
