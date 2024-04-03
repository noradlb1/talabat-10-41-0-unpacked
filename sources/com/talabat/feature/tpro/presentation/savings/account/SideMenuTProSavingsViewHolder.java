package com.talabat.feature.tpro.presentation.savings.account;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.configuration.location.Country;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPlan;
import com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo;
import com.talabat.feature.tpro.presentation.R;
import com.talabat.feature.tpro.presentation.benefits.SubscriptionBenefitsDeeplinkBuilder;
import com.talabat.feature.tpro.presentation.databinding.SidemenuTProSavingsBinding;
import com.talabat.feature.tpro.presentation.util.DateAndTimeUtill;
import com.talabat.talabatcommon.utils.CurrencyFormatter;
import com.talabat.talabatcommon.views.ShimmerLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lp.a;
import lp.b;
import lp.c;
import lp.d;
import lp.e;
import org.jetbrains.annotations.NotNull;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 02\u00020\u0001:\u00010BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u0010J\b\u0010\u0017\u001a\u00020\u000eH\u0002J\u0016\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u000eH\u0002J\u0006\u0010\u001e\u001a\u00020\u000eJ\b\u0010\u001f\u001a\u00020\u000eH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J\u0018\u0010%\u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010&\u001a\u00020\u000eH\u0002J\b\u0010'\u001a\u00020\u000eH\u0002J\u0012\u0010(\u001a\u00020\u000e2\b\u0010)\u001a\u0004\u0018\u00010!H\u0002J\u0012\u0010*\u001a\u00020\u000e2\b\u0010)\u001a\u0004\u0018\u00010!H\u0002J\u000e\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020-J\b\u0010.\u001a\u00020\u000eH\u0002J\u0006\u0010/\u001a\u00020\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/talabat/feature/tpro/presentation/savings/account/SideMenuTProSavingsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "navigator", "Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "subscriptionsRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "subscriptionsFeatureFlag", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "subscriptionsTracker", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;", "onReactivateClick", "Lkotlin/Function0;", "", "onTproSavingsClick", "(Landroid/view/View;Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "binding", "Lcom/talabat/feature/tpro/presentation/databinding/SidemenuTProSavingsBinding;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "activeMode", "bindSavingsInfo", "savingsInfo", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionSavingsInfo;", "locationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "cancellationPeriodMode", "endShimmer", "expiredMode", "getDaysToExpireText", "", "daysToExpire", "", "getExpirationDays", "getFormattedCurrency", "navigateToBenefits", "navigateToDetails", "reactivateAttemptEvent", "planId", "reactivateLoadedEvent", "setSavingsViewVisibility", "isVisible", "", "setupViews", "startShimmer", "Companion", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SideMenuTProSavingsViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String screenNameReactivate = "Navigation Screen";
    @NotNull
    private static final String screenTypeReactivate = "bottom_navigation_menu";
    @NotNull
    private final SidemenuTProSavingsBinding binding;
    @NotNull
    private final DeepLinkNavigator navigator;
    @NotNull
    private final Function0<Unit> onReactivateClick;
    @NotNull
    private final Function0<Unit> onTproSavingsClick;
    @NotNull
    private final ISubscriptionsFeatureFlagsRepository subscriptionsFeatureFlag;
    @NotNull
    private final ISubscriptionStatusRepository subscriptionsRepository;
    @NotNull
    private final ISubscriptionsTracker subscriptionsTracker;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/tpro/presentation/savings/account/SideMenuTProSavingsViewHolder$Companion;", "", "()V", "screenNameReactivate", "", "screenTypeReactivate", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SideMenuTProSavingsViewHolder(@NotNull View view, @NotNull DeepLinkNavigator deepLinkNavigator, @NotNull ISubscriptionStatusRepository iSubscriptionStatusRepository, @NotNull ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository, @NotNull ISubscriptionsTracker iSubscriptionsTracker, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(deepLinkNavigator, "navigator");
        Intrinsics.checkNotNullParameter(iSubscriptionStatusRepository, "subscriptionsRepository");
        Intrinsics.checkNotNullParameter(iSubscriptionsFeatureFlagsRepository, "subscriptionsFeatureFlag");
        Intrinsics.checkNotNullParameter(iSubscriptionsTracker, "subscriptionsTracker");
        Intrinsics.checkNotNullParameter(function0, "onReactivateClick");
        Intrinsics.checkNotNullParameter(function02, "onTproSavingsClick");
        this.navigator = deepLinkNavigator;
        this.subscriptionsRepository = iSubscriptionStatusRepository;
        this.subscriptionsFeatureFlag = iSubscriptionsFeatureFlagsRepository;
        this.subscriptionsTracker = iSubscriptionsTracker;
        this.onReactivateClick = function0;
        this.onTproSavingsClick = function02;
        SidemenuTProSavingsBinding bind = SidemenuTProSavingsBinding.bind(view);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(view)");
        this.binding = bind;
    }

    private final void activeMode() {
        SidemenuTProSavingsBinding sidemenuTProSavingsBinding = this.binding;
        Drawable drawable = getContext().getDrawable(R.drawable.bg_rounded_filled_light_blue);
        Drawable drawable2 = getContext().getDrawable(R.drawable.savings_account_tab_image);
        LinearLayout linearLayout = sidemenuTProSavingsBinding.llTproSavingsBannerContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "llTproSavingsBannerContainer");
        linearLayout.setVisibility(0);
        sidemenuTProSavingsBinding.cvTproSavingsContainer.setBackground(drawable);
        sidemenuTProSavingsBinding.ivSavingsAccountBanner.setImageDrawable(drawable2);
        TextView textView = sidemenuTProSavingsBinding.tvExpireTime;
        Intrinsics.checkNotNullExpressionValue(textView, "tvExpireTime");
        textView.setVisibility(8);
        TextView textView2 = sidemenuTProSavingsBinding.tvReactivate;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvReactivate");
        textView2.setVisibility(8);
        sidemenuTProSavingsBinding.cvTproSavingsContainer.setOnClickListener(new c(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: activeMode$lambda-1$lambda-0  reason: not valid java name */
    public static final void m10423activeMode$lambda1$lambda0(SideMenuTProSavingsViewHolder sideMenuTProSavingsViewHolder, View view) {
        Intrinsics.checkNotNullParameter(sideMenuTProSavingsViewHolder, "this$0");
        sideMenuTProSavingsViewHolder.navigateToDetails();
    }

    private final void cancellationPeriodMode() {
        String str;
        SubscriptionPlan plan;
        SidemenuTProSavingsBinding sidemenuTProSavingsBinding = this.binding;
        Drawable drawable = getContext().getDrawable(R.drawable.bg_rounded_filled_light_yellow);
        Drawable drawable2 = getContext().getDrawable(R.drawable.savings_account_tab_image_churned);
        Drawable drawable3 = getContext().getDrawable(R.drawable.bg_rounded_filled_yellow);
        int color = getContext().getColor(com.designsystem.marshmallow.R.color.ds_neutral_100);
        int expirationDays = getExpirationDays();
        if (expirationDays >= 0) {
            TextView textView = sidemenuTProSavingsBinding.tvExpireTime;
            Intrinsics.checkNotNullExpressionValue(textView, "tvExpireTime");
            textView.setVisibility(0);
            sidemenuTProSavingsBinding.tvExpireTime.setText(getDaysToExpireText(expirationDays));
        } else {
            TextView textView2 = sidemenuTProSavingsBinding.tvExpireTime;
            Intrinsics.checkNotNullExpressionValue(textView2, "tvExpireTime");
            textView2.setVisibility(8);
        }
        LinearLayout linearLayout = sidemenuTProSavingsBinding.llTproSavingsBannerContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "llTproSavingsBannerContainer");
        linearLayout.setVisibility(0);
        sidemenuTProSavingsBinding.cvTproSavingsContainer.setBackground(drawable);
        sidemenuTProSavingsBinding.ivSavingsAccountBanner.setImageDrawable(drawable2);
        TextView textView3 = sidemenuTProSavingsBinding.tvReactivate;
        Intrinsics.checkNotNullExpressionValue(textView3, "tvReactivate");
        textView3.setVisibility(0);
        TextView textView4 = sidemenuTProSavingsBinding.tvExpireTime;
        Intrinsics.checkNotNullExpressionValue(textView4, "tvExpireTime");
        textView4.setVisibility(0);
        sidemenuTProSavingsBinding.tvExpireTime.setBackground(drawable3);
        sidemenuTProSavingsBinding.tvExpireTime.setTextColor(color);
        sidemenuTProSavingsBinding.tvExpireTime.setText(getDaysToExpireText(expirationDays));
        sidemenuTProSavingsBinding.tvReactivate.setClickable(true);
        Subscription tProSubscriptionInfo = this.subscriptionsRepository.getTProSubscriptionInfo();
        if (tProSubscriptionInfo == null || (plan = tProSubscriptionInfo.getPlan()) == null) {
            str = null;
        } else {
            str = plan.getPlanId();
        }
        reactivateLoadedEvent(str);
        sidemenuTProSavingsBinding.tvReactivate.setOnClickListener(new a(sidemenuTProSavingsBinding, this));
        sidemenuTProSavingsBinding.cvTproSavingsContainer.setOnClickListener(new b(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: cancellationPeriodMode$lambda-7$lambda-5  reason: not valid java name */
    public static final void m10424cancellationPeriodMode$lambda7$lambda5(SidemenuTProSavingsBinding sidemenuTProSavingsBinding, SideMenuTProSavingsViewHolder sideMenuTProSavingsViewHolder, View view) {
        String str;
        SubscriptionPlan plan;
        Intrinsics.checkNotNullParameter(sidemenuTProSavingsBinding, "$this_with");
        Intrinsics.checkNotNullParameter(sideMenuTProSavingsViewHolder, "this$0");
        sidemenuTProSavingsBinding.tvReactivate.setClickable(false);
        Subscription tProSubscriptionInfo = sideMenuTProSavingsViewHolder.subscriptionsRepository.getTProSubscriptionInfo();
        if (tProSubscriptionInfo == null || (plan = tProSubscriptionInfo.getPlan()) == null) {
            str = null;
        } else {
            str = plan.getPlanId();
        }
        sideMenuTProSavingsViewHolder.reactivateAttemptEvent(str);
        sideMenuTProSavingsViewHolder.onReactivateClick.invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: cancellationPeriodMode$lambda-7$lambda-6  reason: not valid java name */
    public static final void m10425cancellationPeriodMode$lambda7$lambda6(SideMenuTProSavingsViewHolder sideMenuTProSavingsViewHolder, View view) {
        Intrinsics.checkNotNullParameter(sideMenuTProSavingsViewHolder, "this$0");
        sideMenuTProSavingsViewHolder.navigateToDetails();
    }

    private final void expiredMode() {
        SidemenuTProSavingsBinding sidemenuTProSavingsBinding = this.binding;
        Drawable drawable = getContext().getDrawable(R.drawable.bg_rounded_filled_light_red);
        Drawable drawable2 = getContext().getDrawable(R.drawable.savings_account_tab_image_expired);
        Drawable drawable3 = getContext().getDrawable(R.drawable.bg_rounded_filled_red);
        int color = getContext().getColor(com.designsystem.marshmallow.R.color.ds_danger_100);
        LinearLayout linearLayout = sidemenuTProSavingsBinding.llTproSavingsBannerContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "llTproSavingsBannerContainer");
        linearLayout.setVisibility(0);
        sidemenuTProSavingsBinding.cvTproSavingsContainer.setBackground(drawable);
        sidemenuTProSavingsBinding.ivSavingsAccountBanner.setImageDrawable(drawable2);
        TextView textView = sidemenuTProSavingsBinding.tvReactivate;
        Intrinsics.checkNotNullExpressionValue(textView, "tvReactivate");
        textView.setVisibility(0);
        TextView textView2 = sidemenuTProSavingsBinding.tvExpireTime;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvExpireTime");
        textView2.setVisibility(0);
        sidemenuTProSavingsBinding.tvExpireTime.setBackground(drawable3);
        sidemenuTProSavingsBinding.tvExpireTime.setTextColor(color);
        sidemenuTProSavingsBinding.tvExpireTime.setText(getContext().getString(com.talabat.localization.R.string.tpro_subscription_expired));
        sidemenuTProSavingsBinding.tvReactivate.setClickable(true);
        reactivateLoadedEvent((String) null);
        sidemenuTProSavingsBinding.tvReactivate.setOnClickListener(new d(this));
        sidemenuTProSavingsBinding.cvTproSavingsContainer.setOnClickListener(new e(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: expiredMode$lambda-4$lambda-2  reason: not valid java name */
    public static final void m10426expiredMode$lambda4$lambda2(SideMenuTProSavingsViewHolder sideMenuTProSavingsViewHolder, View view) {
        Intrinsics.checkNotNullParameter(sideMenuTProSavingsViewHolder, "this$0");
        sideMenuTProSavingsViewHolder.reactivateAttemptEvent((String) null);
        sideMenuTProSavingsViewHolder.navigateToBenefits();
    }

    /* access modifiers changed from: private */
    /* renamed from: expiredMode$lambda-4$lambda-3  reason: not valid java name */
    public static final void m10427expiredMode$lambda4$lambda3(SideMenuTProSavingsViewHolder sideMenuTProSavingsViewHolder, View view) {
        Intrinsics.checkNotNullParameter(sideMenuTProSavingsViewHolder, "this$0");
        sideMenuTProSavingsViewHolder.navigateToDetails();
    }

    private final Context getContext() {
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        return context;
    }

    private final String getDaysToExpireText(int i11) {
        if (i11 == 0) {
            String string = getContext().getString(com.talabat.localization.R.string.tpro_expires_today);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.ta…tring.tpro_expires_today)");
            return string;
        } else if (i11 != 1) {
            String string2 = getContext().getString(com.talabat.localization.R.string.tpro_expires_in, new Object[]{String.valueOf(i11)});
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(\n     …tring()\n                )");
            return string2;
        } else {
            String string3 = getContext().getString(com.talabat.localization.R.string.tpro_expires_tomorrow);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(com.ta…ng.tpro_expires_tomorrow)");
            return string3;
        }
    }

    private final int getExpirationDays() {
        LocalDateTime localDateTime;
        Subscription tProSubscriptionInfo = this.subscriptionsRepository.getTProSubscriptionInfo();
        if (tProSubscriptionInfo != null) {
            localDateTime = tProSubscriptionInfo.getEndDate();
        } else {
            localDateTime = null;
        }
        if (localDateTime != null) {
            return DateAndTimeUtill.INSTANCE.getRemainingDaysForDate(localDateTime);
        }
        return -1;
    }

    private final String getFormattedCurrency(SubscriptionSavingsInfo subscriptionSavingsInfo, LocationConfigurationRepository locationConfigurationRepository) {
        Country selectedCountry = locationConfigurationRepository.selectedCountry();
        if (selectedCountry == null) {
            return "";
        }
        return CurrencyFormatter.Companion.getFormattedCurrency$default(CurrencyFormatter.Companion, (double) subscriptionSavingsInfo.getOverallSavings(), true, selectedCountry.getCurrencyCode(), selectedCountry.getNumberOfDecimalPlaces(), (String) null, 16, (Object) null);
    }

    private final void navigateToBenefits() {
        DeepLinkNavigator.DefaultImpls.navigateTo$default(this.navigator, getContext(), new SubscriptionBenefitsDeeplinkBuilder().build(), (Function0) null, 4, (Object) null);
    }

    private final void navigateToDetails() {
        this.onTproSavingsClick.invoke();
    }

    private final void reactivateAttemptEvent(String str) {
        ISubscriptionsTracker iSubscriptionsTracker = this.subscriptionsTracker;
        if (str == null) {
            str = "";
        }
        iSubscriptionsTracker.tProSubscriptionReactivateAttempt("bottom_navigation_menu", "Navigation Screen", str);
    }

    private final void reactivateLoadedEvent(String str) {
        ISubscriptionsTracker iSubscriptionsTracker = this.subscriptionsTracker;
        if (str == null) {
            str = "";
        }
        iSubscriptionsTracker.tProSubscriptionReactivateLoaded("bottom_navigation_menu", "Navigation Screen", str);
    }

    private final void setupViews() {
        if (this.subscriptionsRepository.isTProCancellationPeriod() && this.subscriptionsFeatureFlag.isReactivateFromROIBannerEnabled()) {
            cancellationPeriodMode();
        } else if (this.subscriptionsRepository.isTProExpiredPeriod() && this.subscriptionsFeatureFlag.isROIbannerExpiredModeEnabled()) {
            expiredMode();
        } else if (!this.subscriptionsRepository.isTProUser() || !this.subscriptionsFeatureFlag.isSavingsBannerEnabled()) {
            setSavingsViewVisibility(false);
        } else {
            activeMode();
        }
    }

    public final void bindSavingsInfo(@NotNull SubscriptionSavingsInfo subscriptionSavingsInfo, @NotNull LocationConfigurationRepository locationConfigurationRepository) {
        Intrinsics.checkNotNullParameter(subscriptionSavingsInfo, "savingsInfo");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationRepository");
        String formattedCurrency = getFormattedCurrency(subscriptionSavingsInfo, locationConfigurationRepository);
        boolean z11 = !StringsKt__StringsJVMKt.isBlank(formattedCurrency);
        setSavingsViewVisibility(z11);
        if (z11) {
            this.binding.tvSavingsAmount.setText(formattedCurrency);
            setupViews();
        }
        endShimmer();
    }

    public final void endShimmer() {
        ShimmerLayout shimmerLayout = this.binding.sidemenuTProSavingsShimmer;
        Intrinsics.checkNotNullExpressionValue(shimmerLayout, "");
        shimmerLayout.setVisibility(8);
        shimmerLayout.stopShimmerAnimation();
    }

    public final void setSavingsViewVisibility(boolean z11) {
        int i11;
        ConstraintLayout constraintLayout = this.binding.cvTproSavingsContainer;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.cvTproSavingsContainer");
        if (z11) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        constraintLayout.setVisibility(i11);
        endShimmer();
    }

    public final void startShimmer() {
        ShimmerLayout shimmerLayout = this.binding.sidemenuTProSavingsShimmer;
        Intrinsics.checkNotNullExpressionValue(shimmerLayout, "");
        shimmerLayout.setVisibility(0);
        shimmerLayout.startShimmerAnimation();
    }
}
