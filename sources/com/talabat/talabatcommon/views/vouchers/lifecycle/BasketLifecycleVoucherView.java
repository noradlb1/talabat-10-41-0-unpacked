package com.talabat.talabatcommon.views.vouchers.lifecycle;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.testframework.ViewModelInjectorKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vv.a;
import vv.b;
import vv.c;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\"\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010J\u0016\u0010\u0012\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/lifecycle/BasketLifecycleVoucherView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewModel", "Lcom/talabat/talabatcommon/views/vouchers/lifecycle/BasketLifecycleVoucherViewModel;", "initiateView", "", "redirectToLoginAction", "Lkotlin/Function0;", "onErrorAction", "setupUi", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BasketLifecycleVoucherView extends FrameLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final BasketLifecycleVoucherViewModel viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BasketLifecycleVoucherView(@NotNull Context context) {
        super(context);
        ViewModel viewModel2;
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Class cls = BasketLifecycleVoucherViewModel.class;
        Object obj = ViewModelInjectorKt.getTestDependencies().get(cls.getSimpleName());
        ViewModel viewModel3 = (BasketLifecycleVoucherViewModel) (!(obj instanceof BasketLifecycleVoucherViewModel) ? null : obj);
        if (viewModel3 == null) {
            if (context2 instanceof AppCompatActivity) {
                viewModel2 = ViewModelProviders.of((FragmentActivity) context2, (ViewModelProvider.Factory) null).get(cls);
            } else if (context2 instanceof Fragment) {
                viewModel2 = ViewModelProviders.of((Fragment) context2, (ViewModelProvider.Factory) null).get(cls);
            } else if (context2 instanceof ContextThemeWrapper) {
                ContextThemeWrapper contextThemeWrapper = (ContextThemeWrapper) context2;
                if (contextThemeWrapper.getBaseContext() instanceof AppCompatActivity) {
                    Context baseContext = contextThemeWrapper.getBaseContext();
                    if (baseContext != null) {
                        viewModel2 = ViewModelProviders.of((FragmentActivity) (AppCompatActivity) baseContext, (ViewModelProvider.Factory) null).get(cls);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                    }
                } else {
                    throw new UnsupportedOperationException("ViewModelProviders works with Activities and Fragment hosts only");
                }
            } else {
                throw new UnsupportedOperationException("ViewModelProviders works with Activities and Fragment hosts only");
            }
            viewModel3 = viewModel2;
            Intrinsics.checkNotNullExpressionValue(viewModel3, "when (host) {\n        is…sts only\"\n        )\n    }");
        }
        this.viewModel = (BasketLifecycleVoucherViewModel) viewModel3;
        LayoutInflater.from(getContext()).inflate(R.layout.basket_lifecycle_voucher_view, this, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: initiateView$lambda-4  reason: not valid java name */
    public static final void m5785initiateView$lambda4(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$redirectToLoginAction");
        function0.invoke();
    }

    private final void setupUi(Function0<Unit> function0) {
        LifecycleOwner lifecycleOwner;
        BasketLifecycleVoucherViewModel basketLifecycleVoucherViewModel = this.viewModel;
        basketLifecycleVoucherViewModel.getWelcomeVoucherData$com_talabat_NewArchi_TalabatCommon_TalabatCommon();
        Context context = getContext();
        if (context instanceof LifecycleOwner) {
            lifecycleOwner = (LifecycleOwner) context;
        } else {
            lifecycleOwner = null;
        }
        if (lifecycleOwner != null) {
            basketLifecycleVoucherViewModel.getVoucherDataLiveData().observe(lifecycleOwner, new b(this));
            basketLifecycleVoucherViewModel.getFailureData().observe(lifecycleOwner, new c(function0));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setupUi$lambda-3$lambda-2$lambda-0  reason: not valid java name */
    public static final void m5786setupUi$lambda3$lambda2$lambda0(BasketLifecycleVoucherView basketLifecycleVoucherView, String str) {
        Intrinsics.checkNotNullParameter(basketLifecycleVoucherView, "this$0");
        basketLifecycleVoucherView.setVisibility(0);
        ((TextView) basketLifecycleVoucherView._$_findCachedViewById(R.id.welcomeVoucherTitleTextView)).setText(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: setupUi$lambda-3$lambda-2$lambda-1  reason: not valid java name */
    public static final void m5787setupUi$lambda3$lambda2$lambda1(Function0 function0, Failure failure) {
        Intrinsics.checkNotNullParameter(function0, "$onErrorAction");
        function0.invoke();
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

    public final void initiateView(@NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(function0, "redirectToLoginAction");
        Intrinsics.checkNotNullParameter(function02, "onErrorAction");
        setupUi(function02);
        ((TextView) _$_findCachedViewById(R.id.welcomeVoucherLoginButton)).setOnClickListener(new a(function0));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BasketLifecycleVoucherView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        ViewModel viewModel2;
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Class cls = BasketLifecycleVoucherViewModel.class;
        Object obj = ViewModelInjectorKt.getTestDependencies().get(cls.getSimpleName());
        ViewModel viewModel3 = (BasketLifecycleVoucherViewModel) (!(obj instanceof BasketLifecycleVoucherViewModel) ? null : obj);
        if (viewModel3 == null) {
            if (context2 instanceof AppCompatActivity) {
                viewModel2 = ViewModelProviders.of((FragmentActivity) context2, (ViewModelProvider.Factory) null).get(cls);
            } else if (context2 instanceof Fragment) {
                viewModel2 = ViewModelProviders.of((Fragment) context2, (ViewModelProvider.Factory) null).get(cls);
            } else if (context2 instanceof ContextThemeWrapper) {
                ContextThemeWrapper contextThemeWrapper = (ContextThemeWrapper) context2;
                if (contextThemeWrapper.getBaseContext() instanceof AppCompatActivity) {
                    Context baseContext = contextThemeWrapper.getBaseContext();
                    if (baseContext != null) {
                        viewModel2 = ViewModelProviders.of((FragmentActivity) (AppCompatActivity) baseContext, (ViewModelProvider.Factory) null).get(cls);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                    }
                } else {
                    throw new UnsupportedOperationException("ViewModelProviders works with Activities and Fragment hosts only");
                }
            } else {
                throw new UnsupportedOperationException("ViewModelProviders works with Activities and Fragment hosts only");
            }
            viewModel3 = viewModel2;
            Intrinsics.checkNotNullExpressionValue(viewModel3, "when (host) {\n        is…sts only\"\n        )\n    }");
        }
        this.viewModel = (BasketLifecycleVoucherViewModel) viewModel3;
        LayoutInflater.from(getContext()).inflate(R.layout.basket_lifecycle_voucher_view, this, true);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BasketLifecycleVoucherView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        ViewModel viewModel2;
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Class cls = BasketLifecycleVoucherViewModel.class;
        Object obj = ViewModelInjectorKt.getTestDependencies().get(cls.getSimpleName());
        ViewModel viewModel3 = (BasketLifecycleVoucherViewModel) (!(obj instanceof BasketLifecycleVoucherViewModel) ? null : obj);
        if (viewModel3 == null) {
            if (context2 instanceof AppCompatActivity) {
                viewModel2 = ViewModelProviders.of((FragmentActivity) context2, (ViewModelProvider.Factory) null).get(cls);
            } else if (context2 instanceof Fragment) {
                viewModel2 = ViewModelProviders.of((Fragment) context2, (ViewModelProvider.Factory) null).get(cls);
            } else if (context2 instanceof ContextThemeWrapper) {
                ContextThemeWrapper contextThemeWrapper = (ContextThemeWrapper) context2;
                if (contextThemeWrapper.getBaseContext() instanceof AppCompatActivity) {
                    Context baseContext = contextThemeWrapper.getBaseContext();
                    if (baseContext != null) {
                        viewModel2 = ViewModelProviders.of((FragmentActivity) (AppCompatActivity) baseContext, (ViewModelProvider.Factory) null).get(cls);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                    }
                } else {
                    throw new UnsupportedOperationException("ViewModelProviders works with Activities and Fragment hosts only");
                }
            } else {
                throw new UnsupportedOperationException("ViewModelProviders works with Activities and Fragment hosts only");
            }
            viewModel3 = viewModel2;
            Intrinsics.checkNotNullExpressionValue(viewModel3, "when (host) {\n        is…sts only\"\n        )\n    }");
        }
        this.viewModel = (BasketLifecycleVoucherViewModel) viewModel3;
        LayoutInflater.from(getContext()).inflate(R.layout.basket_lifecycle_voucher_view, this, true);
    }
}
