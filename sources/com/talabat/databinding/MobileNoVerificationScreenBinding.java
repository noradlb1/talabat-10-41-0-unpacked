package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.materialedittext.MaterialEditText;
import com.talabat.R;
import com.talabat.TalabatSpinner;
import com.talabat.TalabatTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;
import mobilenumberverificationhelpers.PinEntryEditText;

public final class MobileNoVerificationScreenBinding implements ViewBinding {
    @Nullable
    public final TalabatTextView arabicErrorTxt;
    @NonNull
    public final ImageView callMeImg;
    @NonNull
    public final TalabatTextView callMeLabel;
    @NonNull
    public final LinearLayout callMeView;
    @NonNull
    public final TalabatTextView callmeCounter;
    @NonNull
    public final TalabatTextView continueButton;
    @NonNull
    public final TalabatSpinner countryCodeSpinner;
    @NonNull
    public final TalabatSpinner countryCodeUpdateSpinner;
    @NonNull
    public final TalabatTextView getCode;
    @NonNull
    public final TalabatTextView liveChatCounter;
    @NonNull
    public final ImageView liveChatImage;
    @NonNull
    public final TalabatTextView liveChatLabel;
    @NonNull
    public final LinearLayout liveChatView;
    @NonNull
    public final TalabatTextView mobileThankyouScreenTitle;
    @NonNull
    public final TalabatTextView next;
    @NonNull
    public final TalabatTextView otpCancel;
    @NonNull
    public final TalabatTextView otpChange;
    @NonNull
    public final TalabatTextView otpCountryCode;
    @NonNull
    public final TalabatTextView otpNumber;
    @NonNull
    public final TalabatFillButton otpVerify;
    @NonNull
    public final CardView otpView;
    @NonNull
    public final LinearLayout resendCodeView;
    @NonNull
    public final TalabatTextView resendCounter;
    @NonNull
    public final ImageView resendImg;
    @NonNull
    public final TalabatTextView resendMeLabel;
    @NonNull
    public final LinearLayout rootLayout;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TalabatTextView talabatTextView4;
    @NonNull
    public final TalabatTextView talabatTextView5;
    @NonNull
    public final TalabatTextView talabatTextView6;
    @NonNull
    public final TalabatTextView talabatTextView7;
    @Nullable
    public final TalabatTextView talabatTextView8;
    @NonNull
    public final PinEntryEditText txtPinEntry;
    @NonNull
    public final TalabatTextView updateCancel;
    @Nullable
    public final LinearLayout updateContainer;
    @NonNull
    public final TalabatTextView updateCountryCode;
    @NonNull
    public final CardView updateMobNoMainView;
    @NonNull
    public final MaterialEditText updateNumber;
    @NonNull
    public final TalabatTextView updatedMessage;
    @NonNull
    public final CardView updatedNumberView;
    @NonNull
    public final TalabatTextView updatedThankyouCountryCode;
    @NonNull
    public final TalabatTextView updatedThankyouNumber;
    @NonNull
    public final TalabatTextView verifiedNumberMessage;
    @NonNull
    public final TalabatTextView verifyCancel;
    @NonNull
    public final TalabatTextView verifyChangeButton;
    @NonNull
    public final TalabatTextView verifyCountryCode;
    @NonNull
    public final TalabatTextView verifyEnter4DigitsMsg;
    @NonNull
    public final TalabatTextView verifyNumber;
    @NonNull
    public final CardView verifyNumberInitialView;

    private MobileNoVerificationScreenBinding(@NonNull LinearLayout linearLayout, @Nullable TalabatTextView talabatTextView, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView2, @NonNull LinearLayout linearLayout2, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatTextView talabatTextView9, @NonNull TalabatSpinner talabatSpinner, @NonNull TalabatSpinner talabatSpinner2, @NonNull TalabatTextView talabatTextView10, @NonNull TalabatTextView talabatTextView11, @NonNull ImageView imageView2, @NonNull TalabatTextView talabatTextView12, @NonNull LinearLayout linearLayout3, @NonNull TalabatTextView talabatTextView13, @NonNull TalabatTextView talabatTextView14, @NonNull TalabatTextView talabatTextView15, @NonNull TalabatTextView talabatTextView16, @NonNull TalabatTextView talabatTextView17, @NonNull TalabatTextView talabatTextView18, @NonNull TalabatFillButton talabatFillButton, @NonNull CardView cardView, @NonNull LinearLayout linearLayout4, @NonNull TalabatTextView talabatTextView19, @NonNull ImageView imageView3, @NonNull TalabatTextView talabatTextView20, @NonNull LinearLayout linearLayout5, @NonNull TalabatTextView talabatTextView21, @NonNull TalabatTextView talabatTextView22, @NonNull TalabatTextView talabatTextView23, @NonNull TalabatTextView talabatTextView24, @Nullable TalabatTextView talabatTextView25, @NonNull PinEntryEditText pinEntryEditText, @NonNull TalabatTextView talabatTextView26, @Nullable LinearLayout linearLayout6, @NonNull TalabatTextView talabatTextView27, @NonNull CardView cardView2, @NonNull MaterialEditText materialEditText, @NonNull TalabatTextView talabatTextView28, @NonNull CardView cardView3, @NonNull TalabatTextView talabatTextView29, @NonNull TalabatTextView talabatTextView30, @NonNull TalabatTextView talabatTextView31, @NonNull TalabatTextView talabatTextView32, @NonNull TalabatTextView talabatTextView33, @NonNull TalabatTextView talabatTextView34, @NonNull TalabatTextView talabatTextView35, @NonNull TalabatTextView talabatTextView36, @NonNull CardView cardView4) {
        this.rootView = linearLayout;
        this.arabicErrorTxt = talabatTextView;
        this.callMeImg = imageView;
        this.callMeLabel = talabatTextView2;
        this.callMeView = linearLayout2;
        this.callmeCounter = talabatTextView3;
        this.continueButton = talabatTextView9;
        this.countryCodeSpinner = talabatSpinner;
        this.countryCodeUpdateSpinner = talabatSpinner2;
        this.getCode = talabatTextView10;
        this.liveChatCounter = talabatTextView11;
        this.liveChatImage = imageView2;
        this.liveChatLabel = talabatTextView12;
        this.liveChatView = linearLayout3;
        this.mobileThankyouScreenTitle = talabatTextView13;
        this.next = talabatTextView14;
        this.otpCancel = talabatTextView15;
        this.otpChange = talabatTextView16;
        this.otpCountryCode = talabatTextView17;
        this.otpNumber = talabatTextView18;
        this.otpVerify = talabatFillButton;
        this.otpView = cardView;
        this.resendCodeView = linearLayout4;
        this.resendCounter = talabatTextView19;
        this.resendImg = imageView3;
        this.resendMeLabel = talabatTextView20;
        this.rootLayout = linearLayout5;
        this.talabatTextView4 = talabatTextView21;
        this.talabatTextView5 = talabatTextView22;
        this.talabatTextView6 = talabatTextView23;
        this.talabatTextView7 = talabatTextView24;
        this.talabatTextView8 = talabatTextView25;
        this.txtPinEntry = pinEntryEditText;
        this.updateCancel = talabatTextView26;
        this.updateContainer = linearLayout6;
        this.updateCountryCode = talabatTextView27;
        this.updateMobNoMainView = cardView2;
        this.updateNumber = materialEditText;
        this.updatedMessage = talabatTextView28;
        this.updatedNumberView = cardView3;
        this.updatedThankyouCountryCode = talabatTextView29;
        this.updatedThankyouNumber = talabatTextView30;
        this.verifiedNumberMessage = talabatTextView31;
        this.verifyCancel = talabatTextView32;
        this.verifyChangeButton = talabatTextView33;
        this.verifyCountryCode = talabatTextView34;
        this.verifyEnter4DigitsMsg = talabatTextView35;
        this.verifyNumber = talabatTextView36;
        this.verifyNumberInitialView = cardView4;
    }

    @NonNull
    public static MobileNoVerificationScreenBinding bind(@NonNull View view) {
        View view2 = view;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.arabic_error_txt);
        int i11 = R.id.call_me_img;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.call_me_img);
        if (imageView != null) {
            i11 = R.id.call_me_label;
            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.call_me_label);
            if (talabatTextView2 != null) {
                i11 = R.id.call_me_view;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.call_me_view);
                if (linearLayout != null) {
                    i11 = R.id.callme_counter;
                    TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.callme_counter);
                    if (talabatTextView3 != null) {
                        i11 = R.id.continue_button;
                        TalabatTextView talabatTextView9 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.continue_button);
                        if (talabatTextView9 != null) {
                            i11 = R.id.country_code_spinner;
                            TalabatSpinner talabatSpinner = (TalabatSpinner) ViewBindings.findChildViewById(view2, R.id.country_code_spinner);
                            if (talabatSpinner != null) {
                                i11 = R.id.country_code_update_spinner;
                                TalabatSpinner talabatSpinner2 = (TalabatSpinner) ViewBindings.findChildViewById(view2, R.id.country_code_update_spinner);
                                if (talabatSpinner2 != null) {
                                    i11 = R.id.get_code;
                                    TalabatTextView talabatTextView10 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.get_code);
                                    if (talabatTextView10 != null) {
                                        i11 = R.id.live_chat_counter;
                                        TalabatTextView talabatTextView11 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.live_chat_counter);
                                        if (talabatTextView11 != null) {
                                            i11 = R.id.live_chat_image;
                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.live_chat_image);
                                            if (imageView2 != null) {
                                                i11 = R.id.live_chat_label;
                                                TalabatTextView talabatTextView12 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.live_chat_label);
                                                if (talabatTextView12 != null) {
                                                    i11 = R.id.live_chat_view;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.live_chat_view);
                                                    if (linearLayout2 != null) {
                                                        i11 = R.id.mobile_thankyou_screen_title;
                                                        TalabatTextView talabatTextView13 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.mobile_thankyou_screen_title);
                                                        if (talabatTextView13 != null) {
                                                            i11 = R.id.next;
                                                            TalabatTextView talabatTextView14 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.next);
                                                            if (talabatTextView14 != null) {
                                                                i11 = R.id.otp_cancel;
                                                                TalabatTextView talabatTextView15 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.otp_cancel);
                                                                if (talabatTextView15 != null) {
                                                                    i11 = R.id.otp_change;
                                                                    TalabatTextView talabatTextView16 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.otp_change);
                                                                    if (talabatTextView16 != null) {
                                                                        i11 = R.id.otp_country_code;
                                                                        TalabatTextView talabatTextView17 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.otp_country_code);
                                                                        if (talabatTextView17 != null) {
                                                                            i11 = R.id.otp_number;
                                                                            TalabatTextView talabatTextView18 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.otp_number);
                                                                            if (talabatTextView18 != null) {
                                                                                i11 = R.id.otp_verify;
                                                                                TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view2, R.id.otp_verify);
                                                                                if (talabatFillButton != null) {
                                                                                    i11 = R.id.otp_view;
                                                                                    CardView cardView = (CardView) ViewBindings.findChildViewById(view2, R.id.otp_view);
                                                                                    if (cardView != null) {
                                                                                        i11 = R.id.resend_code_view;
                                                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.resend_code_view);
                                                                                        if (linearLayout3 != null) {
                                                                                            i11 = R.id.resend_counter;
                                                                                            TalabatTextView talabatTextView19 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.resend_counter);
                                                                                            if (talabatTextView19 != null) {
                                                                                                i11 = R.id.resend_img;
                                                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.resend_img);
                                                                                                if (imageView3 != null) {
                                                                                                    i11 = R.id.resend_me_label;
                                                                                                    TalabatTextView talabatTextView20 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.resend_me_label);
                                                                                                    if (talabatTextView20 != null) {
                                                                                                        LinearLayout linearLayout4 = (LinearLayout) view2;
                                                                                                        i11 = R.id.talabatTextView4;
                                                                                                        TalabatTextView talabatTextView21 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.talabatTextView4);
                                                                                                        if (talabatTextView21 != null) {
                                                                                                            i11 = R.id.talabatTextView5;
                                                                                                            TalabatTextView talabatTextView22 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.talabatTextView5);
                                                                                                            if (talabatTextView22 != null) {
                                                                                                                i11 = R.id.talabatTextView6;
                                                                                                                TalabatTextView talabatTextView23 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.talabatTextView6);
                                                                                                                if (talabatTextView23 != null) {
                                                                                                                    i11 = R.id.talabatTextView7;
                                                                                                                    TalabatTextView talabatTextView24 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.talabatTextView7);
                                                                                                                    if (talabatTextView24 != null) {
                                                                                                                        TalabatTextView talabatTextView25 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.talabatTextView8);
                                                                                                                        i11 = R.id.txt_pin_entry;
                                                                                                                        PinEntryEditText pinEntryEditText = (PinEntryEditText) ViewBindings.findChildViewById(view2, R.id.txt_pin_entry);
                                                                                                                        if (pinEntryEditText != null) {
                                                                                                                            i11 = R.id.update_cancel;
                                                                                                                            TalabatTextView talabatTextView26 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.update_cancel);
                                                                                                                            if (talabatTextView26 != null) {
                                                                                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.update_container);
                                                                                                                                i11 = R.id.update_country_code;
                                                                                                                                TalabatTextView talabatTextView27 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.update_country_code);
                                                                                                                                if (talabatTextView27 != null) {
                                                                                                                                    i11 = R.id.update_mob_no_main_view;
                                                                                                                                    CardView cardView2 = (CardView) ViewBindings.findChildViewById(view2, R.id.update_mob_no_main_view);
                                                                                                                                    if (cardView2 != null) {
                                                                                                                                        i11 = R.id.update_number;
                                                                                                                                        MaterialEditText materialEditText = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.update_number);
                                                                                                                                        if (materialEditText != null) {
                                                                                                                                            i11 = R.id.updated_message;
                                                                                                                                            TalabatTextView talabatTextView28 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.updated_message);
                                                                                                                                            if (talabatTextView28 != null) {
                                                                                                                                                i11 = R.id.updated_number_view;
                                                                                                                                                CardView cardView3 = (CardView) ViewBindings.findChildViewById(view2, R.id.updated_number_view);
                                                                                                                                                if (cardView3 != null) {
                                                                                                                                                    i11 = R.id.updated_thankyou_country_code;
                                                                                                                                                    TalabatTextView talabatTextView29 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.updated_thankyou_country_code);
                                                                                                                                                    if (talabatTextView29 != null) {
                                                                                                                                                        i11 = R.id.updated_thankyou_number;
                                                                                                                                                        TalabatTextView talabatTextView30 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.updated_thankyou_number);
                                                                                                                                                        if (talabatTextView30 != null) {
                                                                                                                                                            i11 = R.id.verified_number_message;
                                                                                                                                                            TalabatTextView talabatTextView31 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.verified_number_message);
                                                                                                                                                            if (talabatTextView31 != null) {
                                                                                                                                                                i11 = R.id.verify_cancel;
                                                                                                                                                                TalabatTextView talabatTextView32 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.verify_cancel);
                                                                                                                                                                if (talabatTextView32 != null) {
                                                                                                                                                                    i11 = R.id.verify_change_button;
                                                                                                                                                                    TalabatTextView talabatTextView33 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.verify_change_button);
                                                                                                                                                                    if (talabatTextView33 != null) {
                                                                                                                                                                        i11 = R.id.verify_country_code;
                                                                                                                                                                        TalabatTextView talabatTextView34 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.verify_country_code);
                                                                                                                                                                        if (talabatTextView34 != null) {
                                                                                                                                                                            i11 = R.id.verify_enter_4_digits_msg;
                                                                                                                                                                            TalabatTextView talabatTextView35 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.verify_enter_4_digits_msg);
                                                                                                                                                                            if (talabatTextView35 != null) {
                                                                                                                                                                                i11 = R.id.verify_number;
                                                                                                                                                                                TalabatTextView talabatTextView36 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.verify_number);
                                                                                                                                                                                if (talabatTextView36 != null) {
                                                                                                                                                                                    i11 = R.id.verify_number_initial_view;
                                                                                                                                                                                    CardView cardView4 = (CardView) ViewBindings.findChildViewById(view2, R.id.verify_number_initial_view);
                                                                                                                                                                                    if (cardView4 != null) {
                                                                                                                                                                                        return new MobileNoVerificationScreenBinding(linearLayout4, talabatTextView, imageView, talabatTextView2, linearLayout, talabatTextView3, talabatTextView9, talabatSpinner, talabatSpinner2, talabatTextView10, talabatTextView11, imageView2, talabatTextView12, linearLayout2, talabatTextView13, talabatTextView14, talabatTextView15, talabatTextView16, talabatTextView17, talabatTextView18, talabatFillButton, cardView, linearLayout3, talabatTextView19, imageView3, talabatTextView20, linearLayout4, talabatTextView21, talabatTextView22, talabatTextView23, talabatTextView24, talabatTextView25, pinEntryEditText, talabatTextView26, linearLayout5, talabatTextView27, cardView2, materialEditText, talabatTextView28, cardView3, talabatTextView29, talabatTextView30, talabatTextView31, talabatTextView32, talabatTextView33, talabatTextView34, talabatTextView35, talabatTextView36, cardView4);
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
    public static MobileNoVerificationScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static MobileNoVerificationScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.mobile_no_verification_screen, viewGroup, false);
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
