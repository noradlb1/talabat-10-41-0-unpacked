package com.talabat.feature.tpro.presentation.checkout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewKt;
import androidx.lifecycle.ViewModelLazy;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.model.SubscriptionMultiPlan;
import com.talabat.feature.tpro.presentation.databinding.ViewSubscriptionAtCheckoutBannerBinding;
import com.talabat.feature.tpro.presentation.di.DaggerTproPresentationComponent;
import com.talabat.feature.tpro.presentation.di.TproPresentationComponent;
import com.talabat.feature.tpro.presentation.model.SubscriptionsErrorDisplayModel;
import com.talabat.feature.tpro.presentation.util.SubscriptionsErrorMapper;
import com.talabat.localization.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uo.a;
import uo.b;
import uo.c;
import uo.d;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u001b\u001a\u00020\u000eJ\u0006\u0010\u001c\u001a\u00020\u000eJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\fH\u0002J\u0006\u0010 \u001a\u00020\u001eJ\b\u0010!\u001a\u00020\u001eH\u0002J\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u00020\u001eH\u0014J\u001a\u0010%\u001a\u00020\u001e2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001e0'J\u001a\u0010(\u001a\u00020\u001e2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001e0'J\u0010\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,H\u0002J\u000e\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020#J\u0017\u0010/\u001a\u0004\u0018\u00010\u001e2\u0006\u00100\u001a\u00020\u000eH\u0002¢\u0006\u0002\u00101J\u0006\u00102\u001a\u00020\u001eR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u00063"}, d2 = {"Lcom/talabat/feature/tpro/presentation/checkout/SubscriptionAtCheckoutBannerView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/talabat/feature/tpro/presentation/databinding/ViewSubscriptionAtCheckoutBannerBinding;", "subscriptionMultiPlan", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionMultiPlan;", "termsUrl", "", "viewModel", "Lcom/talabat/feature/tpro/presentation/checkout/SubscriptionAtCheckoutBannerViewModel;", "getViewModel", "()Lcom/talabat/feature/tpro/presentation/checkout/SubscriptionAtCheckoutBannerViewModel;", "viewModel$delegate", "Landroidx/lifecycle/ViewModelLazy;", "viewModelFactory", "Lcom/talabat/feature/tpro/presentation/checkout/SubscriptionAtCheckoutBannerViewModelFactory;", "getViewModelFactory", "()Lcom/talabat/feature/tpro/presentation/checkout/SubscriptionAtCheckoutBannerViewModelFactory;", "setViewModelFactory", "(Lcom/talabat/feature/tpro/presentation/checkout/SubscriptionAtCheckoutBannerViewModelFactory;)V", "getFreeTrialText", "getPlanId", "handleMultiPlan", "", "plan", "hideSubscriptionAtCheckoutBannerView", "initDagger", "isSubscriptionOnCheckoutSelectorChecked", "", "onAttachedToWindow", "setOnCheckedChangeListenerForCheckout", "onCheckedChange", "Lkotlin/Function1;", "setTermsAndConditionsClick", "onTermsAndConditionsClick", "setupObservers", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "shouldShowSubscriptionBanner", "doesMyBasketMeetsMOV", "showError", "errorCode", "(Ljava/lang/String;)Lkotlin/Unit;", "showSubscriptionAtCheckoutBannerView", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionAtCheckoutBannerView extends RelativeLayout {
    @NotNull
    private final ViewSubscriptionAtCheckoutBannerBinding binding;
    private SubscriptionMultiPlan subscriptionMultiPlan;
    private String termsUrl;
    @NotNull
    private final ViewModelLazy viewModel$delegate;
    @Inject
    public SubscriptionAtCheckoutBannerViewModelFactory viewModelFactory;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SubscriptionAtCheckoutBannerView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SubscriptionAtCheckoutBannerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionAtCheckoutBannerView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final SubscriptionAtCheckoutBannerViewModel getViewModel() {
        return (SubscriptionAtCheckoutBannerViewModel) this.viewModel$delegate.getValue();
    }

    private final void handleMultiPlan(SubscriptionMultiPlan subscriptionMultiPlan2) {
        SubscriptionMultiPlan subscriptionMultiPlan3;
        RelativeLayout relativeLayout = this.binding.subscriptionAtCheckoutBannerLayout;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.subscriptionAtCheckoutBannerLayout");
        relativeLayout.setVisibility(0);
        this.subscriptionMultiPlan = subscriptionMultiPlan2;
        if (subscriptionMultiPlan2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscriptionMultiPlan");
            subscriptionMultiPlan3 = null;
        } else {
            subscriptionMultiPlan3 = subscriptionMultiPlan2;
        }
        this.termsUrl = subscriptionMultiPlan3.getTermsUrl();
        String string = getResources().getString(R.string.tpro_trial_plan_price, new Object[]{subscriptionMultiPlan2.getFreeTrialInfo().getFreeTrialTitle(), subscriptionMultiPlan2.getPlans().get(0).getPaymentText()});
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …[0].paymentText\n        )");
        this.binding.subscriptionPaymentText.setText(string);
    }

    private final void initDagger() {
        TproPresentationComponent.Factory factory = DaggerTproPresentationComponent.factory();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        factory.create(context, (ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ConfigurationRemoteCoreLibApi.class), (SubscriptionsFeatureApi) AndroidComponentsKt.apiContainer((View) this).getFeature(SubscriptionsFeatureApi.class), (NavigationCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(NavigationCoreLibApi.class), (DeepLinkCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(DeepLinkCoreLibApi.class), (ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ObservabilityCoreLibApi.class)).inject(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnCheckedChangeListenerForCheckout$lambda-4  reason: not valid java name */
    public static final void m10372setOnCheckedChangeListenerForCheckout$lambda4(Function1 function1, CompoundButton compoundButton, boolean z11) {
        Intrinsics.checkNotNullParameter(function1, "$onCheckedChange");
        function1.invoke(Boolean.valueOf(z11));
    }

    /* access modifiers changed from: private */
    /* renamed from: setTermsAndConditionsClick$lambda-5  reason: not valid java name */
    public static final void m10373setTermsAndConditionsClick$lambda5(Function1 function1, SubscriptionAtCheckoutBannerView subscriptionAtCheckoutBannerView, View view) {
        Intrinsics.checkNotNullParameter(function1, "$onTermsAndConditionsClick");
        Intrinsics.checkNotNullParameter(subscriptionAtCheckoutBannerView, "this$0");
        String str = subscriptionAtCheckoutBannerView.termsUrl;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("termsUrl");
            str = null;
        }
        function1.invoke(str);
    }

    private final void setupObservers(LifecycleOwner lifecycleOwner) {
        getViewModel().getSubscriptionMultiPlan().observe(lifecycleOwner, new c(this));
        getViewModel().getDisplayError().observe(lifecycleOwner, new d(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupObservers$lambda-0  reason: not valid java name */
    public static final void m10374setupObservers$lambda0(SubscriptionAtCheckoutBannerView subscriptionAtCheckoutBannerView, SubscriptionMultiPlan subscriptionMultiPlan2) {
        Intrinsics.checkNotNullParameter(subscriptionAtCheckoutBannerView, "this$0");
        Intrinsics.checkNotNullExpressionValue(subscriptionMultiPlan2, "it");
        subscriptionAtCheckoutBannerView.handleMultiPlan(subscriptionMultiPlan2);
    }

    /* access modifiers changed from: private */
    /* renamed from: setupObservers$lambda-2  reason: not valid java name */
    public static final void m10375setupObservers$lambda2(SubscriptionAtCheckoutBannerView subscriptionAtCheckoutBannerView, SubscriptionsErrorDisplayModel subscriptionsErrorDisplayModel) {
        Intrinsics.checkNotNullParameter(subscriptionAtCheckoutBannerView, "this$0");
        String errorCode = subscriptionsErrorDisplayModel.getErrorMessage().getErrorCode();
        if (errorCode != null) {
            subscriptionAtCheckoutBannerView.showError(errorCode);
        }
    }

    private final Unit showError(String str) {
        Integer resId = SubscriptionsErrorMapper.INSTANCE.toResId(str);
        if (resId == null) {
            return null;
        }
        Toast.makeText(getContext(), resId.intValue(), 1).show();
        return Unit.INSTANCE;
    }

    @NotNull
    public final String getFreeTrialText() {
        SubscriptionMultiPlan subscriptionMultiPlan2 = this.subscriptionMultiPlan;
        if (subscriptionMultiPlan2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscriptionMultiPlan");
            subscriptionMultiPlan2 = null;
        }
        return subscriptionMultiPlan2.getFreeTrialInfo().getFreeTrialTitle();
    }

    @NotNull
    public final String getPlanId() {
        SubscriptionMultiPlan subscriptionMultiPlan2 = this.subscriptionMultiPlan;
        if (subscriptionMultiPlan2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscriptionMultiPlan");
            subscriptionMultiPlan2 = null;
        }
        return subscriptionMultiPlan2.getPlans().get(0).getPlanId();
    }

    @NotNull
    public final SubscriptionAtCheckoutBannerViewModelFactory getViewModelFactory() {
        SubscriptionAtCheckoutBannerViewModelFactory subscriptionAtCheckoutBannerViewModelFactory = this.viewModelFactory;
        if (subscriptionAtCheckoutBannerViewModelFactory != null) {
            return subscriptionAtCheckoutBannerViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    public final void hideSubscriptionAtCheckoutBannerView() {
        RelativeLayout relativeLayout = this.binding.subscriptionAtCheckoutBannerLayout;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.subscriptionAtCheckoutBannerLayout");
        relativeLayout.setVisibility(8);
    }

    public final boolean isSubscriptionOnCheckoutSelectorChecked() {
        return this.binding.subscriptionOnCheckoutSelector.isChecked();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LifecycleOwner findViewTreeLifecycleOwner = ViewKt.findViewTreeLifecycleOwner(this);
        if (findViewTreeLifecycleOwner != null) {
            setupObservers(findViewTreeLifecycleOwner);
        }
    }

    public final void setOnCheckedChangeListenerForCheckout(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onCheckedChange");
        this.binding.subscriptionOnCheckoutSelector.setOnCheckedChangeListener(new a(function1));
    }

    public final void setTermsAndConditionsClick(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onTermsAndConditionsClick");
        this.binding.termsAndConditionsLinkClickable.setOnClickListener(new b(function1, this));
    }

    public final void setViewModelFactory(@NotNull SubscriptionAtCheckoutBannerViewModelFactory subscriptionAtCheckoutBannerViewModelFactory) {
        Intrinsics.checkNotNullParameter(subscriptionAtCheckoutBannerViewModelFactory, "<set-?>");
        this.viewModelFactory = subscriptionAtCheckoutBannerViewModelFactory;
    }

    public final boolean shouldShowSubscriptionBanner(boolean z11) {
        return getViewModel().arrangeBannerVisibility(z11);
    }

    public final void showSubscriptionAtCheckoutBannerView() {
        RelativeLayout relativeLayout = this.binding.subscriptionAtCheckoutBannerLayout;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.subscriptionAtCheckoutBannerLayout");
        relativeLayout.setVisibility(0);
        getViewModel().getSubscriptionMultiPlan();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SubscriptionAtCheckoutBannerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        SubscriptionAtCheckoutBannerView$viewModel$2 subscriptionAtCheckoutBannerView$viewModel$2 = new SubscriptionAtCheckoutBannerView$viewModel$2(this);
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(SubscriptionAtCheckoutBannerViewModel.class), new SubscriptionAtCheckoutBannerView$special$$inlined$viewModels$1(this), subscriptionAtCheckoutBannerView$viewModel$2);
        ViewSubscriptionAtCheckoutBannerBinding inflate = ViewSubscriptionAtCheckoutBannerBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n            Lay…           true\n        )");
        this.binding = inflate;
        initDagger();
    }
}
