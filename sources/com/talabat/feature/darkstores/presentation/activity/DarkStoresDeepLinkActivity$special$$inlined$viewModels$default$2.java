package com.talabat.feature.darkstores.presentation.activity;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelStore;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/activity/ActivityViewModelLazyKt$viewModels$3"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DarkStoresDeepLinkActivity$special$$inlined$viewModels$default$2 extends Lambda implements Function0<ViewModelStore> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f58385g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DarkStoresDeepLinkActivity$special$$inlined$viewModels$default$2(ComponentActivity componentActivity) {
        super(0);
        this.f58385g = componentActivity;
    }

    @NotNull
    public final ViewModelStore invoke() {
        ViewModelStore viewModelStore = this.f58385g.getViewModelStore();
        Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
        return viewModelStore;
    }
}
