package org.koin.androidx.viewmodel.ext.android;

import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.koin.androidx.viewmodel.ViewModelOwner;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"Landroidx/lifecycle/ViewModel;", "T", "Lorg/koin/androidx/viewmodel/ViewModelOwner;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class SavedStateRegistryOwnerExtKt$getStateViewModel$owner$1 extends Lambda implements Function0<ViewModelOwner> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SavedStateRegistryOwner f62672g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SavedStateRegistryOwnerExtKt$getStateViewModel$owner$1(SavedStateRegistryOwner savedStateRegistryOwner) {
        super(0);
        this.f62672g = savedStateRegistryOwner;
    }

    @NotNull
    public final ViewModelOwner invoke() {
        ViewModelOwner.Companion companion = ViewModelOwner.Companion;
        SavedStateRegistryOwner savedStateRegistryOwner = this.f62672g;
        return companion.from((ViewModelStoreOwner) savedStateRegistryOwner, savedStateRegistryOwner);
    }
}
