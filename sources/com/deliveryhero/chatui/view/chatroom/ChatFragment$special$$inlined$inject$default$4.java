package com.deliveryhero.chatui.view.chatroom;

import android.content.ComponentCallbacks;
import com.deliveryhero.customerchat.view.util.AttributeUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.core.qualifier.Qualifier;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0003\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¨\u0006\u0002"}, d2 = {"", "T", "org/koin/android/ext/android/ComponentCallbackExtKt$inject$1", "<anonymous>"}, k = 3, mv = {1, 6, 0})
public final class ChatFragment$special$$inlined$inject$default$4 extends Lambda implements Function0<AttributeUtils> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ComponentCallbacks f29435g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Qualifier f29436h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0 f29437i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatFragment$special$$inlined$inject$default$4(ComponentCallbacks componentCallbacks, Qualifier qualifier, Function0 function0) {
        super(0);
        this.f29435g = componentCallbacks;
        this.f29436h = qualifier;
        this.f29437i = function0;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.Object, com.deliveryhero.customerchat.view.util.AttributeUtils] */
    @NotNull
    public final AttributeUtils invoke() {
        ComponentCallbacks componentCallbacks = this.f29435g;
        return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(AttributeUtils.class), this.f29436h, this.f29437i);
    }
}
