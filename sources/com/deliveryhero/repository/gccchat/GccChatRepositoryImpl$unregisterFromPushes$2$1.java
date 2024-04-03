package com.deliveryhero.repository.gccchat;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "result", "Lkotlin/Result;", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GccChatRepositoryImpl$unregisterFromPushes$2$1 extends Lambda implements Function1<Result<? extends Unit>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GccChatRepositoryImpl f30477g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30478h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Throwable, Unit> f30479i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GccChatRepositoryImpl$unregisterFromPushes$2$1(GccChatRepositoryImpl gccChatRepositoryImpl, Function0<Unit> function0, Function1<? super Throwable, Unit> function1) {
        super(1);
        this.f30477g = gccChatRepositoryImpl;
        this.f30478h = function0;
        this.f30479i = function1;
    }

    public final void invoke(@NotNull Object obj) {
        GccChatRepositoryImpl gccChatRepositoryImpl = this.f30477g;
        Function0<Unit> function0 = this.f30478h;
        if (Result.m6336isSuccessimpl(obj)) {
            Unit unit = (Unit) obj;
            gccChatRepositoryImpl.pushConfigRepository.clear();
            function0.invoke();
        }
        Function1<Throwable, Unit> function1 = this.f30479i;
        Throwable r42 = Result.m6332exceptionOrNullimpl(obj);
        if (r42 != null) {
            function1.invoke(r42);
        }
    }
}
