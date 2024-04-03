package com.talabat.feature.tpro.presentation.management.details.adapter.viewholder;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsFeatureFlagsKeys;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.model.SubscriptionCancellationType;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPlanCategory;
import com.talabat.feature.subscriptions.domain.model.SubscriptionRenewType;
import com.talabat.feature.tpro.presentation.databinding.ItemSubscriptionDetailsManageBinding;
import com.talabat.localization.R;
import com.talabat.talabatcommon.extentions.LagecyTalabatNavigatorExtKt;
import com.talabat.talabatnavigation.Navigator;
import ep.c;
import ep.d;
import ep.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u000eJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/details/adapter/viewholder/TproDetailsManageSubscriptionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/talabat/feature/tpro/presentation/databinding/ItemSubscriptionDetailsManageBinding;", "(Lcom/talabat/feature/tpro/presentation/databinding/ItemSubscriptionDetailsManageBinding;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "bind", "", "subscription", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "onEndMembershipClick", "Lkotlin/Function0;", "onManageAutoUpgrade", "getIsShahidPlanActive", "", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TproDetailsManageSubscriptionViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private final ItemSubscriptionDetailsManageBinding binding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TproDetailsManageSubscriptionViewHolder(@NotNull ItemSubscriptionDetailsManageBinding itemSubscriptionDetailsManageBinding) {
        super(itemSubscriptionDetailsManageBinding.getRoot());
        Intrinsics.checkNotNullParameter(itemSubscriptionDetailsManageBinding, "binding");
        this.binding = itemSubscriptionDetailsManageBinding;
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-3$lambda-0  reason: not valid java name */
    public static final void m10400bind$lambda3$lambda0(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$onManageAutoUpgrade");
        function0.invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-3$lambda-1  reason: not valid java name */
    public static final void m10401bind$lambda3$lambda1(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$onEndMembershipClick");
        function0.invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-3$lambda-2  reason: not valid java name */
    public static final void m10402bind$lambda3$lambda2(TproDetailsManageSubscriptionViewHolder tproDetailsManageSubscriptionViewHolder, Subscription subscription, View view) {
        Intrinsics.checkNotNullParameter(tproDetailsManageSubscriptionViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(subscription, "$subscription");
        String string = tproDetailsManageSubscriptionViewHolder.getContext().getString(R.string.tpro_tnc);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.ta…zation.R.string.tpro_tnc)");
        LagecyTalabatNavigatorExtKt.navigateToMainFAQ(Navigator.Companion, tproDetailsManageSubscriptionViewHolder.getContext(), string, subscription.getPlan().getTermsUrl());
    }

    private final Context getContext() {
        Context context = this.binding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
        return context;
    }

    private final boolean getIsShahidPlanActive(Subscription subscription) {
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
        if (!z11 || !z12 || !subscription.isActive() || !booleanVariant) {
            return false;
        }
        return true;
    }

    public final void bind(@NotNull Subscription subscription, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        boolean z11;
        boolean z12;
        int i11;
        Intrinsics.checkNotNullParameter(subscription, "subscription");
        Intrinsics.checkNotNullParameter(function0, "onEndMembershipClick");
        Intrinsics.checkNotNullParameter(function02, "onManageAutoUpgrade");
        ItemSubscriptionDetailsManageBinding itemSubscriptionDetailsManageBinding = this.binding;
        boolean z13 = true;
        if (!subscription.isActive() || !subscription.isAutorenewable() || subscription.getPlan().getCancellationType() == SubscriptionCancellationType.NoCancellation) {
            z11 = false;
        } else {
            z11 = true;
        }
        View view = itemSubscriptionDetailsManageBinding.separatorSubscriptionDetailsManageInfo;
        Intrinsics.checkNotNullExpressionValue(view, "separatorSubscriptionDetailsManageInfo");
        if (z11 || (getIsShahidPlanActive(subscription) && subscription.getPlan().getCancellationType() != SubscriptionCancellationType.NoCancellation)) {
            z12 = true;
        } else {
            z12 = false;
        }
        int i12 = 8;
        if (z12) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        view.setVisibility(i11);
        LinearLayoutCompat linearLayoutCompat = itemSubscriptionDetailsManageBinding.containerEndMembership;
        Intrinsics.checkNotNullExpressionValue(linearLayoutCompat, "containerEndMembership");
        if (!z11 && (!getIsShahidPlanActive(subscription) || subscription.getPlan().getCancellationType() == SubscriptionCancellationType.NoCancellation)) {
            z13 = false;
        }
        if (z13) {
            i12 = 0;
        }
        linearLayoutCompat.setVisibility(i12);
        if (getIsShahidPlanActive(subscription)) {
            View view2 = itemSubscriptionDetailsManageBinding.separatorManageAutoUpgrade;
            Intrinsics.checkNotNullExpressionValue(view2, "separatorManageAutoUpgrade");
            view2.setVisibility(0);
            if (subscription.isAutorenewable()) {
                itemSubscriptionDetailsManageBinding.tvManageAutoUpgrade.setText(getContext().getString(R.string.deactivate_auto_upgrade));
                itemSubscriptionDetailsManageBinding.ivManageAutoUpgrade.setImageResource(com.talabat.feature.tpro.presentation.R.drawable.ic_cancel_basket);
            } else {
                itemSubscriptionDetailsManageBinding.tvManageAutoUpgrade.setText(getContext().getString(R.string.activate_auto_upgrade));
                itemSubscriptionDetailsManageBinding.ivManageAutoUpgrade.setImageResource(com.talabat.feature.tpro.presentation.R.drawable.ic_pro_logo_blue_framed_alt);
            }
            LinearLayoutCompat linearLayoutCompat2 = itemSubscriptionDetailsManageBinding.containerManageAutoUpgrade;
            Intrinsics.checkNotNullExpressionValue(linearLayoutCompat2, "containerManageAutoUpgrade");
            linearLayoutCompat2.setVisibility(0);
            itemSubscriptionDetailsManageBinding.containerManageAutoUpgrade.setOnClickListener(new c(function02));
        }
        itemSubscriptionDetailsManageBinding.containerEndMembership.setOnClickListener(new d(function0));
        itemSubscriptionDetailsManageBinding.containerManageTnc.setOnClickListener(new e(this, subscription));
    }
}
