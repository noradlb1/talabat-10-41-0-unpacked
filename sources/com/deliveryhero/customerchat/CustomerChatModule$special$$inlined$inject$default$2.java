package com.deliveryhero.customerchat;

import com.deliveryhero.contract.ChatPushNotificationParser;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0003\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¨\u0006\u0002"}, d2 = {"", "T", "org/koin/core/Koin$inject$$inlined$inject$1", "<anonymous>"}, k = 3, mv = {1, 6, 0})
public final class CustomerChatModule$special$$inlined$inject$default$2 extends Lambda implements Function0<ChatPushNotificationParser> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Scope f29733g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Qualifier f29734h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0 f29735i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerChatModule$special$$inlined$inject$default$2(Scope scope, Qualifier qualifier, Function0 function0) {
        super(0);
        this.f29733g = scope;
        this.f29734h = qualifier;
        this.f29735i = function0;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [com.deliveryhero.contract.ChatPushNotificationParser, java.lang.Object] */
    @NotNull
    public final ChatPushNotificationParser invoke() {
        return this.f29733g.get(Reflection.getOrCreateKotlinClass(ChatPushNotificationParser.class), this.f29734h, this.f29735i);
    }
}
