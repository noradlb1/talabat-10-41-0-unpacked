package com.talabat.talabatcommon.views.customMvvmView;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.talabat.talabatcommon.exception.LifecycleOwnerNotFoundException;
import com.talabat.talabatcore.R;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005B%\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ/\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\u0002\b\u001eH\b¢\u0006\u0002\u0010\u001fJ\u0012\u0010 \u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\"H&J\u0014\u0010#\u001a\u00020\u000b2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H&J\b\u0010&\u001a\u00020\u001dH\u0016J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)H&J\b\u0010*\u001a\u00020\u001dH\u0014J\b\u0010+\u001a\u00020\u001dH\u0017J\b\u0010,\u001a\u00020\u001dH\u0017J\b\u0010-\u001a\u00020\u001dH\u0017J\u0010\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020\u000bH\u0002J\u0012\u00100\u001a\u0002012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u00102\u001a\u00020\u001dH\u0016J\r\u00103\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0015R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00028\u00008VX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u00064"}, d2 = {"Lcom/talabat/talabatcommon/views/customMvvmView/MvvmLinearLayout;", "VM", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "Landroid/widget/LinearLayout;", "Lcom/talabat/talabatcommon/views/customMvvmView/MvvmCustomView;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "setCoroutineScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "viewModel", "getViewModel", "()Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "createViewModel", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "body", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/lifecycle/ViewModelProvider$Factory;Lkotlin/jvm/functions/Function1;)Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "failureHere", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getLayoutId", "getViewModelClass", "Ljava/lang/Class;", "hideProgress", "observatory", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onAttachedToWindow", "onDestroy", "onPause", "onResume", "progressStatus", "viewStatus", "scanForActivity", "Landroidx/fragment/app/FragmentActivity;", "showProgress", "viewModelBuilder", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class MvvmLinearLayout<VM extends BaseViewModel> extends LinearLayout implements MvvmCustomView<VM>, LifecycleObserver {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    private CoroutineScope coroutineScope;
    @NotNull
    private final Lazy viewModel$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MvvmLinearLayout(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MvvmLinearLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MvvmLinearLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.viewModel$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new MvvmLinearLayout$viewModel$2(this));
        this.coroutineScope = new MvvmLinearLayout$coroutineScope$1();
        View.inflate(context, getLayoutId(attributeSet), this);
    }

    private final VM createViewModel(ViewModelProvider.Factory factory, Function1<? super VM, Unit> function1) {
        VM vm2 = (BaseViewModel) ViewModelProviders.of(scanForActivity(getContext()), factory).get(String.valueOf(getLayoutId$default(this, (AttributeSet) null, 1, (Object) null)), getViewModelClass());
        function1.invoke(vm2);
        return vm2;
    }

    public static /* synthetic */ int getLayoutId$default(MvvmLinearLayout mvvmLinearLayout, AttributeSet attributeSet, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                attributeSet = null;
            }
            return mvvmLinearLayout.getLayoutId(attributeSet);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLayoutId");
    }

    private final void progressStatus(int i11) {
        RelativeLayout relativeLayout = (RelativeLayout) getRootView().findViewById(R.id.genericProgressBarRootRelativeLayout);
        if (relativeLayout != null) {
            relativeLayout.setVisibility(i11);
        }
    }

    /* access modifiers changed from: private */
    public final FragmentActivity scanForActivity(Context context) {
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

    public abstract int getLayoutId(@Nullable AttributeSet attributeSet);

    @NotNull
    public VM getViewModel() {
        return (BaseViewModel) this.viewModel$delegate.getValue();
    }

    @NotNull
    public abstract Class<VM> getViewModelClass();

    public void hideProgress() {
        progressStatus(8);
    }

    public abstract void observatory(@NotNull LifecycleOwner lifecycleOwner);

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        FragmentActivity scanForActivity = scanForActivity(getContext());
        if (!(scanForActivity instanceof LifecycleOwner)) {
            scanForActivity = null;
        }
        if (scanForActivity != null) {
            onLifecycleOwnerAttached(scanForActivity);
            scanForActivity.getLifecycle().addObserver(this);
            observatory(scanForActivity);
            return;
        }
        throw new LifecycleOwnerNotFoundException();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
    }

    public final void setCoroutineScope(@NotNull CoroutineScope coroutineScope2) {
        Intrinsics.checkNotNullParameter(coroutineScope2, "<set-?>");
        this.coroutineScope = coroutineScope2;
    }

    public void showProgress() {
        progressStatus(0);
    }

    @NotNull
    public abstract VM viewModelBuilder();

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MvvmLinearLayout(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
