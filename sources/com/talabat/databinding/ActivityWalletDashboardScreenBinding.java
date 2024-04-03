package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class ActivityWalletDashboardScreenBinding implements ViewBinding {
    @NonNull
    public final AppBarLayout appBar;
    @NonNull
    public final TextView availableCreditTextview;
    @NonNull
    public final ImageButton backIcon;
    @NonNull
    public final TextView emptyTransactionTextview;
    @NonNull
    public final TalabatFillButton logInButton;
    @NonNull
    public final TextView logToAccessWallet;
    @NonNull
    public final TextView menuManageTextview;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    private final SwipeRefreshLayout rootView;
    @NonNull
    public final TextView sendGiftButton;
    @NonNull
    public final TextView stickyToolbarAvailableCreditAmountTextView;
    @NonNull
    public final TalabatTextView stickyToolbarAvailableCreditTextView;
    @NonNull
    public final TalabatTextView stickyToolbarCurrencyTextView;
    @NonNull
    public final TextView stickyToolbarSpentInMonthAmountTextView;
    @NonNull
    public final TextView stickyToolbarSpentInMonthStringTextView;
    @NonNull
    public final SwipeRefreshLayout swipeRefresh;
    @NonNull
    public final RelativeLayout talabatToolbar;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final ImageView toolbarBackIcon;
    @NonNull
    public final CollapsingToolbarLayout toolbarLayout;
    @NonNull
    public final TextView topButton;
    @NonNull
    public final ConstraintLayout userNotLoggedContainer;
    @NonNull
    public final ConstraintLayout walletActionContainer;
    @NonNull
    public final TextView walletBalanceTextView;
    @NonNull
    public final ConstraintLayout walletCreditBalanceSummaryContainer;
    @NonNull
    public final TextView walletDashboardTitle;
    @NonNull
    public final ImageView walletEmptyIcon;
    @NonNull
    public final Toolbar walletStickyToolbar;
    @NonNull
    public final RecyclerView walletTransactionList;

    private ActivityWalletDashboardScreenBinding(@NonNull SwipeRefreshLayout swipeRefreshLayout, @NonNull AppBarLayout appBarLayout, @NonNull TextView textView, @NonNull ImageButton imageButton, @NonNull TextView textView2, @NonNull TalabatFillButton talabatFillButton, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull ProgressBar progressBar2, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull TextView textView7, @NonNull TextView textView8, @NonNull SwipeRefreshLayout swipeRefreshLayout2, @NonNull RelativeLayout relativeLayout, @NonNull Toolbar toolbar2, @NonNull ImageView imageView, @NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull TextView textView9, @NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView10, @NonNull ConstraintLayout constraintLayout3, @NonNull TextView textView11, @NonNull ImageView imageView2, @NonNull Toolbar toolbar3, @NonNull RecyclerView recyclerView) {
        this.rootView = swipeRefreshLayout;
        this.appBar = appBarLayout;
        this.availableCreditTextview = textView;
        this.backIcon = imageButton;
        this.emptyTransactionTextview = textView2;
        this.logInButton = talabatFillButton;
        this.logToAccessWallet = textView3;
        this.menuManageTextview = textView4;
        this.progressBar = progressBar2;
        this.sendGiftButton = textView5;
        this.stickyToolbarAvailableCreditAmountTextView = textView6;
        this.stickyToolbarAvailableCreditTextView = talabatTextView;
        this.stickyToolbarCurrencyTextView = talabatTextView2;
        this.stickyToolbarSpentInMonthAmountTextView = textView7;
        this.stickyToolbarSpentInMonthStringTextView = textView8;
        this.swipeRefresh = swipeRefreshLayout2;
        this.talabatToolbar = relativeLayout;
        this.toolbar = toolbar2;
        this.toolbarBackIcon = imageView;
        this.toolbarLayout = collapsingToolbarLayout;
        this.topButton = textView9;
        this.userNotLoggedContainer = constraintLayout;
        this.walletActionContainer = constraintLayout2;
        this.walletBalanceTextView = textView10;
        this.walletCreditBalanceSummaryContainer = constraintLayout3;
        this.walletDashboardTitle = textView11;
        this.walletEmptyIcon = imageView2;
        this.walletStickyToolbar = toolbar3;
        this.walletTransactionList = recyclerView;
    }

    @NonNull
    public static ActivityWalletDashboardScreenBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.app_bar;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view2, R.id.app_bar);
        if (appBarLayout != null) {
            i11 = R.id.available_credit_textview;
            TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.available_credit_textview);
            if (textView != null) {
                i11 = R.id.back_icon;
                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view2, R.id.back_icon);
                if (imageButton != null) {
                    i11 = R.id.empty_transaction_textview;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.empty_transaction_textview);
                    if (textView2 != null) {
                        i11 = R.id.log_in_button;
                        TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view2, R.id.log_in_button);
                        if (talabatFillButton != null) {
                            i11 = R.id.log_to_access_wallet;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.log_to_access_wallet);
                            if (textView3 != null) {
                                i11 = R.id.menu_manage_textview;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.menu_manage_textview);
                                if (textView4 != null) {
                                    i11 = R.id.progressBar;
                                    ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.progressBar);
                                    if (progressBar2 != null) {
                                        i11 = R.id.send_gift_button;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.send_gift_button);
                                        if (textView5 != null) {
                                            i11 = R.id.sticky_toolbar_available_credit_amount_text_view;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.sticky_toolbar_available_credit_amount_text_view);
                                            if (textView6 != null) {
                                                i11 = R.id.sticky_toolbar_available_credit_text_view;
                                                TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.sticky_toolbar_available_credit_text_view);
                                                if (talabatTextView != null) {
                                                    i11 = R.id.sticky_toolbar_currency_text_view;
                                                    TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.sticky_toolbar_currency_text_view);
                                                    if (talabatTextView2 != null) {
                                                        i11 = R.id.sticky_toolbar_spent_in_month_amount_text_view;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.sticky_toolbar_spent_in_month_amount_text_view);
                                                        if (textView7 != null) {
                                                            i11 = R.id.sticky_toolbar_spent_in_month_string_text_view;
                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, R.id.sticky_toolbar_spent_in_month_string_text_view);
                                                            if (textView8 != null) {
                                                                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view2;
                                                                i11 = R.id.talabat_toolbar;
                                                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.talabat_toolbar);
                                                                if (relativeLayout != null) {
                                                                    i11 = R.id.toolbar;
                                                                    Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                                    if (toolbar2 != null) {
                                                                        i11 = R.id.toolbar_back_icon;
                                                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.toolbar_back_icon);
                                                                        if (imageView != null) {
                                                                            i11 = R.id.toolbar_layout;
                                                                            CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) ViewBindings.findChildViewById(view2, R.id.toolbar_layout);
                                                                            if (collapsingToolbarLayout != null) {
                                                                                i11 = R.id.top_button;
                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view2, R.id.top_button);
                                                                                if (textView9 != null) {
                                                                                    i11 = R.id.user_not_logged_container;
                                                                                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, R.id.user_not_logged_container);
                                                                                    if (constraintLayout != null) {
                                                                                        i11 = R.id.wallet_action_container;
                                                                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view2, R.id.wallet_action_container);
                                                                                        if (constraintLayout2 != null) {
                                                                                            i11 = R.id.wallet_balance_text_view;
                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view2, R.id.wallet_balance_text_view);
                                                                                            if (textView10 != null) {
                                                                                                i11 = R.id.wallet_credit_balance_summary_container;
                                                                                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view2, R.id.wallet_credit_balance_summary_container);
                                                                                                if (constraintLayout3 != null) {
                                                                                                    i11 = R.id.wallet_dashboard_title;
                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view2, R.id.wallet_dashboard_title);
                                                                                                    if (textView11 != null) {
                                                                                                        i11 = R.id.wallet_empty_icon;
                                                                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.wallet_empty_icon);
                                                                                                        if (imageView2 != null) {
                                                                                                            i11 = R.id.wallet_sticky_toolbar;
                                                                                                            Toolbar toolbar3 = (Toolbar) ViewBindings.findChildViewById(view2, R.id.wallet_sticky_toolbar);
                                                                                                            if (toolbar3 != null) {
                                                                                                                i11 = R.id.wallet_transaction_list;
                                                                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.wallet_transaction_list);
                                                                                                                if (recyclerView != null) {
                                                                                                                    return new ActivityWalletDashboardScreenBinding(swipeRefreshLayout, appBarLayout, textView, imageButton, textView2, talabatFillButton, textView3, textView4, progressBar2, textView5, textView6, talabatTextView, talabatTextView2, textView7, textView8, swipeRefreshLayout, relativeLayout, toolbar2, imageView, collapsingToolbarLayout, textView9, constraintLayout, constraintLayout2, textView10, constraintLayout3, textView11, imageView2, toolbar3, recyclerView);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ActivityWalletDashboardScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityWalletDashboardScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_wallet_dashboard_screen, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public SwipeRefreshLayout getRoot() {
        return this.rootView;
    }
}
