package com.talabat.talabatcore;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import com.talabat.talabatcore.viewmodel.BaseViewModelFactory;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J/\u0010\u0015\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\u00162\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0002\b\u001aH\b¢\u0006\u0002\u0010\u001bJ\u0012\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000 H&J\b\u0010!\u001a\u00020\u0019H\u0016J\b\u0010\"\u001a\u00020\u0019H&J\b\u0010#\u001a\u00020\u0019H\u0016J\b\u0010$\u001a\u00020\u0019H\u0016J\u001a\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020\u0019H\u0016J\r\u0010.\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u00028\u0000X.¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006/"}, d2 = {"Lcom/talabat/talabatcore/TalabatBaseMvvmBottomSheetDialogFragment;", "VM", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "Lcom/talabat/talabatcore/TalabatBaseBottomSheetDialogFragment;", "()V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "factory", "Lcom/talabat/talabatcore/viewmodel/BaseViewModelFactory;", "getFactory", "()Lcom/talabat/talabatcore/viewmodel/BaseViewModelFactory;", "setFactory", "(Lcom/talabat/talabatcore/viewmodel/BaseViewModelFactory;)V", "viewModel", "getViewModel", "()Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "setViewModel", "(Lcom/talabat/talabatcore/viewmodel/BaseViewModel;)V", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "createViewModel", "Landroidx/lifecycle/ViewModelProvider$Factory;", "body", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/lifecycle/ViewModelProvider$Factory;Lkotlin/jvm/functions/Function1;)Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "failureHere", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getViewModelClass", "Ljava/lang/Class;", "hideProgress", "observatory", "onBottomSheetVisible", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "progressStatus", "viewStatus", "", "showProgress", "viewModelBuilder", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class TalabatBaseMvvmBottomSheetDialogFragment<VM extends BaseViewModel> extends TalabatBaseBottomSheetDialogFragment {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final CoroutineScope coroutineScope = new TalabatBaseMvvmBottomSheetDialogFragment$coroutineScope$1();
    @NotNull
    private BaseViewModelFactory<VM> factory = new BaseViewModelFactory<>(new TalabatBaseMvvmBottomSheetDialogFragment$factory$1(this));
    public VM viewModel;

    private final VM createViewModel(ViewModelProvider.Factory factory2, Function1<? super VM, Unit> function1) {
        VM vm2 = ViewModelProviders.of((Fragment) this, factory2).get(getViewModelClass());
        Intrinsics.checkNotNullExpressionValue(vm2, "ViewModelProviders.of(th…ory)[getViewModelClass()]");
        VM vm3 = (BaseViewModel) vm2;
        function1.invoke(vm3);
        return vm3;
    }

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

    public abstract void failureHere(@Nullable Failure failure);

    @NotNull
    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    @NotNull
    public final BaseViewModelFactory<VM> getFactory() {
        return this.factory;
    }

    @NotNull
    public final VM getViewModel() {
        VM vm2 = this.viewModel;
        if (vm2 != null) {
            return vm2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    @NotNull
    public abstract Class<VM> getViewModelClass();

    public void hideProgress() {
        progressStatus(8);
    }

    public abstract void observatory();

    public void onBottomSheetVisible() {
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onResume() {
        super.onResume();
        onBottomSheetVisible();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ViewModel viewModel2 = ViewModelProviders.of((Fragment) this, (ViewModelProvider.Factory) this.factory).get(getViewModelClass());
        Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProviders.of(th…ory)[getViewModelClass()]");
        setViewModel((BaseViewModel) viewModel2);
        LifecycleKt.failure(this, getViewModel().getFailureData(), new TalabatBaseMvvmBottomSheetDialogFragment$onViewCreated$2(this));
        observatory();
    }

    public final void setFactory(@NotNull BaseViewModelFactory<VM> baseViewModelFactory) {
        Intrinsics.checkNotNullParameter(baseViewModelFactory, "<set-?>");
        this.factory = baseViewModelFactory;
    }

    public final void setViewModel(@NotNull VM vm2) {
        Intrinsics.checkNotNullParameter(vm2, "<set-?>");
        this.viewModel = vm2;
    }

    public void showProgress() {
        progressStatus(0);
    }

    @NotNull
    public abstract VM viewModelBuilder();
}
