package com.deliveryhero.chatui.view.root;

import android.content.ComponentCallbacks;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.koin.androidx.viewmodel.ViewModelOwner;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¨\u0006\u0003"}, d2 = {"Landroidx/lifecycle/ViewModel;", "T", "Lorg/koin/androidx/viewmodel/ViewModelOwner;", "org/koin/androidx/viewmodel/ext/android/ComponentCallbackExtKt$viewModel$1", "<anonymous>"}, k = 3, mv = {1, 6, 0})
public final class CustomerChatActivity$special$$inlined$viewModel$default$1 extends Lambda implements Function0<ViewModelOwner> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ComponentCallbacks f29688g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerChatActivity$special$$inlined$viewModel$default$1(ComponentCallbacks componentCallbacks) {
        super(0);
        this.f29688g = componentCallbacks;
    }

    @NotNull
    public final ViewModelOwner invoke() {
        ViewModelOwner.Companion companion = ViewModelOwner.Companion;
        ComponentCallbacks componentCallbacks = this.f29688g;
        return companion.from((ViewModelStoreOwner) componentCallbacks, componentCallbacks instanceof SavedStateRegistryOwner ? (SavedStateRegistryOwner) componentCallbacks : null);
    }
}
