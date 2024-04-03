package org.koin.androidx.viewmodel.scope;

import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.koin.androidx.viewmodel.ViewModelOwner;
import org.koin.androidx.viewmodel.ViewModelParameter;
import org.koin.androidx.viewmodel.ViewModelResolverKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0000\u001a\f\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u0003\u001a)\u0010\u0004\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\tH\u0000¢\u0006\u0002\u0010\n\u001au\u0010\u0004\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u0006*\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0010\u0010\r\u001a\f\u0012\u0004\u0012\u00020\u000e0\u0001j\u0002`\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00112\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001j\u0004\u0018\u0001`\u00032\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0001j\u0004\u0018\u0001`\u0015¢\u0006\u0002\u0010\u0016\u001aY\u0010\u0004\u001a\u0002H\u0005\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u0006*\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0012\b\b\u0010\r\u001a\f\u0012\u0004\u0012\u00020\u000e0\u0001j\u0002`\u000f2\u0016\b\n\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0001j\u0004\u0018\u0001`\u0015H\bø\u0001\u0000¢\u0006\u0002\u0010\u0017*\u0016\u0010\u0018\"\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0019"}, d2 = {"emptyState", "Lkotlin/Function0;", "Landroid/os/Bundle;", "Lorg/koin/androidx/viewmodel/scope/BundleDefinition;", "getViewModel", "T", "Landroidx/lifecycle/ViewModel;", "Lorg/koin/core/scope/Scope;", "viewModelParameters", "Lorg/koin/androidx/viewmodel/ViewModelParameter;", "(Lorg/koin/core/scope/Scope;Lorg/koin/androidx/viewmodel/ViewModelParameter;)Landroidx/lifecycle/ViewModel;", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "owner", "Lorg/koin/androidx/viewmodel/ViewModelOwner;", "Lorg/koin/androidx/viewmodel/ViewModelOwnerDefinition;", "clazz", "Lkotlin/reflect/KClass;", "state", "parameters", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/parameter/ParametersDefinition;", "(Lorg/koin/core/scope/Scope;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Landroidx/lifecycle/ViewModel;", "(Lorg/koin/core/scope/Scope;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Landroidx/lifecycle/ViewModel;", "BundleDefinition", "koin-android_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ScopeExtKt {
    @NotNull
    public static final Function0<Bundle> emptyState() {
        return ScopeExtKt$emptyState$1.INSTANCE;
    }

    public static final /* synthetic */ <T extends ViewModel> T getViewModel(Scope scope, Qualifier qualifier, Function0<ViewModelOwner> function0, Function0<? extends ParametersHolder> function02) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(function0, "owner");
        Intrinsics.reifiedOperationMarker(4, "T");
        return getViewModel$default(scope, qualifier, function0, Reflection.getOrCreateKotlinClass(ViewModel.class), (Function0) null, function02, 8, (Object) null);
    }

    public static /* synthetic */ ViewModel getViewModel$default(Scope scope, Qualifier qualifier, Function0 function0, Function0 function02, int i11, Object obj) {
        Qualifier qualifier2 = (i11 & 1) != 0 ? null : qualifier;
        Function0 function03 = (i11 & 4) != 0 ? null : function02;
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(function0, "owner");
        Intrinsics.reifiedOperationMarker(4, "T");
        return getViewModel$default(scope, qualifier2, function0, Reflection.getOrCreateKotlinClass(ViewModel.class), (Function0) null, function03, 8, (Object) null);
    }

    @NotNull
    public static final <T extends ViewModel> T getViewModel(@NotNull Scope scope, @Nullable Qualifier qualifier, @NotNull Function0<ViewModelOwner> function0, @NotNull KClass<T> kClass, @Nullable Function0<Bundle> function02, @Nullable Function0<? extends ParametersHolder> function03) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(function0, "owner");
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        ViewModelOwner invoke = function0.invoke();
        return getViewModel(scope, new ViewModelParameter(kClass, qualifier, function02, function03, invoke.getStore(), invoke.getStateRegistry()));
    }

    public static /* synthetic */ ViewModel getViewModel$default(Scope scope, Qualifier qualifier, Function0 function0, KClass kClass, Function0 function02, Function0 function03, int i11, Object obj) {
        return getViewModel(scope, (i11 & 1) != 0 ? null : qualifier, function0, kClass, (i11 & 8) != 0 ? null : function02, (i11 & 16) != 0 ? null : function03);
    }

    @NotNull
    public static final <T extends ViewModel> T getViewModel(@NotNull Scope scope, @NotNull ViewModelParameter<T> viewModelParameter) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(viewModelParameter, "viewModelParameters");
        return ViewModelResolverKt.resolveInstance(new ViewModelProvider(viewModelParameter.getViewModelStore(), ViewModelResolverKt.pickFactory(scope, viewModelParameter)), viewModelParameter);
    }
}
