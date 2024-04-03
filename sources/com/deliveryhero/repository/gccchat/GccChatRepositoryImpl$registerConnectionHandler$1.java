package com.deliveryhero.repository.gccchat;

import com.deliveryhero.chatsdk.domain.model.ConnectionState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/deliveryhero/chatsdk/domain/model/ConnectionState;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GccChatRepositoryImpl$registerConnectionHandler$1 extends Lambda implements Function1<ConnectionState, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30462g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GccChatRepositoryImpl$registerConnectionHandler$1(Function0<Unit> function0) {
        super(1);
        this.f30462g = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ConnectionState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ConnectionState connectionState) {
        Intrinsics.checkNotNullParameter(connectionState, "it");
        if (connectionState == ConnectionState.OPEN) {
            this.f30462g.invoke();
        }
    }
}
