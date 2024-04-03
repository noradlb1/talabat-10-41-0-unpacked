package org.koin.androidx.viewmodel.ext.android;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.scope.ScopeExtKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;

@Metadata(d1 = {"\u0000:\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a_\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007j\u0004\u0018\u0001`\u000e¢\u0006\u0002\u0010\u000f\u001aY\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\n\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t2\u0016\b\n\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007j\u0004\u0018\u0001`\u000eH\bø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a`\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0012\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007j\u0004\u0018\u0001`\u000e\u001aZ\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0012\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\n\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t2\u0016\b\n\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007j\u0004\u0018\u0001`\u000eH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0013"}, d2 = {"getStateViewModel", "T", "Landroidx/lifecycle/ViewModel;", "Landroidx/fragment/app/Fragment;", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "state", "Lkotlin/Function0;", "Landroid/os/Bundle;", "Lorg/koin/androidx/viewmodel/scope/BundleDefinition;", "clazz", "Lkotlin/reflect/KClass;", "parameters", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/parameter/ParametersDefinition;", "(Landroidx/fragment/app/Fragment;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)Landroidx/lifecycle/ViewModel;", "(Landroidx/fragment/app/Fragment;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Landroidx/lifecycle/ViewModel;", "sharedStateViewModel", "Lkotlin/Lazy;", "koin-android_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class SharedSavedStateRegistryOwnerExtKt {
    public static final /* synthetic */ <T extends ViewModel> T getStateViewModel(Fragment fragment, Qualifier qualifier, Function0<Bundle> function0, Function0<? extends ParametersHolder> function02) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(function0, "state");
        Intrinsics.reifiedOperationMarker(4, "T");
        return getStateViewModel(fragment, qualifier, function0, Reflection.getOrCreateKotlinClass(ViewModel.class), function02);
    }

    public static /* synthetic */ ViewModel getStateViewModel$default(Fragment fragment, Qualifier qualifier, Function0<Bundle> function0, Function0 function02, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            qualifier = null;
        }
        if ((i11 & 2) != 0) {
            function0 = ScopeExtKt.emptyState();
        }
        if ((i11 & 4) != 0) {
            function02 = null;
        }
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(function0, "state");
        Intrinsics.reifiedOperationMarker(4, "T");
        return getStateViewModel(fragment, qualifier, function0, Reflection.getOrCreateKotlinClass(ViewModel.class), function02);
    }

    public static final /* synthetic */ <T extends ViewModel> Lazy<T> sharedStateViewModel(Fragment fragment, Qualifier qualifier, Function0<Bundle> function0, Function0<? extends ParametersHolder> function02) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(function0, "state");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Intrinsics.needClassReification();
        return LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new SharedSavedStateRegistryOwnerExtKt$sharedStateViewModel$1(fragment, qualifier, function0, function02));
    }

    public static /* synthetic */ Lazy sharedStateViewModel$default(Fragment fragment, Qualifier qualifier, Function0<Bundle> function0, Function0 function02, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            qualifier = null;
        }
        if ((i11 & 2) != 0) {
            function0 = ScopeExtKt.emptyState();
        }
        if ((i11 & 4) != 0) {
            function02 = null;
        }
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(function0, "state");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Intrinsics.needClassReification();
        return LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new SharedSavedStateRegistryOwnerExtKt$sharedStateViewModel$1(fragment, qualifier, function0, function02));
    }

    @NotNull
    public static final <T extends ViewModel> T getStateViewModel(@NotNull Fragment fragment, @Nullable Qualifier qualifier, @NotNull Function0<Bundle> function0, @NotNull KClass<T> kClass, @Nullable Function0<? extends ParametersHolder> function02) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(function0, "state");
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        return ScopeExtKt.getViewModel(AndroidKoinScopeExtKt.getKoinScope(fragment), qualifier, new SharedSavedStateRegistryOwnerExtKt$getStateViewModel$1(fragment), kClass, function0, function02);
    }

    @NotNull
    public static final <T extends ViewModel> Lazy<T> sharedStateViewModel(@NotNull Fragment fragment, @Nullable Qualifier qualifier, @NotNull Function0<Bundle> function0, @NotNull KClass<T> kClass, @Nullable Function0<? extends ParametersHolder> function02) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(function0, "state");
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        return LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new SharedSavedStateRegistryOwnerExtKt$sharedStateViewModel$2(fragment, qualifier, function0, kClass, function02));
    }

    public static /* synthetic */ ViewModel getStateViewModel$default(Fragment fragment, Qualifier qualifier, Function0<Bundle> function0, KClass kClass, Function0 function02, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            qualifier = null;
        }
        if ((i11 & 2) != 0) {
            function0 = ScopeExtKt.emptyState();
        }
        if ((i11 & 8) != 0) {
            function02 = null;
        }
        return getStateViewModel(fragment, qualifier, function0, kClass, function02);
    }

    public static /* synthetic */ Lazy sharedStateViewModel$default(Fragment fragment, Qualifier qualifier, Function0<Bundle> function0, KClass kClass, Function0 function02, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            qualifier = null;
        }
        if ((i11 & 2) != 0) {
            function0 = ScopeExtKt.emptyState();
        }
        if ((i11 & 8) != 0) {
            function02 = null;
        }
        return sharedStateViewModel(fragment, qualifier, function0, kClass, function02);
    }
}
