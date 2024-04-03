package androidx.navigation;

import androidx.annotation.IdRes;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\u001a>\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\bø\u0001\u0000\u001aP\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0010\b\n\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b2\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\bø\u0001\u0000\u001a<\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\bø\u0001\u0000\u001aN\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0010\b\n\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b2\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000e²\u0006\u0016\u0010\u000f\u001a\u00020\u0010\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003X\u0002²\u0006\u0016\u0010\u000f\u001a\u00020\u0010\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003X\u0002²\u0006\u0016\u0010\u000f\u001a\u00020\u0010\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003X\u0002²\u0006\u0016\u0010\u000f\u001a\u00020\u0010\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003X\u0002"}, d2 = {"navGraphViewModels", "Lkotlin/Lazy;", "VM", "Landroidx/lifecycle/ViewModel;", "Landroidx/fragment/app/Fragment;", "navGraphId", "", "factoryProducer", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "extrasProducer", "Landroidx/lifecycle/viewmodel/CreationExtras;", "navGraphRoute", "", "navigation-fragment_release", "backStackEntry", "Landroidx/navigation/NavBackStackEntry;"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class NavGraphViewModelLazyKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by navGraphViewModels that takes a CreationExtras producer")
    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> navGraphViewModels(Fragment fragment, @IdRes int i11, Function0<? extends ViewModelProvider.Factory> function0) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Lazy lazy = LazyKt__LazyJVMKt.lazy(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$2(fragment, i11));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1(lazy);
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
        NavGraphViewModelLazyKt$navGraphViewModels$1 navGraphViewModelLazyKt$navGraphViewModels$1 = new NavGraphViewModelLazyKt$navGraphViewModels$1(lazy);
        if (function0 == null) {
            function0 = new NavGraphViewModelLazyKt$navGraphViewModels$2(lazy);
        }
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, orCreateKotlinClass, navGraphViewModelLazyKt$navGraphViewModels$storeProducer$1, navGraphViewModelLazyKt$navGraphViewModels$1, function0);
    }

    public static /* synthetic */ Lazy navGraphViewModels$default(Fragment fragment, int i11, Function0 function0, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            function0 = null;
        }
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Lazy lazy = LazyKt__LazyJVMKt.lazy(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$2(fragment, i11));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1(lazy);
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
        NavGraphViewModelLazyKt$navGraphViewModels$1 navGraphViewModelLazyKt$navGraphViewModels$1 = new NavGraphViewModelLazyKt$navGraphViewModels$1(lazy);
        if (function0 == null) {
            function0 = new NavGraphViewModelLazyKt$navGraphViewModels$2(lazy);
        }
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, orCreateKotlinClass, navGraphViewModelLazyKt$navGraphViewModels$storeProducer$1, navGraphViewModelLazyKt$navGraphViewModels$1, function0);
    }

    /* access modifiers changed from: private */
    /* renamed from: navGraphViewModels$lambda-0  reason: not valid java name */
    public static final NavBackStackEntry m9098navGraphViewModels$lambda0(Lazy<NavBackStackEntry> lazy) {
        return lazy.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: navGraphViewModels$lambda-1  reason: not valid java name */
    public static final NavBackStackEntry m9099navGraphViewModels$lambda1(Lazy<NavBackStackEntry> lazy) {
        return lazy.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: navGraphViewModels$lambda-2  reason: not valid java name */
    public static final NavBackStackEntry m9100navGraphViewModels$lambda2(Lazy<NavBackStackEntry> lazy) {
        return lazy.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: navGraphViewModels$lambda-3  reason: not valid java name */
    public static final NavBackStackEntry m9101navGraphViewModels$lambda3(Lazy<NavBackStackEntry> lazy) {
        return lazy.getValue();
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> navGraphViewModels(Fragment fragment, @IdRes int i11, Function0<? extends CreationExtras> function0, Function0<? extends ViewModelProvider.Factory> function02) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Lazy lazy = LazyKt__LazyJVMKt.lazy(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$4(fragment, i11));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$2 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$2 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$2(lazy);
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
        NavGraphViewModelLazyKt$navGraphViewModels$3 navGraphViewModelLazyKt$navGraphViewModels$3 = new NavGraphViewModelLazyKt$navGraphViewModels$3(function0, lazy);
        if (function02 == null) {
            function02 = new NavGraphViewModelLazyKt$navGraphViewModels$4(lazy);
        }
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, orCreateKotlinClass, navGraphViewModelLazyKt$navGraphViewModels$storeProducer$2, navGraphViewModelLazyKt$navGraphViewModels$3, function02);
    }

    public static /* synthetic */ Lazy navGraphViewModels$default(Fragment fragment, int i11, Function0 function0, Function0 function02, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            function0 = null;
        }
        if ((i12 & 4) != 0) {
            function02 = null;
        }
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Lazy lazy = LazyKt__LazyJVMKt.lazy(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$4(fragment, i11));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$2 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$2 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$2(lazy);
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
        NavGraphViewModelLazyKt$navGraphViewModels$3 navGraphViewModelLazyKt$navGraphViewModels$3 = new NavGraphViewModelLazyKt$navGraphViewModels$3(function0, lazy);
        if (function02 == null) {
            function02 = new NavGraphViewModelLazyKt$navGraphViewModels$4(lazy);
        }
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, orCreateKotlinClass, navGraphViewModelLazyKt$navGraphViewModels$storeProducer$2, navGraphViewModelLazyKt$navGraphViewModels$3, function02);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by navGraphViewModels that takes a CreationExtras producer")
    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> navGraphViewModels(Fragment fragment, String str, Function0<? extends ViewModelProvider.Factory> function0) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(str, "navGraphRoute");
        Lazy lazy = LazyKt__LazyJVMKt.lazy(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$6(fragment, str));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$3 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$3 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$3(lazy);
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
        NavGraphViewModelLazyKt$navGraphViewModels$5 navGraphViewModelLazyKt$navGraphViewModels$5 = new NavGraphViewModelLazyKt$navGraphViewModels$5(lazy);
        if (function0 == null) {
            function0 = new NavGraphViewModelLazyKt$navGraphViewModels$6(lazy);
        }
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, orCreateKotlinClass, navGraphViewModelLazyKt$navGraphViewModels$storeProducer$3, navGraphViewModelLazyKt$navGraphViewModels$5, function0);
    }

    public static /* synthetic */ Lazy navGraphViewModels$default(Fragment fragment, String str, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function0 = null;
        }
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(str, "navGraphRoute");
        Lazy lazy = LazyKt__LazyJVMKt.lazy(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$6(fragment, str));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$3 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$3 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$3(lazy);
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
        NavGraphViewModelLazyKt$navGraphViewModels$5 navGraphViewModelLazyKt$navGraphViewModels$5 = new NavGraphViewModelLazyKt$navGraphViewModels$5(lazy);
        if (function0 == null) {
            function0 = new NavGraphViewModelLazyKt$navGraphViewModels$6(lazy);
        }
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, orCreateKotlinClass, navGraphViewModelLazyKt$navGraphViewModels$storeProducer$3, navGraphViewModelLazyKt$navGraphViewModels$5, function0);
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> navGraphViewModels(Fragment fragment, String str, Function0<? extends CreationExtras> function0, Function0<? extends ViewModelProvider.Factory> function02) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(str, "navGraphRoute");
        Lazy lazy = LazyKt__LazyJVMKt.lazy(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$8(fragment, str));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$4 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$4 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$4(lazy);
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
        NavGraphViewModelLazyKt$navGraphViewModels$7 navGraphViewModelLazyKt$navGraphViewModels$7 = new NavGraphViewModelLazyKt$navGraphViewModels$7(function0, lazy);
        if (function02 == null) {
            function02 = new NavGraphViewModelLazyKt$navGraphViewModels$8(lazy);
        }
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, orCreateKotlinClass, navGraphViewModelLazyKt$navGraphViewModels$storeProducer$4, navGraphViewModelLazyKt$navGraphViewModels$7, function02);
    }

    public static /* synthetic */ Lazy navGraphViewModels$default(Fragment fragment, String str, Function0 function0, Function0 function02, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function0 = null;
        }
        if ((i11 & 4) != 0) {
            function02 = null;
        }
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(str, "navGraphRoute");
        Lazy lazy = LazyKt__LazyJVMKt.lazy(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$8(fragment, str));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$4 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$4 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$4(lazy);
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
        NavGraphViewModelLazyKt$navGraphViewModels$7 navGraphViewModelLazyKt$navGraphViewModels$7 = new NavGraphViewModelLazyKt$navGraphViewModels$7(function0, lazy);
        if (function02 == null) {
            function02 = new NavGraphViewModelLazyKt$navGraphViewModels$8(lazy);
        }
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, orCreateKotlinClass, navGraphViewModelLazyKt$navGraphViewModels$storeProducer$4, navGraphViewModelLazyKt$navGraphViewModels$7, function02);
    }
}
