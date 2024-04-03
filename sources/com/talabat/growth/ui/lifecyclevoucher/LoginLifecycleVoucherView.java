package com.talabat.growth.ui.lifecyclevoucher;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.flagskeys.GrowthFeatureFlagConstantKt;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.growth.databinding.LoginInfoContainerLifecycleVoucherBinding;
import com.talabat.growth.databinding.LoginInfoContainerLifecycleVoucherInfoBinding;
import com.talabat.growth.ui.lifecyclevoucher.di.DaggerLoginLifecycleVoucherViewComponent;
import com.talabat.growth.ui.lifecyclevoucher.factory.LoginLifecycleVoucherViewModelFactory;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.views.ShimmerLayout;
import com.talabat.talabatcore.testframework.ViewModelInjectorKt;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0014\u0010\u0019\u001a\u00020\u0016*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/talabat/growth/ui/lifecyclevoucher/LoginLifecycleVoucherView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/talabat/growth/databinding/LoginInfoContainerLifecycleVoucherBinding;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getFeatureFlagRepo", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setFeatureFlagRepo", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "viewModel", "Lcom/talabat/growth/ui/lifecyclevoucher/LoginLifecycleVoucherViewModel;", "getLifeCycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "init", "", "defaultLoginInfo", "Landroid/view/View;", "bindLifecycleVoucherView", "Lcom/talabat/growth/databinding/LoginInfoContainerLifecycleVoucherInfoBinding;", "it", "Lcom/talabat/growth/ui/lifecyclevoucher/LoginLifecycleVoucherDisplayModel;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoginLifecycleVoucherView extends FrameLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    /* access modifiers changed from: private */
    @NotNull
    public final LoginInfoContainerLifecycleVoucherBinding binding;
    @Inject
    public ITalabatFeatureFlag featureFlagRepo;
    /* access modifiers changed from: private */
    @NotNull
    public final LoginLifecycleVoucherViewModel viewModel;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LoginLifecycleVoucherView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LoginLifecycleVoucherView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LoginLifecycleVoucherView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        ViewModel viewModel2;
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        LoginLifecycleVoucherViewModelFactory newInstance = LoginLifecycleVoucherViewModelFactory.Companion.newInstance(context);
        Context context2 = getContext();
        Class cls = LoginLifecycleVoucherViewModel.class;
        Object obj = ViewModelInjectorKt.getTestDependencies().get(cls.getSimpleName());
        ViewModel viewModel3 = (LoginLifecycleVoucherViewModel) (!(obj instanceof LoginLifecycleVoucherViewModel) ? null : obj);
        if (viewModel3 == null) {
            if (context2 instanceof AppCompatActivity) {
                viewModel2 = ViewModelProviders.of((FragmentActivity) context2, (ViewModelProvider.Factory) newInstance).get(cls);
            } else if (context2 instanceof Fragment) {
                viewModel2 = ViewModelProviders.of((Fragment) context2, (ViewModelProvider.Factory) newInstance).get(cls);
            } else if (context2 instanceof ContextThemeWrapper) {
                ContextThemeWrapper contextThemeWrapper = (ContextThemeWrapper) context2;
                if (contextThemeWrapper.getBaseContext() instanceof AppCompatActivity) {
                    Context baseContext = contextThemeWrapper.getBaseContext();
                    if (baseContext != null) {
                        viewModel2 = ViewModelProviders.of((FragmentActivity) (AppCompatActivity) baseContext, (ViewModelProvider.Factory) newInstance).get(cls);
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
        this.viewModel = (LoginLifecycleVoucherViewModel) viewModel3;
        DaggerLoginLifecycleVoucherViewComponent.factory().create((FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(FeatureFlagCoreLibApi.class)).inject(this);
        LoginInfoContainerLifecycleVoucherBinding inflate = LoginInfoContainerLifecycleVoucherBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n            Lay…           true\n        )");
        this.binding = inflate;
    }

    /* access modifiers changed from: private */
    public final void bindLifecycleVoucherView(LoginInfoContainerLifecycleVoucherInfoBinding loginInfoContainerLifecycleVoucherInfoBinding, LoginLifecycleVoucherDisplayModel loginLifecycleVoucherDisplayModel) {
        LinearLayout root = loginInfoContainerLifecycleVoucherInfoBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "this.root");
        ShimmerLayout root2 = this.binding.lifeCycleVoucherLoginLoading.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.lifeCycleVoucherLoginLoading.root");
        ViewKt.crossFade(root, root2);
        loginInfoContainerLifecycleVoucherInfoBinding.voucherTag.setTagText(loginLifecycleVoucherDisplayModel.getTag());
        loginInfoContainerLifecycleVoucherInfoBinding.lifecycleVoucherTitle.setText(loginLifecycleVoucherDisplayModel.getTitle());
        loginInfoContainerLifecycleVoucherInfoBinding.lifecycleVoucherDescription.setText(loginLifecycleVoucherDisplayModel.getDescription());
        loginInfoContainerLifecycleVoucherInfoBinding.lifecycleVoucherTermsAndConditions.setText(loginLifecycleVoucherDisplayModel.getTermsAndConditions());
    }

    /* access modifiers changed from: private */
    public final LifecycleOwner getLifeCycleOwner() {
        LifecycleOwner lifecycleOwner;
        ContextThemeWrapper contextThemeWrapper;
        Context context;
        Context context2 = getContext();
        if (context2 instanceof LifecycleOwner) {
            lifecycleOwner = (LifecycleOwner) context2;
        } else {
            lifecycleOwner = null;
        }
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        Context context3 = getContext();
        if (context3 instanceof ContextThemeWrapper) {
            contextThemeWrapper = (ContextThemeWrapper) context3;
        } else {
            contextThemeWrapper = null;
        }
        if (contextThemeWrapper != null) {
            context = contextThemeWrapper.getBaseContext();
        } else {
            context = null;
        }
        if (context instanceof LifecycleOwner) {
            return (LifecycleOwner) context;
        }
        return null;
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

    @NotNull
    public final ITalabatFeatureFlag getFeatureFlagRepo() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.featureFlagRepo;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("featureFlagRepo");
        return null;
    }

    public final void init(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "defaultLoginInfo");
        getFeatureFlagRepo().getFeatureFlag((FWFKey) GrowthFeatureFlagConstantKt.FunWithFlagEnableLoginLifecycleVoucher, false, false, (Function1<? super Boolean, Unit>) new LoginLifecycleVoucherView$init$1(this, view));
    }

    public final void setFeatureFlagRepo(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.featureFlagRepo = iTalabatFeatureFlag;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LoginLifecycleVoucherView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
