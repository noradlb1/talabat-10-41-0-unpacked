package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class PaymentErrorNewBinding implements ViewBinding {
    @NonNull
    public final TalabatToolBarImageButton back;
    @NonNull
    public final LinearLayout detailsView;
    @NonNull
    public final TalabatTextView errorTitle;
    @NonNull
    public final LinearLayout knetGatewayDownContainer;
    @NonNull
    public final TalabatTextView knetPaymentAmount;
    @NonNull
    public final TalabatTextView knetPaymentAuthorizationId;
    @NonNull
    public final TalabatFillButton knetPaymentBackToCheckout;
    @NonNull
    public final TalabatTextView knetPaymentDate;
    @NonNull
    public final TalabatTextView knetPaymentPaymentId;
    @NonNull
    public final TalabatTextView knetPaymentReferenceId;
    @NonNull
    public final TalabatTextView knetPaymentResult;
    @NonNull
    public final TalabatTextView knetPaymentTrackId;
    @NonNull
    public final TalabatTextView knetPaymentTransactionId;
    @NonNull
    public final RelativeLayout parentLayout;
    @NonNull
    public final LinearLayout paymentDeclinedDetailsContainer;
    @NonNull
    public final LinearLayout paymentDeclinedTipsContainer;
    @NonNull
    public final TalabatTextView paymentErrorDescription;
    @NonNull
    public final LinearLayout paymentErrorDescriptionContainer;
    @NonNull
    public final TalabatTextView paymentErrorDescriptionPaymentDown;
    @NonNull
    public final LinearLayout paymentIdContainer;
    @NonNull
    public final RelativeLayout progressLayout;
    @NonNull
    public final LinearLayout referenceIdContainer;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TalabatToolBarTextView title;
    @NonNull
    public final TalabatToolBar toolbar;
    @NonNull
    public final LinearLayout trackIdContainer;
    @NonNull
    public final TalabatTextView transactionDecliendTo;
    @NonNull
    public final LinearLayout transactionDeclinedContainer;
    @NonNull
    public final LinearLayout transationIdContainer;

    private PaymentErrorNewBinding(@NonNull LinearLayout linearLayout, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull LinearLayout linearLayout2, @NonNull TalabatTextView talabatTextView, @NonNull LinearLayout linearLayout3, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatFillButton talabatFillButton, @NonNull TalabatTextView talabatTextView4, @NonNull TalabatTextView talabatTextView5, @NonNull TalabatTextView talabatTextView6, @NonNull TalabatTextView talabatTextView7, @NonNull TalabatTextView talabatTextView8, @NonNull TalabatTextView talabatTextView9, @NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout4, @NonNull LinearLayout linearLayout5, @NonNull TalabatTextView talabatTextView10, @NonNull LinearLayout linearLayout6, @NonNull TalabatTextView talabatTextView11, @NonNull LinearLayout linearLayout7, @NonNull RelativeLayout relativeLayout2, @NonNull LinearLayout linearLayout8, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull TalabatToolBar talabatToolBar, @NonNull LinearLayout linearLayout9, @NonNull TalabatTextView talabatTextView12, @NonNull LinearLayout linearLayout10, @NonNull LinearLayout linearLayout11) {
        this.rootView = linearLayout;
        this.back = talabatToolBarImageButton;
        this.detailsView = linearLayout2;
        this.errorTitle = talabatTextView;
        this.knetGatewayDownContainer = linearLayout3;
        this.knetPaymentAmount = talabatTextView2;
        this.knetPaymentAuthorizationId = talabatTextView3;
        this.knetPaymentBackToCheckout = talabatFillButton;
        this.knetPaymentDate = talabatTextView4;
        this.knetPaymentPaymentId = talabatTextView5;
        this.knetPaymentReferenceId = talabatTextView6;
        this.knetPaymentResult = talabatTextView7;
        this.knetPaymentTrackId = talabatTextView8;
        this.knetPaymentTransactionId = talabatTextView9;
        this.parentLayout = relativeLayout;
        this.paymentDeclinedDetailsContainer = linearLayout4;
        this.paymentDeclinedTipsContainer = linearLayout5;
        this.paymentErrorDescription = talabatTextView10;
        this.paymentErrorDescriptionContainer = linearLayout6;
        this.paymentErrorDescriptionPaymentDown = talabatTextView11;
        this.paymentIdContainer = linearLayout7;
        this.progressLayout = relativeLayout2;
        this.referenceIdContainer = linearLayout8;
        this.title = talabatToolBarTextView;
        this.toolbar = talabatToolBar;
        this.trackIdContainer = linearLayout9;
        this.transactionDecliendTo = talabatTextView12;
        this.transactionDeclinedContainer = linearLayout10;
        this.transationIdContainer = linearLayout11;
    }

    @NonNull
    public static PaymentErrorNewBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.back;
        TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view2, R.id.back);
        if (talabatToolBarImageButton != null) {
            i11 = R.id.detailsView;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.detailsView);
            if (linearLayout != null) {
                i11 = R.id.error_title;
                TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.error_title);
                if (talabatTextView != null) {
                    i11 = R.id.knet_gateway_down_container;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.knet_gateway_down_container);
                    if (linearLayout2 != null) {
                        i11 = R.id.knet_payment_amount;
                        TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.knet_payment_amount);
                        if (talabatTextView2 != null) {
                            i11 = R.id.knet_payment_authorization_id;
                            TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.knet_payment_authorization_id);
                            if (talabatTextView3 != null) {
                                i11 = R.id.knet_payment_back_to_checkout;
                                TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view2, R.id.knet_payment_back_to_checkout);
                                if (talabatFillButton != null) {
                                    i11 = R.id.knet_payment_date;
                                    TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.knet_payment_date);
                                    if (talabatTextView4 != null) {
                                        i11 = R.id.knet_payment_payment_id;
                                        TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.knet_payment_payment_id);
                                        if (talabatTextView5 != null) {
                                            i11 = R.id.knet_payment_reference_id;
                                            TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.knet_payment_reference_id);
                                            if (talabatTextView6 != null) {
                                                i11 = R.id.knet_payment_result;
                                                TalabatTextView talabatTextView7 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.knet_payment_result);
                                                if (talabatTextView7 != null) {
                                                    i11 = R.id.knet_payment_track_id;
                                                    TalabatTextView talabatTextView8 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.knet_payment_track_id);
                                                    if (talabatTextView8 != null) {
                                                        i11 = R.id.knet_payment_transaction_id;
                                                        TalabatTextView talabatTextView9 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.knet_payment_transaction_id);
                                                        if (talabatTextView9 != null) {
                                                            i11 = R.id.parent_layout;
                                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.parent_layout);
                                                            if (relativeLayout != null) {
                                                                i11 = R.id.payment_declined_details_container;
                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.payment_declined_details_container);
                                                                if (linearLayout3 != null) {
                                                                    i11 = R.id.payment_declined_tips_container;
                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.payment_declined_tips_container);
                                                                    if (linearLayout4 != null) {
                                                                        i11 = R.id.payment_error_description;
                                                                        TalabatTextView talabatTextView10 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.payment_error_description);
                                                                        if (talabatTextView10 != null) {
                                                                            i11 = R.id.payment_error_description_container;
                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.payment_error_description_container);
                                                                            if (linearLayout5 != null) {
                                                                                i11 = R.id.payment_error_description_payment_down;
                                                                                TalabatTextView talabatTextView11 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.payment_error_description_payment_down);
                                                                                if (talabatTextView11 != null) {
                                                                                    i11 = R.id.payment_id_container;
                                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.payment_id_container);
                                                                                    if (linearLayout6 != null) {
                                                                                        i11 = R.id.progress_layout;
                                                                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.progress_layout);
                                                                                        if (relativeLayout2 != null) {
                                                                                            i11 = R.id.reference_id_container;
                                                                                            LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.reference_id_container);
                                                                                            if (linearLayout7 != null) {
                                                                                                i11 = R.id.title;
                                                                                                TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view2, R.id.title);
                                                                                                if (talabatToolBarTextView != null) {
                                                                                                    i11 = R.id.toolbar;
                                                                                                    TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                                                                    if (talabatToolBar != null) {
                                                                                                        i11 = R.id.track_id_container;
                                                                                                        LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.track_id_container);
                                                                                                        if (linearLayout8 != null) {
                                                                                                            i11 = R.id.transaction_decliend_to;
                                                                                                            TalabatTextView talabatTextView12 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.transaction_decliend_to);
                                                                                                            if (talabatTextView12 != null) {
                                                                                                                i11 = R.id.transaction_declined_container;
                                                                                                                LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.transaction_declined_container);
                                                                                                                if (linearLayout9 != null) {
                                                                                                                    i11 = R.id.transation_id_container;
                                                                                                                    LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.transation_id_container);
                                                                                                                    if (linearLayout10 != null) {
                                                                                                                        return new PaymentErrorNewBinding((LinearLayout) view2, talabatToolBarImageButton, linearLayout, talabatTextView, linearLayout2, talabatTextView2, talabatTextView3, talabatFillButton, talabatTextView4, talabatTextView5, talabatTextView6, talabatTextView7, talabatTextView8, talabatTextView9, relativeLayout, linearLayout3, linearLayout4, talabatTextView10, linearLayout5, talabatTextView11, linearLayout6, relativeLayout2, linearLayout7, talabatToolBarTextView, talabatToolBar, linearLayout8, talabatTextView12, linearLayout9, linearLayout10);
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
    public static PaymentErrorNewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static PaymentErrorNewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.payment_error_new, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
