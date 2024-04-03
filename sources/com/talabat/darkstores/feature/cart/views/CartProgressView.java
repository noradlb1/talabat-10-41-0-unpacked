package com.talabat.darkstores.feature.cart.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QCommerceFeatureFlagsKeys;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.extensions.ContextExtensionsKt;
import com.talabat.darkstores.common.extensions.TextViewExtensionsKt;
import com.talabat.darkstores.di.DaggerCartFragmentComponent;
import com.talabat.darkstores.feature.campaigns.CampaignProgressState;
import com.talabat.darkstores.feature.campaigns.CampaignProgressStateSource;
import com.talabat.darkstores.feature.campaigns.CampaignProgressVisualisation;
import com.talabat.darkstores.feature.cart.model.ScreenTrackingInfo;
import com.talabat.darkstores.feature.cart.views.CartProgressContract;
import com.talabat.darkstores.feature.main.viewmodel.BottomSheetViewState;
import com.talabat.darkstores.feature.main.viewmodel.DeliveryTierBottomSheetViewState;
import com.talabat.darkstores.feature.main.viewmodel.DeliveryTierBottomSheetViewStateViewModel;
import com.talabat.darkstores.feature.main.viewmodel.DeliveryTierClickOrigin;
import com.talabat.darkstores.feature.tracking.EventOriginType;
import com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wi.a;
import wi.b;
import wi.c;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0000\u0018\u0000 w2\u00020\u00012\u00020\u0002:\u0001wB%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\bH\u0002J\u0010\u0010T\u001a\u00020R2\u0006\u0010U\u001a\u00020VH\u0016J\u0018\u0010W\u001a\u00020R2\u0006\u0010X\u001a\u00020V2\u0006\u0010Y\u001a\u00020VH\u0016J\u0010\u0010Z\u001a\u00020R2\u0006\u0010[\u001a\u00020VH\u0002J\u0010\u0010\\\u001a\u00020R2\u0006\u0010[\u001a\u00020VH\u0002J\u0006\u0010]\u001a\u00020RJ\u0010\u0010^\u001a\u00020_2\u0006\u0010[\u001a\u00020VH\u0002J\b\u0010`\u001a\u00020RH\u0014J\b\u0010a\u001a\u00020RH\u0014J7\u0010b\u001a\u00020R2\b\b\u0003\u0010c\u001a\u00020\b2\b\b\u0003\u0010d\u001a\u00020\b2\b\b\u0003\u0010e\u001a\u00020\b2\n\b\u0003\u0010f\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010gJ\u0010\u0010h\u001a\u00020R2\u0006\u0010[\u001a\u00020VH\u0002J\u0010\u0010i\u001a\u00020_2\u0006\u0010[\u001a\u00020VH\u0002J\u0006\u0010j\u001a\u00020RJ\u000e\u0010k\u001a\u00020R2\u0006\u0010l\u001a\u00020mJ\u0010\u0010n\u001a\u00020R2\u0006\u0010[\u001a\u00020VH\u0016J\u000e\u0010o\u001a\u00020R2\u0006\u0010p\u001a\u00020qJ%\u0010r\u001a\n \u0011*\u0004\u0018\u00010s0s*\u00020V2\n\b\u0002\u0010t\u001a\u0004\u0018\u00010uH\u0002¢\u0006\u0002\u0010vR\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR#\u0010\u0010\u001a\n \u0011*\u0004\u0018\u00010\u00010\u00018BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R#\u0010\u0016\u001a\n \u0011*\u0004\u0018\u00010\u00170\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R#\u0010!\u001a\n \u0011*\u0004\u0018\u00010\"0\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\u0015\u001a\u0004\b#\u0010$R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R#\u0010(\u001a\n \u0011*\u0004\u0018\u00010\"0\"8BX\u0002¢\u0006\f\n\u0004\b*\u0010\u0015\u001a\u0004\b)\u0010$R\u001b\u0010+\u001a\u00020,8BX\u0002¢\u0006\f\n\u0004\b/\u0010\u0015\u001a\u0004\b-\u0010.R#\u00100\u001a\n \u0011*\u0004\u0018\u000101018BX\u0002¢\u0006\f\n\u0004\b4\u0010\u0015\u001a\u0004\b2\u00103R\u000e\u00105\u001a\u000206X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u000e¢\u0006\u0002\n\u0000R\u001e\u00109\u001a\u00020:8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R#\u0010?\u001a\n \u0011*\u0004\u0018\u00010\u00010\u00018BX\u0002¢\u0006\f\n\u0004\bA\u0010\u0015\u001a\u0004\b@\u0010\u0013R#\u0010B\u001a\n \u0011*\u0004\u0018\u00010\u00170\u00178BX\u0002¢\u0006\f\n\u0004\bD\u0010\u0015\u001a\u0004\bC\u0010\u0019R\u001e\u0010E\u001a\u00020F8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001e\u0010K\u001a\u00020L8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010P¨\u0006x"}, d2 = {"Lcom/talabat/darkstores/feature/cart/views/CartProgressView;", "Landroid/widget/LinearLayout;", "Lcom/talabat/darkstores/feature/cart/views/CartProgressContract$View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomSheetViewStateViewModel", "Lcom/talabat/darkstores/feature/main/viewmodel/DeliveryTierBottomSheetViewStateViewModel;", "getBottomSheetViewStateViewModel", "()Lcom/talabat/darkstores/feature/main/viewmodel/DeliveryTierBottomSheetViewStateViewModel;", "bottomSheetViewStateViewModel$delegate", "Landroidx/lifecycle/ViewModelLazy;", "campaignContainer", "kotlin.jvm.PlatformType", "getCampaignContainer", "()Landroid/widget/LinearLayout;", "campaignContainer$delegate", "Lkotlin/Lazy;", "campaignMessage", "Landroidx/appcompat/widget/AppCompatTextView;", "getCampaignMessage", "()Landroidx/appcompat/widget/AppCompatTextView;", "campaignMessage$delegate", "customerRepository", "Lcom/talabat/customer/domain/CustomerRepository;", "getCustomerRepository", "()Lcom/talabat/customer/domain/CustomerRepository;", "setCustomerRepository", "(Lcom/talabat/customer/domain/CustomerRepository;)V", "deliveryInfoIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "getDeliveryInfoIcon", "()Landroidx/appcompat/widget/AppCompatImageView;", "deliveryInfoIcon$delegate", "eventOrigin", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "icon", "getIcon", "icon$delegate", "presenter", "Lcom/talabat/darkstores/feature/cart/views/CartProgressContract$Presenter;", "getPresenter", "()Lcom/talabat/darkstores/feature/cart/views/CartProgressContract$Presenter;", "presenter$delegate", "progress", "Lcom/google/android/material/progressindicator/LinearProgressIndicator;", "getProgress", "()Lcom/google/android/material/progressindicator/LinearProgressIndicator;", "progress$delegate", "screenName", "Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$ScreenName;", "screenType", "Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$ScreenType;", "subscriptionsFlagsRepo", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "getSubscriptionsFlagsRepo", "()Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "setSubscriptionsFlagsRepo", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;)V", "tProCampaignContainer", "getTProCampaignContainer", "tProCampaignContainer$delegate", "tProCampaignMessage", "getTProCampaignMessage", "tProCampaignMessage$delegate", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getTalabatFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setTalabatFeatureFlag", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "animateProgress", "", "endValue", "animateStateChange", "newState", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState;", "animateWithTransientState", "transientState", "permanentState", "applyStyleToCampaignMessage", "state", "displayCampaignContainer", "hide", "isCampaignSourceTpro", "", "onAttachedToWindow", "onDetachedFromWindow", "setProgressStyle", "image", "imageTint", "textColor", "trackColor", "(IIILjava/lang/Integer;)V", "setStyle", "shouldApplyTProCampaign", "showDeliveryTierInfoIcon", "showIfPossible", "screenTrackingInfo", "Lcom/talabat/darkstores/feature/cart/model/ScreenTrackingInfo;", "updateState", "visualise", "campaignVisualisation", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressVisualisation;", "createAnimator", "Landroid/animation/ValueAnimator;", "delay", "", "(Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState;Ljava/lang/Long;)Landroid/animation/ValueAnimator;", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartProgressView extends LinearLayout implements CartProgressContract.View {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long PROGRESS_ANIMATION_DURATION = 150;
    private static final long SHOW_ANIMATION_DURATION = 300;
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    private final ViewModelLazy bottomSheetViewStateViewModel$delegate;
    @NotNull
    private final Lazy campaignContainer$delegate;
    @NotNull
    private final Lazy campaignMessage$delegate;
    @Inject
    public CustomerRepository customerRepository;
    @NotNull
    private final Lazy deliveryInfoIcon$delegate;
    @NotNull
    private EventOriginType eventOrigin;
    @NotNull
    private final Lazy icon$delegate;
    @NotNull
    private final Lazy presenter$delegate;
    @NotNull
    private final Lazy progress$delegate;
    @NotNull
    private ScreenTrackingProvider.ScreenName screenName;
    @NotNull
    private ScreenTrackingProvider.ScreenType screenType;
    @Inject
    public ISubscriptionsFeatureFlagsRepository subscriptionsFlagsRepo;
    @NotNull
    private final Lazy tProCampaignContainer$delegate;
    @NotNull
    private final Lazy tProCampaignMessage$delegate;
    @Inject
    public ITalabatFeatureFlag talabatFeatureFlag;
    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/darkstores/feature/cart/views/CartProgressView$Companion;", "", "()V", "PROGRESS_ANIMATION_DURATION", "", "SHOW_ANIMATION_DURATION", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CartProgressView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CartProgressView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CartProgressView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.progress$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new CartProgressView$progress$2(this));
        this.campaignContainer$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new CartProgressView$campaignContainer$2(this));
        this.campaignMessage$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new CartProgressView$campaignMessage$2(this));
        this.tProCampaignContainer$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new CartProgressView$tProCampaignContainer$2(this));
        this.tProCampaignMessage$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new CartProgressView$tProCampaignMessage$2(this));
        this.icon$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new CartProgressView$icon$2(this));
        this.deliveryInfoIcon$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new CartProgressView$deliveryInfoIcon$2(this));
        this.presenter$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, CartProgressView$presenter$2.INSTANCE);
        this.eventOrigin = EventOriginType.None;
        this.screenType = ScreenTrackingProvider.ScreenType.LANDING;
        this.screenName = ScreenTrackingProvider.ScreenName.LANDING;
        CartProgressView$bottomSheetViewStateViewModel$2 cartProgressView$bottomSheetViewStateViewModel$2 = new CartProgressView$bottomSheetViewStateViewModel$2(this);
        this.bottomSheetViewStateViewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DeliveryTierBottomSheetViewStateViewModel.class), new CartProgressView$special$$inlined$viewModels$1(this), cartProgressView$bottomSheetViewStateViewModel$2);
        DaggerCartFragmentComponent.factory().create((SubscriptionsFeatureApi) AndroidComponentsKt.apiContainer((View) this).getFeature(SubscriptionsFeatureApi.class), (CustomerCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(CustomerCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(FeatureFlagCoreLibApi.class)).inject(this);
        View.inflate(context, R.layout.darkstores_cart_progress_view, this);
        setBackgroundColor(ContextExtensionsKt.getColorCompat(context, com.designsystem.marshmallow.R.color.ds_neutral_white));
        setOrientation(1);
        getDeliveryInfoIcon().setOnClickListener(new c(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m9851_init_$lambda0(CartProgressView cartProgressView, View view) {
        Intrinsics.checkNotNullParameter(cartProgressView, "this$0");
        cartProgressView.getBottomSheetViewStateViewModel().getDeliveryTierBottomSheetViewState().postValue(new DeliveryTierBottomSheetViewState(BottomSheetViewState.SHOW, DeliveryTierClickOrigin.CART_PROGRESS_INFO, new ScreenTrackingInfo(cartProgressView.eventOrigin, cartProgressView.screenName, cartProgressView.screenType)));
    }

    private final void animateProgress(int i11) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{getProgress().getProgress(), i11});
        ofInt.setDuration(150);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.addUpdateListener(new a(this));
        ofInt.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: animateProgress$lambda-10$lambda-9  reason: not valid java name */
    public static final void m9852animateProgress$lambda10$lambda9(CartProgressView cartProgressView, ValueAnimator valueAnimator) {
        Integer num;
        Intrinsics.checkNotNullParameter(cartProgressView, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, "animator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue instanceof Integer) {
            num = (Integer) animatedValue;
        } else {
            num = null;
        }
        if (num != null) {
            LinearProgressIndicator progress = cartProgressView.getProgress();
            Intrinsics.checkNotNullExpressionValue(progress, "progress");
            progress.setProgress(num.intValue());
        }
    }

    private final void applyStyleToCampaignMessage(CampaignProgressState campaignProgressState) {
        boolean featureFlag = getTalabatFeatureFlag().getFeatureFlag(QCommerceFeatureFlagsKeys.QCOMMERCE_VOUCHER_MOV_PROGRESSBAR, true);
        if (!Intrinsics.areEqual((Object) campaignProgressState, (Object) CampaignProgressState.Hidden.INSTANCE)) {
            if (campaignProgressState instanceof CampaignProgressState.BelowThreshold) {
                if (!featureFlag || campaignProgressState.getSource() != CampaignProgressStateSource.VOUCHER_MOV) {
                    e(this, com.designsystem.marshmallow.R.drawable.ds_bag_filled, com.designsystem.marshmallow.R.color.ds_neutral_100, 0, Integer.valueOf(com.designsystem.marshmallow.R.color.ds_primary_100), 4, (Object) null);
                    return;
                }
                int i11 = com.designsystem.marshmallow.R.drawable.ds_voucher;
                int i12 = com.designsystem.marshmallow.R.color.ds_promo_100;
                setProgressStyle(i11, i12, com.designsystem.marshmallow.R.color.ds_neutral_100, Integer.valueOf(i12));
            } else if (campaignProgressState instanceof CampaignProgressState.InProgress) {
                if (!featureFlag || campaignProgressState.getSource() != CampaignProgressStateSource.VOUCHER_MOV) {
                    e(this, 0, 0, 0, Integer.valueOf(com.designsystem.marshmallow.R.color.ds_promo_100), 7, (Object) null);
                    return;
                }
                int i13 = com.designsystem.marshmallow.R.drawable.ds_voucher;
                int i14 = com.designsystem.marshmallow.R.color.ds_promo_100;
                setProgressStyle(i13, i14, com.designsystem.marshmallow.R.color.ds_neutral_100, Integer.valueOf(i14));
            } else if (campaignProgressState instanceof CampaignProgressState.Success) {
                if (!featureFlag || campaignProgressState.getSource() != CampaignProgressStateSource.VOUCHER_MOV) {
                    e(this, 0, 0, com.designsystem.marshmallow.R.color.ds_promo_100, (Integer) null, 11, (Object) null);
                    return;
                }
                e(this, com.designsystem.marshmallow.R.drawable.ds_voucher_filled, com.designsystem.marshmallow.R.color.ds_promo_100, com.designsystem.marshmallow.R.color.ds_neutral_100, (Integer) null, 8, (Object) null);
            } else if (campaignProgressState instanceof CampaignProgressState.Transient) {
                e(this, com.designsystem.marshmallow.R.drawable.ds_check_circle_filled, com.designsystem.marshmallow.R.color.ds_success_100, 0, (Integer) null, 12, (Object) null);
            }
        }
    }

    private final ValueAnimator createAnimator(CampaignProgressState campaignProgressState, Long l11) {
        long j11;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, (float) getHeight()});
        ofFloat.setDuration(SHOW_ANIMATION_DURATION);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(1);
        ofFloat.setRepeatMode(2);
        ofFloat.addUpdateListener(new b(this));
        Intrinsics.checkNotNullExpressionValue(ofFloat, "");
        ofFloat.addListener(new CartProgressView$createAnimator$lambda5$$inlined$doOnRepeat$1(this, campaignProgressState));
        if (l11 != null) {
            j11 = l11.longValue();
        } else {
            j11 = 0;
        }
        ofFloat.setStartDelay(j11);
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: createAnimator$lambda-5$lambda-3  reason: not valid java name */
    public static final void m9853createAnimator$lambda5$lambda3(CartProgressView cartProgressView, ValueAnimator valueAnimator) {
        Float f11;
        Intrinsics.checkNotNullParameter(cartProgressView, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue instanceof Float) {
            f11 = (Float) animatedValue;
        } else {
            f11 = null;
        }
        if (f11 != null) {
            cartProgressView.setTranslationY(f11.floatValue());
        }
    }

    public static /* synthetic */ ValueAnimator d(CartProgressView cartProgressView, CampaignProgressState campaignProgressState, Long l11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            l11 = null;
        }
        return cartProgressView.createAnimator(campaignProgressState, l11);
    }

    private final void displayCampaignContainer(CampaignProgressState campaignProgressState) {
        int i11;
        LinearLayout tProCampaignContainer = getTProCampaignContainer();
        int i12 = 8;
        if (isCampaignSourceTpro(campaignProgressState) || campaignProgressState.isTPro()) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        tProCampaignContainer.setVisibility(i11);
        LinearLayout campaignContainer = getCampaignContainer();
        if (!isCampaignSourceTpro(campaignProgressState) && !campaignProgressState.isTPro()) {
            i12 = 0;
        }
        campaignContainer.setVisibility(i12);
    }

    public static /* synthetic */ void e(CartProgressView cartProgressView, int i11, int i12, int i13, Integer num, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i11 = com.designsystem.marshmallow.R.drawable.ds_promo_filled;
        }
        if ((i14 & 2) != 0) {
            i12 = com.designsystem.marshmallow.R.color.ds_promo_100;
        }
        if ((i14 & 4) != 0) {
            i13 = com.designsystem.marshmallow.R.color.ds_neutral_100;
        }
        if ((i14 & 8) != 0) {
            num = null;
        }
        cartProgressView.setProgressStyle(i11, i12, i13, num);
    }

    private final DeliveryTierBottomSheetViewStateViewModel getBottomSheetViewStateViewModel() {
        return (DeliveryTierBottomSheetViewStateViewModel) this.bottomSheetViewStateViewModel$delegate.getValue();
    }

    private final LinearLayout getCampaignContainer() {
        return (LinearLayout) this.campaignContainer$delegate.getValue();
    }

    private final AppCompatTextView getCampaignMessage() {
        return (AppCompatTextView) this.campaignMessage$delegate.getValue();
    }

    private final AppCompatImageView getDeliveryInfoIcon() {
        return (AppCompatImageView) this.deliveryInfoIcon$delegate.getValue();
    }

    private final AppCompatImageView getIcon() {
        return (AppCompatImageView) this.icon$delegate.getValue();
    }

    private final CartProgressContract.Presenter getPresenter() {
        return (CartProgressContract.Presenter) this.presenter$delegate.getValue();
    }

    private final LinearProgressIndicator getProgress() {
        return (LinearProgressIndicator) this.progress$delegate.getValue();
    }

    private final LinearLayout getTProCampaignContainer() {
        return (LinearLayout) this.tProCampaignContainer$delegate.getValue();
    }

    private final AppCompatTextView getTProCampaignMessage() {
        return (AppCompatTextView) this.tProCampaignMessage$delegate.getValue();
    }

    private final boolean isCampaignSourceTpro(CampaignProgressState campaignProgressState) {
        if (campaignProgressState.getSource() != CampaignProgressStateSource.TPRO || !getTalabatFeatureFlag().getFeatureFlag(QCommerceFeatureFlagsKeys.QCOMMERCE_VOUCHER_MOV_PROGRESSBAR, true)) {
            return false;
        }
        return true;
    }

    private final void setProgressStyle(@DrawableRes int i11, @ColorRes int i12, @ColorRes int i13, @ColorRes Integer num) {
        Unit unit;
        getIcon().setImageResource(i11);
        AppCompatImageView icon = getIcon();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        icon.setColorFilter(ContextExtensionsKt.getColorCompat(context, i12));
        AppCompatTextView campaignMessage = getCampaignMessage();
        Intrinsics.checkNotNullExpressionValue(campaignMessage, "campaignMessage");
        TextViewExtensionsKt.setTextColorRes(campaignMessage, i13);
        if (num != null) {
            int intValue = num.intValue();
            LinearProgressIndicator progress = getProgress();
            Intrinsics.checkNotNullExpressionValue(progress, "progress");
            progress.setVisibility(0);
            LinearProgressIndicator progress2 = getProgress();
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            progress2.setIndicatorColor(ContextExtensionsKt.getColorCompat(context2, intValue));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            LinearProgressIndicator progress3 = getProgress();
            Intrinsics.checkNotNullExpressionValue(progress3, "progress");
            progress3.setVisibility(8);
        }
    }

    private final void setStyle(CampaignProgressState campaignProgressState) {
        if (shouldApplyTProCampaign(campaignProgressState)) {
            e(this, 0, 0, 0, Integer.valueOf(com.talabat.talabatcommon.R.color.new_brand_blue), 7, (Object) null);
            return;
        }
        applyStyleToCampaignMessage(campaignProgressState);
    }

    private final boolean shouldApplyTProCampaign(CampaignProgressState campaignProgressState) {
        boolean isCampaignSourceTpro = isCampaignSourceTpro(campaignProgressState);
        boolean isTPro = campaignProgressState.isTPro();
        boolean isTPro2 = getCustomerRepository().isTPro();
        boolean isTProEnabledForTMart = getSubscriptionsFlagsRepo().isTProEnabledForTMart();
        if (isCampaignSourceTpro || (isTPro && isTPro2 && isTProEnabledForTMart)) {
            return true;
        }
        return false;
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

    public void animateStateChange(@NotNull CampaignProgressState campaignProgressState) {
        Intrinsics.checkNotNullParameter(campaignProgressState, "newState");
        d(this, campaignProgressState, (Long) null, 1, (Object) null).start();
    }

    public void animateWithTransientState(@NotNull CampaignProgressState campaignProgressState, @NotNull CampaignProgressState campaignProgressState2) {
        Intrinsics.checkNotNullParameter(campaignProgressState, "transientState");
        Intrinsics.checkNotNullParameter(campaignProgressState2, "permanentState");
        ValueAnimator d11 = d(this, campaignProgressState, (Long) null, 1, (Object) null);
        ValueAnimator createAnimator = createAnimator(campaignProgressState2, campaignProgressState.getAnimationPauseMillis());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{d11, createAnimator});
        animatorSet.start();
    }

    @NotNull
    public final CustomerRepository getCustomerRepository() {
        CustomerRepository customerRepository2 = this.customerRepository;
        if (customerRepository2 != null) {
            return customerRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("customerRepository");
        return null;
    }

    @NotNull
    public final ISubscriptionsFeatureFlagsRepository getSubscriptionsFlagsRepo() {
        ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository = this.subscriptionsFlagsRepo;
        if (iSubscriptionsFeatureFlagsRepository != null) {
            return iSubscriptionsFeatureFlagsRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("subscriptionsFlagsRepo");
        return null;
    }

    @NotNull
    public final ITalabatFeatureFlag getTalabatFeatureFlag() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.talabatFeatureFlag;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("talabatFeatureFlag");
        return null;
    }

    @NotNull
    public final ViewModelProvider.Factory getViewModelFactory() {
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory != null) {
            return factory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    public final void hide() {
        setVisibility(8);
        setEnabled(false);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getPresenter().onAttach(this);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getPresenter().onDetach();
    }

    public final void setCustomerRepository(@NotNull CustomerRepository customerRepository2) {
        Intrinsics.checkNotNullParameter(customerRepository2, "<set-?>");
        this.customerRepository = customerRepository2;
    }

    public final void setSubscriptionsFlagsRepo(@NotNull ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository) {
        Intrinsics.checkNotNullParameter(iSubscriptionsFeatureFlagsRepository, "<set-?>");
        this.subscriptionsFlagsRepo = iSubscriptionsFeatureFlagsRepository;
    }

    public final void setTalabatFeatureFlag(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public final void setViewModelFactory(@NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.viewModelFactory = factory;
    }

    public final void showDeliveryTierInfoIcon() {
        getDeliveryInfoIcon().setVisibility(0);
    }

    public final void showIfPossible(@NotNull ScreenTrackingInfo screenTrackingInfo) {
        int i11;
        Intrinsics.checkNotNullParameter(screenTrackingInfo, "screenTrackingInfo");
        if (getPresenter().getCanShow()) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        setVisibility(i11);
        setEnabled(true);
        this.eventOrigin = screenTrackingInfo.getEventOriginType();
        this.screenName = screenTrackingInfo.getScreenName();
        this.screenType = screenTrackingInfo.getScreenType();
    }

    public void updateState(@NotNull CampaignProgressState campaignProgressState) {
        boolean z11;
        AppCompatTextView appCompatTextView;
        Spanned spanned;
        Intrinsics.checkNotNullParameter(campaignProgressState, "state");
        int i11 = 0;
        if (!isEnabled() || Intrinsics.areEqual((Object) campaignProgressState, (Object) CampaignProgressState.Hidden.INSTANCE)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            i11 = 8;
        }
        setVisibility(i11);
        Integer progress = campaignProgressState.getProgress();
        if (progress != null) {
            animateProgress(progress.intValue());
        }
        displayCampaignContainer(campaignProgressState);
        if (shouldApplyTProCampaign(campaignProgressState)) {
            appCompatTextView = getTProCampaignMessage();
        } else {
            appCompatTextView = getCampaignMessage();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            spanned = Html.fromHtml(campaignProgressState.getMessage(), 63);
        } else {
            spanned = Html.fromHtml(campaignProgressState.getMessage());
        }
        appCompatTextView.setText(spanned);
        setStyle(campaignProgressState);
    }

    public final void visualise(@NotNull CampaignProgressVisualisation campaignProgressVisualisation) {
        Intrinsics.checkNotNullParameter(campaignProgressVisualisation, "campaignVisualisation");
        getPresenter().handleVisualisation(campaignProgressVisualisation);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CartProgressView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
