package org.koin.androidx.viewmodel.ext.android;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"Landroidx/lifecycle/ViewModel;", "T", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class SavedStateRegistryOwnerExtKt$stateViewModel$2 extends Lambda implements Function0<T> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SavedStateRegistryOwner f62677g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Qualifier f62678h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Bundle> f62679i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ KClass<T> f62680j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function0<ParametersHolder> f62681k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SavedStateRegistryOwnerExtKt$stateViewModel$2(SavedStateRegistryOwner savedStateRegistryOwner, Qualifier qualifier, Function0<Bundle> function0, KClass<T> kClass, Function0<? extends ParametersHolder> function02) {
        super(0);
        this.f62677g = savedStateRegistryOwner;
        this.f62678h = qualifier;
        this.f62679i = function0;
        this.f62680j = kClass;
        this.f62681k = function02;
    }

    @NotNull
    public final T invoke() {
        return SavedStateRegistryOwnerExtKt.getStateViewModel(this.f62677g, this.f62678h, this.f62679i, this.f62680j, this.f62681k);
    }
}
