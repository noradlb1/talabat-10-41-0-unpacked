package com.talabat.homescreen.widget;

import android.view.View;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeViewModelKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "com/talabat/core/ui/di/ViewModelsKt$viewModels$viewModelStoreFactory$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenHeaderRewardsView$special$$inlined$viewModels$1 extends Lambda implements Function0<ViewModelStore> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ View f60976g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeScreenHeaderRewardsView$special$$inlined$viewModels$1(View view) {
        super(0);
        this.f60976g = view;
    }

    @NotNull
    public final ViewModelStore invoke() {
        ViewModelStoreOwner findViewTreeViewModelStoreOwner = ViewTreeViewModelKt.findViewTreeViewModelStoreOwner(this.f60976g);
        ViewModelStore viewModelStore = findViewTreeViewModelStoreOwner != null ? findViewTreeViewModelStoreOwner.getViewModelStore() : null;
        if (viewModelStore != null) {
            return viewModelStore;
        }
        throw new UnsupportedOperationException("Cannot create a ViewModel for this View");
    }
}
