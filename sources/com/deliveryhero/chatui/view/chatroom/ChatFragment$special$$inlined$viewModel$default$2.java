package com.deliveryhero.chatui.view.chatroom;

import android.content.ComponentCallbacks;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.koin.androidx.viewmodel.ext.android.ComponentCallbackExtKt;
import org.koin.core.qualifier.Qualifier;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¨\u0006\u0002"}, d2 = {"Landroidx/lifecycle/ViewModel;", "T", "org/koin/androidx/viewmodel/ext/android/ComponentCallbackExtKt$viewModel$2", "<anonymous>"}, k = 3, mv = {1, 6, 0})
public final class ChatFragment$special$$inlined$viewModel$default$2 extends Lambda implements Function0<ChatViewModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ComponentCallbacks f29448g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Qualifier f29449h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0 f29450i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function0 f29451j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatFragment$special$$inlined$viewModel$default$2(ComponentCallbacks componentCallbacks, Qualifier qualifier, Function0 function0, Function0 function02) {
        super(0);
        this.f29448g = componentCallbacks;
        this.f29449h = qualifier;
        this.f29450i = function0;
        this.f29451j = function02;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [androidx.lifecycle.ViewModel, com.deliveryhero.chatui.view.chatroom.ChatViewModel] */
    @NotNull
    public final ChatViewModel invoke() {
        return ComponentCallbackExtKt.getViewModel(this.f29448g, this.f29449h, Reflection.getOrCreateKotlinClass(ChatViewModel.class), this.f29450i, this.f29451j);
    }
}
