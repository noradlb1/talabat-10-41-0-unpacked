package com.talabat.sidemenu;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.growth.ui.loyalty.models.LoyaltyPointsDisplayModel;
import com.talabat.talabatcommon.views.TalabatImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0007J\b\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/sidemenu/SideMenuRewardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "appendPts", "", "(Landroid/view/View;Z)V", "", "points", "failed", "", "point", "hideProgress", "populate", "data", "Lcom/talabat/growth/ui/loyalty/models/LoyaltyPointsDisplayModel;", "Lcom/talabat/sidemenu/SideMenuHeader;", "setOnClickListener", "onClickListener", "Landroid/view/View$OnClickListener;", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SideMenuRewardViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String DEFAULT_LOGGED_IN_USER_POINTS_VALUE = "-";
    @NotNull
    public static final String DEFAULT_POINTS_VALUE = "0";
    private final boolean appendPts;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/sidemenu/SideMenuRewardViewHolder$Companion;", "", "()V", "DEFAULT_LOGGED_IN_USER_POINTS_VALUE", "", "DEFAULT_POINTS_VALUE", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SideMenuRewardViewHolder(View view, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, (i11 & 2) != 0 ? false : z11);
    }

    private final String appendPts(String str) {
        String string = this.itemView.getResources().getString(R.string.reward_points_suffix, new Object[]{str});
        Intrinsics.checkNotNullExpressionValue(string, "itemView.resources.getSt…rd_points_suffix, points)");
        return string;
    }

    public static /* synthetic */ void failed$default(SideMenuRewardViewHolder sideMenuRewardViewHolder, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "0";
        }
        sideMenuRewardViewHolder.failed(str);
    }

    private final void hideProgress() {
        View findViewById = this.itemView.findViewById(R.id.side_menu_reward_points_ProgressBar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView\n            .fi…eward_points_ProgressBar)");
        findViewById.setVisibility(8);
    }

    public final void failed(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "point");
        hideProgress();
        ((LinearLayout) this.itemView.findViewById(R.id.side_menu_reward_points_LinearLayout)).setVisibility(0);
        TalabatTextView talabatTextView = (TalabatTextView) this.itemView.findViewById(R.id.side_menu_reward_header_points);
        if (this.appendPts) {
            str = appendPts(str);
        }
        talabatTextView.setText(str);
    }

    public final void populate(@NotNull SideMenuHeader sideMenuHeader) {
        Intrinsics.checkNotNullParameter(sideMenuHeader, "data");
        ((TalabatTextView) this.itemView.findViewById(R.id.side_menu_reward_header_title)).setText(sideMenuHeader.getTitle());
        ((TalabatImageView) this.itemView.findViewById(R.id.side_menu_reward_header_icon)).setBackground(sideMenuHeader.getDrawable());
    }

    public final void setOnClickListener(@NotNull View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.itemView.setOnClickListener(onClickListener);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SideMenuRewardViewHolder(@NotNull View view, boolean z11) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.appendPts = z11;
    }

    public final void populate(@Nullable LoyaltyPointsDisplayModel loyaltyPointsDisplayModel) {
        if (loyaltyPointsDisplayModel != null) {
            hideProgress();
            ((LinearLayout) this.itemView.findViewById(R.id.side_menu_reward_points_LinearLayout)).setVisibility(0);
            String valueOf = String.valueOf(loyaltyPointsDisplayModel.getTotalPoints());
            TalabatTextView talabatTextView = (TalabatTextView) this.itemView.findViewById(R.id.side_menu_reward_header_points);
            if (this.appendPts) {
                valueOf = appendPts(valueOf);
            }
            talabatTextView.setText(valueOf);
        }
    }
}
