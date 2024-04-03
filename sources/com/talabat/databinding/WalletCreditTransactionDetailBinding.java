package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.talabatcommon.views.TalabatStrokeButton;

public final class WalletCreditTransactionDetailBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView creditCardAmountDeducted;
    @NonNull
    public final ImageView creditCardLogo;
    @NonNull
    public final TalabatTextView creditCardName;
    @NonNull
    public final TalabatTextView creditCardStringPlaceholder;
    @NonNull
    public final ConstraintLayout expiredCardContainer;
    @NonNull
    public final TalabatTextView expiredStringPlaceholder;
    @NonNull
    public final TalabatTextView expiryDate;
    @NonNull
    public final TalabatTextView expiryStringPlaceholder;
    @NonNull
    public final WalletTransactionDetailHeaderBinding inputInclude;
    @NonNull
    public final WalletCashbackViewBinding paidCashbackContainer;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    public final TalabatTextView receivedFromStringPlaceholder;
    @NonNull
    public final TalabatTextView receivedFromStringPlaceholderExpired;
    @NonNull
    public final WalletCashbackViewBinding rechargeCashbackContainer;
    @NonNull
    public final ConstraintLayout rechargeContainer;
    @NonNull
    public final WalletCashbackViewBinding refundCashbackContainer;
    @NonNull
    public final ConstraintLayout refundCreditContainer;
    @NonNull
    public final TalabatTextView refundSource;
    @NonNull
    public final TalabatTextView refundSourceExpired;
    @NonNull
    public final TalabatTextView riderTipAmount;
    @NonNull
    public final ConstraintLayout riderTipContainer;
    @NonNull
    public final TalabatTextView riderTipTextView;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final ConstraintLayout rootViewDetailTransaction;
    @NonNull
    public final TalabatTextView tpayAmount;
    @NonNull
    public final TalabatTextView tpayLogo;
    @NonNull
    public final TalabatTextView transactionAmount;
    @NonNull
    public final ConstraintLayout transactionAmountContainer;
    @NonNull
    public final TalabatTextView transactionDate;
    @NonNull
    public final ImageView transactionLogo;
    @NonNull
    public final TalabatTextView transactionName;
    @NonNull
    public final TalabatStrokeButton viewOrderSummaryButton;
    @NonNull
    public final View viewRefund;
    @NonNull
    public final View viewRefundExpired;
    @NonNull
    public final TalabatTextView voucherAmount;
    @NonNull
    public final ConstraintLayout voucherContainer;
    @NonNull
    public final TalabatTextView voucherStringPlaceholder;

    private WalletCreditTransactionDetailBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TalabatTextView talabatTextView, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull ConstraintLayout constraintLayout2, @NonNull TalabatTextView talabatTextView4, @NonNull TalabatTextView talabatTextView5, @NonNull TalabatTextView talabatTextView6, @NonNull WalletTransactionDetailHeaderBinding walletTransactionDetailHeaderBinding, @NonNull WalletCashbackViewBinding walletCashbackViewBinding, @NonNull ProgressBar progressBar2, @NonNull TalabatTextView talabatTextView7, @NonNull TalabatTextView talabatTextView8, @NonNull WalletCashbackViewBinding walletCashbackViewBinding2, @NonNull ConstraintLayout constraintLayout3, @NonNull WalletCashbackViewBinding walletCashbackViewBinding3, @NonNull ConstraintLayout constraintLayout4, @NonNull TalabatTextView talabatTextView9, @NonNull TalabatTextView talabatTextView10, @NonNull TalabatTextView talabatTextView11, @NonNull ConstraintLayout constraintLayout5, @NonNull TalabatTextView talabatTextView12, @NonNull ConstraintLayout constraintLayout6, @NonNull TalabatTextView talabatTextView13, @NonNull TalabatTextView talabatTextView14, @NonNull TalabatTextView talabatTextView15, @NonNull ConstraintLayout constraintLayout7, @NonNull TalabatTextView talabatTextView16, @NonNull ImageView imageView2, @NonNull TalabatTextView talabatTextView17, @NonNull TalabatStrokeButton talabatStrokeButton, @NonNull View view, @NonNull View view2, @NonNull TalabatTextView talabatTextView18, @NonNull ConstraintLayout constraintLayout8, @NonNull TalabatTextView talabatTextView19) {
        this.rootView = constraintLayout;
        this.creditCardAmountDeducted = talabatTextView;
        this.creditCardLogo = imageView;
        this.creditCardName = talabatTextView2;
        this.creditCardStringPlaceholder = talabatTextView3;
        this.expiredCardContainer = constraintLayout2;
        this.expiredStringPlaceholder = talabatTextView4;
        this.expiryDate = talabatTextView5;
        this.expiryStringPlaceholder = talabatTextView6;
        this.inputInclude = walletTransactionDetailHeaderBinding;
        this.paidCashbackContainer = walletCashbackViewBinding;
        this.progressBar = progressBar2;
        this.receivedFromStringPlaceholder = talabatTextView7;
        this.receivedFromStringPlaceholderExpired = talabatTextView8;
        this.rechargeCashbackContainer = walletCashbackViewBinding2;
        this.rechargeContainer = constraintLayout3;
        this.refundCashbackContainer = walletCashbackViewBinding3;
        this.refundCreditContainer = constraintLayout4;
        this.refundSource = talabatTextView9;
        this.refundSourceExpired = talabatTextView10;
        this.riderTipAmount = talabatTextView11;
        this.riderTipContainer = constraintLayout5;
        this.riderTipTextView = talabatTextView12;
        this.rootViewDetailTransaction = constraintLayout6;
        this.tpayAmount = talabatTextView13;
        this.tpayLogo = talabatTextView14;
        this.transactionAmount = talabatTextView15;
        this.transactionAmountContainer = constraintLayout7;
        this.transactionDate = talabatTextView16;
        this.transactionLogo = imageView2;
        this.transactionName = talabatTextView17;
        this.viewOrderSummaryButton = talabatStrokeButton;
        this.viewRefund = view;
        this.viewRefundExpired = view2;
        this.voucherAmount = talabatTextView18;
        this.voucherContainer = constraintLayout8;
        this.voucherStringPlaceholder = talabatTextView19;
    }

    @NonNull
    public static WalletCreditTransactionDetailBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.credit_card_amount_deducted;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.credit_card_amount_deducted);
        if (talabatTextView != null) {
            i11 = R.id.credit_card_logo;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.credit_card_logo);
            if (imageView != null) {
                i11 = R.id.credit_card_name;
                TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.credit_card_name);
                if (talabatTextView2 != null) {
                    i11 = R.id.credit_card_string_placeholder;
                    TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.credit_card_string_placeholder);
                    if (talabatTextView3 != null) {
                        i11 = R.id.expired_card_container;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, R.id.expired_card_container);
                        if (constraintLayout != null) {
                            i11 = R.id.expired_string_placeholder;
                            TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.expired_string_placeholder);
                            if (talabatTextView4 != null) {
                                i11 = R.id.expiry_date;
                                TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.expiry_date);
                                if (talabatTextView5 != null) {
                                    i11 = R.id.expiry_string_placeholder;
                                    TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.expiry_string_placeholder);
                                    if (talabatTextView6 != null) {
                                        i11 = R.id.input_include;
                                        View findChildViewById = ViewBindings.findChildViewById(view2, R.id.input_include);
                                        if (findChildViewById != null) {
                                            WalletTransactionDetailHeaderBinding bind = WalletTransactionDetailHeaderBinding.bind(findChildViewById);
                                            i11 = R.id.paid_cashback_container;
                                            View findChildViewById2 = ViewBindings.findChildViewById(view2, R.id.paid_cashback_container);
                                            if (findChildViewById2 != null) {
                                                WalletCashbackViewBinding bind2 = WalletCashbackViewBinding.bind(findChildViewById2);
                                                i11 = R.id.progressBar;
                                                ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.progressBar);
                                                if (progressBar2 != null) {
                                                    i11 = R.id.received_from_string_placeholder;
                                                    TalabatTextView talabatTextView7 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.received_from_string_placeholder);
                                                    if (talabatTextView7 != null) {
                                                        i11 = R.id.received_from_string_placeholder_expired;
                                                        TalabatTextView talabatTextView8 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.received_from_string_placeholder_expired);
                                                        if (talabatTextView8 != null) {
                                                            i11 = R.id.recharge_cashback_container;
                                                            View findChildViewById3 = ViewBindings.findChildViewById(view2, R.id.recharge_cashback_container);
                                                            if (findChildViewById3 != null) {
                                                                WalletCashbackViewBinding bind3 = WalletCashbackViewBinding.bind(findChildViewById3);
                                                                i11 = R.id.recharge_container;
                                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view2, R.id.recharge_container);
                                                                if (constraintLayout2 != null) {
                                                                    i11 = R.id.refund_cashback_container;
                                                                    View findChildViewById4 = ViewBindings.findChildViewById(view2, R.id.refund_cashback_container);
                                                                    if (findChildViewById4 != null) {
                                                                        WalletCashbackViewBinding bind4 = WalletCashbackViewBinding.bind(findChildViewById4);
                                                                        i11 = R.id.refund_credit_container;
                                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view2, R.id.refund_credit_container);
                                                                        if (constraintLayout3 != null) {
                                                                            i11 = R.id.refund_source;
                                                                            TalabatTextView talabatTextView9 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.refund_source);
                                                                            if (talabatTextView9 != null) {
                                                                                i11 = R.id.refund_source_expired;
                                                                                TalabatTextView talabatTextView10 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.refund_source_expired);
                                                                                if (talabatTextView10 != null) {
                                                                                    i11 = R.id.rider_tip_amount;
                                                                                    TalabatTextView talabatTextView11 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.rider_tip_amount);
                                                                                    if (talabatTextView11 != null) {
                                                                                        i11 = R.id.rider_tip_container;
                                                                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view2, R.id.rider_tip_container);
                                                                                        if (constraintLayout4 != null) {
                                                                                            i11 = R.id.rider_tip_text_view;
                                                                                            TalabatTextView talabatTextView12 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.rider_tip_text_view);
                                                                                            if (talabatTextView12 != null) {
                                                                                                ConstraintLayout constraintLayout5 = (ConstraintLayout) view2;
                                                                                                i11 = R.id.tpay_amount;
                                                                                                TalabatTextView talabatTextView13 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tpay_amount);
                                                                                                if (talabatTextView13 != null) {
                                                                                                    i11 = R.id.tpay_logo;
                                                                                                    TalabatTextView talabatTextView14 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tpay_logo);
                                                                                                    if (talabatTextView14 != null) {
                                                                                                        i11 = R.id.transaction_amount;
                                                                                                        TalabatTextView talabatTextView15 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.transaction_amount);
                                                                                                        if (talabatTextView15 != null) {
                                                                                                            i11 = R.id.transaction_amount_container;
                                                                                                            ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view2, R.id.transaction_amount_container);
                                                                                                            if (constraintLayout6 != null) {
                                                                                                                i11 = R.id.transaction_date;
                                                                                                                TalabatTextView talabatTextView16 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.transaction_date);
                                                                                                                if (talabatTextView16 != null) {
                                                                                                                    i11 = R.id.transaction_logo;
                                                                                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.transaction_logo);
                                                                                                                    if (imageView2 != null) {
                                                                                                                        i11 = R.id.transaction_name;
                                                                                                                        TalabatTextView talabatTextView17 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.transaction_name);
                                                                                                                        if (talabatTextView17 != null) {
                                                                                                                            i11 = R.id.view_order_summary_button;
                                                                                                                            TalabatStrokeButton talabatStrokeButton = (TalabatStrokeButton) ViewBindings.findChildViewById(view2, R.id.view_order_summary_button);
                                                                                                                            if (talabatStrokeButton != null) {
                                                                                                                                i11 = R.id.view_refund;
                                                                                                                                View findChildViewById5 = ViewBindings.findChildViewById(view2, R.id.view_refund);
                                                                                                                                if (findChildViewById5 != null) {
                                                                                                                                    i11 = R.id.view_refund_expired;
                                                                                                                                    View findChildViewById6 = ViewBindings.findChildViewById(view2, R.id.view_refund_expired);
                                                                                                                                    if (findChildViewById6 != null) {
                                                                                                                                        i11 = R.id.voucher_amount;
                                                                                                                                        TalabatTextView talabatTextView18 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.voucher_amount);
                                                                                                                                        if (talabatTextView18 != null) {
                                                                                                                                            i11 = R.id.voucher_container;
                                                                                                                                            ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view2, R.id.voucher_container);
                                                                                                                                            if (constraintLayout7 != null) {
                                                                                                                                                i11 = R.id.voucher_string_placeholder;
                                                                                                                                                TalabatTextView talabatTextView19 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.voucher_string_placeholder);
                                                                                                                                                if (talabatTextView19 != null) {
                                                                                                                                                    return new WalletCreditTransactionDetailBinding(constraintLayout5, talabatTextView, imageView, talabatTextView2, talabatTextView3, constraintLayout, talabatTextView4, talabatTextView5, talabatTextView6, bind, bind2, progressBar2, talabatTextView7, talabatTextView8, bind3, constraintLayout2, bind4, constraintLayout3, talabatTextView9, talabatTextView10, talabatTextView11, constraintLayout4, talabatTextView12, constraintLayout5, talabatTextView13, talabatTextView14, talabatTextView15, constraintLayout6, talabatTextView16, imageView2, talabatTextView17, talabatStrokeButton, findChildViewById5, findChildViewById6, talabatTextView18, constraintLayout7, talabatTextView19);
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
    public static WalletCreditTransactionDetailBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static WalletCreditTransactionDetailBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.wallet_credit_transaction_detail, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
