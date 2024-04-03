package com.talabat.talabatcore.testframework;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\n\u001a\u0002H\u000b\"\n\b\u0000\u0010\u000b\u0018\u0001*\u00020\f*\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\b¢\u0006\u0002\u0010\u0010\u001a*\u0010\n\u001a\u0002H\u000b\"\n\b\u0000\u0010\u000b\u0018\u0001*\u00020\f*\u00020\u00112\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\b¢\u0006\u0002\u0010\u0012\u001a5\u0010\n\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f*\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00142\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0015\u001a*\u0010\n\u001a\u0002H\u000b\"\n\b\u0000\u0010\u000b\u0018\u0001*\u00020\f*\u00020\u00162\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\b¢\u0006\u0002\u0010\u0017\u001a5\u0010\n\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f*\u00020\u00162\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00142\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0018\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"7\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0004`\u00058FX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"SHARED_VIEW_MODEL_PREFIX", "", "testDependencies", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getTestDependencies", "()Ljava/util/HashMap;", "testDependencies$delegate", "Lkotlin/Lazy;", "injectViewModel", "VM", "Landroidx/lifecycle/ViewModel;", "Landroid/view/View;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "(Landroid/view/View;Landroidx/lifecycle/ViewModelProvider$Factory;)Landroidx/lifecycle/ViewModel;", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/ViewModelProvider$Factory;)Landroidx/lifecycle/ViewModel;", "type", "Ljava/lang/Class;", "(Landroidx/fragment/app/Fragment;Ljava/lang/Class;Landroidx/lifecycle/ViewModelProvider$Factory;)Landroidx/lifecycle/ViewModel;", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;Landroidx/lifecycle/ViewModelProvider$Factory;)Landroidx/lifecycle/ViewModel;", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/Class;Landroidx/lifecycle/ViewModelProvider$Factory;)Landroidx/lifecycle/ViewModel;", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ViewModelInjectorKt {
    @NotNull
    public static final String SHARED_VIEW_MODEL_PREFIX = "*";
    @NotNull
    private static final Lazy testDependencies$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, ViewModelInjectorKt$testDependencies$2.INSTANCE);

    @NotNull
    public static final HashMap<String, Object> getTestDependencies() {
        return (HashMap) testDependencies$delegate.getValue();
    }

    @ViewModelsInjection(apiVersion = 1)
    public static final /* synthetic */ <VM extends ViewModel> VM injectViewModel(FragmentActivity fragmentActivity, ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        VM vm2 = getTestDependencies().get(fragmentActivity.getClass().getName());
        Intrinsics.reifiedOperationMarker(2, "VM");
        VM vm3 = (ViewModel) vm2;
        if (vm3 != null) {
            return vm3;
        }
        ViewModelProvider of2 = ViewModelProviders.of(fragmentActivity, factory);
        Intrinsics.reifiedOperationMarker(4, "VM");
        VM vm4 = of2.get(ViewModel.class);
        Intrinsics.checkNotNullExpressionValue(vm4, "ViewModelProviders.of(th… factory)[VM::class.java]");
        return vm4;
    }

    public static /* synthetic */ ViewModel injectViewModel$default(FragmentActivity fragmentActivity, ViewModelProvider.Factory factory, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            factory = null;
        }
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        Object obj2 = getTestDependencies().get(fragmentActivity.getClass().getName());
        Intrinsics.reifiedOperationMarker(2, "VM");
        ViewModel viewModel = (ViewModel) obj2;
        if (viewModel != null) {
            return viewModel;
        }
        ViewModelProvider of2 = ViewModelProviders.of(fragmentActivity, factory);
        Intrinsics.reifiedOperationMarker(4, "VM");
        ViewModel viewModel2 = of2.get(ViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProviders.of(th… factory)[VM::class.java]");
        return viewModel2;
    }

    @ViewModelsInjection(apiVersion = 1)
    public static final /* synthetic */ <VM extends ViewModel> VM injectViewModel(Fragment fragment, ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        VM vm2 = getTestDependencies().get(fragment.getClass().getName());
        Intrinsics.reifiedOperationMarker(2, "VM");
        VM vm3 = (ViewModel) vm2;
        if (vm3 != null) {
            return vm3;
        }
        ViewModelProvider of2 = ViewModelProviders.of(fragment, factory);
        Intrinsics.reifiedOperationMarker(4, "VM");
        VM vm4 = of2.get(ViewModel.class);
        Intrinsics.checkNotNullExpressionValue(vm4, "ViewModelProviders.of(th… factory)[VM::class.java]");
        return vm4;
    }

    public static /* synthetic */ ViewModel injectViewModel$default(Fragment fragment, ViewModelProvider.Factory factory, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            factory = null;
        }
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Object obj2 = getTestDependencies().get(fragment.getClass().getName());
        Intrinsics.reifiedOperationMarker(2, "VM");
        ViewModel viewModel = (ViewModel) obj2;
        if (viewModel != null) {
            return viewModel;
        }
        ViewModelProvider of2 = ViewModelProviders.of(fragment, factory);
        Intrinsics.reifiedOperationMarker(4, "VM");
        ViewModel viewModel2 = of2.get(ViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProviders.of(th… factory)[VM::class.java]");
        return viewModel2;
    }

    @NotNull
    @ViewModelsInjection(apiVersion = 1)
    public static final <VM extends ViewModel> VM injectViewModel(@NotNull FragmentActivity fragmentActivity, @NotNull Class<VM> cls, @Nullable ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        Intrinsics.checkNotNullParameter(cls, "type");
        VM vm2 = getTestDependencies().get(fragmentActivity.getClass().getName());
        VM vm3 = vm2 instanceof ViewModel ? (ViewModel) vm2 : null;
        if (vm3 != null) {
            return vm3;
        }
        VM vm4 = ViewModelProviders.of(fragmentActivity, factory).get(cls);
        Intrinsics.checkNotNullExpressionValue(vm4, "ViewModelProviders.of(this, factory)[type]");
        return vm4;
    }

    @NotNull
    @ViewModelsInjection(apiVersion = 1)
    public static final <VM extends ViewModel> VM injectViewModel(@NotNull Fragment fragment, @NotNull Class<VM> cls, @Nullable ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(cls, "type");
        VM vm2 = getTestDependencies().get(fragment.getClass().getName());
        VM vm3 = vm2 instanceof ViewModel ? (ViewModel) vm2 : null;
        if (vm3 != null) {
            return vm3;
        }
        VM vm4 = ViewModelProviders.of(fragment, factory).get(cls);
        Intrinsics.checkNotNullExpressionValue(vm4, "ViewModelProviders.of(this, factory)[type]");
        return vm4;
    }

    @ViewModelsInjection(apiVersion = 1)
    public static final /* synthetic */ <VM extends ViewModel> VM injectViewModel(View view, ViewModelProvider.Factory factory) {
        VM vm2;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        HashMap<String, Object> testDependencies = getTestDependencies();
        Intrinsics.reifiedOperationMarker(4, "VM");
        Class<ViewModel> cls = ViewModel.class;
        VM vm3 = testDependencies.get(cls.getSimpleName());
        Intrinsics.reifiedOperationMarker(2, "VM");
        VM vm4 = (ViewModel) vm3;
        if (vm4 == null) {
            if (context instanceof AppCompatActivity) {
                ViewModelProvider of2 = ViewModelProviders.of((FragmentActivity) context, factory);
                Intrinsics.reifiedOperationMarker(4, "VM");
                vm2 = of2.get(cls);
            } else if (context instanceof Fragment) {
                ViewModelProvider of3 = ViewModelProviders.of((Fragment) context, factory);
                Intrinsics.reifiedOperationMarker(4, "VM");
                vm2 = of3.get(cls);
            } else if (context instanceof ContextThemeWrapper) {
                ContextThemeWrapper contextThemeWrapper = (ContextThemeWrapper) context;
                if (contextThemeWrapper.getBaseContext() instanceof AppCompatActivity) {
                    Context baseContext = contextThemeWrapper.getBaseContext();
                    if (baseContext != null) {
                        ViewModelProvider of4 = ViewModelProviders.of((FragmentActivity) (AppCompatActivity) baseContext, factory);
                        Intrinsics.reifiedOperationMarker(4, "VM");
                        vm2 = of4.get(cls);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                    }
                } else {
                    throw new UnsupportedOperationException("ViewModelProviders works with Activities and Fragment hosts only");
                }
            } else {
                throw new UnsupportedOperationException("ViewModelProviders works with Activities and Fragment hosts only");
            }
            vm4 = vm2;
            Intrinsics.checkNotNullExpressionValue(vm4, "when (host) {\n        is…sts only\"\n        )\n    }");
        }
        return vm4;
    }

    public static /* synthetic */ ViewModel injectViewModel$default(FragmentActivity fragmentActivity, Class cls, ViewModelProvider.Factory factory, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            factory = null;
        }
        return injectViewModel(fragmentActivity, cls, factory);
    }

    public static /* synthetic */ ViewModel injectViewModel$default(Fragment fragment, Class cls, ViewModelProvider.Factory factory, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            factory = null;
        }
        return injectViewModel(fragment, cls, factory);
    }

    public static /* synthetic */ ViewModel injectViewModel$default(View view, ViewModelProvider.Factory factory, int i11, Object obj) {
        ViewModel viewModel;
        if ((i11 & 1) != 0) {
            factory = null;
        }
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        HashMap<String, Object> testDependencies = getTestDependencies();
        Intrinsics.reifiedOperationMarker(4, "VM");
        Class<ViewModel> cls = ViewModel.class;
        Object obj2 = testDependencies.get(cls.getSimpleName());
        Intrinsics.reifiedOperationMarker(2, "VM");
        ViewModel viewModel2 = (ViewModel) obj2;
        if (viewModel2 == null) {
            if (context instanceof AppCompatActivity) {
                ViewModelProvider of2 = ViewModelProviders.of((FragmentActivity) context, factory);
                Intrinsics.reifiedOperationMarker(4, "VM");
                viewModel = of2.get(cls);
            } else if (context instanceof Fragment) {
                ViewModelProvider of3 = ViewModelProviders.of((Fragment) context, factory);
                Intrinsics.reifiedOperationMarker(4, "VM");
                viewModel = of3.get(cls);
            } else if (context instanceof ContextThemeWrapper) {
                ContextThemeWrapper contextThemeWrapper = (ContextThemeWrapper) context;
                if (contextThemeWrapper.getBaseContext() instanceof AppCompatActivity) {
                    Context baseContext = contextThemeWrapper.getBaseContext();
                    if (baseContext != null) {
                        ViewModelProvider of4 = ViewModelProviders.of((FragmentActivity) (AppCompatActivity) baseContext, factory);
                        Intrinsics.reifiedOperationMarker(4, "VM");
                        viewModel = of4.get(cls);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                    }
                } else {
                    throw new UnsupportedOperationException("ViewModelProviders works with Activities and Fragment hosts only");
                }
            } else {
                throw new UnsupportedOperationException("ViewModelProviders works with Activities and Fragment hosts only");
            }
            viewModel2 = viewModel;
            Intrinsics.checkNotNullExpressionValue(viewModel2, "when (host) {\n        is…sts only\"\n        )\n    }");
        }
        return viewModel2;
    }
}
