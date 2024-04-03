package org.koin.androidx.viewmodel.ext.android;

import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n"}, d2 = {"Landroidx/lifecycle/ViewModel;", "T", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class SavedStateRegistryOwnerExtKt$stateViewModel$1 extends Lambda implements Function0<T> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SavedStateRegistryOwner f62673g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Qualifier f62674h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Bundle> f62675i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function0<ParametersHolder> f62676j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SavedStateRegistryOwnerExtKt$stateViewModel$1(SavedStateRegistryOwner savedStateRegistryOwner, Qualifier qualifier, Function0<Bundle> function0, Function0<? extends ParametersHolder> function02) {
        super(0);
        this.f62673g = savedStateRegistryOwner;
        this.f62674h = qualifier;
        this.f62675i = function0;
        this.f62676j = function02;
    }

    @NotNull
    public final T invoke() {
        SavedStateRegistryOwner savedStateRegistryOwner = this.f62673g;
        Qualifier qualifier = this.f62674h;
        Function0<Bundle> function0 = this.f62675i;
        Function0<ParametersHolder> function02 = this.f62676j;
        Intrinsics.reifiedOperationMarker(4, "T");
        return SavedStateRegistryOwnerExtKt.getStateViewModel(savedStateRegistryOwner, qualifier, function0, Reflection.getOrCreateKotlinClass(ViewModel.class), function02);
    }
}
