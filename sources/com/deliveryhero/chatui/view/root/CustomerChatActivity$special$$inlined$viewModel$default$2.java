package com.deliveryhero.chatui.view.root;

import android.content.ComponentCallbacks;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.koin.androidx.viewmodel.ext.android.ComponentCallbackExtKt;
import org.koin.core.qualifier.Qualifier;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¨\u0006\u0002"}, d2 = {"Landroidx/lifecycle/ViewModel;", "T", "org/koin/androidx/viewmodel/ext/android/ComponentCallbackExtKt$viewModel$2", "<anonymous>"}, k = 3, mv = {1, 6, 0})
public final class CustomerChatActivity$special$$inlined$viewModel$default$2 extends Lambda implements Function0<CustomerChatViewModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ComponentCallbacks f29689g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Qualifier f29690h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0 f29691i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function0 f29692j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerChatActivity$special$$inlined$viewModel$default$2(ComponentCallbacks componentCallbacks, Qualifier qualifier, Function0 function0, Function0 function02) {
        super(0);
        this.f29689g = componentCallbacks;
        this.f29690h = qualifier;
        this.f29691i = function0;
        this.f29692j = function02;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [com.deliveryhero.chatui.view.root.CustomerChatViewModel, androidx.lifecycle.ViewModel] */
    @NotNull
    public final CustomerChatViewModel invoke() {
        return ComponentCallbackExtKt.getViewModel(this.f29689g, this.f29690h, Reflection.getOrCreateKotlinClass(CustomerChatViewModel.class), this.f29691i, this.f29692j);
    }
}
