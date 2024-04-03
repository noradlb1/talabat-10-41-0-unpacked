package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.materialedittext.MaterialEditText;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarLinearLayoutContainer;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.talabatcommon.views.TalabatStrokeButton;

public final class AppFeedbackScreenBinding implements ViewBinding {
    @NonNull
    public final TalabatToolBarImageButton appFeedbackBack;
    @NonNull
    public final TalabatFillButton appFeedbackContactMe;
    @NonNull
    public final CardView appFeedbackContactMeView;
    @NonNull
    public final MaterialEditText appFeedbackEmail;
    @NonNull
    public final TalabatStrokeButton appFeedbackLiveChat;
    @NonNull
    public final CardView appFeedbackLiveChatCard;
    @NonNull
    public final MaterialEditText appFeedbackMobile;
    @NonNull
    public final TalabatStrokeButton appFeedbackNo;
    @NonNull
    public final TalabatFillButton appFeedbackSend;
    @NonNull
    public final LinearLayout contactMeButtonGroup;
    @NonNull
    public final MaterialEditText feedback;
    @NonNull
    public final TalabatTextView liveChatTxt;
    @NonNull
    public final CardView rateCardView;
    @NonNull
    public final RatingBar ratingbarAppFeedback;
    @NonNull
    private final TalabatToolBarLinearLayoutContainer rootView;
    @NonNull
    public final NestedScrollView scrollView1;
    @NonNull
    public final TalabatTextView talabatDotCom;
    @NonNull
    public final CardView thanksView;
    @NonNull
    public final TalabatToolBar toolbar;
    @NonNull
    public final CardView typeFeedbackView;

    private AppFeedbackScreenBinding(@NonNull TalabatToolBarLinearLayoutContainer talabatToolBarLinearLayoutContainer, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull TalabatFillButton talabatFillButton, @NonNull CardView cardView, @NonNull MaterialEditText materialEditText, @NonNull TalabatStrokeButton talabatStrokeButton, @NonNull CardView cardView2, @NonNull MaterialEditText materialEditText2, @NonNull TalabatStrokeButton talabatStrokeButton2, @NonNull TalabatFillButton talabatFillButton2, @NonNull LinearLayout linearLayout, @NonNull MaterialEditText materialEditText3, @NonNull TalabatTextView talabatTextView, @NonNull CardView cardView3, @NonNull RatingBar ratingBar, @NonNull NestedScrollView nestedScrollView, @NonNull TalabatTextView talabatTextView2, @NonNull CardView cardView4, @NonNull TalabatToolBar talabatToolBar, @NonNull CardView cardView5) {
        this.rootView = talabatToolBarLinearLayoutContainer;
        this.appFeedbackBack = talabatToolBarImageButton;
        this.appFeedbackContactMe = talabatFillButton;
        this.appFeedbackContactMeView = cardView;
        this.appFeedbackEmail = materialEditText;
        this.appFeedbackLiveChat = talabatStrokeButton;
        this.appFeedbackLiveChatCard = cardView2;
        this.appFeedbackMobile = materialEditText2;
        this.appFeedbackNo = talabatStrokeButton2;
        this.appFeedbackSend = talabatFillButton2;
        this.contactMeButtonGroup = linearLayout;
        this.feedback = materialEditText3;
        this.liveChatTxt = talabatTextView;
        this.rateCardView = cardView3;
        this.ratingbarAppFeedback = ratingBar;
        this.scrollView1 = nestedScrollView;
        this.talabatDotCom = talabatTextView2;
        this.thanksView = cardView4;
        this.toolbar = talabatToolBar;
        this.typeFeedbackView = cardView5;
    }

    @NonNull
    public static AppFeedbackScreenBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.app_feedback_back;
        TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view2, R.id.app_feedback_back);
        if (talabatToolBarImageButton != null) {
            i11 = R.id.app_feedback_contact_me;
            TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view2, R.id.app_feedback_contact_me);
            if (talabatFillButton != null) {
                i11 = R.id.app_feedback_contact_me_view;
                CardView cardView = (CardView) ViewBindings.findChildViewById(view2, R.id.app_feedback_contact_me_view);
                if (cardView != null) {
                    i11 = R.id.app_feedback_email;
                    MaterialEditText materialEditText = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.app_feedback_email);
                    if (materialEditText != null) {
                        i11 = R.id.app_feedback_live_chat;
                        TalabatStrokeButton talabatStrokeButton = (TalabatStrokeButton) ViewBindings.findChildViewById(view2, R.id.app_feedback_live_chat);
                        if (talabatStrokeButton != null) {
                            i11 = R.id.app_feedback_live_chat_card;
                            CardView cardView2 = (CardView) ViewBindings.findChildViewById(view2, R.id.app_feedback_live_chat_card);
                            if (cardView2 != null) {
                                i11 = R.id.app_feedback_mobile;
                                MaterialEditText materialEditText2 = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.app_feedback_mobile);
                                if (materialEditText2 != null) {
                                    i11 = R.id.app_feedback_no;
                                    TalabatStrokeButton talabatStrokeButton2 = (TalabatStrokeButton) ViewBindings.findChildViewById(view2, R.id.app_feedback_no);
                                    if (talabatStrokeButton2 != null) {
                                        i11 = R.id.app_feedback_send;
                                        TalabatFillButton talabatFillButton2 = (TalabatFillButton) ViewBindings.findChildViewById(view2, R.id.app_feedback_send);
                                        if (talabatFillButton2 != null) {
                                            i11 = R.id.contact_me_button_group;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.contact_me_button_group);
                                            if (linearLayout != null) {
                                                i11 = R.id.feedback;
                                                MaterialEditText materialEditText3 = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.feedback);
                                                if (materialEditText3 != null) {
                                                    i11 = R.id.live_chat_txt;
                                                    TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.live_chat_txt);
                                                    if (talabatTextView != null) {
                                                        i11 = R.id.rate_card_view;
                                                        CardView cardView3 = (CardView) ViewBindings.findChildViewById(view2, R.id.rate_card_view);
                                                        if (cardView3 != null) {
                                                            i11 = R.id.ratingbar_app_feedback;
                                                            RatingBar ratingBar = (RatingBar) ViewBindings.findChildViewById(view2, R.id.ratingbar_app_feedback);
                                                            if (ratingBar != null) {
                                                                i11 = R.id.scrollView1;
                                                                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view2, R.id.scrollView1);
                                                                if (nestedScrollView != null) {
                                                                    i11 = R.id.talabat_dot_com;
                                                                    TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.talabat_dot_com);
                                                                    if (talabatTextView2 != null) {
                                                                        i11 = R.id.thanks_view;
                                                                        CardView cardView4 = (CardView) ViewBindings.findChildViewById(view2, R.id.thanks_view);
                                                                        if (cardView4 != null) {
                                                                            i11 = R.id.toolbar;
                                                                            TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                                            if (talabatToolBar != null) {
                                                                                i11 = R.id.type_feedback_view;
                                                                                CardView cardView5 = (CardView) ViewBindings.findChildViewById(view2, R.id.type_feedback_view);
                                                                                if (cardView5 != null) {
                                                                                    return new AppFeedbackScreenBinding((TalabatToolBarLinearLayoutContainer) view2, talabatToolBarImageButton, talabatFillButton, cardView, materialEditText, talabatStrokeButton, cardView2, materialEditText2, talabatStrokeButton2, talabatFillButton2, linearLayout, materialEditText3, talabatTextView, cardView3, ratingBar, nestedScrollView, talabatTextView2, cardView4, talabatToolBar, cardView5);
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
    public static AppFeedbackScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static AppFeedbackScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.app_feedback_screen, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public TalabatToolBarLinearLayoutContainer getRoot() {
        return this.rootView;
    }
}
