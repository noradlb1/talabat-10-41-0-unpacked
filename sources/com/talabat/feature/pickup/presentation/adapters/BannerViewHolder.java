package com.talabat.feature.pickup.presentation.adapters;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.designsystem.ds_small_button.DSSecondarySmallButton;
import com.talabat.feature.pickup.presentation.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/pickup/presentation/adapters/BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "onLearnMoreClicked", "Lkotlin/Function0;", "", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;)V", "bannerTitleTv", "Landroid/widget/TextView;", "getBannerTitleTv", "()Landroid/widget/TextView;", "learnMoreBtn", "Lcom/designsystem/ds_small_button/DSSecondarySmallButton;", "kotlin.jvm.PlatformType", "com_talabat_feature_pickup_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BannerViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private final TextView bannerTitleTv;
    private final DSSecondarySmallButton learnMoreBtn;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BannerViewHolder(@NotNull View view, @NotNull Function0<Unit> function0) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(function0, "onLearnMoreClicked");
        DSSecondarySmallButton dSSecondarySmallButton = (DSSecondarySmallButton) view.findViewById(R.id.learnBtn);
        this.learnMoreBtn = dSSecondarySmallButton;
        View findViewById = view.findViewById(R.id.bannerTitleTv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.bannerTitleTv)");
        this.bannerTitleTv = (TextView) findViewById;
        dSSecondarySmallButton.setOnTap(function0);
    }

    @NotNull
    public final TextView getBannerTitleTv() {
        return this.bannerTitleTv;
    }
}
