package org.koin.androidx.scope;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¨\u0006\u0003"}, d2 = {"Landroidx/lifecycle/ViewModel;", "VM", "Landroidx/lifecycle/ViewModelProvider$Factory;", "androidx/activity/ActivityViewModelLazyKt$viewModels$factoryPromise$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class LifecycleViewModelScopeDelegate$3$onCreate$$inlined$viewModels$default$1 extends Lambda implements Function0<ViewModelProvider.Factory> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f62652g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LifecycleViewModelScopeDelegate$3$onCreate$$inlined$viewModels$default$1(ComponentActivity componentActivity) {
        super(0);
        this.f62652g = componentActivity;
    }

    @NotNull
    public final ViewModelProvider.Factory invoke() {
        ViewModelProvider.Factory defaultViewModelProviderFactory = this.f62652g.getDefaultViewModelProviderFactory();
        Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
        return defaultViewModelProviderFactory;
    }
}
