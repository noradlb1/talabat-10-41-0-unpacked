package org.koin.androidx.viewmodel.ext.android;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"Landroidx/lifecycle/ViewModel;", "T", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class SharedSavedStateRegistryOwnerExtKt$sharedStateViewModel$2 extends Lambda implements Function0<T> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Fragment f62687g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Qualifier f62688h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Bundle> f62689i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ KClass<T> f62690j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function0<ParametersHolder> f62691k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SharedSavedStateRegistryOwnerExtKt$sharedStateViewModel$2(Fragment fragment, Qualifier qualifier, Function0<Bundle> function0, KClass<T> kClass, Function0<? extends ParametersHolder> function02) {
        super(0);
        this.f62687g = fragment;
        this.f62688h = qualifier;
        this.f62689i = function0;
        this.f62690j = kClass;
        this.f62691k = function02;
    }

    @NotNull
    public final T invoke() {
        return SharedSavedStateRegistryOwnerExtKt.getStateViewModel(this.f62687g, this.f62688h, this.f62689i, this.f62690j, this.f62691k);
    }
}
