package com.talabat.feature.tpro.presentation.management.details.adapter.viewholder;

import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsFeatureFlagsKeys;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPlanCategory;
import com.talabat.feature.subscriptions.domain.model.SubscriptionRenewType;
import com.talabat.feature.tpro.presentation.R;
import com.talabat.feature.tpro.presentation.databinding.ItemSubscriptionDetailsHeaderBinding;
import com.talabat.feature.tpro.presentation.util.TproImageResources;
import ep.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/details/adapter/viewholder/TproDetailsHeaderItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/talabat/feature/tpro/presentation/databinding/ItemSubscriptionDetailsHeaderBinding;", "onBackClick", "Lkotlin/Function1;", "Landroid/view/View;", "", "(Lcom/talabat/feature/tpro/presentation/databinding/ItemSubscriptionDetailsHeaderBinding;Lkotlin/jvm/functions/Function1;)V", "applyBrandUpdates", "imageName", "", "bind", "subscription", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TproDetailsHeaderItemViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private final ItemSubscriptionDetailsHeaderBinding binding;
    @NotNull
    private final Function1<View, Unit> onBackClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TproDetailsHeaderItemViewHolder(@NotNull ItemSubscriptionDetailsHeaderBinding itemSubscriptionDetailsHeaderBinding, @NotNull Function1<? super View, Unit> function1) {
        super(itemSubscriptionDetailsHeaderBinding.getRoot());
        Intrinsics.checkNotNullParameter(itemSubscriptionDetailsHeaderBinding, "binding");
        Intrinsics.checkNotNullParameter(function1, "onBackClick");
        this.binding = itemSubscriptionDetailsHeaderBinding;
        this.onBackClick = function1;
    }

    private final void applyBrandUpdates(String str) {
        ItemSubscriptionDetailsHeaderBinding itemSubscriptionDetailsHeaderBinding = this.binding;
        TproImageResources tproImageResources = new TproImageResources(false, (String) null, false, 7, (DefaultConstructorMarker) null);
        Resources resources = itemSubscriptionDetailsHeaderBinding.getRoot().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "root.resources");
        ((RequestBuilder) Glide.with((View) itemSubscriptionDetailsHeaderBinding.ivPoster).load(Uri.parse(tproImageResources.getBenefitsHeaderImage(resources, str))).fitCenter()).into(itemSubscriptionDetailsHeaderBinding.ivPoster);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams((int) this.itemView.getResources().getDimension(R.dimen.tpro_header_width), -2);
        layoutParams.setMargins(0, 0, 0, 0);
        layoutParams.bottomToBottom = 0;
        layoutParams.endToEnd = 0;
        itemSubscriptionDetailsHeaderBinding.ivPoster.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-1$lambda-0  reason: not valid java name */
    public static final void m10399bind$lambda1$lambda0(Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(view);
    }

    public final void bind(@NotNull Subscription subscription) {
        boolean z11;
        boolean z12;
        int i11;
        Intrinsics.checkNotNullParameter(subscription, "subscription");
        ItemSubscriptionDetailsHeaderBinding itemSubscriptionDetailsHeaderBinding = this.binding;
        boolean booleanVariant = TalabatExperiment.INSTANCE.getBooleanVariant(EcosystemsFeatureFlagsKeys.IS_TPRO_SHAHID_B2B_RENEWABLE_PLAN_MODE_ENABLED, false, TalabatExperimentDataSourceStrategy.FWF);
        boolean z13 = true;
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
            z13 = false;
        }
        ImageView imageView = itemSubscriptionDetailsHeaderBinding.ivBenefitsTproLogo;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivBenefitsTproLogo");
        if (!z13) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        imageView.setVisibility(i11);
        itemSubscriptionDetailsHeaderBinding.ivClose.setOnClickListener(new b(this.onBackClick));
        if (z13) {
            applyBrandUpdates(subscription.getPlan().getBannerImage());
            AppCompatTextView appCompatTextView = itemSubscriptionDetailsHeaderBinding.textGiftFromShahid;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView, "textGiftFromShahid");
            appCompatTextView.setVisibility(0);
            AppCompatTextView appCompatTextView2 = itemSubscriptionDetailsHeaderBinding.textLimitedBenefits;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "textLimitedBenefits");
            appCompatTextView2.setVisibility(0);
            AppCompatImageView appCompatImageView = itemSubscriptionDetailsHeaderBinding.ivShahidBenefitsTproLogo;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "ivShahidBenefitsTproLogo");
            appCompatImageView.setVisibility(0);
            itemSubscriptionDetailsHeaderBinding.textGiftFromShahid.setText(subscription.getPlan().getBannerHeader());
            itemSubscriptionDetailsHeaderBinding.textLimitedBenefits.setText(subscription.getPlan().getBannerDescription());
        }
    }
}
