package com.talabat.darkstores.common.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.ToolbarKt;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$activityViewModel$$inlined$activityViewModels$default$1;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$activityViewModel$$inlined$activityViewModels$default$2;
import com.talabat.darkstores.common.view.ErrorView;
import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import com.talabat.darkstores.feature.tracking.EventOriginType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yh.b;

@Instrumented
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b?\u0010@J&\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0014J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0004J6\u0010\u001a\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0014*\b\u0012\u0004\u0012\u00028\u00000\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00162\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\u0018H\u0004JQ\u0010\u001f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0014*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b0\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00162'\u0010\u0019\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u001b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u000b0\u0018H\u0004J\n\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020\u000bH\u0016J\b\u0010&\u001a\u00020\u000bH\u0016J\b\u0010'\u001a\u00020\u000bH&R\u001b\u0010-\u001a\u00020(8FX\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R$\u00104\u001a\u00020.2\u0006\u0010/\u001a\u00020.8B@BX\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0014\u00106\u001a\u00020.8&X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u00101R\u0016\u0010:\u001a\u0004\u0018\u0001078&X¦\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8&X¦\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=¨\u0006A"}, d2 = {"Lcom/talabat/darkstores/common/base/BaseFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "view", "", "onViewCreated", "onDestroy", "outState", "onSaveInstanceState", "i0", "", "makeIconsDark", "e", "T", "Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lkotlin/Function1;", "block", "g", "Lcom/talabat/darkstores/common/Result;", "Lkotlin/ParameterName;", "name", "result", "f", "Lcom/talabat/darkstores/common/view/ErrorView;", "getErrorView", "", "error", "showError", "hideError", "onResume", "onRetryClicked", "Lcom/talabat/darkstores/feature/cart/CartFragmentViewModel;", "cartFragmentViewModel$delegate", "Lkotlin/Lazy;", "getCartFragmentViewModel", "()Lcom/talabat/darkstores/feature/cart/CartFragmentViewModel;", "cartFragmentViewModel", "", "value", "getSystemUiVisibility", "()I", "setSystemUiVisibility", "(I)V", "systemUiVisibility", "getContentViewId", "contentViewId", "", "getScreenName", "()Ljava/lang/String;", "screenName", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "getEventOriginType", "()Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "eventOriginType", "<init>", "()V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
public abstract class BaseFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @NotNull
    private final Lazy cartFragmentViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CartFragmentViewModel.class), new ViewModelFactoryExtensionsKt$activityViewModel$$inlined$activityViewModels$default$1(this), new ViewModelFactoryExtensionsKt$activityViewModel$$inlined$activityViewModels$default$2((Function0) null, this), new BaseFragment$special$$inlined$activityViewModel$1());

    private final int getSystemUiVisibility() {
        return requireActivity().getWindow().getDecorView().getSystemUiVisibility();
    }

    public static /* synthetic */ void observeHandleErrors$default(BaseFragment baseFragment, LiveData liveData, LifecycleOwner lifecycleOwner, Function1 function1, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                lifecycleOwner = baseFragment.getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "viewLifecycleOwner");
            }
            baseFragment.f(liveData, lifecycleOwner, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: observeHandleErrors");
    }

    public static /* synthetic */ void observeNonNull$default(BaseFragment baseFragment, LiveData liveData, LifecycleOwner lifecycleOwner, Function1 function1, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                lifecycleOwner = baseFragment.getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "viewLifecycleOwner");
            }
            baseFragment.g(liveData, lifecycleOwner, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: observeNonNull");
    }

    private final void setSystemUiVisibility(int i11) {
        requireActivity().getWindow().getDecorView().setSystemUiVisibility(i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: setupToolbar$lambda-1  reason: not valid java name */
    public static final boolean m9632setupToolbar$lambda1(BaseFragment baseFragment) {
        Intrinsics.checkNotNullParameter(baseFragment, "this$0");
        baseFragment.requireActivity().onBackPressed();
        return true;
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i11)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    public final void e(boolean z11) {
        int i11;
        requireActivity().getWindow().getDecorView();
        if (z11) {
            i11 = getSystemUiVisibility() | 8192;
        } else {
            i11 = getSystemUiVisibility() & -8193;
        }
        setSystemUiVisibility(i11);
    }

    public final <T> void f(@NotNull LiveData<Result<T>> liveData, @NotNull LifecycleOwner lifecycleOwner, @NotNull Function1<? super Result<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(function1, "block");
        g(liveData, lifecycleOwner, new BaseFragment$observeHandleErrors$1(this, function1));
    }

    public final <T> void g(@NotNull LiveData<T> liveData, @NotNull LifecycleOwner lifecycleOwner, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(function1, "block");
        liveData.observe(lifecycleOwner, new BaseFragment$observeNonNull$$inlined$observe$1(function1));
    }

    @NotNull
    public final CartFragmentViewModel getCartFragmentViewModel() {
        return (CartFragmentViewModel) this.cartFragmentViewModel$delegate.getValue();
    }

    public abstract int getContentViewId();

    @Nullable
    public ErrorView getErrorView() {
        return (ErrorView) requireActivity().findViewById(R.id.loadingFailedView);
    }

    @NotNull
    public abstract EventOriginType getEventOriginType();

    @Nullable
    public abstract String getScreenName();

    public void hideError() {
        FragmentActivity activity = getActivity();
        DarkstoresMainActivity darkstoresMainActivity = activity instanceof DarkstoresMainActivity ? (DarkstoresMainActivity) activity : null;
        if (darkstoresMainActivity != null) {
            darkstoresMainActivity.disposeError(new BaseFragment$hideError$1(this));
        }
    }

    public void i0() {
        Toolbar toolbar;
        View view = getView();
        if (view != null) {
            toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        } else {
            toolbar = null;
        }
        if (toolbar != null) {
            ToolbarKt.setupWithNavController(toolbar, FragmentKt.findNavController(this), new AppBarConfiguration.Builder(new int[0]).setFallbackOnNavigateUpListener(new b(this)).build());
        }
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "BaseFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "BaseFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(getContentViewId(), viewGroup, false);
        TraceMachine.exitMethod();
        return inflate;
    }

    public void onDestroy() {
        hideError();
        super.onDestroy();
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onResume() {
        super.onResume();
        getCartFragmentViewModel().trackScreenOpened(getScreenName(), getEventOriginType());
        getCartFragmentViewModel().updateEventOrigin(getEventOriginType());
    }

    public abstract void onRetryClicked();

    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        DarkstoresMainActivity darkstoresMainActivity;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        e(true);
        i0();
        FragmentActivity activity = getActivity();
        if (activity instanceof DarkstoresMainActivity) {
            darkstoresMainActivity = (DarkstoresMainActivity) activity;
        } else {
            darkstoresMainActivity = null;
        }
        if (darkstoresMainActivity != null) {
            darkstoresMainActivity.setErrorView(getErrorView());
        }
    }

    public void showError(@NotNull Throwable th2) {
        DarkstoresMainActivity darkstoresMainActivity;
        Intrinsics.checkNotNullParameter(th2, "error");
        FragmentActivity activity = getActivity();
        if (activity instanceof DarkstoresMainActivity) {
            darkstoresMainActivity = (DarkstoresMainActivity) activity;
        } else {
            darkstoresMainActivity = null;
        }
        if (darkstoresMainActivity != null) {
            darkstoresMainActivity.showError(th2, new BaseFragment$showError$1(this));
        }
    }
}
