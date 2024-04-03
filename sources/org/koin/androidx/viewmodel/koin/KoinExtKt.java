package org.koin.androidx.viewmodel.koin;

import androidx.lifecycle.ViewModel;
import com.instabug.library.model.session.config.SessionsConfigParameter;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.koin.androidx.viewmodel.ViewModelOwner;
import org.koin.androidx.viewmodel.ViewModelParameter;
import org.koin.androidx.viewmodel.scope.ScopeExtKt;
import org.koin.core.Koin;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;

@Metadata(d1 = {"\u0000H\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a)\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0000¢\u0006\u0002\u0010\u0006\u001a]\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u000b0\nj\u0002`\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000e2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\nj\u0004\u0018\u0001`\u0011¢\u0006\u0002\u0010\u0012\u001aY\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0012\b\b\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u000b0\nj\u0002`\f2\u0016\b\n\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\nj\u0004\u0018\u0001`\u0011H\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001ad\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0015\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0012\b\b\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u000b0\nj\u0002`\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0016\b\n\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\nj\u0004\u0018\u0001`\u0011H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0018"}, d2 = {"getViewModel", "T", "Landroidx/lifecycle/ViewModel;", "Lorg/koin/core/Koin;", "viewModelParameters", "Lorg/koin/androidx/viewmodel/ViewModelParameter;", "(Lorg/koin/core/Koin;Lorg/koin/androidx/viewmodel/ViewModelParameter;)Landroidx/lifecycle/ViewModel;", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "owner", "Lkotlin/Function0;", "Lorg/koin/androidx/viewmodel/ViewModelOwner;", "Lorg/koin/androidx/viewmodel/ViewModelOwnerDefinition;", "clazz", "Lkotlin/reflect/KClass;", "parameters", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/parameter/ParametersDefinition;", "(Lorg/koin/core/Koin;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)Landroidx/lifecycle/ViewModel;", "(Lorg/koin/core/Koin;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Landroidx/lifecycle/ViewModel;", "viewModel", "Lkotlin/Lazy;", "mode", "Lkotlin/LazyThreadSafetyMode;", "koin-android_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class KoinExtKt {
    public static final /* synthetic */ <T extends ViewModel> T getViewModel(Koin koin, Qualifier qualifier, Function0<ViewModelOwner> function0, Function0<? extends ParametersHolder> function02) {
        Intrinsics.checkNotNullParameter(koin, "<this>");
        Intrinsics.checkNotNullParameter(function0, "owner");
        Intrinsics.reifiedOperationMarker(4, "T");
        return getViewModel(koin, qualifier, function0, Reflection.getOrCreateKotlinClass(ViewModel.class), function02);
    }

    public static /* synthetic */ ViewModel getViewModel$default(Koin koin, Qualifier qualifier, Function0 function0, Function0 function02, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            qualifier = null;
        }
        if ((i11 & 4) != 0) {
            function02 = null;
        }
        Intrinsics.checkNotNullParameter(koin, "<this>");
        Intrinsics.checkNotNullParameter(function0, "owner");
        Intrinsics.reifiedOperationMarker(4, "T");
        return getViewModel(koin, qualifier, function0, Reflection.getOrCreateKotlinClass(ViewModel.class), function02);
    }

    public static final /* synthetic */ <T extends ViewModel> Lazy<T> viewModel(Koin koin, Qualifier qualifier, Function0<ViewModelOwner> function0, LazyThreadSafetyMode lazyThreadSafetyMode, Function0<? extends ParametersHolder> function02) {
        Intrinsics.checkNotNullParameter(koin, "<this>");
        Intrinsics.checkNotNullParameter(function0, "owner");
        Intrinsics.checkNotNullParameter(lazyThreadSafetyMode, SessionsConfigParameter.SYNC_MODE);
        Intrinsics.needClassReification();
        return LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new KoinExtKt$viewModel$1(koin, qualifier, function0, function02));
    }

    public static /* synthetic */ Lazy viewModel$default(Koin koin, Qualifier qualifier, Function0 function0, LazyThreadSafetyMode lazyThreadSafetyMode, Function0 function02, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            qualifier = null;
        }
        if ((i11 & 4) != 0) {
            lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        }
        if ((i11 & 8) != 0) {
            function02 = null;
        }
        Intrinsics.checkNotNullParameter(koin, "<this>");
        Intrinsics.checkNotNullParameter(function0, "owner");
        Intrinsics.checkNotNullParameter(lazyThreadSafetyMode, SessionsConfigParameter.SYNC_MODE);
        Intrinsics.needClassReification();
        return LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new KoinExtKt$viewModel$1(koin, qualifier, function0, function02));
    }

    @NotNull
    public static final <T extends ViewModel> T getViewModel(@NotNull Koin koin, @Nullable Qualifier qualifier, @NotNull Function0<ViewModelOwner> function0, @NotNull KClass<T> kClass, @Nullable Function0<? extends ParametersHolder> function02) {
        Intrinsics.checkNotNullParameter(koin, "<this>");
        Intrinsics.checkNotNullParameter(function0, "owner");
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        return ScopeExtKt.getViewModel$default(koin.getScopeRegistry().getRootScope(), qualifier, function0, kClass, (Function0) null, function02, 8, (Object) null);
    }

    @NotNull
    public static final <T extends ViewModel> T getViewModel(@NotNull Koin koin, @NotNull ViewModelParameter<T> viewModelParameter) {
        Intrinsics.checkNotNullParameter(koin, "<this>");
        Intrinsics.checkNotNullParameter(viewModelParameter, "viewModelParameters");
        return ScopeExtKt.getViewModel(koin.getScopeRegistry().getRootScope(), viewModelParameter);
    }

    public static /* synthetic */ ViewModel getViewModel$default(Koin koin, Qualifier qualifier, Function0 function0, KClass kClass, Function0 function02, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            qualifier = null;
        }
        if ((i11 & 8) != 0) {
            function02 = null;
        }
        return getViewModel(koin, qualifier, function0, kClass, function02);
    }
}
