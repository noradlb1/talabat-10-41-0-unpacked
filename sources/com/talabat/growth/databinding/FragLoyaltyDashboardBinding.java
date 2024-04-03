package com.talabat.growth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_alert.DSAlert;
import com.designsystem.ds_navigation_bar.DSNavigationBarWithActionButton;
import com.talabat.feature.rewards.presentation.mission.RewardsMissionView;
import com.talabat.growth.R;
import com.talabat.growth.ui.loyalty.views.LoyaltyPointsSummaryView;

public final class FragLoyaltyDashboardBinding implements ViewBinding {
    @NonNull
    public final ConstraintLayout clMissionBlock;
    @NonNull
    public final DSAlert dsAlert;
    @NonNull
    public final TextView loyaltyDashLastProcessedDateTextView;
    @NonNull
    public final TextView loyaltyDashLastProcessedPointsTextView;
    @NonNull
    public final LinearLayout loyaltyDashPointHistoryTextLinearLayout;
    @NonNull
    public final LinearLayout loyaltyDashViewBurnOptionsLinearLayout;
    @NonNull
    public final TextView loyaltyDashViewHistoryTextView;
    @NonNull
    public final LinearLayout loyaltyDashboardLinearLayout;
    @NonNull
    public final LoyaltyPointsSummaryView loyaltyDashboardSummaryView;
    @NonNull
    public final SwipeRefreshLayout loyaltyDashboardSwipeRefreshLayout;
    @NonNull
    public final DSNavigationBarWithActionButton marketPlaceNavigationBar;
    @NonNull
    public final RewardsMissionView missionWidget;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final TextView tvMission;

    private FragLoyaltyDashboardBinding(@NonNull RelativeLayout relativeLayout, @NonNull ConstraintLayout constraintLayout, @NonNull DSAlert dSAlert, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout3, @NonNull LoyaltyPointsSummaryView loyaltyPointsSummaryView, @NonNull SwipeRefreshLayout swipeRefreshLayout, @NonNull DSNavigationBarWithActionButton dSNavigationBarWithActionButton, @NonNull RewardsMissionView rewardsMissionView, @NonNull TextView textView4) {
        this.rootView = relativeLayout;
        this.clMissionBlock = constraintLayout;
        this.dsAlert = dSAlert;
        this.loyaltyDashLastProcessedDateTextView = textView;
        this.loyaltyDashLastProcessedPointsTextView = textView2;
        this.loyaltyDashPointHistoryTextLinearLayout = linearLayout;
        this.loyaltyDashViewBurnOptionsLinearLayout = linearLayout2;
        this.loyaltyDashViewHistoryTextView = textView3;
        this.loyaltyDashboardLinearLayout = linearLayout3;
        this.loyaltyDashboardSummaryView = loyaltyPointsSummaryView;
        this.loyaltyDashboardSwipeRefreshLayout = swipeRefreshLayout;
        this.marketPlaceNavigationBar = dSNavigationBarWithActionButton;
        this.missionWidget = rewardsMissionView;
        this.tvMission = textView4;
    }

    @NonNull
    public static FragLoyaltyDashboardBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.clMissionBlock;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, i11);
        if (constraintLayout != null) {
            i11 = R.id.dsAlert;
            DSAlert dSAlert = (DSAlert) ViewBindings.findChildViewById(view2, i11);
            if (dSAlert != null) {
                i11 = R.id.loyaltyDashLastProcessedDateTextView;
                TextView textView = (TextView) ViewBindings.findChildViewById(view2, i11);
                if (textView != null) {
                    i11 = R.id.loyaltyDashLastProcessedPointsTextView;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i11);
                    if (textView2 != null) {
                        i11 = R.id.loyaltyDashPointHistoryTextLinearLayout;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, i11);
                        if (linearLayout != null) {
                            i11 = R.id.loyaltyDashViewBurnOptionsLinearLayout;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, i11);
                            if (linearLayout2 != null) {
                                i11 = R.id.loyaltyDashViewHistoryTextView;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                if (textView3 != null) {
                                    i11 = R.id.loyaltyDashboardLinearLayout;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, i11);
                                    if (linearLayout3 != null) {
                                        i11 = R.id.loyaltyDashboardSummaryView;
                                        LoyaltyPointsSummaryView loyaltyPointsSummaryView = (LoyaltyPointsSummaryView) ViewBindings.findChildViewById(view2, i11);
                                        if (loyaltyPointsSummaryView != null) {
                                            i11 = R.id.loyaltyDashboardSwipeRefreshLayout;
                                            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(view2, i11);
                                            if (swipeRefreshLayout != null) {
                                                i11 = R.id.marketPlaceNavigationBar;
                                                DSNavigationBarWithActionButton dSNavigationBarWithActionButton = (DSNavigationBarWithActionButton) ViewBindings.findChildViewById(view2, i11);
                                                if (dSNavigationBarWithActionButton != null) {
                                                    i11 = R.id.missionWidget;
                                                    RewardsMissionView rewardsMissionView = (RewardsMissionView) ViewBindings.findChildViewById(view2, i11);
                                                    if (rewardsMissionView != null) {
                                                        i11 = R.id.tvMission;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                        if (textView4 != null) {
                                                            return new FragLoyaltyDashboardBinding((RelativeLayout) view2, constraintLayout, dSAlert, textView, textView2, linearLayout, linearLayout2, textView3, linearLayout3, loyaltyPointsSummaryView, swipeRefreshLayout, dSNavigationBarWithActionButton, rewardsMissionView, textView4);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragLoyaltyDashboardBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragLoyaltyDashboardBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.frag_loyalty_dashboard, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
