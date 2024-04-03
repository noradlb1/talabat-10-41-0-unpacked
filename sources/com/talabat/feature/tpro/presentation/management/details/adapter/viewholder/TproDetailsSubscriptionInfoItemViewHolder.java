package com.talabat.feature.tpro.presentation.management.details.adapter.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.TalabatFormatter;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsFeatureFlagsKeys;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPlanCategory;
import com.talabat.feature.subscriptions.domain.model.SubscriptionRenewType;
import com.talabat.feature.tpro.presentation.databinding.ItemSubscriptionDetailsInfoBinding;
import com.talabat.localization.R;
import com.talabat.talabatcommon.utils.DateUtils;
import com.talabat.talabatcommon.views.wallet.dsalert.DSAlertView;
import ep.f;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.format.DateTimeFormatter;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0001$B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J*\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0010J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001e\u0010\u001a\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0010H\u0002J\u0018\u0010\u001b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001c\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0019H\u0002J0\u0010\u001e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0019H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/details/adapter/viewholder/TproDetailsSubscriptionInfoItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/talabat/feature/tpro/presentation/databinding/ItemSubscriptionDetailsInfoBinding;", "showCancelAutoRenewalBanner", "", "isUpgradeFlagEnabled", "(Lcom/talabat/feature/tpro/presentation/databinding/ItemSubscriptionDetailsInfoBinding;ZZ)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "bind", "", "subscription", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "onCancelAutoRenewalClicked", "Lkotlin/Function0;", "onInitiateUpgradeClicked", "getShahidPlanActive", "getString", "", "resId", "", "setRenewalHeader", "view", "Landroid/widget/TextView;", "setUpgradePlanDuration", "showAutoRenewDate", "showIsActiveStatus", "textView", "showPriceContent", "tvPriceContent", "separatorSubscriptionDetailsInfo", "Landroid/view/View;", "tvPrice", "tvAutoUpgradeDateContent", "Companion", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TproDetailsSubscriptionInfoItemViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final float SUBSCRIPTION_FEE = 29.0f;
    @NotNull
    private final ItemSubscriptionDetailsInfoBinding binding;
    private final Context context;
    private final boolean isUpgradeFlagEnabled;
    private final boolean showCancelAutoRenewalBanner;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/details/adapter/viewholder/TproDetailsSubscriptionInfoItemViewHolder$Companion;", "", "()V", "SUBSCRIPTION_FEE", "", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TproDetailsSubscriptionInfoItemViewHolder(@NotNull ItemSubscriptionDetailsInfoBinding itemSubscriptionDetailsInfoBinding, boolean z11, boolean z12) {
        super(itemSubscriptionDetailsInfoBinding.getRoot());
        Intrinsics.checkNotNullParameter(itemSubscriptionDetailsInfoBinding, "binding");
        this.binding = itemSubscriptionDetailsInfoBinding;
        this.showCancelAutoRenewalBanner = z11;
        this.isUpgradeFlagEnabled = z12;
        this.context = itemSubscriptionDetailsInfoBinding.getRoot().getContext();
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-1$lambda-0  reason: not valid java name */
    public static final void m10403bind$lambda1$lambda0(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$onCancelAutoRenewalClicked");
        function0.invoke();
    }

    private final boolean getShahidPlanActive(Subscription subscription) {
        boolean z11;
        boolean z12;
        boolean booleanVariant = TalabatExperiment.INSTANCE.getBooleanVariant(EcosystemsFeatureFlagsKeys.IS_TPRO_SHAHID_B2B_RENEWABLE_PLAN_MODE_ENABLED, false, TalabatExperimentDataSourceStrategy.FWF);
        if (subscription.getPlan().getCategory() == SubscriptionPlanCategory.B2B) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (subscription.getPlan().getRenewType() == SubscriptionRenewType.Renewable) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z11 || !z12 || !booleanVariant) {
            return false;
        }
        return true;
    }

    private final String getString(int i11) {
        String string = this.context.getString(i11);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(resId)");
        return string;
    }

    private final void setRenewalHeader(Subscription subscription, TextView textView) {
        boolean z11;
        int i11;
        if (subscription.getPlan().getCategory() == SubscriptionPlanCategory.B2B) {
            z11 = true;
        } else {
            z11 = false;
        }
        if ((!subscription.isAutorenewable() || z11) && !getShahidPlanActive(subscription)) {
            i11 = R.string.tpro_expiry_date;
        } else {
            i11 = R.string.tpro_renewal_date;
        }
        textView.setText(getString(i11));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006d, code lost:
        if (r5 == false) goto L_0x0071;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setUpgradePlanDuration(com.talabat.feature.subscriptions.domain.model.Subscription r7, kotlin.jvm.functions.Function0<kotlin.Unit> r8) {
        /*
            r6 = this;
            com.talabat.feature.subscriptions.domain.model.SubscriptionPlan r0 = r7.getPlan()
            com.talabat.feature.subscriptions.domain.model.SubscriptionPlanCategory r0 = r0.getCategory()
            com.talabat.feature.subscriptions.domain.model.SubscriptionPlanCategory r1 = com.talabat.feature.subscriptions.domain.model.SubscriptionPlanCategory.B2C
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L_0x0014
            boolean r0 = r6.isUpgradeFlagEnabled
            if (r0 == 0) goto L_0x0014
            r0 = r2
            goto L_0x0015
        L_0x0014:
            r0 = r3
        L_0x0015:
            com.talabat.feature.tpro.presentation.databinding.ItemSubscriptionDetailsInfoBinding r1 = r6.binding
            android.view.View r1 = r1.separatorSubscriptionPlanDuration
            java.lang.String r4 = "binding.separatorSubscriptionPlanDuration"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            r4 = 8
            if (r0 == 0) goto L_0x0024
            r5 = r3
            goto L_0x0025
        L_0x0024:
            r5 = r4
        L_0x0025:
            r1.setVisibility(r5)
            com.talabat.feature.tpro.presentation.databinding.ItemSubscriptionDetailsInfoBinding r1 = r6.binding
            android.widget.TextView r1 = r1.tvPlanDurationTitle
            java.lang.String r5 = "binding.tvPlanDurationTitle"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            if (r0 == 0) goto L_0x0035
            r5 = r3
            goto L_0x0036
        L_0x0035:
            r5 = r4
        L_0x0036:
            r1.setVisibility(r5)
            com.talabat.feature.tpro.presentation.databinding.ItemSubscriptionDetailsInfoBinding r1 = r6.binding
            android.widget.TextView r1 = r1.tvPlanDurationContent
            java.lang.String r5 = "binding.tvPlanDurationContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            if (r0 == 0) goto L_0x0046
            r5 = r3
            goto L_0x0047
        L_0x0046:
            r5 = r4
        L_0x0047:
            r1.setVisibility(r5)
            com.talabat.feature.tpro.presentation.databinding.ItemSubscriptionDetailsInfoBinding r1 = r6.binding
            android.widget.TextView r1 = r1.btnUpgrade
            java.lang.String r5 = "binding.btnUpgrade"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            if (r0 == 0) goto L_0x0070
            boolean r5 = r7.isUpgradeable()
            if (r5 == 0) goto L_0x0070
            java.util.List r5 = r7.getUpgradeablePlanInfos()
            java.util.Collection r5 = (java.util.Collection) r5
            if (r5 == 0) goto L_0x006c
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x006a
            goto L_0x006c
        L_0x006a:
            r5 = r3
            goto L_0x006d
        L_0x006c:
            r5 = r2
        L_0x006d:
            if (r5 != 0) goto L_0x0070
            goto L_0x0071
        L_0x0070:
            r2 = r3
        L_0x0071:
            if (r2 == 0) goto L_0x0074
            goto L_0x0075
        L_0x0074:
            r3 = r4
        L_0x0075:
            r1.setVisibility(r3)
            if (r0 == 0) goto L_0x0095
            com.talabat.feature.tpro.presentation.databinding.ItemSubscriptionDetailsInfoBinding r0 = r6.binding
            android.widget.TextView r0 = r0.tvPlanDurationContent
            com.talabat.feature.subscriptions.domain.model.SubscriptionPlan r7 = r7.getPlan()
            java.lang.String r7 = r7.getPlanPeriod()
            r0.setText(r7)
            com.talabat.feature.tpro.presentation.databinding.ItemSubscriptionDetailsInfoBinding r7 = r6.binding
            android.widget.TextView r7 = r7.btnUpgrade
            ep.g r0 = new ep.g
            r0.<init>(r8)
            r7.setOnClickListener(r0)
        L_0x0095:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.management.details.adapter.viewholder.TproDetailsSubscriptionInfoItemViewHolder.setUpgradePlanDuration(com.talabat.feature.subscriptions.domain.model.Subscription, kotlin.jvm.functions.Function0):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: setUpgradePlanDuration$lambda-6  reason: not valid java name */
    public static final void m10404setUpgradePlanDuration$lambda6(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$onInitiateUpgradeClicked");
        function0.invoke();
    }

    private final void showAutoRenewDate(Subscription subscription, TextView textView) {
        if (subscription.getPlan().getCategory() != SubscriptionPlanCategory.B2B || subscription.getPlan().getRenewType() == SubscriptionRenewType.Renewable) {
            LocalDateTime nextBillingDate = subscription.getNextBillingDate();
            if (nextBillingDate != null) {
                DateUtils.Companion companion = DateUtils.Companion;
                String format = nextBillingDate.format(DateTimeFormatter.ISO_DATE_TIME);
                Intrinsics.checkNotNullExpressionValue(format, "it.format(DateTimeFormatter.ISO_DATE_TIME)");
                textView.setText(companion.getLocalizedFormattedDateString(format, "dd LLLL yyyy"));
                return;
            }
            return;
        }
        LocalDateTime endDate = subscription.getEndDate();
        if (endDate != null) {
            DateUtils.Companion companion2 = DateUtils.Companion;
            String format2 = endDate.format(DateTimeFormatter.ISO_DATE_TIME);
            Intrinsics.checkNotNullExpressionValue(format2, "it.format(DateTimeFormatter.ISO_DATE_TIME)");
            textView.setText(companion2.getLocalizedFormattedDateString(format2, "dd LLLL yyyy"));
        }
    }

    private final void showIsActiveStatus(Subscription subscription, TextView textView) {
        int i11;
        String str;
        boolean isActive = subscription.isActive();
        boolean isAutorenewable = subscription.isAutorenewable();
        Context context2 = this.context;
        if (!isActive || !isAutorenewable) {
            i11 = com.designsystem.marshmallow.R.color.ds_danger_100;
        } else {
            i11 = com.designsystem.marshmallow.R.color.ds_success_100;
        }
        int color = context2.getColor(i11);
        if (!isActive || !isAutorenewable) {
            str = getString(R.string.cancelled);
        } else {
            str = getString(R.string.active);
        }
        textView.setText(str);
        textView.setTextColor(color);
    }

    private final void showPriceContent(Subscription subscription, TextView textView, View view, TextView textView2, TextView textView3) {
        boolean z11;
        int i11;
        boolean z12;
        int i12;
        boolean z13;
        int i13;
        boolean z14;
        String str;
        float f11;
        boolean z15 = true;
        if (subscription.getPlan().getCategory() == SubscriptionPlanCategory.B2B) {
            z11 = true;
        } else {
            z11 = false;
        }
        int i14 = 8;
        if (!z11) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        view.setVisibility(i11);
        if (!z11 || (getShahidPlanActive(subscription) && subscription.isActive())) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            i12 = 0;
        } else {
            i12 = 8;
        }
        textView.setVisibility(i12);
        if (!z11 || (getShahidPlanActive(subscription) && subscription.isActive())) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z13) {
            i13 = 0;
        } else {
            i13 = 8;
        }
        textView2.setVisibility(i13);
        if (!getShahidPlanActive(subscription) || !subscription.isActive() || !subscription.isAutorenewable()) {
            z14 = false;
        } else {
            z14 = true;
        }
        if (z14) {
            i14 = 0;
        }
        textView3.setVisibility(i14);
        LocalDateTime nextBillingDate = subscription.getNextBillingDate();
        if (nextBillingDate != null) {
            DateUtils.Companion companion = DateUtils.Companion;
            String format = nextBillingDate.format(DateTimeFormatter.ISO_DATE_TIME);
            Intrinsics.checkNotNullExpressionValue(format, "it.format(DateTimeFormatter.ISO_DATE_TIME)");
            str = companion.getLocalizedFormattedDateString(format, "dd LLLL yyyy");
        } else {
            str = null;
        }
        textView3.setText(this.context.getString(R.string.auto_upgrade_info, new Object[]{str}));
        if (!z11 || (getShahidPlanActive(subscription) && subscription.isActive())) {
            if (subscription.getPlan().getCurrencyAmount().getAmount() != 0.0f) {
                z15 = false;
            }
            if (z15) {
                f11 = 29.0f;
            } else {
                f11 = subscription.getPlan().getCurrencyAmount().getAmount();
            }
            String formattedCurrency = TalabatFormatter.getInstance().getFormattedCurrency(f11);
            String string = getString(R.string.tpro_per);
            String string2 = getString(R.string.tpro_days);
            textView.setText(formattedCurrency + " " + string + " " + subscription.getPlan().getDurationDays() + " " + string2);
        }
    }

    public final void bind(@NotNull Subscription subscription, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        int i11;
        Intrinsics.checkNotNullParameter(subscription, "subscription");
        Intrinsics.checkNotNullParameter(function0, "onCancelAutoRenewalClicked");
        Intrinsics.checkNotNullParameter(function02, "onInitiateUpgradeClicked");
        ItemSubscriptionDetailsInfoBinding itemSubscriptionDetailsInfoBinding = this.binding;
        TextView textView = itemSubscriptionDetailsInfoBinding.tvRenewalHeader;
        Intrinsics.checkNotNullExpressionValue(textView, "tvRenewalHeader");
        setRenewalHeader(subscription, textView);
        TextView textView2 = itemSubscriptionDetailsInfoBinding.tvRenewalDateContent;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvRenewalDateContent");
        showAutoRenewDate(subscription, textView2);
        TextView textView3 = itemSubscriptionDetailsInfoBinding.tvSubscriptionStatus;
        Intrinsics.checkNotNullExpressionValue(textView3, "tvSubscriptionStatus");
        showIsActiveStatus(subscription, textView3);
        TextView textView4 = itemSubscriptionDetailsInfoBinding.tvPriceContent;
        Intrinsics.checkNotNullExpressionValue(textView4, "tvPriceContent");
        View view = itemSubscriptionDetailsInfoBinding.separatorSubscriptionDetailsInfo;
        Intrinsics.checkNotNullExpressionValue(view, "separatorSubscriptionDetailsInfo");
        TextView textView5 = itemSubscriptionDetailsInfoBinding.tvPrice;
        Intrinsics.checkNotNullExpressionValue(textView5, "tvPrice");
        TextView textView6 = itemSubscriptionDetailsInfoBinding.tvAutoUpgradeDateContent;
        Intrinsics.checkNotNullExpressionValue(textView6, "tvAutoUpgradeDateContent");
        showPriceContent(subscription, textView4, view, textView5, textView6);
        DSAlertView dSAlertView = itemSubscriptionDetailsInfoBinding.dsAlertView;
        if (this.showCancelAutoRenewalBanner) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        dSAlertView.setVisibility(i11);
        itemSubscriptionDetailsInfoBinding.dsAlertView.getActionText().setOnClickListener(new f(function0));
        setUpgradePlanDuration(subscription, function02);
    }
}
