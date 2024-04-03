package com.talabat.verticals.helper.customMvvmView;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import com.talabat.talabatcore.viewmodel.BaseViewModelFactory;
import com.talabat.verticals.helper.exception.LifecycleOwnerNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ/\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\u0002\b\u001eH\b¢\u0006\u0002\u0010\u001fJ\u0012\u0010 \u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\"H&J\b\u0010#\u001a\u00020$H&J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000&H&J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)H&J\b\u0010*\u001a\u00020\u001dH\u0014J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)H&J\u0012\u0010,\u001a\u00020-2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\r\u0010.\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0014R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u00028\u0000X.¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006/"}, d2 = {"Lcom/talabat/verticals/helper/customMvvmView/MvvmLinearLayout;", "VM", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "Landroid/widget/LinearLayout;", "Lcom/talabat/verticals/helper/customMvvmView/MvvmCustomView;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "setCoroutineScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "mFactory", "Lcom/talabat/talabatcore/viewmodel/BaseViewModelFactory;", "viewModel", "getViewModel", "()Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "setViewModel", "(Lcom/talabat/talabatcore/viewmodel/BaseViewModel;)V", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "createViewModel", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "body", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/lifecycle/ViewModelProvider$Factory;Lkotlin/jvm/functions/Function1;)Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "failureHere", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getLayoutId", "", "getViewModelClass", "Ljava/lang/Class;", "observatory", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onAttachedToWindow", "onViewInitiated", "scanForActivity", "Landroidx/fragment/app/FragmentActivity;", "viewModelBuilder", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class MvvmLinearLayout<VM extends BaseViewModel> extends LinearLayout implements MvvmCustomView<VM> {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private CoroutineScope coroutineScope;
    @NotNull
    private final BaseViewModelFactory<VM> mFactory;
    public VM viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MvvmLinearLayout(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        LifecycleOwner lifecycleOwner;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        BaseViewModelFactory<VM> baseViewModelFactory = new BaseViewModelFactory<>(new MvvmLinearLayout$mFactory$1(this));
        this.mFactory = baseViewModelFactory;
        this.coroutineScope = new MvvmLinearLayout$coroutineScope$1();
        View.inflate(context, getLayoutId(), this);
        setViewModel((BaseViewModel) ViewModelProviders.of(scanForActivity(getContext()), (ViewModelProvider.Factory) baseViewModelFactory).get(String.valueOf(getLayoutId()), getViewModelClass()));
        if (context instanceof LifecycleOwner) {
            lifecycleOwner = (LifecycleOwner) context;
        } else {
            lifecycleOwner = null;
        }
        if (lifecycleOwner != null) {
            onViewInitiated(lifecycleOwner);
            return;
        }
        throw new LifecycleOwnerNotFoundException();
    }

    private final VM createViewModel(ViewModelProvider.Factory factory, Function1<? super VM, Unit> function1) {
        VM vm2 = (BaseViewModel) ViewModelProviders.of(scanForActivity(getContext()), factory).get(String.valueOf(getLayoutId()), getViewModelClass());
        function1.invoke(vm2);
        return vm2;
    }

    private final FragmentActivity scanForActivity(Context context) {
        if (context instanceof FragmentActivity) {
            return (FragmentActivity) context;
        }
        if (context instanceof ContextWrapper) {
            return scanForActivity(((ContextWrapper) context).getBaseContext());
        }
        throw new IllegalArgumentException("Context must be a FragmentActivity!");
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
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

    public abstract int getLayoutId();

    @NotNull
    public VM getViewModel() {
        VM vm2 = this.viewModel;
        if (vm2 != null) {
            return vm2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    @NotNull
    public abstract Class<VM> getViewModelClass();

    public abstract void observatory(@NotNull LifecycleOwner lifecycleOwner);

    public void onAttachedToWindow() {
        LifecycleOwner lifecycleOwner;
        super.onAttachedToWindow();
        Context context = getContext();
        if (context instanceof LifecycleOwner) {
            lifecycleOwner = (LifecycleOwner) context;
        } else {
            lifecycleOwner = null;
        }
        if (lifecycleOwner != null) {
            onLifecycleOwnerAttached(lifecycleOwner);
            return;
        }
        throw new LifecycleOwnerNotFoundException();
    }

    public abstract void onViewInitiated(@NotNull LifecycleOwner lifecycleOwner);

    public final void setCoroutineScope(@NotNull CoroutineScope coroutineScope2) {
        Intrinsics.checkNotNullParameter(coroutineScope2, "<set-?>");
        this.coroutineScope = coroutineScope2;
    }

    public void setViewModel(@NotNull VM vm2) {
        Intrinsics.checkNotNullParameter(vm2, "<set-?>");
        this.viewModel = vm2;
    }

    @NotNull
    public abstract VM viewModelBuilder();
}
