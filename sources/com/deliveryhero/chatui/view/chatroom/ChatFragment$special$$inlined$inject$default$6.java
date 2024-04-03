package com.deliveryhero.chatui.view.chatroom;

import android.content.ComponentCallbacks;
import com.deliveryhero.contract.configuration.ChatFeatureCallbacks;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.core.qualifier.Qualifier;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0003\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¨\u0006\u0002"}, d2 = {"", "T", "org/koin/android/ext/android/ComponentCallbackExtKt$inject$1", "<anonymous>"}, k = 3, mv = {1, 6, 0})
public final class ChatFragment$special$$inlined$inject$default$6 extends Lambda implements Function0<ChatFeatureCallbacks> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ComponentCallbacks f29441g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Qualifier f29442h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0 f29443i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatFragment$special$$inlined$inject$default$6(ComponentCallbacks componentCallbacks, Qualifier qualifier, Function0 function0) {
        super(0);
        this.f29441g = componentCallbacks;
        this.f29442h = qualifier;
        this.f29443i = function0;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [com.deliveryhero.contract.configuration.ChatFeatureCallbacks, java.lang.Object] */
    @NotNull
    public final ChatFeatureCallbacks invoke() {
        ComponentCallbacks componentCallbacks = this.f29441g;
        return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ChatFeatureCallbacks.class), this.f29442h, this.f29443i);
    }
}
