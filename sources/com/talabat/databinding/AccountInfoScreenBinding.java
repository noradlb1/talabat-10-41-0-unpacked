package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.materialedittext.MaterialEditText;
import com.talabat.R;
import com.talabat.TalabatRadioButton;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarButton;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarTextView;
import com.talabat.talabatcommon.views.MobileNumberEditText;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class AccountInfoScreenBinding implements ViewBinding {
    @NonNull
    public final TalabatToolBarImageButton accountInfoBack;
    @NonNull
    public final TalabatToolBarButton accountInfoDone;
    @NonNull
    public final MaterialEditText accountInfoEtRegEmail;
    @NonNull
    public final MaterialEditText accountInfoEtRegFirstName;
    @NonNull
    public final MaterialEditText accountInfoEtRegLastName;
    @NonNull
    public final MaterialEditText accountInfoEtdob;
    @NonNull
    public final LinearLayout accountInfoGenderEditView;
    @NonNull
    public final RadioGroup accountInfoRadioGroupGender;
    @NonNull
    public final TalabatRadioButton accountInfoRbFemale;
    @NonNull
    public final TalabatRadioButton accountInfoRbMale;
    @NonNull
    public final CheckBox accountInfoSwitchNewsLetter;
    @NonNull
    public final CheckBox accountInfoSwitchSMS;
    @NonNull
    public final TalabatToolBarTextView accountInfoTitle;
    @NonNull
    public final ImageView calendarIcon;
    @NonNull
    public final FrameLayout dateContainer;
    @NonNull
    public final MobileNumberEditText eTMobileNumber;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final TalabatFillButton saveBottom;
    @NonNull
    public final TalabatToolBar toolbar;

    private AccountInfoScreenBinding(@NonNull RelativeLayout relativeLayout, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull TalabatToolBarButton talabatToolBarButton, @NonNull MaterialEditText materialEditText, @NonNull MaterialEditText materialEditText2, @NonNull MaterialEditText materialEditText3, @NonNull MaterialEditText materialEditText4, @NonNull LinearLayout linearLayout, @NonNull RadioGroup radioGroup, @NonNull TalabatRadioButton talabatRadioButton, @NonNull TalabatRadioButton talabatRadioButton2, @NonNull CheckBox checkBox, @NonNull CheckBox checkBox2, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull MobileNumberEditText mobileNumberEditText, @NonNull TalabatFillButton talabatFillButton, @NonNull TalabatToolBar talabatToolBar) {
        this.rootView = relativeLayout;
        this.accountInfoBack = talabatToolBarImageButton;
        this.accountInfoDone = talabatToolBarButton;
        this.accountInfoEtRegEmail = materialEditText;
        this.accountInfoEtRegFirstName = materialEditText2;
        this.accountInfoEtRegLastName = materialEditText3;
        this.accountInfoEtdob = materialEditText4;
        this.accountInfoGenderEditView = linearLayout;
        this.accountInfoRadioGroupGender = radioGroup;
        this.accountInfoRbFemale = talabatRadioButton;
        this.accountInfoRbMale = talabatRadioButton2;
        this.accountInfoSwitchNewsLetter = checkBox;
        this.accountInfoSwitchSMS = checkBox2;
        this.accountInfoTitle = talabatToolBarTextView;
        this.calendarIcon = imageView;
        this.dateContainer = frameLayout;
        this.eTMobileNumber = mobileNumberEditText;
        this.saveBottom = talabatFillButton;
        this.toolbar = talabatToolBar;
    }

    @NonNull
    public static AccountInfoScreenBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.account_info_back;
        TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view2, R.id.account_info_back);
        if (talabatToolBarImageButton != null) {
            i11 = R.id.account_info_done;
            TalabatToolBarButton talabatToolBarButton = (TalabatToolBarButton) ViewBindings.findChildViewById(view2, R.id.account_info_done);
            if (talabatToolBarButton != null) {
                i11 = R.id.account_info_etRegEmail;
                MaterialEditText materialEditText = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.account_info_etRegEmail);
                if (materialEditText != null) {
                    i11 = R.id.account_info_etRegFirstName;
                    MaterialEditText materialEditText2 = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.account_info_etRegFirstName);
                    if (materialEditText2 != null) {
                        i11 = R.id.account_info_etRegLastName;
                        MaterialEditText materialEditText3 = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.account_info_etRegLastName);
                        if (materialEditText3 != null) {
                            i11 = R.id.account_info_etdob;
                            MaterialEditText materialEditText4 = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.account_info_etdob);
                            if (materialEditText4 != null) {
                                i11 = R.id.account_info_gender_edit_view;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.account_info_gender_edit_view);
                                if (linearLayout != null) {
                                    i11 = R.id.account_info_radioGroupGender;
                                    RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view2, R.id.account_info_radioGroupGender);
                                    if (radioGroup != null) {
                                        i11 = R.id.account_info_rbFemale;
                                        TalabatRadioButton talabatRadioButton = (TalabatRadioButton) ViewBindings.findChildViewById(view2, R.id.account_info_rbFemale);
                                        if (talabatRadioButton != null) {
                                            i11 = R.id.account_info_rbMale;
                                            TalabatRadioButton talabatRadioButton2 = (TalabatRadioButton) ViewBindings.findChildViewById(view2, R.id.account_info_rbMale);
                                            if (talabatRadioButton2 != null) {
                                                i11 = R.id.account_info_switchNewsLetter;
                                                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view2, R.id.account_info_switchNewsLetter);
                                                if (checkBox != null) {
                                                    i11 = R.id.account_info_switchSMS;
                                                    CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view2, R.id.account_info_switchSMS);
                                                    if (checkBox2 != null) {
                                                        i11 = R.id.account_info_title;
                                                        TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view2, R.id.account_info_title);
                                                        if (talabatToolBarTextView != null) {
                                                            i11 = R.id.calendar_icon;
                                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.calendar_icon);
                                                            if (imageView != null) {
                                                                i11 = R.id.date_container;
                                                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.date_container);
                                                                if (frameLayout != null) {
                                                                    i11 = R.id.eTMobileNumber;
                                                                    MobileNumberEditText mobileNumberEditText = (MobileNumberEditText) ViewBindings.findChildViewById(view2, R.id.eTMobileNumber);
                                                                    if (mobileNumberEditText != null) {
                                                                        i11 = R.id.save_bottom;
                                                                        TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view2, R.id.save_bottom);
                                                                        if (talabatFillButton != null) {
                                                                            i11 = R.id.toolbar;
                                                                            TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                                            if (talabatToolBar != null) {
                                                                                return new AccountInfoScreenBinding((RelativeLayout) view2, talabatToolBarImageButton, talabatToolBarButton, materialEditText, materialEditText2, materialEditText3, materialEditText4, linearLayout, radioGroup, talabatRadioButton, talabatRadioButton2, checkBox, checkBox2, talabatToolBarTextView, imageView, frameLayout, mobileNumberEditText, talabatFillButton, talabatToolBar);
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
    public static AccountInfoScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static AccountInfoScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.account_info_screen, viewGroup, false);
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
