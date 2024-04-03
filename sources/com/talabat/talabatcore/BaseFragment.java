package com.talabat.talabatcore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatcore.testframework.ViewModelInjectorKt;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import com.talabat.talabatcore.viewmodel.BaseViewModelFactory;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H&J\u000f\u0010\t\u001a\u00028\u0000H&¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH&J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\b\u0010\u0010\u001a\u00020\u0006H&J$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016R\"\u0010#\u001a\u00028\u00008\u0004@\u0004X.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\"R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000$8\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u00060"}, d2 = {"Lcom/talabat/talabatcore/BaseFragment;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "VM", "Landroidx/fragment/app/Fragment;", "", "viewStatus", "", "progressStatus", "layoutId", "viewModelBuilder", "()Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "Ljava/lang/Class;", "getViewModelClass", "Lcom/talabat/talabatcore/exception/Failure;", "failure", "failureHere", "observatory", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "onBackPressed", "showProgress", "hideProgress", "C", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "getViewModel", "setViewModel", "(Lcom/talabat/talabatcore/viewmodel/BaseViewModel;)V", "viewModel", "Lcom/talabat/talabatcore/viewmodel/BaseViewModelFactory;", "factory", "Lcom/talabat/talabatcore/viewmodel/BaseViewModelFactory;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "setCoroutineScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "<init>", "()V", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0})
@Deprecated(message = "This class will be deleted in near future. Please use BaseFragmentVB which supports ViewBinding.")
public abstract class BaseFragment extends Fragment implements TraceFieldInterface {
    public BaseViewModel C;
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @NotNull
    private CoroutineScope coroutineScope = new BaseFragment$coroutineScope$1();
    @NotNull
    private final BaseViewModelFactory<BaseViewModel> factory = new BaseViewModelFactory<>(new BaseFragment$factory$1(this));

    private final void progressStatus(int i11) {
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(R.id.genericProgressBarRootRelativeLayout);
        if (relativeLayout != null) {
            relativeLayout.setVisibility(i11);
        }
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

    public abstract void failureHere(@Nullable Failure failure);

    @NotNull
    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    @NotNull
    public final BaseViewModel getViewModel() {
        BaseViewModel baseViewModel = this.C;
        if (baseViewModel != null) {
            return baseViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    @NotNull
    public abstract Class<BaseViewModel> getViewModelClass();

    public void hideProgress() {
        progressStatus(8);
    }

    public abstract int layoutId();

    public abstract void observatory();

    public void onBackPressed() {
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "BaseFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "BaseFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(layoutId(), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(layoutId(), container, false)");
        TraceMachine.exitMethod();
        return inflate;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        setViewModel((BaseViewModel) ViewModelInjectorKt.injectViewModel((Fragment) this, getViewModelClass(), (ViewModelProvider.Factory) this.factory));
        LifecycleKt.failure(this, getViewModel().getFailureData(), new BaseFragment$onViewCreated$1(this));
        observatory();
    }

    public final void setViewModel(@NotNull BaseViewModel baseViewModel) {
        Intrinsics.checkNotNullParameter(baseViewModel, "<set-?>");
        this.C = baseViewModel;
    }

    public void showProgress() {
        progressStatus(0);
    }

    @NotNull
    public abstract BaseViewModel viewModelBuilder();
}
