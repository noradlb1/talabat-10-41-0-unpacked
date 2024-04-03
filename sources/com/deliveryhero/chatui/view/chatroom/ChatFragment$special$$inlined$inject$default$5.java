package com.deliveryhero.chatui.view.chatroom;

import android.content.ComponentCallbacks;
import com.deliveryhero.customerchat.configuration.ChatConfigProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.core.qualifier.Qualifier;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0003\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¨\u0006\u0002"}, d2 = {"", "T", "org/koin/android/ext/android/ComponentCallbackExtKt$inject$1", "<anonymous>"}, k = 3, mv = {1, 6, 0})
public final class ChatFragment$special$$inlined$inject$default$5 extends Lambda implements Function0<ChatConfigProvider> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ComponentCallbacks f29438g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Qualifier f29439h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0 f29440i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatFragment$special$$inlined$inject$default$5(ComponentCallbacks componentCallbacks, Qualifier qualifier, Function0 function0) {
        super(0);
        this.f29438g = componentCallbacks;
        this.f29439h = qualifier;
        this.f29440i = function0;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [com.deliveryhero.customerchat.configuration.ChatConfigProvider, java.lang.Object] */
    @NotNull
    public final ChatConfigProvider invoke() {
        ComponentCallbacks componentCallbacks = this.f29438g;
        return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ChatConfigProvider.class), this.f29439h, this.f29440i);
    }
}
