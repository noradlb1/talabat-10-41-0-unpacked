package org.koin.androidx.viewmodel.ext.android;

import android.content.ComponentCallbacks;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.koin.androidx.viewmodel.ViewModelOwner;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n"}, d2 = {"Landroidx/lifecycle/ViewModel;", "T", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ComponentCallbackExtKt$viewModel$2 extends Lambda implements Function0<T> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ComponentCallbacks f62661g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Qualifier f62662h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<ViewModelOwner> f62663i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function0<ParametersHolder> f62664j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComponentCallbackExtKt$viewModel$2(ComponentCallbacks componentCallbacks, Qualifier qualifier, Function0<ViewModelOwner> function0, Function0<? extends ParametersHolder> function02) {
        super(0);
        this.f62661g = componentCallbacks;
        this.f62662h = qualifier;
        this.f62663i = function0;
        this.f62664j = function02;
    }

    @NotNull
    public final T invoke() {
        ComponentCallbacks componentCallbacks = this.f62661g;
        Qualifier qualifier = this.f62662h;
        Function0<ViewModelOwner> function0 = this.f62663i;
        Function0<ParametersHolder> function02 = this.f62664j;
        Intrinsics.reifiedOperationMarker(4, "T");
        return ComponentCallbackExtKt.getViewModel(componentCallbacks, qualifier, Reflection.getOrCreateKotlinClass(ViewModel.class), function0, function02);
    }
}
