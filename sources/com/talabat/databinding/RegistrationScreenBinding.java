package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Switch;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.materialedittext.MaterialEditText;
import com.talabat.R;
import com.talabat.TalabatRadioButton;
import com.talabat.TalabatTextView;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarRelativeLayoutContainer;
import com.talabat.helpers.TalabatToolBarTextView;
import com.talabat.talabatcommon.views.MobileNumberWithOTPView;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class RegistrationScreenBinding implements ViewBinding {
    @NonNull
    public final TalabatToolBarImageButton back;
    @NonNull
    public final TalabatFillButton btnSubmit;
    @NonNull
    public final LinearLayout consendTermsConditionContainer;
    @NonNull
    public final TalabatTextView consentTermsPrivacy;
    @NonNull
    public final FrameLayout containerDateOfBirth;
    @NonNull
    public final FrameLayout dateContainer;
    @NonNull
    public final MobileNumberWithOTPView eTMobileNumber;
    @NonNull
    public final MaterialEditText edtOTP;
    @NonNull
    public final MaterialEditText etRegConfirm;
    @NonNull
    public final MaterialEditText etRegEmail;
    @NonNull
    public final MaterialEditText etRegFirstName;
    @NonNull
    public final MaterialEditText etRegLastName;
    @NonNull
    public final MaterialEditText etRegMobile;
    @NonNull
    public final MaterialEditText etdob;
    @NonNull
    public final LinearLayout normalTermsAndConditionContainer;
    @NonNull
    public final TalabatTextView passwordError;
    @NonNull
    public final TalabatTextView passwordHint;
    @NonNull
    public final TalabatTextView privacyPolicy;
    @NonNull
    public final RadioGroup radioGroupGender;
    @NonNull
    public final TalabatRadioButton rbFemale;
    @NonNull
    public final TalabatRadioButton rbMale;
    @NonNull
    private final TalabatToolBarRelativeLayoutContainer rootView;
    @NonNull
    public final NestedScrollView scrollView;
    @NonNull
    public final CheckBox switchNewsLetter;
    @NonNull
    public final Switch switchSMS;
    @NonNull
    public final CheckBox termsConditionConsentCheck;
    @NonNull
    public final TalabatToolBarTextView title;
    @NonNull
    public final TalabatToolBar toolbar;
    @NonNull
    public final TalabatTextView txtForgot;
    @NonNull
    public final TalabatTextView txtSubTitle;
    @NonNull
    public final TalabatTextView txtTitle;

    private RegistrationScreenBinding(@NonNull TalabatToolBarRelativeLayoutContainer talabatToolBarRelativeLayoutContainer, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull TalabatFillButton talabatFillButton, @NonNull LinearLayout linearLayout, @NonNull TalabatTextView talabatTextView, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull MobileNumberWithOTPView mobileNumberWithOTPView, @NonNull MaterialEditText materialEditText, @NonNull MaterialEditText materialEditText2, @NonNull MaterialEditText materialEditText3, @NonNull MaterialEditText materialEditText4, @NonNull MaterialEditText materialEditText5, @NonNull MaterialEditText materialEditText6, @NonNull MaterialEditText materialEditText7, @NonNull LinearLayout linearLayout2, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatTextView talabatTextView4, @NonNull RadioGroup radioGroup, @NonNull TalabatRadioButton talabatRadioButton, @NonNull TalabatRadioButton talabatRadioButton2, @NonNull NestedScrollView nestedScrollView, @NonNull CheckBox checkBox, @NonNull Switch switchR, @NonNull CheckBox checkBox2, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull TalabatToolBar talabatToolBar, @NonNull TalabatTextView talabatTextView5, @NonNull TalabatTextView talabatTextView6, @NonNull TalabatTextView talabatTextView7) {
        this.rootView = talabatToolBarRelativeLayoutContainer;
        this.back = talabatToolBarImageButton;
        this.btnSubmit = talabatFillButton;
        this.consendTermsConditionContainer = linearLayout;
        this.consentTermsPrivacy = talabatTextView;
        this.containerDateOfBirth = frameLayout;
        this.dateContainer = frameLayout2;
        this.eTMobileNumber = mobileNumberWithOTPView;
        this.edtOTP = materialEditText;
        this.etRegConfirm = materialEditText2;
        this.etRegEmail = materialEditText3;
        this.etRegFirstName = materialEditText4;
        this.etRegLastName = materialEditText5;
        this.etRegMobile = materialEditText6;
        this.etdob = materialEditText7;
        this.normalTermsAndConditionContainer = linearLayout2;
        this.passwordError = talabatTextView2;
        this.passwordHint = talabatTextView3;
        this.privacyPolicy = talabatTextView4;
        this.radioGroupGender = radioGroup;
        this.rbFemale = talabatRadioButton;
        this.rbMale = talabatRadioButton2;
        this.scrollView = nestedScrollView;
        this.switchNewsLetter = checkBox;
        this.switchSMS = switchR;
        this.termsConditionConsentCheck = checkBox2;
        this.title = talabatToolBarTextView;
        this.toolbar = talabatToolBar;
        this.txtForgot = talabatTextView5;
        this.txtSubTitle = talabatTextView6;
        this.txtTitle = talabatTextView7;
    }

    @NonNull
    public static RegistrationScreenBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.back;
        TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view2, R.id.back);
        if (talabatToolBarImageButton != null) {
            i11 = R.id.btnSubmit;
            TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view2, R.id.btnSubmit);
            if (talabatFillButton != null) {
                i11 = R.id.consend_terms_condition_container;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.consend_terms_condition_container);
                if (linearLayout != null) {
                    i11 = R.id.consent_terms_privacy;
                    TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.consent_terms_privacy);
                    if (talabatTextView != null) {
                        i11 = R.id.containerDateOfBirth;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.containerDateOfBirth);
                        if (frameLayout != null) {
                            i11 = R.id.date_container;
                            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.date_container);
                            if (frameLayout2 != null) {
                                i11 = R.id.eTMobileNumber;
                                MobileNumberWithOTPView mobileNumberWithOTPView = (MobileNumberWithOTPView) ViewBindings.findChildViewById(view2, R.id.eTMobileNumber);
                                if (mobileNumberWithOTPView != null) {
                                    i11 = R.id.edtOTP;
                                    MaterialEditText materialEditText = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.edtOTP);
                                    if (materialEditText != null) {
                                        i11 = R.id.etRegConfirm;
                                        MaterialEditText materialEditText2 = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.etRegConfirm);
                                        if (materialEditText2 != null) {
                                            i11 = R.id.etRegEmail;
                                            MaterialEditText materialEditText3 = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.etRegEmail);
                                            if (materialEditText3 != null) {
                                                i11 = R.id.etRegFirstName;
                                                MaterialEditText materialEditText4 = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.etRegFirstName);
                                                if (materialEditText4 != null) {
                                                    i11 = R.id.etRegLastName;
                                                    MaterialEditText materialEditText5 = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.etRegLastName);
                                                    if (materialEditText5 != null) {
                                                        i11 = R.id.etRegMobile;
                                                        MaterialEditText materialEditText6 = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.etRegMobile);
                                                        if (materialEditText6 != null) {
                                                            i11 = R.id.etdob;
                                                            MaterialEditText materialEditText7 = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.etdob);
                                                            if (materialEditText7 != null) {
                                                                i11 = R.id.normal_terms_and_condition_container;
                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.normal_terms_and_condition_container);
                                                                if (linearLayout2 != null) {
                                                                    i11 = R.id.password_error;
                                                                    TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.password_error);
                                                                    if (talabatTextView2 != null) {
                                                                        i11 = R.id.password_hint;
                                                                        TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.password_hint);
                                                                        if (talabatTextView3 != null) {
                                                                            i11 = R.id.privacy_policy;
                                                                            TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.privacy_policy);
                                                                            if (talabatTextView4 != null) {
                                                                                i11 = R.id.radioGroupGender;
                                                                                RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view2, R.id.radioGroupGender);
                                                                                if (radioGroup != null) {
                                                                                    i11 = R.id.rbFemale;
                                                                                    TalabatRadioButton talabatRadioButton = (TalabatRadioButton) ViewBindings.findChildViewById(view2, R.id.rbFemale);
                                                                                    if (talabatRadioButton != null) {
                                                                                        i11 = R.id.rbMale;
                                                                                        TalabatRadioButton talabatRadioButton2 = (TalabatRadioButton) ViewBindings.findChildViewById(view2, R.id.rbMale);
                                                                                        if (talabatRadioButton2 != null) {
                                                                                            i11 = R.id.scrollView;
                                                                                            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view2, R.id.scrollView);
                                                                                            if (nestedScrollView != null) {
                                                                                                i11 = R.id.switchNewsLetter;
                                                                                                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view2, R.id.switchNewsLetter);
                                                                                                if (checkBox != null) {
                                                                                                    i11 = R.id.switchSMS;
                                                                                                    Switch switchR = (Switch) ViewBindings.findChildViewById(view2, R.id.switchSMS);
                                                                                                    if (switchR != null) {
                                                                                                        i11 = R.id.terms_condition_consent_check;
                                                                                                        CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view2, R.id.terms_condition_consent_check);
                                                                                                        if (checkBox2 != null) {
                                                                                                            i11 = R.id.title;
                                                                                                            TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view2, R.id.title);
                                                                                                            if (talabatToolBarTextView != null) {
                                                                                                                i11 = R.id.toolbar;
                                                                                                                TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                                                                                if (talabatToolBar != null) {
                                                                                                                    i11 = R.id.txtForgot;
                                                                                                                    TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.txtForgot);
                                                                                                                    if (talabatTextView5 != null) {
                                                                                                                        i11 = R.id.txtSubTitle;
                                                                                                                        TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.txtSubTitle);
                                                                                                                        if (talabatTextView6 != null) {
                                                                                                                            i11 = R.id.txtTitle;
                                                                                                                            TalabatTextView talabatTextView7 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.txtTitle);
                                                                                                                            if (talabatTextView7 != null) {
                                                                                                                                return new RegistrationScreenBinding((TalabatToolBarRelativeLayoutContainer) view2, talabatToolBarImageButton, talabatFillButton, linearLayout, talabatTextView, frameLayout, frameLayout2, mobileNumberWithOTPView, materialEditText, materialEditText2, materialEditText3, materialEditText4, materialEditText5, materialEditText6, materialEditText7, linearLayout2, talabatTextView2, talabatTextView3, talabatTextView4, radioGroup, talabatRadioButton, talabatRadioButton2, nestedScrollView, checkBox, switchR, checkBox2, talabatToolBarTextView, talabatToolBar, talabatTextView5, talabatTextView6, talabatTextView7);
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
    public static RegistrationScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static RegistrationScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.registration_screen, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public TalabatToolBarRelativeLayoutContainer getRoot() {
        return this.rootView;
    }
}
