package com.talabat.feature.tpro.presentation.management.details;

import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$2"}, k = 3, mv = {1, 6, 0})
public final class TProSubscriptionDetailsFragment$special$$inlined$viewModels$default$2 extends Lambda implements Function0<ViewModelStore> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0 f59307g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TProSubscriptionDetailsFragment$special$$inlined$viewModels$default$2(Function0 function0) {
        super(0);
        this.f59307g = function0;
    }

    @NotNull
    public final ViewModelStore invoke() {
        ViewModelStore viewModelStore = ((ViewModelStoreOwner) this.f59307g.invoke()).getViewModelStore();
        Intrinsics.checkNotNullExpressionValue(viewModelStore, "ownerProducer().viewModelStore");
        return viewModelStore;
    }
}
